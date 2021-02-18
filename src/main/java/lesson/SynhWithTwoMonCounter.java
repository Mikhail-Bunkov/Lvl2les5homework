package lesson;

public class SynhWithTwoMonCounter {
    private int c;
    private int d;
    private final Object mon2 = new Object();
    private final Object mon1 = new Object();

    public SynhWithTwoMonCounter() {
        c =0;
    }
    public void incC(){
       synchronized (mon1){
           c++;
       }
    }
    public void decC(){
        synchronized (mon1){
            c--;
        }
    }
    public void incD(){
        synchronized (mon2){
            d++;
        }
    }
    public void decD(){
        synchronized (mon2){
            d--;
        }
    }
    public int getD() {
        return d;
    }

    public int getC() {
        return c;
    }
}
