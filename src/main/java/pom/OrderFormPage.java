package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
public class OrderFormPage {
    private final WebDriver driver;

    private final By nameField = By.xpath("//input[@placeholder='* Имя']");

    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");

    private final By adressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    private final By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");

    private final By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private final By buttonNext = By.xpath("//button[contains(text(), 'Далее')]"); //кнопка Далее

    private final By whenField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    // Выпадающий список "* Срок аренды"
    private final By dropDownListRentalPeriod = By.xpath(".//div[@class='Dropdown-root']");

    private final By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); //ввод комментария

    private final By finalButtonOrder = By.xpath("//div[contains(@class, 'Order_Buttons')]//button[contains(text(), 'Заказать')]"); //кнопка Заказать

    private final By yesButtonOrder = By.xpath("//div[contains(@class, 'Order_Buttons')]/button[contains(text(), 'Да')]"); //кнопка Да

    private final By checkButtonStatusOrder = By.xpath("//button[contains(text(), 'Посмотреть статус')]"); //кнопка Посмотреть статус

    public OrderFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void sendNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void sendAdressField(String adress) {
        driver.findElement(adressField).sendKeys(adress);
    }

    public void sendSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }

    public void sendMetroStationField(String metroStation) {
        driver.findElement(metroStationField).sendKeys(metroStation, Keys.ARROW_DOWN, Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void sendPhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }

    public void clickButtonNext() {
        driver.findElement(buttonNext).click();
    }

    public void sendWhenField(String when) {
        driver.findElement(whenField).sendKeys(when, Keys.ENTER);
    }

    public void sendPeriod(String period) { //метод для выбора периода проката
        driver.findElement(dropDownListRentalPeriod).click();
        driver.findElement(By.xpath(".//div[@class='Dropdown-option' and contains(text(), '" + period + "')]")).click();
    }

    //метод для выбора цвета самоката
    public void clickColorField(String color) {
        driver.findElement(By.id(color)).click();
    }

    public void sendCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }

    public void clickFinalButtonOrder() {
        driver.findElement(finalButtonOrder).click();
    }

    public void clickYesButtonOrder() {
        driver.findElement(yesButtonOrder).click();
    }

    public void clickCheckButtonStatusOrder() {
        driver.findElement(checkButtonStatusOrder).click();
    }
}

