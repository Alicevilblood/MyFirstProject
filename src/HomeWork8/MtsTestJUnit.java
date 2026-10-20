package HomeWork8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTestJUnit {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.elementToBeClickable(By.id("cookie-agree")))
                    .click();
        } catch (TimeoutException ignored) {
        }
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkOnlinePaymentBlock() {
        String title = driver.findElement(By.cssSelector(".pay__wrapper h2")).getAttribute("textContent");
        assertEquals("Онлайн пополнение без комиссии", title.replaceAll("\\s+", " ").trim());
    }

    @Test
    void checkPaymentLogos() {
        List<WebElement> logos = driver.findElements(By.cssSelector(".pay__partners img"));
        assertEquals(5, logos.size(), "Должно быть 5 логотипов");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Не виден логотип " + logo.getAttribute("alt"));
        }
    }

    @Test
    void checkMoreDetailsLink() {
        driver.findElement(By.linkText("Подробнее о сервисе")).click();
        boolean opened = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertTrue(opened, "Ссылка открыла не ту страницу");
    }

    @Test
    void checkContinueButton() {
        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("10");
        driver.findElement(By.cssSelector("#pay-connection button[type='submit']")).click();

        WebElement paymentFrame = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("iframe.payment-widget-iframe")));
        assertTrue(paymentFrame.isDisplayed(), "Окно оплаты не открылось");
    }
}
