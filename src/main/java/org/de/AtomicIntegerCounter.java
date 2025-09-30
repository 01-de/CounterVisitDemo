package org.de;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerCounter implements SiteVisitCounter{
    public static AtomicInteger atomicCounter = new AtomicInteger(0);

    @Override
    public void incrementVisitCount() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicCounter.incrementAndGet();
    }

    @Override
    public int getVisitCount() {
        return atomicCounter.get();
    }
}
