package com.xmly.cases.anchorliveroom.android;

import com.xmly.cases.CaseHelper;
import com.xmly.pages.live.anchorliveroompage.TopicPage;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019-02-11
 * Time: 14:35
 */
public class CaseTopic extends CaseHelper {
    @Test(description = "主播端发布话题")
    public void checkTopic() throws InterruptedException {

        String topicContent = "大家好";
        TopicPage topicPage = new TopicPage(driver);
        createAnchorLiveRoom();

        anchorRoomIndexPage.gotoTopicPage();
        topicPage.setTopic(topicContent);
        Reporter.log(anchorRoomIndexPage.lastContent().getText());
        assertHelper.assertTrue(anchorRoomIndexPage.lastContent().getText().contains(topicContent),
                "CaseTopic设置话题成功并直播间展示话题");
    }
}
