package HomeWork8;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTestJUnit {
    private WebDriver driver;
    private MtsPage mtsPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        mtsPage = new MtsPage(driver);
        mtsPage.acceptCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void checkBlockTitle() {
        assertEquals("Онлайн пополнение без комиссии", mtsPage.getBlockTitle());
    }

    @Test
    void checkPaymentLogos() {
        List<WebElement> logos = mtsPage.getPartnerLogos();
        assertEquals(5, logos.size(), "Должно быть 5 логотипов");
        for (WebElement logo : logos) {
            assertTrue(logo.isDisplayed(), "Не виден логотип " + logo.getAttribute("alt"));
        }
    }

    @Test
    void checkMoreDetailsLink() {
        mtsPage.clickMoreDetailsLink();
        assertTrue(mtsPage.isUrlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Ссылка открыла не ту страницу");
    }

    @Test
    void checkContinueButton() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterAmount("10");
        mtsPage.clickContinue();
        assertTrue(mtsPage.isPaymentFrameDisplayed(), "Окно оплаты не открылось");
    }

    @Test
    void checkConnectionPlaceholders() {
        mtsPage.selectPaymentType("Услуги связи");
        assertEquals("Номер телефона", mtsPage.getPlaceholder("connection-phone"));
        assertEquals("Сумма", mtsPage.getPlaceholder("connection-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("connection-email"));
    }

    @Test
    void checkInternetPlaceholders() {
        mtsPage.selectPaymentType("Домашний интернет");
        assertEquals("Номер абонента", mtsPage.getPlaceholder("internet-phone"));
        assertEquals("Сумма", mtsPage.getPlaceholder("internet-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("internet-email"));
    }

    @Test
    void checkInstalmentPlaceholders() {
        mtsPage.selectPaymentType("Рассрочка");
        assertEquals("Номер счета на 44", mtsPage.getPlaceholder("score-instalment"));
        assertEquals("Сумма", mtsPage.getPlaceholder("instalment-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("instalment-email"));
    }

    @Test
    void checkArrearsPlaceholders() {
        mtsPage.selectPaymentType("Задолженность");
        assertEquals("Номер счета на 2073", mtsPage.getPlaceholder("score-arrears"));
        assertEquals("Сумма", mtsPage.getPlaceholder("arrears-sum"));
        assertEquals("E-mail для отправки чека", mtsPage.getPlaceholder("arrears-email"));
    }

    @Test
    void checkRefillFlowForCommunicationServices() {
        mtsPage.enterPhone("297777777");
        mtsPage.enterAmount("10");

        assertEquals("(29)777-77-77", mtsPage.getPhoneValue(),
                "Номер телефона отображается некорректно");
        assertEquals("10", mtsPage.getAmountValue(),
                "Сумма не совпадает с введенной");

        mtsPage.clickContinue();
        mtsPage.switchToPaymentFrame();

        assertEquals("10.00 BYN", mtsPage.getFrameAmount(),
                "Сумма в окне оплаты некорректна");
        assertTrue(mtsPage.getFrameDescription().contains("375297777777"),
                "Номер телефона в окне оплаты некорректен");
        assertEquals("Оплатить 10.00 BYN", mtsPage.getPayButtonText(),
                "Сумма на кнопке некорректна");

        assertEquals("Номер карты", mtsPage.getCardNumberLabel());
        assertEquals("Срок действия", mtsPage.getExpiryLabel());
        assertEquals("CVC", mtsPage.getCvcLabel());
        assertEquals("Имя и фамилия на карте", mtsPage.getHolderLabel());

        List<WebElement> icons = mtsPage.getCardIcons();
        assertEquals(3, icons.size(), "Должно быть 3 иконки: Visa, MasterCard, Белкарт");
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed(), "Не видна иконка " + icon.getAttribute("src"));
        }
    }
}
