package edu.imi.ir.eduimiws.utilities;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PersistenceUtils {

    private final List<String> objectNames = new ArrayList<>();
    private List<PropertyDescriptor> propertyDescriptors;

    public <T> void cleanFromProxyByReadMethod(T value) {
        
        objectNames.add(value.getClass().getName());
        propertyDescriptors = new ArrayList<>();

        propertyDescriptors =
                entityToPropertyDescriptors(value)
                        .filter(Objects::nonNull)
                        .filter(pd -> !isPropertyDescriptorClassOrId.test(pd))
                        .filter(isPropertyDescriptorReadMethodInstanceIMI)
                        .filter(p -> !isPropertyDescriptorInstanceNull(value, p))
                        .collect(Collectors.toList());

        propertyDescriptors
                .stream()
                .filter(pdpu -> isPropertyDescriptorInstanceOfHibernateProxy.test(value, pdpu))
                .forEach(pdh -> setNullInstanceFieldByPropertyDescriptor(value, pdh));

        propertyDescriptors
                .stream()
                .filter(pd -> !isPersistenceUnitLoaded.test(value, pd.getName()))
                .forEach(pdi -> setNullInstanceFieldByPropertyDescriptor(value, pdi));

        propertyDescriptors
                .stream()
                .filter(p -> !isPropertyDescriptorInstanceNull(value, p))
                .map(pd -> propertyReadAsObjectFromEntityAndMethod(value, pd.getReadMethod()))
                .filter(pdf -> !objectNames.contains(pdf.getClass().getName()))
                .forEach(pd -> cleanFromProxyByReadMethod(pd));
    }

    private static <T extends Object> Stream<PropertyDescriptor> entityToPropertyDescriptors(T value) {
        Stream<PropertyDescriptor> propertyDescriptors = null;
        try {
            propertyDescriptors = Stream.of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors());
        } catch (IntrospectionException e) {
            log.warn(e.getMessage(), e);
        }
        return propertyDescriptors;
    }

    private static <T extends Object> T newInstanceInterfaceFromReadMethod(Method method) {
        Object returnObject = null;
        try {
            ParameterizedType parameterizedType = (ParameterizedType) method.getGenericReturnType();
            Type[] types = parameterizedType.getActualTypeArguments();
            if (types == null || types.length == 0) {
                return null;
            }
            String packageName = types[0].getTypeName();
            Class<?> clazz = Class.forName(packageName);
            if (clazz == null) {
                return null;
            }
            Object typeObject = clazz.getConstructor().newInstance();
            List<Object> objects = new ArrayList<>();
            objects.add(typeObject);
            returnObject = objects;
        } catch (ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return (T) returnObject;
    }

    private static <T extends Object> T newInstanceFromReadMethod(Method method) {
        Object returnObject = null;
        try {
            String packageName = method.getReturnType().getName();
            Class<?> clazz = Class.forName(packageName);
            if (clazz == null) {
                return null;
            }
            returnObject = clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return (T) returnObject;
    }

    @SuppressWarnings("unchecked")
    private static <T, S extends Method> Object propertyReadAsObjectFromEntityAndMethod(T value, S method) {
        Object returnObject = null;
        try {
            if (method.getReturnType().isInterface()) {
                return readMethodFromInstanceAndInterfaceMethod(value, method);
            } else {
                returnObject = newInstanceFromReadMethod(method);
            }
            if (returnObject == null) {
                return null;
            }
            String getterName = method.getName();
            Method getterMethod = value.getClass().getDeclaredMethod(getterName);
            getterMethod.setAccessible(true);
            returnObject = getterMethod.invoke(value);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return returnObject;
    }

    private static <T, S extends Method> Object readMethodFromInstanceAndInterfaceMethod(T value, S method) {
        Object returnObject = null;
        try {
            returnObject = newInstanceInterfaceFromReadMethod(method);
            if (returnObject == null) {
                return HibernateProxy.class;
            }
            String getterName = method.getName();
            Method getterMethod = value.getClass().getDeclaredMethod(getterName);
            getterMethod.setAccessible(true);
            if (Hibernate.isInitialized(getterMethod.invoke(value))) {
                returnObject = getterMethod.invoke(value);
            } else {
                returnObject = HibernateProxy.class;
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return returnObject;
    }
    
    private static <T, S extends PropertyDescriptor> Boolean isPropertyDescriptorInstanceHibernateInitialized(T value, S propertyDescriptor) {
        boolean isInitialized = false;
        try {
            Method readMethod = accessiblePropertyDescriptorReadMethodFromInstance(value, propertyDescriptor);
            isInitialized = Hibernate.isInitialized(readMethod.invoke(value));
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return isInitialized;
    }

    private static <T, S extends PropertyDescriptor> Boolean isPropertyDescriptorInstanceHibernateProxy(T value, S propertyDescriptor) {
        boolean isHibernateProxy = false;
        try {
            Method readMethod = accessiblePropertyDescriptorReadMethodFromInstance(value, propertyDescriptor);
            isHibernateProxy = (readMethod.invoke(value) instanceof HibernateProxy);
        } catch (IllegalAccessException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return isHibernateProxy;
    }

    private static <T, S extends PropertyDescriptor> Boolean isPropertyDescriptorInstanceNull(T value, S propertyDescriptor) {
        boolean isNull = false;
        try {
            Field field = propertyDescriptorReadMethodToFieldFromInstance(value, propertyDescriptor);
            if (field.get(value) == null) {
                return true;
            }
        } catch (IllegalAccessException e) {
            log.warn(e.getMessage(), e);
        }
        return isNull;
    }

    private static <T, S extends PropertyDescriptor> Method accessiblePropertyDescriptorReadMethodFromInstance(T value, S propertyDescriptor) {
        Method readMethod = null;
        try {
            String getterName = propertyDescriptor.getReadMethod().getName();
            readMethod = value.getClass().getDeclaredMethod(getterName);
            readMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            log.warn(e.getMessage(), e);
        }
        return readMethod;
    }

    private static <T, S extends PropertyDescriptor> Field propertyDescriptorReadMethodToFieldFromInstance(T value, S propertyDescriptor) {
        Field field = null;
        try {
            field = value.getClass().getDeclaredField(propertyDescriptor.getName());
            field.setAccessible(true);
        } catch (NoSuchFieldException e) {
            log.warn(e.getMessage(), e);
        }
        return field;
    }

    public static <T> void cleanFromProxyByNull(T value) {
        PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();

        Stream
                .of(value.getClass().getDeclaredFields())
                .filter(f -> !persistenceUnitUtil.isLoaded(value, f.getName()))
                .forEach(fv -> {
                    fv.setAccessible(true);
                    try {
                        fv.set(value, null);
                    } catch (IllegalAccessException e) {
                        log.warn(e.getMessage(), e);
                    }
                });
    }

    public static <T> void setNullInstanceFieldByPropertyDescriptor(T instance, PropertyDescriptor propertyDescriptor) {
        try {
            Field fieldInstance = instance.getClass().getDeclaredField(propertyDescriptor.getName());
            fieldInstance.setAccessible(true);
            fieldInstance.set(instance, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            log.warn(e.getMessage(), e);
        }
    }

    private static <T> void cleanFromProxyByNewInstance(T value) throws IntrospectionException {
        PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();

        Stream
                .of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors())
                .filter(pd -> !persistenceUnitUtil.isLoaded(value, pd.getName()))
                .forEach(pde -> {
                    try {
                        String setterName = pde.getWriteMethod().getName();
                        Method setterMethod = value.getClass().getDeclaredMethod(setterName, pde.getPropertyType());
                        setterMethod.setAccessible(true);
                        if (isClassCollection.test(pde.getPropertyType())) {
                            List<?> list = new ArrayList<>();
                            setterMethod.invoke(value, list);
                        } else {
                            setterMethod.invoke(value, pde.getPropertyType().getDeclaredConstructor().newInstance());
                        }

                    } catch (NoSuchMethodException e) {
                        log.warn(e.getMessage(), e);
                    } catch (IllegalAccessException e) {
                        log.warn(e.getMessage(), e);
                    } catch (InstantiationException e) {
                        log.warn(e.getMessage(), e);
                    } catch (InvocationTargetException e) {
                        log.warn(e.getMessage(), e);
                    }
                });
    }

    private static Predicate<PropertyDescriptor> isPropertyDescriptorClassOrId = (propertyDescriptor) -> {
        return (propertyDescriptor.getName().equalsIgnoreCase("class")
                || propertyDescriptor.getName().equalsIgnoreCase("id"));
    };

    private static Predicate<PropertyDescriptor> isPropertyDescriptorReadMethodInstanceIMI = (pd) -> {
        return pd.getReadMethod().getGenericReturnType().getTypeName().contains("imi.ir");
    };

    public static BiPredicate<Object, PropertyDescriptor>
            isPropertyDescriptorInstanceOfHibernateProxy = (value, propertyDescriptor) -> {
        return (isPropertyDescriptorInstanceHibernateProxy(value, propertyDescriptor));
    };

    public static BiPredicate<Object, String> isPersistenceUnitLoaded = (unitObject, attributeName) -> {
        return Persistence.getPersistenceUtil().isLoaded(unitObject, attributeName);
    };

    private static Predicate<Class> isClassCollection = (c) -> {
        return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
    };

    public static BiPredicate<Object, Method> isEntityReadPropertyDescriptorInstanceNull = (value, method) -> {
        Object o = propertyReadAsObjectFromEntityAndMethod(value, method);
        return (o == null);
    };

    public static BiPredicate<Object, Method> isEntityReadPropertyDescriptorInstanceOfHibernateProxy = (value, method) -> {
        Object o = propertyReadAsObjectFromEntityAndMethod(value, method);
        return (o instanceof HibernateProxy);
    };

    public static BiPredicate<Object, PropertyDescriptor> isPropertyDescriptorInstanceOfHibernateInstantiated = (value, propertyDescriptor) -> {
        return (isPropertyDescriptorInstanceHibernateInitialized(value, propertyDescriptor));
    };

    public static BiPredicate<Object, PropertyDescriptor>
            isPropertyDescriptorInstanceOfPersistenceUnitLoaded = (value, propertyDescriptor) -> {
        return (Persistence.getPersistenceUtil().isLoaded(value, propertyDescriptor.getName()));
    };

    public static BiPredicate<Object, PropertyDescriptor>
            isPropertyDescriptorInstanceNull = (value, propertyDescriptor) -> {
        return isPropertyDescriptorInstanceNull(value, propertyDescriptor);
    };

    private static Predicate<Object> isInstanceOfHibernateProxy = (o) -> {
        return (o instanceof HibernateProxy);
    };

    private static Predicate<PropertyDescriptor> isPropertyEntity = (pd) -> {
        return pd.getPropertyType().getName().contains("imi.ir");
    };

    private static Predicate<PropertyDescriptor> isPropertyDescriptorClassCollection = (pd) -> {
        return Collection.class.isAssignableFrom(pd.getPropertyType()) ||
                Map.class.isAssignableFrom(pd.getPropertyType());
    };

    private static Predicate<PropertyDescriptor> isPropertyDescriptorReadMethodInterface = (c) -> {
        return c.getReadMethod().getReturnType().isInterface();
    };

    public static BiPredicate<Field, PropertyDescriptor> isFieldNameEqualPropertyDescriptorName = (field, propertyDescriptor) -> {
        return field.getName().equalsIgnoreCase(propertyDescriptor.getName());
    };

    public static <T> void cleanFromProxyBySetMethod(T value) {
        try {
            PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();
            List<PropertyDescriptor> propertyDescriptors =
                    Stream
                            .of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors())
                            .filter(pd -> !persistenceUnitUtil.isLoaded(value, pd.getName()))
                            .collect(Collectors.toList());
            propertyDescriptors.forEach(pd -> {
                try {
                    String packageName = pd.getReadMethod().getReturnType().getName();
                    Class<?> clazz = Class.forName(packageName);
                    Object returnObject = clazz.getConstructor().newInstance();
                    if (isClassCollection.test(pd.getPropertyType())) {
                        System.out.println("List");
                    } else {
                        String setterName = pd.getWriteMethod().getName();
                        Method setterMethod = value.getClass().getDeclaredMethod(setterName, clazz);
                        Object setterObject = clazz.getConstructor().newInstance();
                        setterObject = setterMethod.invoke(value, pd.getPropertyType().getDeclaredConstructor().newInstance());
                    }
                    if (returnObject instanceof HibernateProxy) {
                        System.out.println("Success");
                    }
                } catch (NoSuchMethodException | InstantiationException |
                        IllegalAccessException | InvocationTargetException |
                        ClassNotFoundException e) {
                    e.printStackTrace();
                }
            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }

    private static <T, S extends PropertyDescriptor> void nullFieldByEntityAndPropertyDescriptor(T value, S propertyDescriptor) {
        try {
            Field field = value.getClass().getDeclaredField(propertyDescriptor.getName());
            field.setAccessible(true);
            field.set(value, null);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            log.warn(e.getMessage(), e);
        }
    }

    private static Function<PropertyDescriptor, PropertyDescriptor>
            removeClassNamePropertyFromStream = (propertyDescriptor) -> {
        if (!propertyDescriptor.getName().equalsIgnoreCase("class")
                || !propertyDescriptor.getName().equalsIgnoreCase("id")) {
            return propertyDescriptor;
        }
        return null;
    };

    public static <T> void cleanAllFromProxyByNull(Collection<T> values) {
        values.forEach(v -> cleanFromProxyByNull(v));
    }

    public static <T> void cleanAllFromProxyByNewInstance(Collection<T> values) {
        values.forEach(v -> {
            try {
                cleanFromProxyByNewInstance(v);
            } catch (IntrospectionException e) {
                log.warn(e.getMessage(), e);
            }
        });
    }

}
