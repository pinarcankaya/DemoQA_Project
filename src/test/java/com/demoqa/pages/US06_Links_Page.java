package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US06_Links_Page {

    public US06_Links_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;


    @FindBy(xpath = "//span[.='Links']")
    public WebElement linksMenuLink;


    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement linkHeader;


    @FindBy(xpath = "//a[@id='simpleLink']")
    public WebElement homeLink;


}
