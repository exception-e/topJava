package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    private static final String INSERT_OR_EDIT = "/mealForm.jsp";
    private static final String LIST_MEALS = "/meals.jsp";
    private final MealDao dao = new MealDao();

    public List<MealTo> mealToList = MealsUtil.mealToList;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");


    //    response.sendRedirect("meals.jsp");

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
        } else if (action.equals("insert")) {
            forward = INSERT_OR_EDIT;
            MealTo meal = new MealTo();
            request.setAttribute("meal", meal);
        } else if (action.equalsIgnoreCase("listMeals")){
            forward = LIST_MEALS;
            request.setAttribute("meals", dao.getAllMeals());
        } else {
            forward = LIST_MEALS;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);

//        request.setAttribute("meals",MealsUtil.mealToList);
//        request.getRequestDispatcher("/meals.jsp").forward(request, response);
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
