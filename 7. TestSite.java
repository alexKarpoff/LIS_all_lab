import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;

public class TestSite {
    String URL = "https://krkrolik.ru/"; String tel = "+7 (950) 485-41-71";

    @Test
    public void Auth() {
        String smsCode = "123456";
        open(URL);
        $x("//a[@id=\"awz_autformlLW6v4_lnk\"]").click();
        sleep(2000);
        $x("//a[@id=\"awz_autformlLW6v4_link_register\"]").click();
        sleep(2000);
        $x("//input[@id=\"awz_autformlLW6v4_phone\"]").setValue(tel);
        sleep(2000);
        $x("//button[@id=\"awz_autformlLW6v4_send\"]").click();
        sleep(2000);
        $x("//input[@id=\"awz_autformlLW6v4_smscode\"]").setValue(smsCode);
        sleep(2000);
        executeJavaScript("arguments[0].click()",$x("//button[@id=\"awz_autformlLW6v4_auth\"]"));
        sleep(3000);
    }

    @Test
    public void Login() {
        String password = "Password";
        open(URL);
        $x("//a[@id=\"awz_autformlLW6v4_lnk\"]").click();
        sleep(2000);
        $x("//a[@id=\"awz_autformlLW6v4_link_login\"]").click();
        sleep(2000);
        $x("//input[@id=\"awz_autformlLW6v4_phone\"]").setValue(tel);
        sleep(2000);
        $x("//input[@id=\"awz_autformlLW6v4_password\"]").setValue(password);
        sleep(2000);
        executeJavaScript("arguments[0].click()",$x("//button[@id=\"awz_autformlLW6v4_auth\"]"));
        sleep(3000);
    }

    @Test
    public void Buy() {
        String countProduct = "10";
        String name = "Александр Александрович Карпов";
        String email = "email@email.com";

        open(URL);
        $x("//a[@href=\"/catalog/koshki/\"]").click();
        $x("//div[@id=\"bx_1970176138_335638_basket_actions\"]").scrollIntoView(false).click();
        sleep(2000);
        $x("//a[@class=\"basket-link basket has_prices with_price big  basket-count\"]").scrollIntoView(false).click();
        $x("//input[@class=\"basket-item-amount-filed\"]").setValue(countProduct).pressEnter();
        sleep(2000);
        $x("//button[@class=\"btn btn-lg btn-default basket-btn-checkout white\"]").click();
        sleep(2000);
        $x("//input[@id=\"soa-property-1\"]").setValue(name).pressEnter();
        $x("//input[@type=\"tel\"]").setValue(tel).pressEnter();
        $x("//input[@id=\"soa-property-2\"]").setValue(email).pressEnter();
        sleep(2000);
        executeJavaScript("arguments[0].click()", $x("//a[@href=\"javascript:void(0)\"]"));
        sleep(30000);
    }
}

