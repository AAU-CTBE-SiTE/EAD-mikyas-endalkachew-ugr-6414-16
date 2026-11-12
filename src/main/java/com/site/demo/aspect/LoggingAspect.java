package com.site.demo.aspect;

import com.site.demo.service.MyFirstService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Before("execution(* com.site.demo.service.*.*(..))")
    public void logBefore() {
        System.out.println("\nA method inside MyFirstService is about to be executed");
    }

    @After("execution(* com.site.demo.service.MyFirstService.tellAStory(..))")
    public void logAfter() {
        System.out.println("The method tellAStory inside MyFirstService finished execution");
    }

    @AfterReturning(
            pointcut = "execution(* com.site.demo.service.*.*(..))",
            returning = "result"
    )
    public void logAfterReturning(Object result) {

        System.out.println("Method returned: " + result);

    }

    @AfterThrowing(
            pointcut = "execution(* com.site.demo.service.*.*(..))",
            throwing = "exception"
    )
    public void logAfterThrowing(Exception exception) {

        System.out.println(
                "An exception occurred: " + exception.getMessage()
        );

    }

    @Around("execution(* com.site.demo.service.*.*(..))")
    public Object measureExecutionTime(
            ProceedingJoinPoint joinPoint
    ) throws Throwable {

        long start = System.nanoTime();

        Object result = joinPoint.proceed();

        long duration = System.nanoTime() - start;

        System.out.println(
                "Execution time: " + duration / 1_000_000.0 + " ms"
        );

        return result;
    }
}
