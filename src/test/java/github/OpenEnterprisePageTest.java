package github;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class OpenEnterprisePageTest {

    @Test
    void openEnterprisePageTest(){

        open("https://github.com/");
        $("[aria-label=Global]").$(byText("Solutions")).hover();
        $(".list-style-none").$(byLinkText("Enterprise")).click();
        $(".h1-mktg").shouldHave(text("Build like the best"));

        sleep(4000);

    }
}
