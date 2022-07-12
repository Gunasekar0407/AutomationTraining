package TestNG;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersExample implements ITestListener {
    // we implementing default methods of itestlistener

    public void onTestStart(ITestResult result) {
        System.out.println("Test case is going to execute");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("Test case is failed");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case is skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Percentage");
    }

    public void onStart(ITestContext result) {
        System.out.println("Before everything");
    }

    public void onFinish(ITestContext result) {
        System.out.println("After Everything");
    }
}
