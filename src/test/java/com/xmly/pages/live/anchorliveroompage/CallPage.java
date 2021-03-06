package com.xmly.pages.live.anchorliveroompage;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/5
 * Time: 4:54 PM
 * 连麦页面
 */
public class CallPage extends AnchorRoomIndexPage {
    public CallPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_onMicNumTv")
    public MobileElement onCallNum; //左上角连麦状态（开启状态及人数）

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/live_openCallCb")
    public MobileElement openCallSwitch; //连麦开关

    //开启或者关闭连麦
    public void switchCall(){
        openCallSwitch.click();
    }


}
