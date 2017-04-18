/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Longest_common_subsequence;

/**
 *
 * @author ElizabethReed PC
 */
public class Timer {
    
    long startTime;
    long stopTime;

    Timer() {

    }

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        stopTime = System.nanoTime();
    }

    public void reset() {
        startTime = 0;
        stopTime = 0;
    }

    public long read() {
        long runTime = stopTime - startTime;
        return (runTime);
    }
    
    public String readHR() {
        long ns = read();
        long s = (ns / 1_000_000_000);
        ns -= (s * 1_000_000_000);
        long ms = (ns / 1_000_000);
        ns -= (ms * 1_000_000);
        long us = (ns / 1_000);
        ns -= (us * 1_000);
        String str = String.format("[%03d:%03d:%03d:%03d]", s, ms, us, ns);
        return str;
    }

   

}
