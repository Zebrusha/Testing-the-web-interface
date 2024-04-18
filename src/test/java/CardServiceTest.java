import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selenide.*;

public class CardServiceTest {
    @Test
    void shouldFillOutForm(){
        open("http://localhost:9999");
        SelenideElement form = $("[class=\"form form_size_m form_theme_alfa-on-white\"]");
        form.$("[data-test-id=name] input").setValue("Вавилова Елена");
        form.$("[data-test-id=phone] input").setValue("+78973546915");
        form.$("[data-test-id=agreement]").click();
        form.$(".button").click();
        $(".paragraph").shouldHave(Condition.exactText("  Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
