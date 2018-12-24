package com.skyscanner.webdriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Testing {

    private WebDriver driver;
    private SkyscannerPage page;

    private String destination = "muc";
    private String departure = "msq";
    private int day = 29;
    private int month = 12;
    private int year = 18;
    private int adults = 1;
    private int children = 0;
    private int infants = 0;
    private String cabinClass = "economy";

    @Before
    public void testingSetup(){
        System.setProperty("webdriver.gecko.driver","E:\\Selenium\\geckodriver\\geckodriver.exe");
        driver = new FirefoxDriver();

        String urlData = "transport/flights/" +
                departure + "/" + destination + "/" +
                year + month + day + "/?adults=" +
                adults +"&children=" + children + "&adultsv2=" + adults + "&childrenv2=&infants=" + infants + "&cabinclass="+
                cabinClass +"&rtn=0&preferdirects=false&outboundaltsenabled=false&inboundaltsenabled=false&ref=home#results";

        driver.navigate().to("https://www.skyscanner.net/" + urlData);

        page = PageFactory.initElements(driver, SkyscannerPage.class);
        page.getRouteData();
    }

    @Test
    public void oneWayTest(){
        for (int i = 0; i<page.routes.size();i++) {
            List<WebElement> points = page.routes.get(i).findElements(By.cssSelector("span[data-e2e='city']"));

            assert (points.size() == 2) : "ticket type is not one-way";
        }
        System.out.println("OneWayTest passed");
    }

    @Test
    public void pointsTest(){
        for (int i = 0; i<page.routes.size();i++){
            List<WebElement> points = page.routes.get(i).findElements(By.cssSelector("span[data-e2e='city']"));

            assert(points.get(0).getText().equals(departure)):
                    "point of departute does not match the searched one";
            assert(points.get(1).getText().equals(destination)):
                    "point of destination does not match the searched one";
        }
        System.out.println("PointsTest passed");
    }


    @After
    public void finish(){
        driver.close();
    }
}