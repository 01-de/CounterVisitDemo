package org.de;

public class VolatileCounter implements SiteVisitCounter {
    public volatile int counter;

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        counter++;
    }

    @Override
    public int getVisitCount() {
        return counter;
    }
}
