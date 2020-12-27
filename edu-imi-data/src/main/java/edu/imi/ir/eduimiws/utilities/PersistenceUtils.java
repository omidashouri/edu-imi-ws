package edu.imi.ir.eduimiws.utilities;

import lombok.extern.slf4j.Slf4j;
import org.apache.cxf.common.util.CollectionUtils;
import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.proxy.HibernateProxy;
import org.hibernate.proxy.pojo.javassist.SerializableProxy;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;


@Slf4j
public class PersistenceUtils {

    public static <T> void cleanFromProxyCollection(Collection<T> values) {
        values.forEach(v -> {
            try {
                cleanFromProxySingle(v);
            } catch (IntrospectionException e) {
                e.printStackTrace();
            }
        });
    }

    private static <T> void cleanFromProxySingle(T value) throws IntrospectionException {
        cleanFromProxies(value);
        PersistenceUtil persistenceUnitUtil = Persistence.getPersistenceUtil();

        Stream
                .of(Introspector.getBeanInfo(value.getClass()).getPropertyDescriptors())
                .filter(pd -> !persistenceUnitUtil.isLoaded(value, pd.getName()))
                .forEach(pde -> {
                    try {
                        String setterName = pde.getWriteMethod().getName();
                        Method setterMethod = value.getClass().getDeclaredMethod(setterName, pde.getPropertyType());
                        setterMethod.setAccessible(true);
                        setterMethod.invoke(value, pde.getPropertyType().getDeclaredConstructor().newInstance());

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

    private static void cleanFromProxies(Object value, List<Object> handledObjects) {
        if ((value != null) && (!isProxy(value)) && !containsTotallyEqual(handledObjects, value)) {
            handledObjects.add(value);
            if (value instanceof Iterable) {
                for (Object item : (Iterable<?>) value) {
                    cleanFromProxies(item, handledObjects);
                }
            } else if (value.getClass().isArray()) {
                for (Object item : (Object[]) value) {
                    cleanFromProxies(item, handledObjects);
                }
            }
            BeanInfo beanInfo = null;
            try {
                beanInfo = Introspector.getBeanInfo(value.getClass());
            } catch (IntrospectionException e) {
                log.warn(e.getMessage(), e);
            }
            if (beanInfo != null) {
                for (PropertyDescriptor property : beanInfo.getPropertyDescriptors()) {
                    try {
                        if ((property.getWriteMethod() != null) && (property.getReadMethod() != null)) {
                            Object fieldValue = property.getReadMethod().invoke(value);
                            if (isProxy(fieldValue)) {
                                fieldValue = unproxyObject(fieldValue);
                                property.getWriteMethod().invoke(value, fieldValue);
                            }
                            cleanFromProxies(fieldValue, handledObjects);
                        }
                    } catch (Exception e) {
                        log.warn(e.getMessage(), e);
                    }
                }
            }
        }
    }

    public static <T> T cleanFromProxies(T value) {
        T result = unproxyObject(value);
        cleanFromProxies(result, new ArrayList<Object>());
        return result;
    }

    private static boolean containsTotallyEqual(Collection<?> collection, Object value) {
        if (CollectionUtils.isEmpty(collection)) {
            return false;
        }
        for (Object object : collection) {
            if (object == value) {
                return true;
            }
        }
        return false;
    }

    public static boolean isProxy(Object value) {
        if (value == null) {
            return false;
        }
        if ((value instanceof HibernateProxy) || (value instanceof PersistentCollection)) {
            return true;
        }
        return false;
    }

    private static Object unproxyHibernateProxy(HibernateProxy hibernateProxy) {
        Object result = hibernateProxy.writeReplace();
        if (!(result instanceof SerializableProxy)) {
            return result;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static <T> T unproxyObject(T object) {
        if (isProxy(object)) {
            if (object instanceof PersistentCollection) {
                PersistentCollection persistentCollection = (PersistentCollection) object;
                return (T) unproxyPersistentCollection(persistentCollection);
            } else if (object instanceof HibernateProxy) {
                HibernateProxy hibernateProxy = (HibernateProxy) object;
                return (T) unproxyHibernateProxy(hibernateProxy);
            } else {
                return null;
            }
        }
        return object;
    }

    private static Object unproxyPersistentCollection(PersistentCollection persistentCollection) {
        if (persistentCollection instanceof PersistentSet) {
            return unproxyPersistentSet((Map<?, ?>) persistentCollection.getStoredSnapshot());
        }
        return persistentCollection.getStoredSnapshot();
    }

    private static <T> Set<T> unproxyPersistentSet(Map<T, ?> persistenceSet) {
        return new LinkedHashSet<T>(persistenceSet.keySet());
    }


}
