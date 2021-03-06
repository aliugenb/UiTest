package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:56 PM
 * case编号：LiveIndex_04
 * 显示直播间
 */

public class CaseCheckLiveRoom extends CaseHelper {
    @Test(description = "首页直播间展示正常")
    public void checkLiveRoom() {
        gotoLiveIndex();
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveIndexPage.liveRoom),
                getCurClassName()+"直播首页直播间正常展示");

        liveIndexPage.musicTab.click();
        
    }
}
