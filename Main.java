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
        
 
        map.put("she", "���");
        map.put("go", "����");
        map.put("to", "�");
        map.put("school", "�����");
 
        System.out.println("�������  ��� �������� ������ ����� - she, go, to, school (���������� ��������� ��������� �������)");
        String tr = reader.readLine();
//        String tr = "She go to school"; // ���� ������ ��� ����� ���������
 
        for (String s : tr.split(" ")) {
            System.out.println(map.get(s));
        }
 
       // System.out.println(value);
 
    }
}