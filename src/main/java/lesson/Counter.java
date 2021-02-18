package lesson;

public class Counter {
    private int c;

    public Counter() {
        c =0;
    }
    public void inc(){
        c++;
    }
    public void dec(){
        c--;
    }

    public int getC() {
        return c;
    }
}
