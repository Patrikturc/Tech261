package selenium;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoqaTests extends BaseTestConfig {
    private static final String BASE_URL = "https://demoqa.com/droppable/";

    @Test
    @DisplayName("Drag and drop test")
    public void dragAndDropTest() {
        webDriver.get(BASE_URL);

        Wait<WebDriver> wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        WebElement dragMe = wait.until(driver -> driver.findElement(By.id("draggable")));
        WebElement dropHere = webDriver.findElement(By.id("droppable"));

        Actions actions = new Actions(webDriver);
        actions.dragAndDrop(dragMe, dropHere).perform();

        WebElement droppedText = dropHere.findElement(By.tagName("p"));
        MatcherAssert.assertThat(droppedText.getText(), Matchers.is("Dropped!"));
    }
}
