
package com.herokuapp.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//Ексклюзивна перша оренда: стильна квартира у Клубному будинку з дизайнерським ремонтом
public class FramesTest extends BaseTest {


    //Мої зміни домашє
    @Test
    public void switchToFrame() {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-bottom");

        String bodyText = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyText, "BOTTOM", "Wrong frame");

        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
    }

}
