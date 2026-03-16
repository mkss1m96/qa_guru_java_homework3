package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    Faker faker = new Faker();

    public String getRandomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 28));
    }

    public String getRandomMonth() {
        String[] months = {"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};
        return faker.options().option(months);
    }

    public String getRandomYear() {
        return String.valueOf(faker.number().numberBetween(1945, 2030));
    }

    public String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> null;
        };
    }
}
