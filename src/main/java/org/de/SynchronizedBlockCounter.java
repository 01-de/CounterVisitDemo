package org.de;

public class SynchronizedBlockCounter implements SiteVisitCounter {
    public int counter = 0;
     public static Object lock = new Object();

    @Override
    public void incrementVisitCount() {
        synchronized (lock) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            counter++;
        }
    }

    @Override
    public int getVisitCount() {
        synchronized(lock) {
            return counter;
        }
    }
}
