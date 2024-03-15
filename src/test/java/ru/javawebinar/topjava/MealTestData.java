package ru.javawebinar.topjava;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.User;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class MealTestData {

    public static final int MEAL_ID_100003 = START_SEQ + 3;


//    public static final User user = new User(USER_ID, "User", "user@yandex.ru", "password", Role.USER);
//    public static final User admin = new User(ADMIN_ID, "Admin", "admin@gmail.com", "admin", Role.ADMIN);
//    public static final User guest = new User(GUEST_ID, "Guest", "guest@gmail.com", "guest");


    public static  final Meal MEAL_100003 = new Meal(100003,
            LocalDateTime.of(2020,01,30, 10,00,00),"Завтрак",500);
    public static  final Meal MEAL_100004 = new Meal(100004,
            LocalDateTime.of(2020,01,30, 13,00,00),"Обед",1000);
    public static  final Meal MEAL_100005 = new Meal(100005,
            LocalDateTime.of(2020,01,30, 20,00,00),"Ужин",500);
    public static  final Meal MEAL_100006 = new Meal(100006,
            LocalDateTime.of(2020,01,31, 00,00,00),"Еда на граничное значение",100);
    public static  final Meal MEAL_100007 = new Meal(100007,
            LocalDateTime.of(2020,01,31, 10,00,00),"Завтрак",500);
    public static  final Meal MEAL_100008 = new Meal(100008,
            LocalDateTime.of(2020,01,31, 13,00,00),"Обед",1000);
    public static  final Meal MEAL_100009 = new Meal(100009,
            LocalDateTime.of(2020,01,31, 20,00,00),"Ужин",510);
    public static  final Meal MEAL_100010 = new Meal(100010,
            LocalDateTime.of(2020,01,31, 14,00,00),"Админ ланч",510);
    public static  final Meal MEAL_100011 = new Meal(100011,
            LocalDateTime.of(2020,01,31, 21,00,00),"Админ ужин",1500);

    public static Meal getNewMeal() {
        return new Meal(null, LocalDateTime.now(),"New", 355);
    }

    public static Meal getUpdatedMeal() {
        Meal updated = new Meal(MEAL_100003);
        updated.setDateTime(LocalDateTime.of(2024,02,01,12,0,0));
        updated.setDescription("UpdatedDescription");
        updated.setCalories(330);

        return updated;
    }

    public static void assertMatch(Meal actual, Meal expected) {
        assertThat(actual).usingRecursiveComparison().ignoringFields("dateTime").isEqualTo(expected);
    }

    public static void assertMatch(Iterable<Meal> actual, Meal... expected) {
        assertMatch(actual, Arrays.asList(expected));
    }

    public static void assertMatch(Iterable<Meal> actual, Iterable<Meal> expected) {
        assertThat(actual).usingRecursiveFieldByFieldElementComparatorIgnoringFields("dateTime").isEqualTo(expected);
    }
}
