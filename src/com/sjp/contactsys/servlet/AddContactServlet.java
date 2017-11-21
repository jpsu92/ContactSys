package com.sjp.contactsys.servlet;

import com.sjp.contactsys.dao.ContactDao;
import com.sjp.contactsys.dao.daoimpl.ContactDaoImpl;
import com.sjp.contactsys.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class AddContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContactDao contactDao = new ContactDaoImpl();
        String id = UUID.randomUUID().toString().replace("-", "");
        String name = request.getParameter("name");
        System.out.println(name);
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String age = request.getParameter("age");
        String email = request.getParameter("email");
        String qq = request.getParameter("qq");
        Contact con = new Contact();
        con.setId(id);
        con.setAge(Integer.parseInt(age));
        con.setEmail(email);
        con.setGender(gender);
        con.setName(name);
        con.setPhone(phone);
        con.setQq(qq);

        contactDao.addContact(con);
        response.sendRedirect(request.getContextPath() + "/listservlet");
    }
}
