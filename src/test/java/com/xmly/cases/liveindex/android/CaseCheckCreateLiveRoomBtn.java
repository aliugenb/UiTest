package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import com.xmly.common.FindElementHelper;
import com.xmly.common.MyException;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 */

public class CaseCheckCreateLiveRoomBtn extends CaseHelper {
    @Test(description = "检查直播首页存在我要直播按钮")
    public void checkCreateLiveRoomBtn() throws InterruptedException, IOException, MyException {
        gotoLiveIndex();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.createLiveRoomBtn),
                getCurClassName() + "首页存在我要直播按钮");
        login();
        liveIndexPage.gotoCreateLiveRoomPage();
        assertHelper.assertTrue(DriverHelper.isDisplayed(createLiveRoomPage.beginLiveBtn),
                getCurClassName() + "判断创建页面存在开始按钮");
    }
}
