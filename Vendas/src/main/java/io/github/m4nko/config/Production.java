package io.github.m4nko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // Diz que notação só poderá ser usada em classes
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Profile("production")
public @interface Production {
}
