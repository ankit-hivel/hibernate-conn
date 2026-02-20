package com.ankit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Laptop l1 = new Laptop();
        l1.setLid(101);
        l1.setLname("Dell");
        l1.setRam(20);

        Laptop l2 = new Laptop();
        l2.setLid(103);
        l2.setLname("MAC");
        l2.setRam(16);

        Student s1 = new Student();
        s1.setsName("XYZ");
        s1.setRollNo(5);
        s1.setAge(21);
        s1.setLaptops(List.of(l1, l2));

//        Student s2 = null;

        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(com.ankit.Student.class).addAnnotatedClass(com.ankit.Laptop.class);
        cfg.configure();

        SessionFactory sf = cfg.buildSessionFactory();
        Session session = sf.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(l1);
        session.persist(l2);
        session.persist(s1);
        tx.commit();
//        session.detach(s1);
//        System.out.println("got results:" + s2);

        session.close();
        sf.close();

//        System.out.println(s1);
    }
}