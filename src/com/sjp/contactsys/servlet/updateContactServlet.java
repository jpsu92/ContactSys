package com.sjp.contactsys.servlet;

import com.sjp.contactsys.dao.ContactDao;
import com.sjp.contactsys.dao.daoimpl.ContactDaoImpl;
import com.sjp.contactsys.entity.Contact;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class updateContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");
        String name = request.getParameter("name");
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
        ContactDao contactDao = new ContactDaoImpl();
        contactDao.updateContact(con);

        response.sendRedirect(request.getContextPath() + "/listservlet");
    }
}
