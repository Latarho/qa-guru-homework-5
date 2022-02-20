import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDropTests {
    @BeforeAll
    public static void beforeAll() {
        // BaseURL
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void moveAtoBDragAndDrop() {
        // Относительный путь от BaseURL (до конкретной страницы)
        open("/drag_and_drop");
        // Использование метода Selenide для перемещения объекта (работает)
        $("#column-a").dragAndDropTo($("#column-b"));
        // Проверка что элемент содержит ожидаемый текст
        $("#column-a").$("header").shouldHave(Condition.text("B"));
        $("#column-b").$("header").shouldHave(Condition.text("A"));
    }
}