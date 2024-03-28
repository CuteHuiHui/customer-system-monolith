package org.geekbang.projects.cs.service.impl.child;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "custom", name = "type", havingValue="main", matchIfMissing=true)
public class CustomerStaffMainServiceImpl extends CustomerStaffServiceImpl {

    @Override
    protected void doBranch1() {
        System.out.println("CustomerStaffMainServiceImpl: main method");
    }
}
