package com.xmly.cases.liveindex.android;

import com.xmly.cases.CaseHelper;
import com.xmly.common.DriverHelper;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-15
 * Time: 15:17
 * 未登录情况下检查直播动态
 */
public class CaseLiveDynamicUnlogin extends CaseHelper {

    @Test(description = "登录情况下进入直播动态")
    public static void checkUnlogin() throws InterruptedException {
        CaseHelper.gotoLiveIndex();
        liveIndexPage.gotoLiveDynamicPage();

        assertHelper.assertTrue(DriverHelper.isDisplayed(liveDynamicPage.goLoginBtn),
                "CaseLiveDynamicUnlogin未登录时显示登录按钮");
        assertHelper.assertTrue(DriverHelper.isDisplayed(liveDynamicPage.hotRecommend),
                "CaseLiveDynamicUnlogin未登录时显示推荐直播间列表");

        liveDynamicPage.goToLogin();
        loginPage.onlineLogin();

        if (DriverHelper.isDisplayed(liveDynamicPage.hotRecommend)) {
            assertHelper.assertTrue(DriverHelper.isDisplayed(liveDynamicPage.noFollowAnchorText),
                    "CaseLiveDynamicUnlogin登录后未关注主播显示\"未关注xxx\"文案");
        } else {
            assertHelper.assertTrue(DriverHelper.isDisplayed(liveDynamicPage.anchorNickName),
                    "CaseLiveDynamicUnlogin登录后显示关注主播");
        }
    }
}