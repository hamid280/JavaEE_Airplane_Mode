package com.airline.controller;

import com.airline.models.Passenger;

import javax.ejb.EJB;
import javax.ejb.SessionBean;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

@WebServlet(name = "MainPage", urlPatterns = "")
public class MainPage extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        ServletContext servletContext = this.getServletContext();
        ArrayList<Passenger> passengersList = (ArrayList<Passenger>)servletContext.getAttribute("passengers");

        out.println("Passenger has been added to the list. Number of Passengers: " + passengersList.size());
        out.println("The flights details servlet has been called...");


    }
}
