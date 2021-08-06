package com.demoqa.pages;

import com.demoqa.tests.US33_Broken_Links;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US33_Broken_Image {
    public US33_Broken_Image() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "(//div[@class='header-wrapper'])[1]")
    public WebElement element;
    @FindBy(xpath = "//div/p")
    public WebElement statusCode;

    @FindBy(id = "item-6")
    public WebElement BrokenLinksImage;
 @FindBy(xpath = "//div/p")
    public List<WebElement> fourObjects;
@FindBy(xpath = "//div/img")
    public List<WebElement> pictures;
@FindBy(xpath = "//div/a[@href]")
    public List<WebElement> links;




}
