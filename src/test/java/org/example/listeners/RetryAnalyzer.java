package org.example.listeners;

import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class RetryAnalyzer  implements IRetryAnalyzer{
    private int retryCount = 0;
    private static final int maxRetryCount = 3;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(retryCount < maxRetryCount){
            retryCount++;
            return true;
        }
        return false;
    }
}
