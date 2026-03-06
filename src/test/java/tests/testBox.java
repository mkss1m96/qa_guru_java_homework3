package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class testBox extends testBase {

    @Test
    void successfulFileFormTest() {
        open("/automation-practice-form");

        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");

        $("[id=firstName]").setValue("David");
        $("[id=lastName]").setValue("Beckham");
        $("[id=userEmail]").setValue("davidbeckham@example.ru");
        $("[id=genterWrapper]").$(byText("Male")).click();
        $("[id=userNumber]").setValue("8800555353");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1975");
        $(".react-datepicker__day--002").click();
        $("[id=subjectsInput]").setValue("English").pressEnter();
        $("[id=hobbiesWrapper]").$(byText("Sports")).click();
        $("[id=uploadPicture]").uploadFromClasspath("bigl.png");
        $("[id=currentAddress]").setValue("London");
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue("NCR").pressEnter();
        $("[id=city]").click();
        $("[id=react-select-4-input]").setValue("Delhi").pressEnter();

        $("[id=submit]").click();

        $(".table-responsive ").shouldHave(text("David Beckham"));
        $(".table-responsive ").shouldHave(text("davidbeckham@example.ru"));
        $(".table-responsive ").shouldHave(text("Male"));
        $(".table-responsive ").shouldHave(text("8800555353"));
        $(".table-responsive ").shouldHave(text("02 May,1975"));
        $(".table-responsive ").shouldHave(text("English"));
        $(".table-responsive ").shouldHave(text("Sports"));
        $(".table-responsive ").shouldHave(text("London"));
        $(".table-responsive ").shouldHave(text("NCR Delhi"));
    }
}
