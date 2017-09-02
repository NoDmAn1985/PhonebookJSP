package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.model.Contact;
import ru.academits.service.ContactService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllContactsServlet extends HttpServlet {
    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List<Contact> contactsList = phoneBookService.getAllContacts();
            req.setAttribute("contacts", contactsList);
            if (req.getAttribute("errorLastName") == null) {
                req.setAttribute("errorLastName", "");
            }
            if (req.getAttribute("errorFirstName") == null) {
                req.setAttribute("errorFirstName", "");
            }
            if (req.getAttribute("errorPhone") == null) {
                req.setAttribute("errorPhone", "");
            }
            req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
