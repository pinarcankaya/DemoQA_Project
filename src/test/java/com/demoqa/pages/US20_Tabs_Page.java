package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US20_Tabs_Page {

    public US20_Tabs_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;


    @FindBy(xpath = "//span[.='Tabs']")
    public WebElement tabsMenuLink;


    @FindBy(xpath = "//a[@role='tab']")
    public List<WebElement> tabsList;

    @FindBy(xpath = "//p[@class='mt-3']")
    public List<WebElement> tabsParagrafList;



}
