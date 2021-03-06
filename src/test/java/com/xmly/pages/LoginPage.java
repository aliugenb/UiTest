package com.xmly.pages;

import com.xmly.utils.CommonUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Created with IntelliJ IDEA.
 * Author: ye.liu
 * Date: 2019/1/2
 * Time: 5:07 PM
 */
public class LoginPage extends BasePage {



    public LoginPage(AppiumDriver<? extends MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_login_more")
    public MobileElement moreLoginBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_login_with_pwd")
    public MobileElement loginByPwdBtn;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_username")
    public MobileElement userNameInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_password")
    public MobileElement passwdInput;

    @AndroidFindBy(id = "com.ximalaya.ting.android:id/main_login")
    public MobileElement loginBtn;

    public void login(String userName, String passwd) {
        moreLoginBtn.click();
        loginByPwdBtn.click();
        userNameInput.sendKeys(userName);
        CommonUtil.sleep(6);
        passwdInput.sendKeys(passwd);
        CommonUtil.sleep(6);
        loginBtn.click();
    }
}
