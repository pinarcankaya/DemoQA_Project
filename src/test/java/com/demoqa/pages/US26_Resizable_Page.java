package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US26_Resizable_Page {

    public US26_Resizable_Page() { PageFactory.initElements(Driver.getDriver(),this);}


    @FindBy(xpath = "(//div[@class='card-up' ])[5]")
    public WebElement interactionsMenuCard;


    @FindBy(xpath = "(//li[@id='item-2'])[4]")
    public WebElement resizableMenuLink;


    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement resizableMainHeader;


    @FindBy(xpath = "//span[@class='react-resizable-handle react-resizable-handle-se']")
    public List<WebElement> resizableBoxCekmeNoktasi;


    @FindBy(xpath = "//div[@class='box react-resizable']")
    public List<WebElement> resizableBoxList;
}
