package ru.academits.servlet;

import ru.academits.PhoneBook;
import ru.academits.service.ContactService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveContactServlet extends HttpServlet {

    private ContactService phoneBookService = PhoneBook.phoneBookService;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) {
        int index = Integer.parseInt(req.getParameter("index"));
        phoneBookService.removeContact(index);
        RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/all");
        try {
            reqDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
