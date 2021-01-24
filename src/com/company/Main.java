package com.company;

import java.util.Scanner;

public class Main {

    final static double cost1L_100 = 46.1;
    final static double cost1L_200 = 48.9;
    final static double cost1L_300 = 47.5;
    final static double cost1L_400 = 48.9;

    final static double consumption_100 = 12.5;
    final static double consumption_200 = 12.0;
    final static double consumption_300 = 11.5;
    final static double consumption_400 = 20.0;

    public static double[] expenses(String[] arr){ // вычисление расходов

        double allSum = 0.0;
        double sum100 = 0.0;
        double sum200 = 0.0;
        double sum300 = 0.0;
        double sum400 = 0.0;

        for(int i = 0; i < arr.length; i++){
            String[] a = arr[i].split("-");
            double tmp = Double.parseDouble(a[1]);
            if(a[0].contains("100"))
                sum100 += ((tmp/100) * cost1L_100);
            else if(a[0].contains("200"))
                sum200 += ((tmp/100) * cost1L_200);
            else if(a[0].contains("300"))
                sum300 += ((tmp/100) * cost1L_300);
            else if(a[0].contains("400"))
                sum400 += ((tmp/100) * cost1L_400);

        }

        allSum = sum100 + sum200 + sum300 + sum400;

        double[] res = new double[]{allSum, sum100, sum200, sum300, sum400};

        return res;
    }

