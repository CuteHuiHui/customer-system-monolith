package org.geekbang.projects.cs.service.impl.child.child1;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CustomerStaffChild1ServiceImpl extends CustomerStaffServiceImpl {

    @Override
    protected void doBranch() {
        System.out.println("child1 method");
    }
}
