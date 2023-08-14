package org.geekbang.projects.cs.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import org.geekbang.projects.cs.provider.MybatisQueryInterceptor;
import org.geekbang.projects.cs.provider.MybatisUpdateInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisConfig {
    @Bean
    public ConfigurationCustomizer mybatisConfigurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(MybatisConfiguration configuration) {
                configuration.addInterceptor(new MybatisUpdateInterceptor());
                configuration.addInterceptor(new MybatisQueryInterceptor());
            }
        };
    }
}

