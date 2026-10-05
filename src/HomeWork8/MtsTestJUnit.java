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
    MtsPage mtsPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        mtsPage = new MtsPage(driver);
        driver.get("https://www.mts.by/");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkOnlinePaymentBlock() {
        assertTrue(mtsPage.isOnlinePaymentTitleDisplayed());
    }

    @Test
    void checkPaymantLogo() {
        assertTrue(mtsPage.isVisaLogoDisplayed());
    }

    @Test
    void checkMastercardLogo() {
        assertTrue(mtsPage.isMastercardLogoDisplayed());
    }

    @Test
    void checkMoreDetailsLink() {
        assertTrue(mtsPage.isMoreDetailsLinkDisplayed());
    }

    @Test
    void checkContinueButton() throws InterruptedException {
        mtsPage.enterPhone("297777777");
        mtsPage.enterAmount("10");

        Thread.sleep(500);

        assertTrue(mtsPage.isContinueButtonDisplayed());
    }
}

