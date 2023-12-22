import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestSelenide {
    @Test
    public void testGoogle(){
        open("https://www.google.ru/");
        $x("//*[@id=\"APjFqb\"]").setValue("Карпов Александр").pressEnter();
    }
}