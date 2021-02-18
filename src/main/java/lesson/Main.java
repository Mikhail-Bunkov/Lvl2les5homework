package lesson;

public class Main {
    public static void main(String[] args) {
        MyThread t1 = new MyThread("t1");
        MyThread t2 = new MyThread("t2");

        t1.start();
        t2.start();

        Thread tr1 = new Thread(new MyRunnable());
        Thread tr2 = new Thread(new MyRunnable());


        tr1.start();
        tr2.start();




        Thread tr3 = new Thread(new MyRunnable(){
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
            }
});

        Thread tr4 = new Thread(()->{
                for (int i = 0; i < 10 ; i++) {
                    System.out.println(i+" "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        });
        tr3.start();
        tr4.start();
        System.out.println("3 "+Thread.currentThread().getName());
        try {
            tr1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        Counter counter = new Counter();
        Thread tc1 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                counter.inc();
            }
        });
        Thread tc2 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                counter.dec();
            }
        });
        tc2.start();
        tc1.start();

        try {
            tc1.join();
            tc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getC());

        Counter wscounter = new Counter();
        Object mon = new Object();
        Thread twsc1 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                synchronized (mon){
                    wscounter.inc();
                }

            }
        });
        Thread twsc2 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                synchronized (mon){
                    wscounter.dec();
                }

            }
        });
        twsc2.start();
        twsc1.start();

        try {
            twsc1.join();
            twsc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(wscounter.getC());

        System.out.println("end "+ Thread.currentThread().getName());

        SynhCounter scounter = new SynhCounter();
        Thread tsc1 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                scounter.inc();
            }
        });
        Thread tsc2 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                scounter.dec();
            }
        });
        tsc2.start();
        tsc1.start();

        try {
            tsc1.join();
            tsc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(scounter.getC());
        System.out.println("end "+ Thread.currentThread().getName());
        SynhWithMonCounter swmcounter = new SynhWithMonCounter();
        Thread tswmc1 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                swmcounter.inc();
            }
        });
        Thread tswmc2 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                swmcounter.dec();
            }
        });
        tswmc2.start();
        tswmc1.start();

        try {
            tswmc1.join();
            tswmc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(swmcounter.getC());

        SynhWithTwoMonCounter swtmcounter = new SynhWithTwoMonCounter();
        Thread tswtmc1 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                swtmcounter.incC();
            }
        });
        Thread tswtmc2 = new Thread(()->{
            for (int i = 0; i <10000000;i++){
                swtmcounter.decD();
            }
        });
        tswtmc2.start();
        tswtmc1.start();

        try {
            tswtmc1.join();
            tswtmc2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(swtmcounter.getC());
        System.out.println(swtmcounter.getD());
        System.out.println("end "+ Thread.currentThread().getName());



















        Thread t = new Thread(new Runnable() {
            int seconds;
            @Override
            public void run() {

                while (true){
                    try {
                        Thread.sleep(1000);
                        seconds++;
                        System.out.printf("Time:  %d \n ", seconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.setDaemon(true);
        t.start();

        try{
            Thread.sleep(5050);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("end");



    }}