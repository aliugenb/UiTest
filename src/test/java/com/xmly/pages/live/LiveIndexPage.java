package com.xmly.pages.live;

import com.xmly.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import org.junit.Test;
import org.testng.Assert;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2018/11/8
 * Time: 11:09 AM
 * 直播首页
 */
public class LiveIndexPage extends BasePage {

    {
        enter(LiveHomePage);
    }

    public LiveIndexPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    private MobileElement SearchBar;

    @AndroidFindBy(id = "com.ximalaya.ting.android.main.application:id/main_tv_search_bar_action")
    private MobileElement createLiveRoomBtn;

    @AndroidFindAll({
            @AndroidBy(uiAutomator = "new UiSelector().text(\"亲密度周榜\")"),
            @AndroidBy(id = "com.ximalaya.ting.android.liveindex.application:id/live_home_anchor_rank_tv")})
    private MobileElement liveRecord;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_tab_layout")
    private List<MobileElement> liveTabs;

    @AndroidFindBy(id = "com.ximalaya.ting.android.live.application:id/live_item_record_cover")
    private MobileElement liveRoom;


    public void isLiveRoomSearchBarDisplayed() {
        Assert.assertTrue(SearchBar.isDisplayed(), "搜索状态栏存在");
    }

    public void isLiveRecordDisplayed() {
        Assert.assertTrue(liveRecord.isDisplayed(), "排行榜存在");
    }

    public void isCreateLiveRoomBtnDisplayed() {
        Assert.assertTrue(createLiveRoomBtn.isDisplayed(), "我要直播存在");
    }

    public void isLiveRoomDisplayed() {
        Assert.assertTrue(liveRoom.isDisplayed(), "我要直播存在");
    }

    public int getLiveTabQty() {
        return liveTabs.size();
    }

    public void clickCreateLiveRoomBtn() {
        createLiveRoomBtn.click();
    }

    public void clickLiveRoom() {
        liveRoom.click();
    }
}
