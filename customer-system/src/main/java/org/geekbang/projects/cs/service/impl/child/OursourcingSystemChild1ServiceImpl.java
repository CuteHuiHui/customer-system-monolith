package org.geekbang.projects.cs.service.impl.child;

import org.geekbang.projects.cs.service.impl.OursourcingSystemServiceImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("child1")
public class OursourcingSystemChild1ServiceImpl extends OursourcingSystemServiceImpl {

    @Override
    public void doBranch2() {
        System.out.println("doBranch2: child1 method");
    }
}
