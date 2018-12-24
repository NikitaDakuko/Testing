package com.skyscanner.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SkyscannerPage {

    @FindBy(className = "day-main-content")
    WebElement q;

    List<WebElement> routes;

    void getRouteData(){
        routes = q.findElement(By.tagName("ul")).findElements(By.tagName("article"));
    }
}
