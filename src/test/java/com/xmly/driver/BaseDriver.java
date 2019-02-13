package com.xmly.driver;

import com.xmly.cases.BaseCase;
import com.xmly.common.ActionHelper;
import com.xmly.common.MyException;
import com.xmly.driver.android.AndroidBaseDriver;
import com.xmly.driver.android.AndroidDeviceInfo;
import com.xmly.driver.ios.IosBaseDriver;
import com.xmly.utils.AppiumServer;
import com.xmly.utils.DeviceInit;
import com.xmly.utils.SnapshotAndLog;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

import static com.xmly.utils.FilesInit.apkPath;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/7
 * Time: 2:45 PM
 */
public abstract class BaseDriver implements Driver {

    private static AppiumDriver<? extends MobileElement> driver;

    public static void setDriver(int osDriver) throws MyException, IOException, InterruptedException {
        if (!AppiumServer.startAppium()) {
            throw new MyException("appium未启动");
        }

        if (osDriver == Driver.AndroidDriver) {
            driver = new AndroidBaseDriver().getDriver();
            SnapshotAndLog.clearAndroidLog();
            String uninstallCmd = "adb uninstall com.ximalaya.ting.android";
            ActionHelper.execCmd(uninstallCmd);
            TimeUnit.SECONDS.sleep(3000);

            System.out.println("++++++++++++==========");
            driver.installApp(apkPath);
        } else if (osDriver == Driver.IosDriver) {
//            BaseDriver.driver = IosBaseDriver.getDriver();
            System.out.println("还没做呢");
        } else {
            throw new MyException("未传入系统类型");
        }
    }

    public static AppiumDriver<? extends MobileElement> getDriver() {
        return driver;
    }
}
