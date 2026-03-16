package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationFormPage;

import testdata.TestDataWithFaker;
import testdata.TestDataWithFaker.*;

public class TestBoxFaker extends TestBase {

    RegistrationFormPage regBoxPage = new RegistrationFormPage();
    TestDataWithFaker faker = new TestDataWithFaker();

    @Test
    void successfulFileFormRegFakerTest() {

        regBoxPage.openPage();
        regBoxPage.fixBan();
        regBoxPage.
                typeFirstName(faker.firstNameFaker).
                typeLastName(faker.lastNameFaker).
                typeUserEmail(faker.emailFaker).
                setGender(faker.sexFaker).
                typeUserNumber(faker.numberFaker).
                setDateOfBirth(faker.dayFaker, faker.monthFaker, faker.yearFaker).
                setSubjects(faker.subjectsFaker).
                setHobbies(faker.hobbiesFaker).
                setPicture(faker.pictureFaker).
                typeCurrentAddress(faker.addressFaker).
                setState(faker.stateFaker).
                setCity(faker.cityFaker).
                submitForm().
                checkField(faker.full_nameFaker).
                checkField(faker.emailFaker).
                checkField(faker.sexFaker).
                checkField(faker.numberFaker).
                checkField(faker.full_dateFaker).
                checkField(faker.subjectsFaker).
                checkField(faker.hobbiesFaker).
                checkField(faker.pictureFaker).
                checkField(faker.addressFaker).
                checkField(faker.state_cityFaker);
    }
}