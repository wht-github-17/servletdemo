package com.wht.thread;

public class SD implements Runnable {
    @Override
    public void run() {
        synchronized (this){
            System.out.println("who:"+Thread.currentThread().getName());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
