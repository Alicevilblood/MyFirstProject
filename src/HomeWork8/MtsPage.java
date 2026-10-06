package HomeWork8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPage {
    private WebDriver driver;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cookieButton = By.id("cookie-agree");

    public void acceptCookies() {
        driver.findElement(cookieButton).click();
    }

    private By phoneInput = By.id("connection-phone");

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public String getPhoneValue() {
        return driver.findElement(phoneInput).getAttribute("value");
    }

    public String getAmountValue() {
        return driver.findElement(amountInput).getAttribute("value");
    }

    public String getPhonePlaceholder() {
        return driver.findElement(phoneInput).getAttribute("placeholder");
    }

    private By internetAmountInput = By.id("internet-sum");

    public String getInternetAmountPlaceholder() {
        return driver.findElement(internetAmountInput).getAttribute("placeholder");
    }

    private By internetEmailInput = By.id("internet-email");

    public String getInternetEmailPlaceholder() {
        return driver.findElement(internetEmailInput).getAttribute("placeholder");
    }

    private By instalmentAccountInput = By.id("score-instalment");

    public String getInstalmentAccountPlaceholder() {
        return driver.findElement(instalmentAccountInput).getAttribute("placeholder");
    }

    private By instalmentAmountInput = By.id("instalment-sum");

    public String getInstalmentAmountPlaceholder() {
        return driver.findElement(instalmentAmountInput).getAttribute("placeholder");
    }

    private By instalmentEmailInput = By.id("instalment-email");

    public String getInstalmentEmailPlaceholder() {
        return driver.findElement(instalmentEmailInput).getAttribute("placeholder");
    }

    private By arrearsAccountInput = By.id("score-arrears");

    public String getArrearsAccountPlaceholder() {
        return driver.findElement(arrearsAccountInput).getAttribute("placeholder");
    }

    private By arrearsAmountInput = By.id("arrears-sum");

    public String getArrearsAmountPlaceholder() {
        return driver.findElement(arrearsAmountInput).getAttribute("placeholder");
    }

    private By arrearsEmailInput = By.id("arrears-email");

    public String getArrearsEmailPlaceholder() {
        return driver.findElement(arrearsEmailInput).getAttribute("placeholder");
    }

    private By internetPhoneInput = By.id("internet-phone");

    public String getInternetPhonePlaceholder() {
        return driver.findElement(internetPhoneInput).getAttribute("placeholder");
    }

    private By amountInput = By.id("connection-sum");

    public void enterAmount(String amount) {
        driver.findElement(amountInput).sendKeys(amount);
    }

    public String getAmountPlaceholder() {
        return driver.findElement(amountInput).getAttribute("placeholder");
    }

    private By emailInput = By.id("connection-email");

    public String getEmailPlaceholder() {
        return driver.findElement(emailInput).getAttribute("placeholder");
    }

    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void waitForPaymentForm() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> driver.findElement(By.id("cc-number")).isDisplayed());
    }

    public String getModalContinueButtonText() {
        return driver.findElement(
                By.cssSelector("button[type='submit'] span")
        ).getText();
    }

    public String getModalPhone() {
        return driver.findElement(
                By.xpath("//*[contains(text(),'29 777-77-77')]")
        ).getText();
    }

    public String getModalAmount() {
        return driver.findElement(
                By.xpath("//*[contains(text(),'10.00 BYN')]")
        ).getText();
    }

    public String getCardExpiryPlaceholder() {
        return driver.findElement(
                By.cssSelector("input[formcontrolname='expirationDate']")
        ).getAttribute("placeholder");
    }

    public String getCardCvvPlaceholder() {
        return driver.findElement(
                        By.cssSelector("input[formcontrolname='cvc']")
                ).findElement(By.xpath("./following-sibling::label"))
                .getText();
    }

    public String getCardNumberPlaceholder() {
        return driver.findElement(By.id("cc-number"))
                .findElement(By.xpath("./following-sibling::label"))
                .getText();
    }

    public boolean arePaymentIconsVisible() {
        return driver.findElements(
                By.cssSelector("img[src*='payment-icons/card-types']")
        ).stream().allMatch(element -> element.isDisplayed());
    }

    public boolean isContinueButtonDisplayed() {
        return driver.findElement(continueButton).isDisplayed();
    }

    public boolean isContinueButtonEnabled() {
        return driver.findElement(continueButton).isEnabled();
    }

    private By onlinePaymentTitle =
            By.xpath("//h2[contains(.,'Онлайн пополнение')]");

    public boolean isOnlinePaymentTitleDisplayed() {
        return driver.findElement(onlinePaymentTitle).isDisplayed();
    }

    private By visaLogo = By.cssSelector("img[alt='Visa']");

    public boolean isVisaLogoDisplayed() {
        return driver.findElement(visaLogo).isDisplayed();
    }

    private By mastercardLogo =
            By.cssSelector("img[alt='MasterCard Secure Code']");

    public boolean isMastercardLogoDisplayed() {
        return driver.findElement(mastercardLogo).isDisplayed();
    }

    private By moreDetailsLink =
            By.linkText("Подробнее о сервисе");

    public boolean isMoreDetailsLinkDisplayed() {
        return driver.findElement(moreDetailsLink).isDisplayed();
    }
}