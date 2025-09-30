package org.de;

import java.util.ArrayList;
import java.util.List;

public class MultiThreadingVisitor {
    public SiteVisitCounter siteVisitCounter;
    public List<Thread> threads = new ArrayList<>();
    private long totalTime;

    public MultiThreadingVisitor(SiteVisitCounter siteVisitCounter) {
        this.siteVisitCounter = siteVisitCounter;
    }

    public void visitMultiThread(int numOfThreads) {
        threads.clear();
        long start = System.currentTimeMillis();

        for (int i = 0; i < numOfThreads; i++) {
            Thread thread = new Thread(() -> {
                siteVisitCounter.incrementVisitCount();
            });
            threads.add(thread);
            thread.start();
        }

        try {
            waitUntilAllVisited();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        totalTime = System.currentTimeMillis() - start;
    }

    public void waitUntilAllVisited() throws InterruptedException {
        for (Thread thread : threads) {
            thread.join();
        }
    }

    public long getTotalTimeOfHandling () {
        return totalTime / 1000;
    }


}
