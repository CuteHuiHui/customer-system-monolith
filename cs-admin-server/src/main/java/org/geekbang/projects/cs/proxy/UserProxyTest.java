package org.geekbang.projects.cs.proxy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;
import java.util.function.Supplier;

public class UserProxyTest {
    public static void main(String[] args) {
        System.out.println(String.format("Main Thread：%s", Thread.currentThread().getName()));
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
//        completableFuture.runAsync(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("runAsync:" + Thread.currentThread().getName());
//                completableFuture.complete("runAsync");
//            }
//        });

        completableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("supplyAsync1:" + Thread.currentThread().getName());
                completableFuture.complete("supplyAsync1");
                return "supplyAsync1";
            }
        }).thenApply(new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                System.out.println("supplyAsync2:" + Thread.currentThread().getName());
                return "supplyAsync2";
            }
        });

        try {
            System.out.println(completableFuture.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }


//        //jdk 基于接口
//        User user = new RealUser();
//        InvocationHandler handler = new UserJdkProxy(user);
//        User proxy = (User) Proxy.newProxyInstance(
//                user.getClass().getClassLoader(), user.getClass().getInterfaces(), handler);
//        proxy.open();

//        //CGLIB 基于子类
//        User user1 = (User) new UserCgLibProxy().getProxy(RealUser.class);
//        user1.open();

    }
}
