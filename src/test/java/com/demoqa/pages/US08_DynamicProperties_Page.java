package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US08_DynamicProperties_Page {

    public US08_DynamicProperties_Page(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement ElementsButton;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    public WebElement DynamicPropertiesButton;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement MainHeader;

    @FindBy(tagName = "p")
    public WebElement RandomIdText;

    @FindBy(xpath = "//button[contains(text(),'Will enable')]")
    public WebElement WillEnable5sec;

    @FindBy(id ="enableAfter")
    public WebElement colorButton;


    @FindBy(xpath = "//button[@class='mt-4 text-danger btn btn-primary']")
    public WebElement colorButton2;

    @FindBy(id = "visibleAfter")
    public WebElement VisiableAfter5;

    @FindBy(id="visibleAfter")
    public List<WebElement> VisibleAfter5List;











}
