package com.airline.controller;

import com.airline.models.Gender;
import com.airline.models.Passenger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddPassenger extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("errors", false);
        Passenger passenger = new Passenger();

        String firstName = request.getParameter("first-name");
        System.out.println("firstName: " + firstName);

        if (firstName.length() == 0) {
            System.out.println("empty first name error");

            request.setAttribute("errors", true);
            request.setAttribute("firstname_error", true);

        } else {
            passenger.setFirstName(firstName);
        }

        String lastName = request.getParameter("last-name");
        System.out.println("lastName: " + lastName);

        if (lastName.length() == 0) {
            System.out.println("empty last name error");

            request.setAttribute("errors", true);
            request.setAttribute("lastname_error", true);

        } else {
            passenger.setLastName(lastName);
        }

        String dob_raw = request.getParameter("dob");

        String dobArray[] = dob_raw.split("\\/");

        String pattern = "^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$";
        Pattern r = Pattern.compile(pattern);

        Matcher m = r.matcher(dob_raw);

        if (m.find()) {

            String day = dobArray[0];
            String month = dobArray[1];
            String year = dobArray[2];

            Calendar cal = Calendar.getInstance();

            cal.set(Calendar.YEAR, Integer.parseInt(year));
            cal.set(Calendar.MONTH, Integer.parseInt(month));
            cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));

            Date dob = cal.getTime();

            System.out.println(dob);

            passenger.setDob(dob);

        } else {
            System.out.println("Invalid date of birth");
            request.setAttribute("errors", true);
            request.setAttribute("date_format_error", true);
        }

        String gender = request.getParameter("gender");
        System.out.println("gender: " + gender);
        passenger.setGender(Gender.valueOf(gender));


        //is sth had gone wrong go to add_passenger.jsp and deal with it
        if((Boolean)request.getAttribute("errors")){
            request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp").forward(request, response);

        }

        //if everything went right then add the passenger to the list
        else {
            ArrayList<Passenger> passengersList = new ArrayList<>();
            passengersList.add(passenger);

            response.sendRedirect("/");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/add_passenger.jsp").forward(request, response);
    }
}
