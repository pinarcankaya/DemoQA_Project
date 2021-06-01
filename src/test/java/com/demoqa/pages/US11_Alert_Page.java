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

    @FindBy(xpath = "(//li[@id='item-1'])[2]")
    public WebElement alert;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    public List<WebElement> clickMe;

    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement textAlert3;

    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement textAlert4;
}
