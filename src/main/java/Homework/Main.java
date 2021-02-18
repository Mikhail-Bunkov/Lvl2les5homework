package Homework;

public class Main {
    public static void main(String[] args) {

        methodOne();
        methodTwo();
    }
    static void methodOne(){
        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println(System.currentTimeMillis() - a);
    }
    static void methodTwo(){

        final int size = 10000000;
        final int h = size / 2;
        float[] arr = new float[size];
        float[] ar1 = new float[h];
        float[] ar2 = new float[h];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=1;
        }
        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, ar1, 0, h);
        System.arraycopy(arr, h, ar2, 0, h);
        Thread t1 = new Thread(() ->{
            for (int i = 0; i < ar1.length; i++) {
                ar1[i] = (float)(ar1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread t2 = new Thread(() ->{
            for (int i = 0; i < ar2.length; i++) {
                ar2[i] = (float)(ar2[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.arraycopy(ar1, 0, arr, 0, h);
        System.arraycopy(ar2, 0, arr, h, h);
        System.out.println(System.currentTimeMillis() - a);
    }
}
