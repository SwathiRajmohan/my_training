package com.main;

import com.config.AppConfig;
import com.model.Career;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {
    public static void main(String[] args) {
        System.out.println("App Main Started...");
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(AppConfig.class);
        Career career = context.getBean(Career.class);
        career.details();
        context.close();
    }
}
