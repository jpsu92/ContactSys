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

public class QueryContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String id = request.getParameter("id");
        ContactDao contactDao = new ContactDaoImpl();
        Contact contact = contactDao.findById(id);

        if (contact != null) {

            PrintWriter writer = response.getWriter();


            String html = "";

            html += "<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>";
            html += "<html xmlns='http://www.w3.org/1999/xhtml'>";
            html += "<head>";
            html += "<meta http-equiv='Content-Type' content='text/html; charset=utf-8' />";
            html += "<title>修改联系人</title>";
            html += "</head>";
            html += "<body>";
            html += "<center><h3>修改联系人</h3></center>";
            html += "<form action='" + request.getContextPath() + "/updatecontactservlet' method='post'>";
            html += "<input type='hidden' name='id' value='" + contact.getId() + "'/>";
            html += "<table align='center' border='1' width='300px'>";
            html += "    <tr>";
            html += "    	<th>姓名</th>";
            html += "        <td><input type='text' name='name' value='" + contact.getName() + "'/></td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "    	<th>性别</th>";
            html += "        <td>";
            String gender = contact.getGender();
            if ("男".equals(gender)) {
                html += "        <input type='radio' name='gender' value='男' checked='checked'/>男";
                html += "        <input type='radio' name='gender' value='女'/>女";
            } else {
                html += "        <input type='radio' name='gender' value='男'/>男";
                html += "        <input type='radio' name='gender' value='女' checked='checked'/>女";
            }

            html += "        </td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "    	<th>年龄</th>";
            html += "        <td><input type='text' name='age' value='" + contact.getAge() + "'/></td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "    	<th>电话</th>";
            html += "        <td><input type='text' name='phone' value='" + contact.getPhone() + "'/></td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "    	<th>邮箱</th>";
            html += "        <td><input type='text' name='email' value='" + contact.getEmail() + "'/></td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "    	<th>QQ</th>";
            html += "        <td><input type='text' name='qq' value='" + contact.getQq() + "'/></td>";
            html += "    </tr>";
            html += "    <tr>";
            html += "        <td colspan='2' align='center'>";
            html += "        <input type='submit' value='保存'/>&nbsp;";
            html += "        <input type='reset' value='重置'/></td>";
            html += "    </tr>";
            html += "</table>";
            html += "</form>";
            html += "</body>";
            html += "</html>";

            writer.write(html);
        }
    }
}
