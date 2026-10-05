package HomeWork8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MtsPage {
    private WebDriver driver;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By phoneInput = By.id("connection-phone");

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    private By amountInput = By.id("connection-sum");

    public void enterAmount(String amount) {
        driver.findElement(amountInput).sendKeys(amount);
    }

    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButton).isDisplayed();
    }

    private By onlinePaymentTitle = By.xpath("//h2[contains(.,'Онлайн пополнение')]");

    public boolean isOnlinePaymentTitleDisplayed() {
        return driver.findElement(onlinePaymentTitle).isDisplayed();
    }

    private By visaLogo = By.cssSelector("img[alt='Visa']");

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    private By mastercardLogo = By.cssSelector("img[alt='MasterCard Secure Code']");

    public boolean isMastercardLogoDisplayed() {
        return driver.findElement(mastercardLogo).isDisplayed();
    }

    private By moreDetailsLink = By.linkText("Подробнее о сервисе");

    public boolean isMoreDetailsLinkDisplayed() {
        return driver.findElement(moreDetailsLink).isDisplayed();
    }
}
