import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;
import pom.OrderFormPage;

import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)

public class TestOrderForm {
    private WebDriver driver;

    private final int orderFormIndex; //точка входа (верхняя или нижняя кнопка Закзать)
    private final String name;
    private final String surname;
    private final String adress;
    private final String metroStation;
    private final String phoneNumber;
    private final String when;

    private final String period;
    private final String color;
    private final String comment;


    public TestOrderForm(int orderFormIndex, String name, String surname, String adress, String metroStation, String phoneNumber, String when, String period, String color, String comment) {
        this.orderFormIndex = orderFormIndex;
        this.name = name;
        this.surname = surname;
        this.adress = adress;
        this.metroStation = metroStation;
        this.phoneNumber = phoneNumber;
        this.when = when;
        this.period = period;
        this.color = color;
        this.comment = comment;
    }


    @Parameterized.Parameters
    public static Object[][] fieldData() {
        return new Object[][]{
                {0, "Юлия", "Евтеева", "Санкт-Петербург", "Сокол", "89999999999", "10.11.2022", "сутки", "black", "ничего"},
                {1, "Иоанн", "Иванов", "Псков", "Перово", "89991234567", "10.12.2022", "семеро суток", "grey", "не звонить"},
        };
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","C:\\tools\\geckodriver.exe");
        driver = new FirefoxDriver();
        /*System.setProperty("webdriver.chrome.driver","C:\\tools\\chromedriver.exe");
        driver = new ChromeDriver(); //выбран брузер Chrome*/
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void testMakeOrder() {
        HomePage homePage = new HomePage(driver);

        OrderFormPage orderFormPage = homePage.openOrderForm(orderFormIndex);

        orderFormPage.sendNameField(name);
        orderFormPage.sendSurnameField(surname);
        orderFormPage.sendAdressField(adress);
        orderFormPage.sendMetroStationField(metroStation);
        orderFormPage.sendPhoneNumberField(phoneNumber);
        orderFormPage.clickButtonNext();
        orderFormPage.sendWhenField(when);
        orderFormPage.sendPeriod(period);
        orderFormPage.clickColorField(color);
        orderFormPage.sendCommentField(comment);
        orderFormPage.clickFinalButtonOrder();
        orderFormPage.clickYesButtonOrder();
        orderFormPage.clickCheckButtonStatusOrder(); //проверка доступностью клика по кнопке Посмотреть статус
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

