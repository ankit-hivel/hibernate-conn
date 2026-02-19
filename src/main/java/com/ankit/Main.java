package com.ankit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setsName("XYZ");
        s1.setRollNo(3);
        s1.setAge(21);

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.ankit.Student.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(s1);
        tx.commit();
        session.close();
        sf.close();

        System.out.println(s1);
    }
}