package com.herokuapp.uitests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test(dataProvider = "frameTextData")
    public void switchToFrame (String frameMain, String subFrame, String text) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        if (!frameMain.equals("")) {
        driver.switchTo().frame(frameMain);
    }
    driver.switchTo().frame(subFrame);
    String body = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(body,text);
        driver.switchTo().defaultContent();
        Assert.assertEquals(driver.findElements(By.xpath("//frameset/frame")).size(), 2);
    }

        @DataProvider
        public Object[][] frameTextData() {
            return new Object[][]{
                    {"", "frame-bottom", "BOTTOM"},
                    {"frame-top", "frame-left", "LEFT"},
                    {"frame-top", "frame-midle", "MIDDLE"},
                    {"frame-top", "frame-right", "RIGHT"}
            };}}

