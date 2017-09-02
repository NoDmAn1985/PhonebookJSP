package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;
import ru.academits.service.ContactValidation;
import ru.academits.service.Errors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddContactServlet extends HttpServlet {

    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        Contact contact = new Contact();
        contact.setLastName(req.getParameter("lastname"));
        contact.setFirstName(req.getParameter("firstname"));
        contact.setPhone(req.getParameter("phone"));
        ContactValidation contactValidation = phoneBookService.addContact(contact);
        req.setAttribute("errorLastName", Errors.NULL.getText());
        req.setAttribute("errorFirstName", Errors.NULL.getText());
        req.setAttribute("errorPhone", Errors.NULL.getText());
        if (!contactValidation.isValid()) {
            Errors error = contactValidation.getError();
            switch (error) {
                case LAST_NAME:
                    req.setAttribute("errorLastName", error.getText());
                    break;
                case FIRST_NAME:
                    req.setAttribute("errorFirstName", error.getText());
                    break;
                default:
                    req.setAttribute("errorPhone", error.getText());
            }
        }
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/all");
        try {
            reqDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
