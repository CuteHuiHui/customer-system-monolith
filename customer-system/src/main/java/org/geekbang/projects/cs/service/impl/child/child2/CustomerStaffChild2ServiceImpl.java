package org.geekbang.projects.cs.service.impl.child.child2;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerStaffChild2ServiceImpl extends CustomerStaffServiceImpl {

    @Override
    protected void doBranch() {
        System.out.println("child2 method");
    }
}
