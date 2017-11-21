package com.sjp.contactsys.test;

import com.sjp.contactsys.dao.ContactDao;
import com.sjp.contactsys.dao.daoimpl.ContactDaoImpl;
import com.sjp.contactsys.entity.Contact;
import org.junit.Before;

import java.util.List;
import java.util.UUID;

public class Test {
    ContactDao operator = null;

    @Before
    public void init(){
        operator = new ContactDaoImpl();
    }

    @org.junit.Test
    public void testAddContact(){
        String id = UUID.randomUUID().toString().replace("-", "");
        Contact contact = new Contact(id, "王五", "男", 21, "15771970267", "sjp921025@163.com","12345567867");
        operator.addContact(contact);
    }

    @org.junit.Test
    public void testUpdateContact(){
        Contact contact = new Contact("001", "xiaoer", "男", 21, "15771970267", "sjp921025@163.com","12345567867");
        operator.updateContact(contact);
    }

    @org.junit.Test
    public void testDeleteContact(){
        operator.deleteContact("ff1f54144d554f799b6754140d1497ff");
    }

    @org.junit.Test
    public void testFindAll(){
        List<Contact> list = operator.findAll();
        System.out.println(list);
    }

    @org.junit.Test
    public void testFindById(){
        Contact contact = operator.findById("852d4581b3824c95abbca537f05b6a1e");
        System.out.println(contact);
    }
}
