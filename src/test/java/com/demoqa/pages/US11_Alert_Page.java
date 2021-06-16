package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US11_Alert_Page {

    public US11_Alert_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[.='Alerts, Frame & Windows']")
    public WebElement alertFrameWindowsMenu;

    @FindBy(xpath = "(//li[@id='item-1'])[2]")
    public WebElement alertMenuLink;

    @FindBy(xpath = "//button[contains(@id,'Button')]")
    public List<WebElement> allClickMeButtonList;

    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement clickMe3SuccesText;

    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement clickMe4SuccesText;
}
