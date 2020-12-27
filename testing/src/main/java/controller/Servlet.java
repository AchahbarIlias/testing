package controller;

import model.Meal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    ArrayList<Meal> meals = new ArrayList<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);

    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");
        String des = "";
        switch (command) {
            case "AddMeal":
                des = addMeal(request, response);
                break;
            case "Overzicht":
                des = getMeals(request, response);
                break;
            case "VoegToe":
                des = "voegtoe.jsp";
                break;
            case "DeleteAll":
                des = deleteAll(request, response);
                break;
        }

        request.getRequestDispatcher(des).forward(request, response);
    }

    private String deleteAll(HttpServletRequest request, HttpServletResponse response) {
        meals = new ArrayList<>();
        return "index.html";
    }

    private String getMeals(HttpServletRequest request, HttpServletResponse response) {
        Collections.sort(meals);
        request.setAttribute("meals", meals);
        System.out.println(meals);
        return "overzicht.jsp";
    }

    private String addMeal(HttpServletRequest request, HttpServletResponse response) {
        String titel = request.getParameter("titel");
        String categorie = request.getParameter("categorie");
        boolean veg = request.getParameter("vegan") != null;
        String allergie = request.getParameter("allergie");
        String prijs = request.getParameter("prijs");
        Meal m = new Meal(titel, categorie, veg, allergie, prijs);
        meals.add(m);
        return getMeals(request, response);
    }
}
