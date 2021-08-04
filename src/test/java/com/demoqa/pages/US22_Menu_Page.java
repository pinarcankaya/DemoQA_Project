package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US22_Menu_Page {
    public US22_Menu_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//span[.='Menu']")
    public WebElement menuButton;

    @FindBy(xpath = "//div[@class='pattern-backgound playgound-header']") ////div[.='Menu'])[2]
    public WebElement header;

    @FindBy(xpath = "//*[@id='nav']/li")
    public List<WebElement> items;  //a[contains(text(),'Main Item')] ==>background-color vermiyor

    @FindBy(xpath = "//ul[@id='nav']/li[2]/ul/li")
    public List<WebElement> sub;

    @FindBy(xpath = "//*[@id='nav']/li[2]/ul/li[3]/ul/li")

    public List<WebElement> subSub;            //a[contains(text(),'Sub Sub Item')]==>background-color vermiyor


}

