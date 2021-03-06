package ru.innopolis.university.task3_8;

import java.math.BigInteger;

public class NewThread{

    int arr;
    BigInteger fact1;
    BigInteger fact2;

    public NewThread(int arr) {
        this.arr=arr;
    }

    Thread t1 = new Thread("t1") {
        public void run() {
            System.out.println("Running t1");
            BigInteger fact = BigInteger.valueOf(1);
            for (int i = 2; i <= arr; i += 2) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact);
            fact1 = fact;
        }
    };

    Thread t2 = new Thread("t2") {
        public void run() {
            System.out.println("Running t2 ");
            BigInteger fact = BigInteger.valueOf(1);
            for (int i = 3; i <= arr; i += 2) {
                fact = fact.multiply(BigInteger.valueOf(i));
            }
            System.out.println(fact);
            fact2 = fact;
        }
    };

    Thread t3 = new Thread("t3") {
        public void run() {
            BigInteger res;
            System.out.println("Running t3 ");
            res = fact1.multiply(fact2);
            System.out.println("факториал числа "+arr+" равен:\n"+res);
        }
    };

}
