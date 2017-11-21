package com.sjp.contactsys.dao.daoimpl;


import com.sjp.contactsys.dao.ContactDao;
import com.sjp.contactsys.entity.Contact;
import com.sjp.contactsys.utils.XMLUtil;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactDaoImpl implements ContactDao{

    @Override
    public void addContact(Contact contact) {
        File file = new File("e:/contact.xml");
        Document doc = null;
        Element rootElem = null;
        if (!file.exists()){
            doc = DocumentHelper.createDocument();
            rootElem = doc.addElement("contactList");
        }
        else{
            doc = XMLUtil.getDocument();
            rootElem = doc.getRootElement();
        }
        Element contactElem = rootElem.addElement("contact");
        String id = UUID.randomUUID().toString().replace("-", "");
        contact.setId(id);
        contactElem.addAttribute("id", id);
        contactElem.addElement("name").setText(contact.getName());
        contactElem.addElement("gender").setText(contact.getGender());
        contactElem.addElement("age").setText(contact.getAge()+"");
        contactElem.addElement("phone").setText(contact.getPhone());
        contactElem.addElement("email").setText(contact.getEmail());
        contactElem.addElement("qq").setText(contact.getQq());

        XMLUtil.write2Xml(doc);
    }

    @Override
    public void updateContact(Contact contact) {
        String id = contact.getId();
        Document doc = XMLUtil.getDocument();
        Element contactElem = (Element) doc.selectSingleNode("//contact[@id='"+  id +"']");

        if (contactElem == null){
            addContact(contact);
        }
        else {
            contactElem.attribute("id").setValue(id);
            List<Element> list = contactElem.elements();
            for(Element elem : list){
                if("name".equals(elem.getName())){
                    elem.setText(contact.getName());
                }
                if("age".equals(elem.getName())){
                    elem.setText(Integer.toString(contact.getAge()));
                }
                if("gender".equals(elem.getName())){
                    elem.setText(contact.getGender());
                }
                if("phone".equals(elem.getName())){
                    elem.setText(contact.getPhone());
                }
                if("email".equals(elem.getName())){
                    elem.setText(contact.getEmail());
                }
                if("qq".equals(elem.getName())){
                    elem.setText(contact.getQq());
                }
            }
        }
        XMLUtil.write2Xml(doc);
    }

    @Override
    public void deleteContact(String id) {
        Document doc = XMLUtil.getDocument();
        Element contactElem = (Element) doc.selectSingleNode("//contact[@id='"+  id +"']");
        if (contactElem != null){
            contactElem.detach();
        }
        XMLUtil.write2Xml(doc);
    }

    @Override
    public List<Contact> findAll() {
        Document doc = XMLUtil.getDocument();
        List<Element> list = (List<Element>)doc.selectNodes("//contact");
        List<Contact> contactList = new ArrayList<>();
        for (Element e : list){
            Contact c = new Contact();
            c.setId(e.attributeValue("id"));
            c.setName(e.elementText("name"));
            c.setGender(e.elementText("gender"));
            c.setAge(Integer.parseInt(e.elementText("age")));
            c.setPhone(e.elementText("phone"));
            c.setEmail(e.elementText("email"));
            c.setQq(e.elementText("qq"));
            //把Contact放入list中
            contactList.add(c);
        }
        return contactList;
    }

    @Override
    public Contact findById(String id) {
        System.out.println("findById:"+id);
        Document doc = XMLUtil.getDocument();
        Element contactElem = (Element) doc.selectSingleNode("//contact[@id='"+  id +"']");
        if (contactElem != null){
            String name = contactElem.elementText("name");
            String age = contactElem.elementText("age");
            String gender = contactElem.elementText("gender");
            String phone = contactElem.elementText("phone");
            String email = contactElem.elementText("email");
            String qq = contactElem.elementText("qq");
            return new Contact(id, name, gender, Integer.parseInt(age), phone, email, qq);
        }
        return null;
    }
}
