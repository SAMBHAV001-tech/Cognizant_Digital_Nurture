package com.hibernate.xml;

import com.hibernate.xml.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        SessionFactory sf = cfg.buildSessionFactory();

        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Book book1 = new Book("Hibernate XML Guide", "Author A", 29.99);
            Book book2 = new Book("Java Masterclass", "Author B", 49.99);
            session.save(book1);
            session.save(book2);
            tx.commit();
            System.out.println("Books saved successfully!");
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        session = sf.openSession();
        try {
            Book retrieved = session.get(Book.class, 1);
            System.out.println("Retrieved Book: " + retrieved);
        } finally {
            session.close();
        }

        session = sf.openSession();
        try {
            List<Book> books = session.createQuery("from Book", Book.class).list();
            System.out.println("Query Results: " + books);
        } finally {
            session.close();
        }

        session = sf.openSession();
        tx = null;
        try {
            tx = session.beginTransaction();
            Book bookToDelete = session.get(Book.class, 1);
            if (bookToDelete != null) {
                session.delete(bookToDelete);
                System.out.println("Deleted Book with ID 1");
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        session = sf.openSession();
        try {
            List<Book> remainingBooks = session.createQuery("from Book", Book.class).list();
            System.out.println("Remaining Books: " + remainingBooks);
        } finally {
            session.close();
        }

        sf.close();
    }
}
