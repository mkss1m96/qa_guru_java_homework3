package testdata;

import com.github.javafaker.Faker;

import java.util.Locale;

import utils.RandomUtils;

public class TestDataWithFaker {
    Faker faker = new Faker(new Locale("en-GB"));
    RandomUtils randomUtils = new RandomUtils();

    public String firstNameFaker = faker.name().firstName();
    public String lastNameFaker = faker.name().lastName();
    public String emailFaker = faker.internet().emailAddress();
    public String sexFaker = faker.options().option("Male","Female","Other");
    public String numberFaker = faker.phoneNumber().subscriberNumber(10);
    public String dayFaker = randomUtils.getRandomDay();
    public String monthFaker = randomUtils.getRandomMonth();
    public String yearFaker = randomUtils.getRandomYear();
    public String subjectsFaker = faker.options().option("Maths", "Accounting", "Arts", "Social Studies", "Physics",
            "Chemistry","Computer Science", "Commerce", "Economics", "Civics", "English", "Hindi", "Biology", "History");
    public String hobbiesFaker = "Sports";
    public String pictureFaker = faker.options().option("bigl.png","corgi.png","labr.png");
    public String addressFaker = faker.address().fullAddress();
    public String stateFaker = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    public String cityFaker = randomUtils.getRandomCity(stateFaker);
    public String full_nameFaker = firstNameFaker + " " + lastNameFaker;
    public String full_dateFaker = dayFaker + " " + monthFaker + "," + yearFaker;
    public String state_cityFaker = stateFaker + " " + cityFaker;
}
