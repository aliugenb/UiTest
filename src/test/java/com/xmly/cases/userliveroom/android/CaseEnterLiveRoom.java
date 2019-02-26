package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.driver.Driver;
import com.xmly.pages.live.userliveroompage.RoomType;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveRoom
 * Author: ye.liu
 * Date: 2019-02-23 15:56
 * Description:
 */
public class CaseEnterLiveRoom extends CaseHelper {
//    @Test(description = "进入普通房间")
//    public void enterCommonRoom() {
//        gotoLiveIndex();
//        login();
//        liveIndexPage.gotoUserLiveRoomByType(RoomType.COMMON);
//        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.COMMON,
//                getCurClassName() + "已进入普通直播间");
//        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.pkStatus) && !DriverHelper.isDisplayed(userRoomIndexPage.requestBtn),
//                getCurClassName() + "普通房间无pk和交友模式按钮");
//        userRoomIndexPage.exitLiveRoom(0);
//    }

    @Test(description = "进入交友模式房间")
    public void enterFriendRoom() {
        gotoLiveIndex();
        login();
        liveIndexPage.gotoUserLiveRoomByType(RoomType.FRIEND);
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ximalaya.ting.android.main.application:id/main_content\")).scrollIntoView(new UiSelector().text(\"交友模式\"))")).click();
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.FRIEND,
                getCurClassName() + "已进入交友模式直播间");
        userRoomIndexPage.exitLiveRoom(0);
    }

    @Test(description = "进入PK模式房间")
    public void enterPkRoom() {
//        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.ximalaya.ting.android.main.application:id/main_content\")).scrollIntoView(new UiSelector().text(\"正在PK\"))")).click();
        liveIndexPage.gotoUserLiveRoomByType(RoomType.PK);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.PK,
                getCurClassName() + "已进入pk模式直播间");
    }
}
