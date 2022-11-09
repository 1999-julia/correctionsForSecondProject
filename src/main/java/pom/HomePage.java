package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pom.OrderFormPage;

import java.util.List;

public class HomePage {
    private final String url = "https://qa-scooter.praktikum-services.ru/";
    private final WebDriver driver;

    private By orderButtonBy = By.xpath(".//button[text() = 'Заказать']"); // общий локатор для кнопки Заказать
    private By cookiePopupBy = By.id("rcc-confirm-button"); // локатор попапа с согласием на куки

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderFormPage openOrderForm(int orderButtonIndex) {
        driver.get(url);

        driver.findElement(cookiePopupBy).click(); //закрытие всплывающего окна с куки

        WebElement orderButton = driver.findElement(orderButtonBy);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", orderButton); // скролл до элемента
        orderButton.click();

        return new OrderFormPage(driver);
    }
}


