package lesson;

public class SynhWithMonCounter {
    private int c;
    private final Object mon = new Object();

    public SynhWithMonCounter() {
        c =0;
    }
    public void inc(){
       synchronized (mon){
           c++;
       }
    }
    public void dec(){
        synchronized (mon){
            c--;
        }
    }

    public int getC() {
        return c;
    }
}
