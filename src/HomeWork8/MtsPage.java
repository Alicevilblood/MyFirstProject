package HomeWork8;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {
    private final WebDriver driver;

    private final By cookieButton = By.id("cookie-agree");
    private final By blockTitle = By.cssSelector(".pay__wrapper h2");
    private final By partnerLogos = By.cssSelector(".pay__partners img");
    private final By moreDetailsLink = By.linkText("Подробнее о сервисе");
    private final By paymentTypeSelect = By.cssSelector(".pay__form .select__header");
    private final By phoneInput = By.id("connection-phone");
    private final By amountInput = By.id("connection-sum");
    private final By continueButton = By.cssSelector("#pay-connection button[type='submit']");

    private final By paymentFrame = By.cssSelector("iframe.payment-widget-iframe");
    private final By frameAmount = By.cssSelector(".pay-description__cost");
    private final By frameDescription = By.cssSelector(".pay-description__text");
    private final By framePayButton = By.cssSelector("button[type='submit']");
    private final By cardNumberLabel = By.xpath("//input[@id='cc-number']/following-sibling::label");
    private final By expiryLabel = By.xpath("//input[@formcontrolname='expirationDate']/following-sibling::label");
    private final By cvcLabel = By.xpath("//input[@formcontrolname='cvc']/following-sibling::label");
    private final By holderLabel = By.xpath("//input[@formcontrolname='holder']/following-sibling::label");
    private final By cardIcons = By.cssSelector(".cards-brands__container > img");

    public MtsPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriverWait waitFor(int seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public void acceptCookiesIfPresent() {
        try {
            waitFor(5).until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        } catch (TimeoutException ignored) {
        }
    }

    public String getBlockTitle() {
        return driver.findElement(blockTitle).getAttribute("textContent").replaceAll("\\s+", " ").trim();
    }

    public List<WebElement> getPartnerLogos() {
        return driver.findElements(partnerLogos);
    }

    public void clickMoreDetailsLink() {
        driver.findElement(moreDetailsLink).click();
    }

    public boolean isUrlContains(String part) {
        try {
            return waitFor(10).until(ExpectedConditions.urlContains(part));
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void selectPaymentType(String name) {
        By option = By.xpath("//p[@class='select__option' and text()='" + name + "']");
        driver.findElement(paymentTypeSelect).click();
        waitFor(5).ignoring(ElementClickInterceptedException.class).until(d -> {
            d.findElement(option).click();
            return true;
        });
    }

    public String getPlaceholder(String fieldId) {
        return waitFor(5).until(ExpectedConditions.visibilityOfElementLocated(By.id(fieldId)))
                .getAttribute("placeholder");
    }

    public void enterPhone(String phone) {
        driver.findElement(phoneInput).sendKeys(phone);
    }

    public void enterAmount(String amount) {
        driver.findElement(amountInput).sendKeys(amount);
    }

    public String getPhoneValue() {
        return driver.findElement(phoneInput).getAttribute("value");
    }

    public String getAmountValue() {
        return driver.findElement(amountInput).getAttribute("value");
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public boolean isPaymentFrameDisplayed() {
        try {
            return waitFor(15).until(ExpectedConditions.visibilityOfElementLocated(paymentFrame)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void switchToPaymentFrame() {
        waitFor(15).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(paymentFrame));
        waitFor(15).until(ExpectedConditions.visibilityOfElementLocated(frameAmount));
    }

    public String getFrameAmount() {
        return driver.findElement(frameAmount).getText();
    }

    public String getFrameDescription() {
        return driver.findElement(frameDescription).getText();
    }

    public String getPayButtonText() {
        return driver.findElement(framePayButton).getText();
    }

    public String getCardNumberLabel() {
        return driver.findElement(cardNumberLabel).getText();
    }

    public String getExpiryLabel() {
        return driver.findElement(expiryLabel).getText();
    }

    public String getCvcLabel() {
        return driver.findElement(cvcLabel).getText();
    }

    public String getHolderLabel() {
        return driver.findElement(holderLabel).getText();
    }

    public List<WebElement> getCardIcons() {
        return driver.findElements(cardIcons);
    }
}
