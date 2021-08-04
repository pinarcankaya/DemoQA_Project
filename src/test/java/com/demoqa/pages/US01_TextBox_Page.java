package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US01_TextBox_Page {

    public US01_TextBox_Page () {PageFactory.initElements(Driver.getDriver(), this);}

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy (xpath = "//li[@id='item-0'][1]")
    public WebElement textBoxButton;

    @FindBy(xpath = "//div[@class='main-header']")
    public  WebElement textBoxHeader;

    @FindBy(id = "userName")
    public WebElement fullName;

    @FindBy (id="userEmail")
    public WebElement email;

    @FindBy (id="currentAddress")
    public WebElement currentAddress;

    @FindBy (id="permanentAddress")
    public WebElement permanentAddress;

    @FindBy (id="submit")
    public WebElement submit;

    @FindBy (id ="output")
    public WebElement output;

    @FindBy(id="userForm")
    public WebElement userForm;

    @FindBy(xpath = "//div[@class='border col-md-12 col-sm-12']")
    public WebElement submitOutput;


}
