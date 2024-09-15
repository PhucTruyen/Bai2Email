package murach.email;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import murach.business.User;

public class EmailListServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
                          throws ServletException, IOException {

        String url = "/index.html";

        // Get current action
        String action = request.getParameter("action");
        if (action == null) {
            action = "join";  // Default action
        }

        if (action.equals("join")) {
            url = "/index.html";  // The "join" page
        }
        else if (action.equals("add")) {
            // Get parameters from the request
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String email = request.getParameter("email");
            String dateOfBirthInput = request.getParameter("dateOfBirth"); // yyyy-MM-dd
            String hearabout = request.getParameter("hearabout");
            String[] announcementsArray = request.getParameterValues("announcements");
            String contactMethod = request.getParameter("contactMethod");
            
            // Convert the announcements array to a string
            String announcements = "";
            if (announcementsArray != null) {
                announcements = String.join("<br>", announcementsArray);
            }

            // Convert date from yyyy-MM-dd to dd-MM-yyyy
            String dateOfBirth = convertDateFormat(dateOfBirthInput);

            // Store data in User object
            User user = new User(firstName, lastName, email, dateOfBirth, hearabout, announcements, contactMethod);
            
            // Set User object in request object and set URL
            request.setAttribute("user", user);
            url = "/thanks.jsp";   // The "thanks" page
        }
        
        // Forward request and response objects to specified URL
        getServletContext()
            .getRequestDispatcher(url)
            .forward(request, response);
    }    

    private String convertDateFormat(String dateInput) {
        String formattedDate = "";
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = inputFormat.parse(dateInput);
            formattedDate = outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace(); // Handle parsing exception
        }
        return formattedDate;
    }

    @Override
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
                         throws ServletException, IOException {
        doPost(request, response);
    }    
}