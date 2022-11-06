package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    private By buttonOrder = By.xpath(".//button[text() = 'Заказать']"); // общий локатор для кнопки Заказать

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public List<WebElement> getButtonOrder() { //получение списка c кнопками Заказать
        return driver.findElements(buttonOrder);
    }

    public void chooseButtonOrder(int index) { //метод для клика по конкретной кнопке Заказать
        driver.findElement(By.className("App_CookieButton__3cvqF")).click(); //закрытие всплывающего окна с куки

        WebElement element = driver.findElement(buttonOrder);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element); //скролл

        driver.findElements(buttonOrder).get(index).click(); //клик по выбранной кнопке Заказать
    }
}

