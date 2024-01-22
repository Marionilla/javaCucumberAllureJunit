package com.saucedemo.proj;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParallelCucumberTestRunner {
    private final String threadCount;
    private static final Logger logger = LogManager.getLogger(ParallelCucumberTestRunner.class);


    @Parameterized.Parameters
    public static Collection<String> data() {
        String threadCount = System.getProperty("thread.count", "1" );
        CucumberContext.setThreadCount(threadCount);
        return Arrays.asList(CucumberContext.getThreadCount());
    }

    public ParallelCucumberTestRunner(String threadCount) {
        this.threadCount = threadCount;
    }
//    private static String getThreadCount() {
//        String threadCount = System.getProperty("thread.count");
//        return threadCount != null ? threadCount : "3";
//    }
    @Test
    public void runCucumberTests() {
        logger.info("!!!!!!!!!Running Cucumber tests in thread: {}", Thread.currentThread().getName());
       // io.cucumber.core.cli.Main.run(new String[]{"--threads", getThreadCount(), "--glue", "com.saucedemo.proj.tests", "src/test/java/com/saucedemo/proj/resources"});
         JUnitCore.runClasses(RunMyTests.class);
    }
}
