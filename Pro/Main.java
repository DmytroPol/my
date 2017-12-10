package com.gmail.dmytropolishchuk2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Retention(value= RetentionPolicy.RUNTIME)// доступна на этапе выполнения
@Target(value= ElementType.METHOD) // цель аннотации(метод)
@interface Test {// параметры аннотации
    int a();
    int b();
}

class Sum {
    @Test(a = 3, b = 5)
    public static void test(int a, int b) {
        System.out.println("a + b = " + (a + b));
    }// метод
}

public class Main {
    public static void main(String[] args) {

        Class<?> cls = Sum.class;// с какого класса
        try{
            Method method = cls.getMethod("test", int.class, int.class);// получить ссылку на метод
            if (method.isAnnotationPresent(Test.class)) {// проверка обьеккта на наличия аннотации truе или false

                Test my = method.getAnnotation(Test.class);// возвращает ссылку на аннотацию
                method.invoke(cls, my.a(), my.b());// вызов метода с передачей ему параметров аннотации
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
