package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class MealDao {

    public void addMeal(Meal meal) {
        MealsUtil.meals.add(meal);
    }

    public void deleteMeal(int mealId) {
        MealsUtil.meals.remove(MealsUtil.meals.get(mealId));
    }

    public void updateMeal(Meal meal) {
        MealsUtil.meals.add(meal);
    }

    public List<MealTo> getAllMeals() {
        return new ArrayList<>(MealsUtil.filteredByStreams(MealsUtil.meals, LocalTime.MIN, LocalTime.MAX, MealsUtil.caloriesPerDay));
    }

    public MealTo getMealById(int mealId) {
        return MealsUtil.mealMap.get(mealId);
    }
}
