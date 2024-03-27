package org.geekbang.projects.cs.service.impl.child;


import org.geekbang.projects.cs.service.impl.OursourcingSystemServiceImpl;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("child2")
public class OursourcingSystemChild2ServiceImpl extends OursourcingSystemServiceImpl {
    @Override
    public void doBranch2() {
        System.out.println("doBranch2: child2 method");
    }

}
