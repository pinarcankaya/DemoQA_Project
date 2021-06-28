package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.WeakHashMap;

public class US20_Tabs_Page {
    public US20_Tabs_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[4]")
    public WebElement widgetsCard;
    @FindBy(xpath = "//span[contains(text(),'Tabs')]")
    public WebElement tabsButton;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement tabsHeader;
    @FindBy(xpath = "//div[@class='mb-3']")
    public WebElement loramText;
    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> tabs;
    @FindBy(xpath = "//a[@id='demo-tab-origin']")
    public WebElement originTab;
    @FindBy(xpath = "//a[@id='demo-tab-what']")
    public WebElement whatTab;
    @FindBy(xpath = "//a[@id='demo-tab-use']")
    public WebElement useTab;
    @FindBy(xpath = "//a[@id='demo-tab-more']")
    public WebElement moreTab;
    @FindBy(xpath = "//p[@class='mt-3']")
    public List<WebElement> textList;
}
