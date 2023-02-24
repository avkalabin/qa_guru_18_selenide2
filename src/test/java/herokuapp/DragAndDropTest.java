package herokuapp;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTest {

    /**Failed**/
   @Test
       void dragAndDropWithActions () {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        Selenide.actions().dragAndDrop($("#column-a"), $("#column-b"));// эта строка Passed
        $("#column-b").shouldHave(text("A"));//но элементы не меняются и здесь Failed

        sleep(4000);
    }

    /**Passed**/
   @Test
    void dragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        $("#column-a").dragAndDropTo($("#column-b"));
        $("#column-b").shouldHave(text("A"));

        sleep(4000);
    }

    /**Failed**/
    @Test
    void dragAndDropClickMoveTo() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().moveToElement($(byText("B"))).release().build().perform();
        $("#column-b").shouldHave(text("A"));

        sleep(4000);
    }

}





/*(опциональное) Запрограммируйте Drag&Drop с помощью Selenide.actions()

 - Откройте

 - Перенесите прямоугольник А на место В

 - Проверьте, что прямоугольники действительно поменялись

 - В Selenide есть команда $(element).dragAndDrop($(to-element)), проверьте работает ли тест, если использовать её вместо actions()*/