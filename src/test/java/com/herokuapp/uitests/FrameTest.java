package com.herokuapp.uitests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FrameTest extends BaseTest {

    @Test
    private void switchToFrame (String frameName) {
        driver.get("https://the-internet.herokuapp.com/nested_frames");

        if (frameName.equals("frame-top")) {
            driver.switchTo().frame("frame-left");
            driver.switchTo().frame("frame-middle");
            driver.switchTo().frame("frame-right");

        } else if (frameName.equals("frame-bottom")) {
            driver.switchTo().frame("frame-bottom");
        } else{
            WebDriver frame = driver.switchTo().frame(frameName);
        }
        String bodyText = driver.findElement(By.xpath("//body")).getText();
        Assert.assertEquals(bodyText, "LEFT", "Wrong frame");
    }

        @DataProvider(name = "frameTextData")
        public Object[][] frameTextData() {
            return new Object[][]{
                    {"frame-top", "LEFT"},
                    {"frame-top", "MIDDLE"},
                    {"frame-top", "RIGHT"},
                    {"frame-bottom", "BOTTOM"}
            };
        }

}