    public static String min(double[] arr){ // нахождение минимума расходов
        double m = Double.MAX_VALUE;
        int pos = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < m){
                m = arr[i];
                pos = i;
            }
        }
        String[] types = new String[]{"Тип 100 - легковой авто", "Тип 200 - грузовой авто",
                "Тип 300 - пассажирский транспорт", "Тип 400 - тяжелая техника"};
        return  types[pos - 1] + " имеет наименьшую стоимость расходов = " + m;
    }

    public static String max(double[] arr){ // нахождение максимума расходов
        double m = Double.MIN_VALUE;
        int pos = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > m){
                m = arr[i];
                pos = i;
            }
        }
        String[] types = new String[]{"Тип 100 - легковой авто", "Тип 200 - грузовой авто",
                "Тип 300 - пассажирский транспорт", "Тип 400 - тяжелая техника"};
        return  types[pos - 1] + " имеет наибольшую стоимость расходов = " + m;
    }

    public static void increase(String []arr, int n){ //сортировка по возрастанию
        boolean isSorted = false;
        String buf = "";
        if(n == 1){ // пробег
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length-1; i++) {
                    String[] tmp = arr[i].split("-"); // разбиваем строку на c100_1 100
                    String[] tmp2 = arr[i + 1].split("-");// разбиваем след строку на c100_1 100
                    if(Integer.parseInt(tmp[1]) > Integer.parseInt(tmp2[1])){ // сравниваем вторые значения(которые после знака '-')
                        isSorted = false;

                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
            System.out.println("По возрастанию пробега:");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }

        if(n == 2){ // доп параметр
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length-1; i++) {
                    String[] tmp = arr[i].split("-"); // разбиваем на c200_1 120 1200
                    String[] tmp2 = arr[i + 1].split("-"); // разбиваем след строку  на c200_1 120 1200
                    if(Integer.parseInt(tmp[2]) > Integer.parseInt(tmp2[2])){ // сравниваем последние значения (1200)
                        isSorted = false;

                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
            if(arr[0].contains("c200_"))
                System.out.println("По возрастанию перевезенного груза:");
            else if(arr[0].contains("c300_"))
                System.out.println("По возрастанию числа перевезенных пассажиров:");
            else if(arr[0].contains("c400_"))
                System.out.println("По возрастанию числа поднятых грузов:");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }

    }

    public static void decrease(String []arr, int n){ // сортировка по убыванию
        boolean isSorted = false;
        String buf = "";
        if(n == 1) { // пробег
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length-1; i++) {
                    String[] tmp = arr[i].split("-"); // разбиваем строку на c100_1 100
                    String[] tmp2 = arr[i + 1].split("-"); // разбиваем след строку на c100_1 100
                    if(Integer.parseInt(tmp[1]) < Integer.parseInt(tmp2[1])){ // сравниваем вторые значения
                        isSorted = false;

                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
            System.out.println("По убыванию пробега:");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }

        if(n == 2){ // доп параметр
            while(!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length-1; i++) {
                    String[] tmp = arr[i].split("-");
                    String[] tmp2 = arr[i + 1].split("-");
                    if(Integer.parseInt(tmp[2]) < Integer.parseInt(tmp2[2])){
                        isSorted = false;

                        buf = arr[i];
                        arr[i] = arr[i+1];
                        arr[i+1] = buf;
                    }
                }
            }
            if(arr[0].contains("c200_"))
                System.out.println("По убыванию перевезенного груза:");
            else if(arr[0].contains("c300_"))
                System.out.println("По убыванию числа перевезенных пассажиров:");
            else if(arr[0].contains("c400_"))
                System.out.println("По убыванию числа поднятых грузов:");
            for (int i = 0; i < arr.length; i++)
                System.out.println(arr[i]);
        }
    }


    public static int typeAuto(String[] arr, String str, int p, int s){// вывод данных с сортировкой, arr - массив данных, str - тип авто, p - выборка, s - сортировка3
        int size = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("c" + str))
                size++;
        }
        String[] t = new String[size ] ;
        int cnt = 0;
        System.out.println("Список авто типа " + str + ":");
        for(int i = 0; i < arr.length; i++){
            if(arr[i].contains("c"+ str +"_")) { //находим авто нужного типа с100_ и тд
                t[cnt] = arr[i];
                System.out.println(t[cnt]);
                cnt++;
            }
        }
        if(str.equals("100")){
            if(s == 1) increase(t, 1); // пробег по возрастанию
            else if (s == 2) decrease(t, 1); // пробег по убыванию
        }
        else if(str.equals("200") || str.equals("300") || str.equals("400")){
            if(p == 1 && s == 1) increase(t, s); // пробег по возрастанию
            else if (p == 1 && s == 2) decrease(t, 1);// пробег по убыванию
            else if (p == 2 && s == 1) increase(t, 2);// доп параметр по возрастанию
            else if (p == 2 && s == 2) decrease(t, 2);// доп параметр по убыванию
        }

        return 0;
    }
    public static void main(String[] args) {
        String[] autoDetails = new String[]{"c100_1-100","c200_1-120-1200","c300_1-120-30",
                "c400_1-80-20","c100_2-50","c200_2-40-1000",
                "c300_2-200-45","c400_2-10-20","c100_3-10",
                "c200_3-170-1100","c300_3-150-29","c400_3-100-28",
                "c100_1-300","c200_1-100-750","c300_1-32-15"};

        double[] a = expenses(autoDetails);
        System.out.println("Общая сумма расходов = " + a[0] + "\n" + min(a) + "\n" + max(a));

        char ans = 'y';
        while(ans == 'y') {
            System.out.println("\n-----------------------------------------------------\n" +
                    "Подбор авто по параметрам:");
            System.out.println("Инструкция - ввод осуществляется число(type авто) --> enter --> " +
                    "число(поиск по параметру) --> enter --> сортировка --> enter\n\n" +
                    "Типы авто:\n 100 - type100\n 200 - type 200\n 300 - type300 \n 400 - type400\n\n" +
                    "Параметры:\n 1 - пробег(все типы авто)\n 2 - доп параметр(type 200,300,400)\n\n" +
                    "Сортировка:\n 1 - возрастание\n 2 - убывание\n\n");

            Scanner in = new Scanner(System.in);
            System.out.println("Введите тип авто: ");
            String t = in.next();
            System.out.println("Введите параметр: ");
            int p = in.nextInt();
            System.out.println("Введите вариант сортировки: ");
            int s = in.nextInt();

            typeAuto(autoDetails, t, p, s);

            System.out.println("Повторить поиск(y/n): ");
            ans = in.next().charAt(0);
        }
        System.out.println("До свидания!");
    }
}
