package com.xmly.common;


import com.xmly.utils.CommonUtil;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-18
 * Time: 18:33
 */

public class Swipe {

    // 上滑
    public static void swipeUp(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width / 2, height * 5 / 7))
                .moveTo(PointOption.point(width / 2, height * 2 / 7)).release().perform();
    }

    // 下滑
    public static void swipeDown(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(width / 2, height * 2 / 7))
                .moveTo(PointOption.point(width / 2, height * 5 / 7)).release()
                .perform();
    }

    // 左滑
    public static void swipeLeft(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver)
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    // 右滑
    public static void swipeRight(AppiumDriver driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2)).release()
                .perform();
    }

    //根据设定时长上下滑动页面
    public static void swipUpAndDownByTime(AppiumDriver driver, int time) throws InterruptedException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        long s = (new Date()).getTime();
        while ((new Date()).getTime() - s < CommonUtil.formatMin(time)) {
            for (int i1 = 0; i1 <= 8; i1++) {
                TouchAction action = new TouchAction(driver).press(PointOption.point(width / 2, height * 5 / 7))
                        .waitAction().moveTo(PointOption.point(width / 2, height * 2 / 7)).release();
                action.perform();
                Thread.sleep(1000);
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                TouchAction action1 = new TouchAction(driver).press(PointOption.point(width / 2, height * 2 / 7))
                        .waitAction().moveTo(PointOption.point(width / 2, height * 5 / 7)).release();
                action1.perform();
                Thread.sleep(1000);
            }
        }
    }
}
