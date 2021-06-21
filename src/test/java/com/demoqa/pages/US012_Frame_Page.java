package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US012_Frame_Page {

    public US012_Frame_Page() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//span[@class='text'])[13]")
    public WebElement frames;

    @FindBy(css = "#frame2")
    public WebElement frame2;

    @FindBy(xpath = "//h1[@id='sampleHeading']")
    public WebElement frame2Text;


    @FindBy(xpath = "(//div[@class='header-right'])[3]")
    public WebElement alertFrameWindows;
}
