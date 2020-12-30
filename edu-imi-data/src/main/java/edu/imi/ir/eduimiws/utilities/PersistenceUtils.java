package edu.imi.ir.eduimiws.utilities;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
public class PersistenceUtils {


/*    public static <T> void cleanFromProxyByGetMethod(T value) {

        try {

            PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();
            List<PropertyDescriptor> propertyDescriptors =
                    Stream
                            .of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors())
                            .filter(l -> l.getPropertyType().getName().contains("imi.ir"))
//                            .filter(pd -> !persistenceUnitUtil.isLoaded(value, pd.getName()))
                            .collect(Collectors.toList());


            List<String> readMethods =
                    Stream
                            .of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors())
                            .map(PropertyDescriptor::getReadMethod)
                            .map(Method::getName)
                            .collect(Collectors.toList());

            List<String> nameMethod =
                    Stream.of(value.getClass().getDeclaredMethods())
                            .map(Method::getName)
                            .collect(Collectors.toList());


            propertyDescriptors.forEach(pd -> {
                try {
                    String packageName = pd.getReadMethod().getReturnType().getName();
                    Class<?> clazz = Class.forName(packageName);
                    Object returnObject = clazz.getConstructor().newInstance();

                    if (isClassCollection(pd.getPropertyType())) {
                        System.out.println("List");
                    } else {
                        String getterName = pd.getReadMethod().getName();
                        String setterName = pd.getWriteMethod().getName();
                        Method getterMethod = value.getClass().getDeclaredMethod(getterName);
                        getterMethod.setAccessible(true);
                        returnObject = getterMethod.invoke(value);

                        if (returnObject instanceof HibernateProxy) {
                            Field setterField = value.getClass().getDeclaredField(pd.getName());
                            setterField.setAccessible(true);
                            setterField.set(value, null);
                        }
                    }
                } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | ClassNotFoundException | NoSuchFieldException e) {
                    e.printStackTrace();
                }
            });
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }*/

    public static <T> void cleanFromProxyByReadMethod(T value) {

        entityToPropertyDescriptors(value)
                .filter(isPropertyEntity)
                .filter(pde -> isEntityPropertyDescriptorInstanceOfHibernateProxy.test(value, pde.getReadMethod()))
                .forEach(pde -> nullFieldByEntityAndPropertyDescriptor(value, pde));

        entityToPropertyDescriptors(value)
                .filter(isPropertyDescriptorClassCollection)
                .forEach(cpd -> nullFieldByEntityAndPropertyDescriptor(value, cpd));
    }


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


    private static <T extends Object> Stream<PropertyDescriptor> entityToPropertyDescriptors(T value) {
        Stream<PropertyDescriptor> propertyDescriptors = null;
        try {
            propertyDescriptors = Stream.of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors());
        } catch (IntrospectionException e) {
            log.warn(e.getMessage(), e);
        }
        return propertyDescriptors;
    }

    private static <T extends Object> T newInstanceFromMethodReturnType(Method method) {
        Object returnObject = null;
        try {
            String packageName = method.getReturnType().getName();
            Class<?> clazz = Class.forName(packageName);
            returnObject = clazz.getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException |
                InstantiationException | IllegalAccessException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return (T) returnObject;
    }

    //    #
    @SuppressWarnings("unchecked")
    private static <T, S extends Method> Object propertyAsObjectFromEntityAndMethod(T value, S method) {
        Object returnObject = null;
        try {
            returnObject = newInstanceFromMethodReturnType(method);

            String getterName = method.getName();
            Method getterMethod = value.getClass().getDeclaredMethod(getterName);
            getterMethod.setAccessible(true);
            returnObject = getterMethod.invoke(value);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            log.warn(e.getMessage(), e);
        }
        return returnObject;
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

    public static <T> void cleanAllFromProxyByNull(Collection<T> values) {
        values.forEach(v -> cleanFromProxyByNull(v));
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

    public static <T> void cleanAllFromProxyByNewInstance(Collection<T> values) {
        values.forEach(v -> {
            try {
                cleanFromProxyByNewInstance(v);
            } catch (IntrospectionException e) {
                log.warn(e.getMessage(), e);
            }
        });
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

    public static BiPredicate<Object, Method> isEntityPropertyDescriptorInstanceOfHibernateProxy = (value, method) -> {
        Object o = propertyAsObjectFromEntityAndMethod(value, method);
        return (o instanceof HibernateProxy);
    };

    public static BiPredicate<Object, String> isPersistenceUnitLoaded = (unitObject, attributeName) -> {
        return Persistence.getPersistenceUtil().isLoaded(unitObject, attributeName);
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

    private static Predicate<Class> isClassCollection = (c) -> {
        return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
    };
}
