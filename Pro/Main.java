package com.gmail.dmytropolishchuk2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Retention(value = RetentionPolicy.RUNTIME)
@interface Saver {} // как сохранить

@Retention(value = RetentionPolicy.RUNTIME)
@interface SaveTo { // куда сохранить
    String filename();
}

@SaveTo(filename = "text.txt")
class TextContainer { // что сохранить
     String text="Hello world!";

    @Saver
    public void saver(String filename) throws IOException {
        FileWriter fw = new FileWriter(filename);// записать в файл
        try{
            fw.write(text); // что именно
        }
        finally
        {
            fw.close(); // закрыть
        }
    }
}

class SaveText {
    public static void saveText(TextContainer txt) { // список параметров
        Class<?> cls = txt.getClass(); // с какого класса
        if (cls.isAnnotationPresent(SaveTo.class)) { // проверка на наличие аннотации
            for (Method meth : cls.getMethods()) { // получить методы
                if (meth.isAnnotationPresent(Saver.class)) {
                    try {
                        meth.invoke(txt, cls.getAnnotation(SaveTo.class).filename());
                        System.out.printf("Text successfully saved to file by method %s()", meth.getName());
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.out.println(e);
                    }
                }
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {
        TextContainer txtcont = new TextContainer();
        SaveText.saveText(txtcont);
    }
}