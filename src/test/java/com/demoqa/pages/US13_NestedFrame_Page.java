package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US13_NestedFrame_Page {
    public US13_NestedFrame_Page(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[3]")
    public WebElement alertFrameCard;
    @FindBy(xpath = "(//*[@id='item-3']/span)[2]")
    public WebElement nestedFrameSegment;
    @FindBy(xpath = "//iframe")
    public List<WebElement> iframeList;
    @FindBy(xpath = "//iframe")
    public WebElement iframe;
    @FindBy(css = "body")
    public WebElement parentFrameText;
    @FindBy(tagName = "p")
    public WebElement childFrameText;
    @FindBy(id = "framesWrapper")
    public WebElement sampleNestedText;
}
