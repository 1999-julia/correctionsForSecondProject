package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;
public class OrderFormPage {
    private WebDriver driver;

    private By nameField = By.xpath("//input[@placeholder='* Имя']");

    private By surnameField = By.xpath("//input[@placeholder='* Фамилия']");

    private By adressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");

    private By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");

    private By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    private By buttonNext = By.xpath("//button[contains(@class, 'Button_Button__ra12g Button_Middle__1CSJM')]"); //кнопка Далее

    private By whenField = By.xpath("//input[@placeholder='* Когда привезти самокат']");

    private By periodField = By.xpath("//div[@class='Dropdown-root']"); //для клика по полю периода проката

    private By period1Field = By.xpath("//div[text()='сутки']");
    private By period2Field = By.xpath("//div[text()='двое суток']");
    private By period3Field = By.xpath("//div[text()='трое суток']");
    private By period4Field = By.xpath("//div[text()='четверо суток']");
    private By period5Field = By.xpath("//div[text()='пятеро суток']");
    private By period6Field = By.xpath("//div[text()='шестеро суток']");
    private By period7Field = By.xpath("//div[text()='семеро суток']");

    private By colorFieldBlack = By.id("black"); //чек-бокс выбор цвета черный

    private By colorFieldGrey = By.id("grey"); //чек-бокс выбор цвета серый

    private By commentField = By.xpath("//input[@placeholder='Комментарий для курьера']"); //ввод комментария

    private By finalButtonOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]"); //кнопка Заказать

    private By yesButtonOrder = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[contains(text(), 'Да')]"); //кнопка Да

    private By checkButtonStatusOrder = By.xpath("//button[contains(text(), 'Посмотреть статус')]"); //кнопка Посмотреть статус

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
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
        driver.findElement(periodField).click();
        if (period == "сутки") {
            driver.findElement(period1Field).click();
        } else if (period == "двое суток") {
            driver.findElement(period2Field).click();
        } else if (period == "трое суток") {
            driver.findElement(period3Field).click();
        } else if (period == "четверо суток") {
            driver.findElement(period4Field).click();
        } else if (period == "пятеро суток") {
            driver.findElement(period5Field).click();
        } else if (period == "шестеро суток") {
            driver.findElement(period6Field).click();
        } else if (period == "семеро суток") {
            driver.findElement(period7Field).click();
        } else {
            System.out.println("Такого срока не существует!");
        }
    }
    public void clickColorField(String color) { //метод для выбора цвета самоката
        if (color == "Чёрный") {
            driver.findElement(colorFieldBlack).click();
        } else if (color == "Серый") {
            driver.findElement(colorFieldGrey).click();
        } else {
            System.out.println("Такого цвета не существует!");
        }
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
