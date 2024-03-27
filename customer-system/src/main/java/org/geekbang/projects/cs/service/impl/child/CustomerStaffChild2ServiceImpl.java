package org.geekbang.projects.cs.service.impl.child;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("child2")
public class CustomerStaffChild2ServiceImpl extends CustomerStaffServiceImpl {

    @Override
    protected void doBranch1() {
        System.out.println("doBranch1: child2 method");
    }
}
