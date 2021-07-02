package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US19_ProgressBar_Page {

    public US19_ProgressBar_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='card-up'])[4]")
    public WebElement widgetMenuCard;


    @FindBy(xpath = "//span[.='Progress Bar']")
    public WebElement progressBarMenuLink;

}
