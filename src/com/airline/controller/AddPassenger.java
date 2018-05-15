package com.airline.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;

public class AddPassenger extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first-name");

        //check if first name is null then throw an error
        if(firstName.length() == 0){
            System.out.print("Empty first name error");
            request.setAttribute("errors", true);
            request.setAttribute("first-name_error", true);
        }
        String lastName = request.getParameter("last-name");

        String dobRaw = request.getParameter("dob");

        //generating the date format accordingly
        String[] dobArray = dobRaw.split("\\/");
        String day = dobArray[0];
        String month = dobArray[1];
        String year = dobArray[2];

        //setting the date format to calender
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, Integer.parseInt(year));
        calendar.set(Calendar.MONTH, Integer.parseInt(month));
        calendar.set(Calendar.DATE, Integer.parseInt(day));
        Date dob = calendar.getTime();
        System.out.println(dob);

        String gender = request.getParameter("gender");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp").forward(request, response);
    }
}
