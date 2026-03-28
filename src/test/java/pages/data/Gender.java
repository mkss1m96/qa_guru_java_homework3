package pages.data;

public enum Gender {
    Male("Мужчина"),
    Female("Женщина"),
    Other("Другое");

    public final String description;

    Gender(String description){
        this.description = description;
    }
}
