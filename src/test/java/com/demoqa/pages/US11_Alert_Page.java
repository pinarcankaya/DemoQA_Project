package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US11_Alert_Page {

    public US11_Alert_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;

    @FindBy(xpath = "//div[@class='header-text']")
    public WebElement elementsMenuLink;

    @FindBy(xpath = "(//div[@class='header-text'])[3]")
    public WebElement alertFrameWindoswMenu;

    @FindBy(xpath = "(//li[@id='item-1'])[2]")
    public WebElement alertMenuLink;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement>  allClickMeButton;

    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement alert3SuccesText;

    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement alert4SuccesText;



    @FindBy(xpath = "//span[.='On button click, prompt box will appear']")
    public WebElement clickMe4AllText;
}
