package lesson;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++) {

            System.out.println(i+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}}
