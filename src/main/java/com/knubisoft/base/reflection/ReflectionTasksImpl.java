package com.knubisoft.base.reflection;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class ReflectionTasksImpl implements ReflectionTasks {

    @SneakyThrows
    @Override
    public Object createNewInstanceForClass(Class<?> cls) {
        Object o;

            Class clazz = cls.getClass();
            Class[] param1 = {String.class};
            Class[] param2 = {String.class, String.class};
            Class[] param3 = {String.class, String.class, String.class};
            o = clazz.getConstructor(param1).newInstance("tablename");



        return o;
    }

    @Override
    public <T> Class<? extends T> findImplementationForInterface(Class<T> cls) {
        return null;
    }

    @Override
    public Map<String, Object> findAllFieldsForClass(Class<?> cls) {
        return null;
    }

    @Override
    public int countPrivateMethodsInClass(Class<?> cls) {
        return -1;
    }

    @Override
    public boolean isMethodHasAnnotation(Method method, Class<?> annotationUnderMethod) {
        return false;
    }

    @Override
    public Object evaluateMethodByName(Class<?> cls, String name) {
        return null;
    }

    @Override
    public Object evaluateMethodWithArgsByName(Object obj, String name, Object... args) {
        return null;
    }

    @Override
    public Object changePrivateFieldValue(Object instance, String name, Object newValue) {
        return null;
    }
}
