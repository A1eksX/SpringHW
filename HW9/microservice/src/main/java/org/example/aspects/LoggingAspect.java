package org.example.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @After("execution(* com.example.HW8.services.*.getAllNotes(..))")        // AfterReturning     // Around
    public Object log(JoinPoint joinPoint) throws Throwable{                        // Proceeding

        Object returnedByMethod = joinPoint.getSignature();            // .proceed();
        System.out.println("Просмотр списка заметок");
        return returnedByMethod;
    }


    @After("execution(* com.example.HW8.services.*.updateNote(..))")        // AfterReturning     // Around
    public Object log1(JoinPoint joinPoint) throws Throwable{                        // Proceeding

        System.out.println("Применён метод для обновления заметки");
        Object returnedByMethod = joinPoint.getSignature();            // .proceed();
        System.out.println("Заметка обновлена");
        return returnedByMethod;
    }




    @Around("execution(* com.example.HW8.services.*.*(..))")
    public Object measureMethodExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long elapsedTime = System.currentTimeMillis() -start;
        System.out.println("Метод: "+joinPoint.getSignature().getName() + " выполнился за - "+elapsedTime+" милсек");
        return result;
    }




}
