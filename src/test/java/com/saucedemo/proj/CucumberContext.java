package com.saucedemo.proj;

public class CucumberContext {
    private static ThreadLocal<String> threadCount = new ThreadLocal<>();

    public static String getThreadCount() {
       return threadCount.get();
    }

    public static void setThreadCount(String count) {
        threadCount.set(count);
    }

}
