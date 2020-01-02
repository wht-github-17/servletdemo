package com.wht.thread;

public class Test {
    public static void main(String[] args) {
        SD sd=new SD();
        for(int i=0;i<10;i++){
            Thread t=new Thread(sd,""+(int)(Math.random()*100));
            t.start();
        }
    }
}
