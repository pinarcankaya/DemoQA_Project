package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US22_Menu_Page {

    public US22_Menu_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;

    @FindBy(xpath = "(//li[@id='item-7'])[2]")
    public WebElement menuLink;


    @FindBy(xpath = "//ul[@id='nav']/li")
    public List<WebElement> menuContainerList;


    @FindBy(xpath = "//a[contains(text(),'Main Item')]")
    public List<WebElement> mainItemList;
}

