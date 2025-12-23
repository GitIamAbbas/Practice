package org.sample;

import java.util.stream.IntStream;

public class ForLoopVsStream {
    private void calculateSumOfEvenNumbers(){
        var startTime = System.nanoTime();

        // This simple code takes more time. Setup cost dominates small workloads. For only 10,000 iterations, the overhead of streams > actual work.
        System.out.println(IntStream.rangeClosed(1,10000).filter(n -> n%2 ==1).sum());
        System.out.println(System.nanoTime() - startTime);

        var startTime1 = System.nanoTime();
        // This will take less time because JVM can optimize this into something very close to pure arithmetic.
        var sum = 0;
        for(int i=1; i<=10000; i++)
        {
            if(i%2 == 1){
                sum = sum +i;
            }
        }
        System.out.println(sum);
        System.out.println(System.nanoTime() - startTime1);


    }
}
