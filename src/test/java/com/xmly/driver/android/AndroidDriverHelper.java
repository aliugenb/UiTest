package com.xmly.driver.android;

import com.xmly.action.KEY;
import com.xmly.action.MyException;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import static com.xmly.action.ActionHelper.execCmd;
import static com.xmly.action.ActionHelper.formatMin;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 5:39 PM
 */
public class AndroidDriverHelper extends AndroidBaseDriver {

    //根据设定时长滑动页面
    public void swipUpAndDownByTime(int time) throws InterruptedException, IOException, MyException {
        int width = driver.manage().window().getSize().width;
        int height = driver.manage().window().getSize().height;
        long s = (new Date()).getTime();
        while ((new Date()).getTime() - s < formatMin(time)) {
//            checkInFanli();
            for (int i1 = 0; i1 <= 8; i1++) {
                TouchAction action = new TouchAction(driver).press(width / 2, height * 5 / 7).waitAction().moveTo(width / 2, height * 2 / 7).release();
                action.perform();
                Thread.sleep(1000);
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                TouchAction action1 = new TouchAction(driver).press(width / 2, height * 2 / 7).waitAction().moveTo(width / 2, height * 5 / 7).release();
                action1.perform();
                Thread.sleep(1000);
            }
        }
    }


    //点击系统按钮
    public static void pressKey(KEY keyCode) throws IOException {
        if (keyCode.equals(KEY.BACK)) {
            //点击返回键
            execCmd("adb shell input keyevent 4");
        } else if (keyCode.equals(KEY.ENTER)) {
            //点击ENTER键
            execCmd("adb shell input keyevent 66");
        } else if (keyCode.equals(KEY.HOME)) {
            //点击HOME键
            execCmd("adb shell input keyevent 3");
        }
    }

    //获取中心点击坐标
    public static String getCenterCoordinates(AndroidElement androidElement) {
        String coordinates = null;
        int x = androidElement.getCenter().getX();
        int y = androidElement.getCenter().getY();
        coordinates = "" + x + " " + y + "";
        return coordinates;
    }

    public List<AndroidElement> getElementsByResourceId(String resourceId) {
        List<AndroidElement> lis = (List<AndroidElement>) driver.findElementsById(resourceId);
        return lis;
    }
}
