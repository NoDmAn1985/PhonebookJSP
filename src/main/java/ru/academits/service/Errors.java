package ru.academits.service;

public enum Errors {
    LAST_NAME("Поле Фамилия должно быть заполнено."), FIRST_NAME("Поле Имя должно быть заполнено."),
    PHONE("Поле Телефон должно быть заполнено."),
    PHONE_EXIST("Номер телефона не должен дублировать другие номера в телефонной книге."), NULL("");
    private String text;

    Errors(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
