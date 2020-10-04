package com.actitime.timetrack;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.genericLib.IAutoConstants;
import com.actitime.genericLib.WebdriverCommonLib;
import com.actitime.pages.LoginPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

@Listeners(com.actitime.genericLib.MyListeners.class)
public class ValidLoginTest extends BaseTest {
    @Test
    public void validLogin() throws IOException, InterruptedException {
        LoginPage lp = new LoginPage(driver);
        FileLib flib = new FileLib();
        lp.login(flib.getPropKeyValue(PROPERTY_pATH, "username"), flib.getPropKeyValue(PROPERTY_pATH, "password"));
        WebdriverCommonLib wlib = new WebdriverCommonLib();
        wlib.waitForPageTitle(flib.getPropKeyValue(PROPERTY_pATH, "homeTitle"));
        wlib.verifyPage(wlib.getPageTitle(), flib.getPropKeyValue(PROPERTY_pATH, "homeTitle"), "HomeTitle");
        Thread.sleep(4000);
    }
}

