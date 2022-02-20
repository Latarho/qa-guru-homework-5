import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SoftAssertionsPageTests {

    @BeforeAll
    public static void beforeAll() {
        // BaseURL
        Configuration.baseUrl = "https://github.com/";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    public void checkJUnit5 () {
        // Относительный путь от BaseURL (до конкретной страницы)
        open("/selenide/selenide");
        // Переход в раздел wiki проекта
        $("#wiki-tab").click();
        // Переход на страницу Soft assertions
        $(".markdown-body ul").$(byText("Soft assertions")).click();
        // Проверка что элемент содержит ожидаемый текст
        $(".markdown-body").shouldHave(Condition.text("Using JUnit5 extend test class"))
                .findElement(byText("@ExtendWith"));
    }
}