package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US19_ProgressBar_Page {

    public US19_ProgressBar_Page(){ PageFactory.initElements(Driver.getDriver(),this); }

    @FindBy(xpath = "//h5[.='Widgets']")
    public WebElement Widgets;

    @FindBy(xpath = "//span[contains(text(),'Progress')]")
    public WebElement ProgressBarButton;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement Header;

    @FindBy(id = "startStopButton")
    public WebElement startStopButton;

    @FindBy(xpath = "//div[@role='progressbar']")
    public WebElement ProgressLoadBar;

    @FindBy(id = "resetButton")
    public WebElement resetButton;




}
