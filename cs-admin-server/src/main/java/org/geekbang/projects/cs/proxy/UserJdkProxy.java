package org.geekbang.projects.cs.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.*;

public class UserJdkProxy implements InvocationHandler {
    private Object object;

    public UserJdkProxy(Object object) {
        this.object = object;
    }

    private void doAfter() {
        System.out.println("jdk after");
    }

    private void doBefore() {
        System.out.println("jdk before");
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doBefore();
//        Object invoke = method.invoke(object, args);

        Future future = Executors.newSingleThreadExecutor().submit(new Runnable() {
            @Override
            public void run() {
                try {
                    method.invoke(object, args);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        return future;
    }
}
