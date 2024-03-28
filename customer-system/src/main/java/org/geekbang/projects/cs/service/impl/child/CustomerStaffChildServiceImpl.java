package org.geekbang.projects.cs.service.impl.child;

import org.geekbang.projects.cs.service.impl.CustomerStaffServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "custom", name = "type", havingValue="tyy", matchIfMissing=false)
public class CustomerStaffChildServiceImpl extends CustomerStaffServiceImpl {

    @Override
    protected void doBranch1() {
        System.out.println("CustomerStaffChildServiceImpl: child method");
    }
}
