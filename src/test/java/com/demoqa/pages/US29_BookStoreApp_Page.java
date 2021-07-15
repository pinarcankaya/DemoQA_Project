package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US29_BookStoreApp_Page {
    public US29_BookStoreApp_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//div[.='Book Store Application']")
    public WebElement bookStoreApp;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement headerBookStore;



}
