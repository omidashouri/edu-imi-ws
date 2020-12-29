package edu.imi.ir.eduimiws.utilities;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.Persistence;
import javax.persistence.PersistenceUtil;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Stream;

@Slf4j
public class PersistenceUtils {


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
                        if (isClassCollection(pde.getPropertyType())) {
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

    private static boolean isClassCollection(Class c) {
        return Collection.class.isAssignableFrom(c) || Map.class.isAssignableFrom(c);
    }
}
