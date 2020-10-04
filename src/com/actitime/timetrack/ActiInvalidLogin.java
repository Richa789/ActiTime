package com.actitime.timetrack;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.genericLib.WebdriverCommonLib;
import com.actitime.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;
@Listeners(com.actitime.genericLib.MyListeners.class)
public class ActiInvalidLogin extends BaseTest {
    @Test
    public void invalidLoginTest() throws IOException, InterruptedException {
        Assert.fail();
        FileLib flib = new FileLib();
        int lastRowNum = flib.getRowCount(EXCEL_PATH, "Invalid");
        for(int i = 0; i <= lastRowNum; i++) {
            WebdriverCommonLib wlib = new WebdriverCommonLib();
            LoginPage lp = new LoginPage(driver);
            lp.login(flib.getCellData(EXCEL_PATH, "Invalid", i, 0), flib.getCellData(EXCEL_PATH, "Invalid", i, 1));
            Thread.sleep(2000);
            wlib.waitForPageTitle(flib.getPropKeyValue(PROPERTY_pATH, "loginTitle"));
            wlib.verifyPage(wlib.getPageTitle(), flib.getPropKeyValue(PROPERTY_pATH, "loginTitle"), "LoginTitle");
            Thread.sleep(2000);
            flib.setCellData(EXCEL_PATH, "Invalid", i, 2, "PASS");
        }
    }
}
