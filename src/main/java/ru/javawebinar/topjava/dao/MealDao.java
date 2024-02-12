package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MealDao {

    public MealDao() {
        MealsUtil.makeMapMeal();
        MealsUtil.makeMapMealTo();
    }

    public void addMeal(Meal meal) {
        MealsUtil.mealMap.put(meal.getId(), meal);
    }

    public void deleteMeal(int mealId) {
        MealsUtil.mealMap.remove(mealId);
    }

    public void updateMeal(Meal meal) {
        MealsUtil.mealMap.put(meal.getId(), meal);
    }

    public List<MealTo> getAllMeals() {
        return new ArrayList<>(MealsUtil.filteredByStreams(MealsUtil.mealMap.values().stream().collect(Collectors.toList()), LocalTime.MIN, LocalTime.MAX, MealsUtil.caloriesPerDay));
    }

    public MealTo getMealById(int mealId) {
        return MealsUtil.makeMapMealTo().get(mealId);
    }
}
