package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.testdata.TestData.*;

public class TestBox extends TestBase {

    @Test
    void successfulFileFormTestReg() {
        open("/automation-practice-form");

        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=genterWrapper]").$(byText(sex)).click();
        $("[id=userNumber]").setValue(number);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day).click();
        $("[id=subjectsInput]").setValue(subjects).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(hobbies)).click();
        $("[id=uploadPicture]").uploadFromClasspath("bigl.png");
        $("[id=currentAddress]").setValue(address);
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue(state).pressEnter();
        $("[id=city]").click();
        $("[id=react-select-4-input]").setValue(city).pressEnter();

        $("[id=submit]").click();

        $(".table-responsive ").shouldHave(text(full_name));
        $(".table-responsive ").shouldHave(text(email));
        $(".table-responsive ").shouldHave(text(sex));
        $(".table-responsive ").shouldHave(text(number));
        $(".table-responsive ").shouldHave(text(full_date));
        $(".table-responsive ").shouldHave(text(subjects));
        $(".table-responsive ").shouldHave(text(hobbies));
        $(".table-responsive ").shouldHave(text(address));
        $(".table-responsive ").shouldHave(text("bigl.png"));
        $(".table-responsive ").shouldHave(text(state_city));
    }

    @Test
    void successfulFileFormTestBox() {
        open("/text-box");

        executeJavaScript("document.getElementById('fixedban')?.remove();document.querySelector('footer')?.remove();");

        $("#userName").setValue(full_name);
        $("#userEmail").setValue(email);
        $("#currentAddress").setValue(address);
        $("#permanentAddress").setValue(address);
    }
}
