package com.sjp.contactsys.utils;

import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;

import java.io.FileOutputStream;

public class XMLUtil {

    public static Document getDocument(){
        SAXReader reader = new SAXReader();
        Document doc = null;
        try {
             doc = reader.read(new File("e:/contact.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doc;
    }

    public static void write2Xml(Document doc){
        try {
            FileOutputStream out = new FileOutputStream("e:/contact.xml");
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setEncoding("utf-8");
            XMLWriter writer = new XMLWriter(out, format);
            writer.write(doc);
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
