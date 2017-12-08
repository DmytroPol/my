package com.gmail.dmytropolishchuk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws Exception
    {
 
        Map<String, String> map = new HashMap<String, String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
 
        map.put("she", "она");
        map.put("go", "идет");
        map.put("to", "в");
        map.put("school", "школу");
 
        System.out.println("Введите  для перевода данные слова - she, go, to, school (ПЕРЕВОДЧИК ОГРАНИЧЕН СЛОВАРНЫМ ЗАПАСОМ)");
        String tr = reader.readLine();
//        String tr = "She go to school"; // сюда вводим что нужно перевести
 
        for (String s : tr.split(" ")) {
            System.out.println(map.get(s));
        }
 
       // System.out.println(value);
 
    }
}