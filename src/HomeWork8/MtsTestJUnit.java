package HomeWork8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTestJUnit {
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.mts.by/");
        driver.findElement(By.id("cookie-agree")).click();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkOnlinePaymentBlock() {
        assertTrue(driver.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение')]"))
                .isDisplayed());
    }

    @Test
    void checkPaymantLogo() {
        assertTrue(driver.findElement(By.cssSelector("img[alt='Visa']"))
                .isDisplayed());
    }

    @Test
    void checkMastercardLogo() {
        assertTrue(driver.findElement(By.cssSelector("img[alt='MasterCard Secure Code']"))
                .isDisplayed());
    }

    @Test
    void checkMoreDetailsLink() {
        assertTrue(driver.findElement(By.linkText("Подробнее о сервисе"))
                .isDisplayed());
    }

    @Test
    void checkContinueButton() throws InterruptedException {
        driver.findElement(By.id("connection-phone"))
                .sendKeys("297777777");
        driver.findElement(By.id("connection-sum"))
                .sendKeys("10");

        Thread.sleep(500);

        assertTrue(driver.findElement(By.cssSelector("#pay-connection button[type='submit']"))
                .isDisplayed());
    }
}

