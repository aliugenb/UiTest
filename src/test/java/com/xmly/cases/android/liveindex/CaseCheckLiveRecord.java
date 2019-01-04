package com.xmly.cases.android.liveindex;

import com.xmly.cases.android.AndroidBaseCase;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/28
 * Time: 7:53 PM
 * case编号：LiveIndex_03
 * 显示亲密度榜
 */

public class CaseCheckLiveRecord extends AndroidBaseCase {
    @Test
    public void checkLiveRecord() throws InterruptedException {
        basePage.enter(basePage.LiveHomePage);
        String recordText = liveIndexPage.gotoAnchorRankPage();
        System.out.println(recordText);
//        AnchorRankPage anchorRankPage = new AnchorRankPage(driver);
//        System.out.println(anchorRankPage.intimacyRank.getLocation());
//        assertHelper.assertTrue(liveIndexPage.liveRecord.isDisplayed());
        Set<String> contexts = driver.getContextHandles();
        for (String context: contexts){
            if (context.toLowerCase().contains("webview")){
                driver.context(context);
                break;
            }
        }
        System.out.println(driver.findElementByClassName("tab-progress-track").getLocation());
    }
}