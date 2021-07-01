package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US27_Droppable_Page {
    public US27_Droppable_Page() { PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath ="//h5[.='Interactions']" )
    public WebElement interactions;

    @FindBy (xpath ="//span[.='Droppable']" )
    public WebElement droppableButton;

    @FindBy (xpath ="//a[@role='tab']" )
    public List<WebElement> tabs;

    @FindBy (xpath ="//div[contains(@class,'drag-box')]" )
    public List<WebElement> smallBoxs;

    @FindBy (xpath ="//div[contains(@class,'drop-box ui-droppable')]" )
    public List<WebElement> bigBoxs;

    @FindBy (xpath ="//div[contains(@class,'drop-box-outer mt-4 ui-droppable')]" )
    public List<WebElement> outerDroppable;

    @FindBy (xpath ="//p" )
    public List<WebElement> pText;
}
