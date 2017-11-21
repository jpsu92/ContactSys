package com.sjp.contactsys.dao;

import com.sjp.contactsys.entity.Contact;

import java.util.List;

public interface ContactDao {
    public void addContact(Contact contact);
    public void updateContact(Contact contact);
    public void deleteContact(String id);
    public List<Contact> findAll();
    public Contact findById(String id);
}
