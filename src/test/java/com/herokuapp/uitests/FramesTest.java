
package com.herokuapp.uitests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//Користувач може видаляти адреси лише зі сторінки “Мої адреси”.
//Користувач може видаляти як власноруч додані адреси, так і ті, що тягнуться з ОР B2C (коректні і некоректні).
//Наразі можливе видалення лише по тапу на кнопку Редагувати.
//По свайпу видалення поки не реалізовуємо.
//Масове видалення неможливе.
public class FramesTest extends BaseTest {
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
