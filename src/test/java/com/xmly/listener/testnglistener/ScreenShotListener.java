package com.xmly.listener.testnglistener;

import com.xmly.common.MyException;
import com.xmly.driver.BaseDriver;
import com.xmly.driver.Driver;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.driver.ios.IosBaseDriver;
import com.xmly.utils.FilesInit;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 11:35 AM
 */
public class ScreenShotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        super.onTestFailure(result);
        try {
            captureScreenShot(result);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private void captureScreenShot(ITestResult result) throws MyException {
        AppiumDriver driver = BaseDriver.getDriver();

        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String screenShotName = FilesInit.resultPath + File.separator +
                result.getMethod().getMethodName() + "-" + dateFormat.format(now) + ".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenShotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}