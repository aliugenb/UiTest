package com.xmly.cases.userliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.MyException;
import com.xmly.pages.live.RoomType;
import org.testng.annotations.Test;

/**
 * ClassName: CaseEnterLiveByType
 * Author: ye.liu
 * Date: 2019-02-23 15:56
 * Description:
 */
public class CaseEnterLiveByType extends CaseHelper {
//    @Test(description = "进入普通房间")
//    public void enterCommonRoom() {
//        gotoLiveIndex();
//        liveIndexPage.gotoUserLiveRoomByType(RoomType.COMMON);
//        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.COMMON,
//                getCurClassName() + "已进入普通直播间");
//        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.pkStatus) && !DriverHelper.isDisplayed(userRoomIndexPage.requestBtn),
//                getCurClassName() + "普通房间无pk和交友模式按钮");
//        userRoomIndexPage.exitLiveRoom(0);
//    }

    @Test(description = "进入交友模式房间")
    public void enterFriendRoom() throws MyException {
        gotoUserLiveRoomAfterLogin(RoomType.FRIEND);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.FRIEND,
                getCurClassName() + "已进入交友模式直播间");
        exitAnchorLiveRoom(RoomType.FRIEND);
    }

    @Test(description = "进入PK模式房间")
    public void enterPkRoom() throws MyException {
        gotoUserLiveRoomByType(RoomType.PK);
        assertHelper.assertTrue(userRoomIndexPage.getRoomType() == RoomType.PK,
                getCurClassName() + "已进入pk模式直播间");
        exitAnchorLiveRoom(RoomType.PK);
    }

    @Test(description = "进入结束的直播间")
    public void enterEndRoom() {
        restartApp();
        gotoLiveIndex();
        liveIndexPage.gotoLiveDynamicPage();
        liveDynamicPage.enterRoomByType(RoomType.END);
        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.endLiveAnchorName),
                getCurClassName() + "进入已结束的直播间");
        exitAnchorLiveRoom(RoomType.END);
    }

    @Test(description = "进入预告直播间")
    public void enterAppointmentRoom() {
        liveDynamicPage.enterRoomByType(RoomType.PREVIEW);
        assertHelper.assertTrue(DriverHelper.isDisplayed(userRoomIndexPage.liveStartTime),
                getCurClassName() + "进入预告直播间展示预告开始时间");
    }
}
