package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class US01_TextBox_Page {

    public US01_TextBox_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//div[@class='card-up']")
    public WebElement elementsCard;


    @FindBy(xpath = "//div[@class='header-text'][1]")
    public WebElement elementsMenu;  //gerekli degil acik geliyor

    @FindBy(xpath = "(//ul[@class='menu-list'])[1]/li")
    public List<WebElement> menuList;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement textBoxHeader;

    @FindBy(xpath = "//span[.='Text Box']")
    public WebElement textBoxMenuLink;


    @FindBy(xpath = "//form[@id='userForm']/div")
    public List<WebElement> formList;


}
