package ru.javawebinar.topjava.controller;

import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MealController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String INSERT_OR_EDIT = "/meal.jsp";
    private static final String LIST_MEALS = "/listmeals.jsp";
    private final MealDao dao;

    public MealController() {
        super();
        dao = new MealDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if(action.equals("delete")){
            int id = Integer.parseInt((request.getParameter("id")));
            dao.deleteMeal(id);
            forward = LIST_MEALS;
            request.setAttribute("meals", dao.getAllMeals());
        } else if (action.equals("edit")) {
            forward = INSERT_OR_EDIT;
            int id = Integer.parseInt(request.getParameter("id"));
            MealTo meal = dao.getMealById(id);
            request.setAttribute("meal", meal);
        } else if (action.equalsIgnoreCase("listMeals")){
            forward = LIST_MEALS;
            request.setAttribute("meals", dao.getAllMeals());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Meal meal = new Meal();

        meal.setDateTime(LocalDateTime.parse(request.getParameter("dateTime"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        meal.setCalories(Integer.parseInt(request.getParameter("calories")));
        meal.setDescription(request.getParameter("description"));

        String id = request.getParameter("id");
        if(id == null || id.isEmpty()){
            dao.addMeal(meal);
        } else {
            meal.setId(Integer.parseInt(id));
            dao.updateMeal(meal);
        }

        RequestDispatcher view = request.getRequestDispatcher(LIST_MEALS);
        request.setAttribute("meals", dao.getAllMeals());
        view.forward(request, response);
    }
}
