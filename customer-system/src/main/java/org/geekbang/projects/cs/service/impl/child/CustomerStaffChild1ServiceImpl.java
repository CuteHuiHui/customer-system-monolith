package org.geekbang.projects.cs.service.impl.child;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "custom", name = "type", havingValue = "child1", matchIfMissing = false)
public class CustomerStaffChild1ServiceImpl extends CustomerStaffServiceImpl {

    @Override
    public void test() {
        System.out.println("child1 method");
    }
}
