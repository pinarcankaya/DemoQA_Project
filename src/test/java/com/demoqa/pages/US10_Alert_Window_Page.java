package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US10_Alert_Window_Page {

    public US10_Alert_Window_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class ='card-body'])[3]")
    public WebElement alertFrameWindowsLink;

    @FindBy(xpath = "(// span [@class= 'text'])[11]")
    public WebElement browserLink;

    @FindBy(xpath = "(//ul[@class='menu-list'])[3]/li")
    public List<WebElement> alertMenuBoxsesLocationList;


    @FindBy(id="tabButton")
    public  WebElement newTabButton;

    @FindBy(id="windowButton")
    public  WebElement newWindowButton;

    @FindBy(id="messageWindowButton")
    public  WebElement newWindowMessageButton;

    @FindBy(id="sampleHeading")
    public  WebElement samplePageMessage;

    @FindBy(xpath = "//body[@data-new-gr-c-s-check-loaded='14.1014.0']")   //
    public WebElement newWindowsMessageText;

    @FindBy (xpath = "/html/body")
    public  WebElement new2WindowsMessageText;

}
