package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackPage {

    @FindBy(id="container_users") private WebElement usersTab;
    public WebElement getUsersTab() {
        return usersTab;
    }
    public void clickUsersTab() {
        usersTab.click();
    }
    public EnterTimeTrackPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
