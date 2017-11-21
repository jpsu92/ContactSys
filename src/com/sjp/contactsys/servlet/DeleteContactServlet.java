package com.sjp.contactsys.servlet;

import com.sjp.contactsys.dao.ContactDao;
import com.sjp.contactsys.dao.daoimpl.ContactDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        System.out.println(id);
        ContactDao contactDao = new ContactDaoImpl();
        contactDao.deleteContact(id);
        response.sendRedirect(request.getContextPath() + "/listservlet");
    }
}
