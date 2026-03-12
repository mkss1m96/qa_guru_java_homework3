package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class TableResultComponent {

    private final SelenideElement outputResults = $(".table-responsive");

    public void checkResult(String value) {
        outputResults.shouldHave(text(value));
    }
}
