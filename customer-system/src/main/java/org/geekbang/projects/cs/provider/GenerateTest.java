package org.geekbang.projects.cs.provider;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;
import org.geekbang.projects.cs.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;

/**
 *
 */

@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class GenerateTest {
    @Test
    public void test01() {
        //创建一个代码生成器
        FastAutoGenerator.create("jdbc:mysql://127.0.0.1:3306/customer_system",
                        "root", "root")
                //全局配置(GlobalConfig)
                .globalConfig(builder -> {
                    builder.author("hhx") // 设置作者，可以写自己名字
                            //.enableSwagger() // 开启 swagger 模式，这个是接口文档生成器，如果开启的话，就还需要导入swagger依赖
                            .fileOverride() // 覆盖已生成文件
                            .dateType(DateType.TIME_PACK) //时间策略
                            .commentDate("yyyy-MM-dd") //注释日期
                            .outputDir("/Users/huhuixia/ProjectToLearn/customer-system-monolith/customer-system/src/main/java"); // 指定输出目录，一般指定到java目录
                })
                //包配置(PackageConfig)
                .packageConfig(builder -> {
                    builder.parent("org.geekbang.projects.cs") // 设置父包名
                            .moduleName("") // 设置父包模块名，这里一般不设置
                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, "/Users/huhuixia/ProjectToLearn/customer-system-monolith/customer-system/src/main/resources/mapperXml")); // 设置mapperXml生成路径，这里是Mapper配置文件的路径，建议使用绝对路径
                })
                //策略配置(StrategyConfig)
                .strategyConfig(builder -> {
                    builder.addInclude("outsourcing_system") // 设置需要生成的表名
                            ;
                    builder.serviceBuilder()
                            .formatServiceFileName("%sService") //设置service的命名策略,没有这个配置的话，生成的service和serviceImpl类前面会有一个I，比如IUserService和IUserServiceImpl
                            .formatServiceImplFileName("%sServiceImpl"); //设置serviceImpl的命名策略
                    builder.controllerBuilder()
                            .enableRestStyle(); // 开启生成@RestController 控制器，不配置这个默认是Controller注解，RestController是返回Json字符串的，多用于前后端分离项目。
                    builder.mapperBuilder()
                            .enableMapperAnnotation() ;//开启 @Mapper 注解，也就是在dao接口上添加一个@Mapper注解，这个注解的作用是开启注解模式，就可以在接口的抽象方法上面直接使用@Select和@Insert和@Update和@Delete注解。
                })
//                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .templateEngine(new VelocityTemplateEngine())
                .execute(); //执行以上配置
    }

}
