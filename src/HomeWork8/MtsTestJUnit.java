package HomeWork8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    void checkPaymentLogo() {
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

    @Test
    void checkPhonePlaceholder() {
        assertEquals("Номер телефона", mtsPage.getPhonePlaceholder());
    }

    @Test
    void checkAmountPlaceholder() {
        assertEquals("Сумма", mtsPage.getAmountPlaceholder());
    }

    @Test
    void checkEmailPlaceholder() {
        assertEquals("E-mail для отправки чека", mtsPage.getEmailPlaceholder());
    }

    @Test
    void checkInternetPhonePlaceholder() {
        assertEquals("Номер абонента", mtsPage.getInternetPhonePlaceholder());
    }

    @Test
    void checkInternetAmountPlaceholder() {
        assertEquals("Сумма", mtsPage.getInternetAmountPlaceholder());
    }

    @Test
    void checkInternetEmailPlaceholder() {
        assertEquals("E-mail для отправки чека", mtsPage.getInternetEmailPlaceholder());
    }

    @Test
    void checkInstalmentAccountPlaceholder() {
        assertEquals("Номер счета на 44", mtsPage.getInstalmentAccountPlaceholder());
    }

    @Test
    void checkInstalmentAmountInput() {
        assertEquals("Сумма", mtsPage.getInstalmentAmountPlaceholder());
    }

    @Test
    void checkInstalmentEmailInput() {
        assertEquals("E-mail для отправки чека", mtsPage.getInstalmentEmailPlaceholder());
    }

    @Test
    void checkArrearsAccountInput() {
        assertEquals("Номер счета на 2073", mtsPage.getArrearsAccountPlaceholder());
    }

    @Test
    void checkArrearsAmountInput() {
        assertEquals("Сумма", mtsPage.getArrearsAmountPlaceholder());
    }

    @Test
    void checkArrearsEmailInput() {
        assertEquals("E-mail для отправки чека", mtsPage.getArrearsEmailPlaceholder());
    }

    @Test
    void checkRefillFlowForCommunicationServices() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterAmount("10");

        assertEquals("(29)777-77-77", mtsPage.getPhoneValue(),
                "Номер телефона отображается некорректно");

        assertEquals("10", mtsPage.getAmountValue(),
                "Сумма не совпадает с введенной");

        assertTrue(mtsPage.isContinueButtonEnabled(),
                "Кнопка 'Продолжить' должна быть активна");

        mtsPage.acceptCookies();
        mtsPage.clickContinue();
        System.out.println("URL после клика: " + driver.getCurrentUrl());
        System.out.println("Есть cc-number: " + driver.getPageSource().contains("cc-number"));
        mtsPage.waitForPaymentForm();

        assertEquals("+375 29 777-77-77", mtsPage.getModalPhone(),
                "Номер телефона в окне подтверждения некорректен");

        assertEquals("10.00 BYN", mtsPage.getModalAmount(),
                "Сумма в окне подтверждения некорректна");

        assertTrue(mtsPage.getModalContinueButtonText().contains("10"),
                "Сумма на кнопке подтверждения некорректна");

        assertEquals("Номер карты", mtsPage.getCardNumberPlaceholder(),
                "Неверная надпись в поле номера карты");

        assertEquals("ММ / ГГ", mtsPage.getCardExpiryPlaceholder(),
                "Неверная надпись в поле срока действия");

        assertEquals("CVC", mtsPage.getCardCvvPlaceholder(),
                "Неверная надпись в поле CVC");

        assertTrue(mtsPage.arePaymentIconsVisible(),
                "Иконки платёжных систем не отображаются");
    }
}

