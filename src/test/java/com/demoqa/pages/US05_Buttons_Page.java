package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US05_Buttons_Page {
    public US05_Buttons_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[1]")
    public WebElement elementCard;
    @FindBy(id = "item-4")
    public WebElement buttonsSegment;
    @FindBy(id = "doubleClickBtn")
    public WebElement doubleClickButton;
    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement mainHeaderText;
    @FindBy(id = "doubleClickMessage")
    public WebElement doubleClickText;
    @FindBy(id = "rightClickBtn")
    public WebElement rigthClickButton;
    @FindBy(id = "rightClickMessage")
    public WebElement rightClickText;
    @FindBy(xpath = "(//button[@class='btn btn-primary'])[3]")
    public WebElement clickMeButton;
    @FindBy(id = "dynamicClickMessage")
    public WebElement clickMeText;
    @FindBy(className = "btn btn-primary")
    public List<WebElement> clickButtons;

}
