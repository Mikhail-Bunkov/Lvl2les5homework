package lesson;

public class SynhCounter {
    private int c;

    public SynhCounter() {
        c =0;
    }
    public synchronized void inc() {
        c++;
    }
    public synchronized void dec(){
        c--;
    }

    public int getC() {
        return c;
    }
}
