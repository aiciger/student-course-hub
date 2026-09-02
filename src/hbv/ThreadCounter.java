package hbv;

public class ThreadCounter {
    static int counter = 0;

    public synchronized static int getCounter() {
        return counter;
    }

    public synchronized static void incrCounter() {
        counter++;
    }

    public synchronized static void decrCounter() {
        counter--;
    }

    public synchronized static void setCounter(int i) {
        counter = i;
    }
}
