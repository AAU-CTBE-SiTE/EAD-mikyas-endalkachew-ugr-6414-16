package com.site.demo.service;

import com.site.demo.MyFirstClass;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Service;

@Service
@PropertySources({
        @PropertySource("classpath:custom.properties"),
        @PropertySource("classpath:custom-file-2.properties")
})
@Data
public class MyFirstService {

    private final MyFirstClass myFirstClass;

    @Value("${my.prop}")
    private String customPropertyFromAnotherFile;
    @Value("${my.prop.2}")
    private String customPropertyFromAnotherFile2;


    // Constructor Injection (Always use this method)
    public MyFirstService(
            @Qualifier("Bean2") MyFirstClass myFirstClass
    ) {
        this.myFirstClass = myFirstClass;
    }

    public void tellAStory() {
        System.out.println("The dependency is saying: " +  myFirstClass.sayHello());
    }
}
