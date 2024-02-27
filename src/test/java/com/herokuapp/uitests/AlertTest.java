package com.herokuapp.uitests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest {
    @Test
public void JSPromt(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        String str = "Student";
        WebElement promButton = driver.findElement(By.xpath("button[contains(text(),'JS Prompt')]"));
        promButton.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(str);
        alert.accept();

        String actualResult = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(actualResult,"You entered: " + str );

    }
}
