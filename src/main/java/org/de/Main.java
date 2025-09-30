package org.de;
public class Main {
    public static void main(String[] args) throws InterruptedException {
        SiteVisitCounter[] counters = {
                new UnSynchronizedCounter(),
                new VolatileCounter(),
                new SynchronizedBlockCounter(),
                new AtomicIntegerCounter(),
                new ReentrantLockCounter()
        };

        String[] names = {
                "UnSynchronized",
                "Volatile",
                "Synchronized",
                "AtomicInteger",
                "ReentrantLock"
        };

        for (int i = 0; i < counters.length; i++) {
            System.out.println(names[i]);
            MultiThreadingVisitor visitor = new MultiThreadingVisitor(counters[i]);

            visitor.visitMultiThread(10);
            System.out.println("10 threads -> Time: " + visitor.getTotalTimeOfHandling() + counters[i].getVisitCount());
            System.out.println("Result of counter is: " + counters[i].getVisitCount());

            visitor.visitMultiThread(100);
            System.out.println("100 threads -> Time: " + visitor.getTotalTimeOfHandling() + counters[i].getVisitCount());
            System.out.println("Result of counter is: " + counters[i].getVisitCount());

        }


    }
}