package com.xmly.cases.android.liveindex;

import com.xmly.action.MyException;
import com.xmly.cases.android.AndroidBaseCase;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/27
 * Time: 23:14
 * case编号：LiveIndex_02
 * 检查存在我要直播按钮
 */

public class CaseCheckCreateLiveRoomBtn extends AndroidBaseCase {
    @Test
    public static void checkCreateLiveRoomBtn() throws InterruptedException, IOException, MyException {
        basePage.enter(basePage.LiveHomePage);
        assertHelper.assertTrue(liveIndexPage.createLiveRoomBtn.isDisplayed());
    }
}
