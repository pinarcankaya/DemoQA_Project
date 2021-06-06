package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US08_DynamicProperties_Page {


    public US08_DynamicProperties_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;


    @FindBy(xpath = " //span[.='Dynamic Properties']")
    public WebElement dynamicPropertiesMenuLink;


    @FindBy(xpath = "//p[.='This text has random Id']")
    public WebElement randomText;

    @FindBy(xpath = "//button[@id='enableAfter']")
    public WebElement enableButton;

    @FindBy(xpath = "//button[@id='colorChange']")
    public WebElement colorChangeButton;

    @FindBy(xpath = "//button[@id='visibleAfter']")
    public WebElement visibleButton;


    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement dynamicPageHeader;
}
