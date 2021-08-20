package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class US006_Links_Page {

    public US006_Links_Page(){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//div[@class ='card-body'])[1]")
    public WebElement elementsCard;

    @FindBy(xpath = "//span[.='Links']")
    public WebElement links;

    @FindBy(xpath = "//*[@class='main-header']")
    public WebElement headerLinks;

    @FindBy(id = "simpleLink")
    public WebElement homeLink;

    @FindBy(xpath = "//*[@id='moved']")
    public WebElement moved;

    @FindBy(id = "linkResponse")
    public WebElement status;

}
