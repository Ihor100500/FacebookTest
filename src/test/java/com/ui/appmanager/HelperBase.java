package com.ui.appmanager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperBase {

    protected final WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text!=null){
            String existingTest = driver.findElement(locator).getAttribute("value");
            if (!text.equals(existingTest)){

              driver.findElement(locator).clear();
                driver.findElement(locator).sendKeys(text);
            }
        }
    }

    public void checkText(By postedTextLocator , String generatedText){

        Assert.assertEquals(driver.findElement(postedTextLocator).getText() , generatedText);
    }


    public void waitForVisibility(WebElement element){
        new WebDriverWait(driver , 10 , 1000).
                until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForTextPresent(By locator , String text){
        new WebDriverWait(driver , 10, 1000).
                until(ExpectedConditions.textToBePresentInElementLocated(locator , text));
    }

    //By.cssSelector("div[class='uiContextualLayerPositioner uiLayer']")
    public void waitForElementPrecence(By locator){
        new WebDriverWait(driver , 10 , 1000).
                until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //By.cssSelector("div[class='uiContextualLayerPositioner uiLayer']")
    public void waitForVisibilityOfAllElements(By locator){
        new WebDriverWait(driver , 10 , 1000).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }



}
