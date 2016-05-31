package com.epam.engx.drills.bowling;

/**
 * @author Nurmakanov
 */
public class AmazinlySlowReporter {

    public void report(String text)  {
        initReports();
        buildReports();
        writeReports();
    }

    private void initReports() {
        SleepUtils.sleep(5000);
    }

    private void buildReports() {
        SleepUtils.sleep(10000);
    }

    private void writeReports() {
        SleepUtils.sleep(5000);
    }
}
