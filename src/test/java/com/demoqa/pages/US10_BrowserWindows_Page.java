package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US10_BrowserWindows_Page {

    public US10_BrowserWindows_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[3]")
    public WebElement alertFrameWindowsCard;


    @FindBy(xpath = "//span[.='Browser Windows']")
    public WebElement browserWindowsMenuLink;



    @FindBy(xpath = "(//ul[@class='menu-list'])[3]/li")    //////li[contains(@id,'item')]
    public List<WebElement>  allMenuList;

    
    @FindBy(xpath = "//button[contains(@id,'Button')]")    
    public List<WebElement> buttonList;


    @FindBy(xpath = "//h1[.='This is a sample page']")
    public WebElement samplePageText;


    @FindBy(tagName = "body")   ////body[contains(text(),'Knowledge increases')]
    public WebElement newWindowsMessageText;
}
