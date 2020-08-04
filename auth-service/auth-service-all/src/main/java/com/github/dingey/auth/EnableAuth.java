package com.github.dingey.auth;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.lang.annotation.*;
import java.util.Set;

@SuppressWarnings("unused")
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import({EnableAuth.AuthRegistrar.class})
public @interface EnableAuth {
    class AuthRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware, EnvironmentAware {

        @Override
        public void setEnvironment(Environment environment) {
        }

        @Override
        public void setResourceLoader(ResourceLoader resourceLoader) {
        }

        @Override
        public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
            AuthClassPathScanner scanner = new AuthClassPathScanner(beanDefinitionRegistry);
            scanner.doScan(EnableAuth.class.getPackage().getName());
        }

        class AuthClassPathScanner extends ClassPathBeanDefinitionScanner {
            AuthClassPathScanner(BeanDefinitionRegistry registry) {
                super(registry);
            }

            @Override
            protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
                return super.doScan(basePackages);
            }
        }
    }
}
