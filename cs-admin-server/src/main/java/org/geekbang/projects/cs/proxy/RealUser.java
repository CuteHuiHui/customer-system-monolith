package org.geekbang.projects.cs.proxy;

public class RealUser implements User {
    @Override
    public void open() {
        System.out.println("realAccount");
        System.out.println("open Thread:" + Thread.currentThread().getName());
    }
}
