package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;
import pages.RegistrationFormPage;
import pages.data.Gender;

import static testdata.TestData.*;

@DisplayName("Заполнение формы регистрации параметризированными данными")
public class ParametrizedTest extends TestBase{

    RegistrationFormPage regBoxPage = new RegistrationFormPage();

    @ValueSource ( strings = {
            "petyasmirnov@yandex.ru",
            "vasyavasiliev@yandex.ru"
    })
    @ParameterizedTest(name = "Параметр Email должен быть {0} ")
    @Tag("WEBFORM")
    void successfulFileFormRegParametrizedEmailTest(String parametrized_email) {
        regBoxPage.openPage();
        regBoxPage.fixBan();
        regBoxPage.
                typeFirstName(firstName).
                typeLastName(lastName).
                typeUserEmail(parametrized_email).
                setGender(sex).
                typeUserNumber(number).
                setDateOfBirth(day, month, year).
                setSubjects(subjects).
                setHobbies(hobbies).
                setPicture("bigl.png").
                typeCurrentAddress(address).
                setState(state).
                setCity(city).
                submitForm().
                checkField(full_name).
                checkField(parametrized_email).
                checkField(sex).
                checkField(number).
                checkField(full_date).
                checkField(subjects).
                checkField(hobbies).
                checkField(address).
                checkField("bigl.png").
                checkField(state_city);
    }

    @CsvSource ( value = {
            "Petya,Petrov",
            "Vasya,Vasiliev"
    })
    @ParameterizedTest(name = "Параметр Имя должен быть {0}, параметр Фамилия должен быть {1} ")
    @Tag("WEBFORM")
    void successfulFileFormRegParametrizedFullNameTest(String parametrized_firstname,String parametrized_lastname) {
        regBoxPage.openPage();
        regBoxPage.fixBan();
        regBoxPage.
                typeFirstName(parametrized_firstname).
                typeLastName(parametrized_lastname).
                typeUserEmail(email).
                setGender(sex).
                typeUserNumber(number).
                setDateOfBirth(day, month, year).
                setSubjects(subjects).
                setHobbies(hobbies).
                setPicture("bigl.png").
                typeCurrentAddress(address).
                setState(state).
                setCity(city).
                submitForm().
                checkField(parametrized_firstname + " " + parametrized_lastname).
                checkField(email).
                checkField(sex).
                checkField(number).
                checkField(full_date).
                checkField(subjects).
                checkField(hobbies).
                checkField(address).
                checkField("bigl.png").
                checkField(state_city);
    }

    @EnumSource(Gender.class)
    @ParameterizedTest(name = "Параметр Пол должен быть {0}")
    @Tag("WEBFORM")
    void successfulFileFormRegParametrizedSexTest(Gender gender) {
        regBoxPage.openPage();
        regBoxPage.fixBan();
        regBoxPage.
                typeFirstName(firstName).
                typeLastName(lastName).
                typeUserEmail(email).
                setGender(gender.name()).
                typeUserNumber(number).
                setDateOfBirth(day, month, year).
                setSubjects(subjects).
                setHobbies(hobbies).
                setPicture("bigl.png").
                typeCurrentAddress(address).
                setState(state).
                setCity(city).
                submitForm().
                checkField(full_name).
                checkField(email).
                checkField(gender.name()).
                checkField(number).
                checkField(full_date).
                checkField(subjects).
                checkField(hobbies).
                checkField(address).
                checkField("bigl.png").
                checkField(state_city);
    }
}
