package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US05_Buttons_Page {
    public US05_Buttons_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(xpath = "//span[.='Buttons']")
    public WebElement buttonsMenu;


    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement> buttonList;


    @FindBy(xpath = "//p[contains(@id,'ClickMessage')]")
    public List<WebElement> clickMessageList;


}
