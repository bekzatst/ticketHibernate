package org.example.dao;

import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.models.User;
import org.example.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserTicketDAO {

    SessionFactory sessionFactory = HibernateSessionFactoryUtil.getSessionFactory();

    public boolean saveUser(User user){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);
            transaction.commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean saveTicket(Ticket ticket){
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(ticket);
            transaction.commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public User getUserById(int id){
        try (Session session = sessionFactory.openSession()){
            return session.get(User.class, id);
        }
    }

    public Ticket getTicketById(int id){
        try (Session session = sessionFactory.openSession()){
            return session.get(Ticket.class, id);
        }
    }

    public List<Ticket> getTicketsByUserId(int userId){
        try (Session session = sessionFactory.openSession()){
            Query<Ticket> query = session.createQuery("from Ticket where user.id = :userId", Ticket.class);
            query.setParameter("userId", userId);
            List<Ticket> resultList = query.list();
            return resultList;
        }
    }

    public void updateTicketType(int ticketId, TicketType ticketType){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            Ticket ticket = session.get(Ticket.class, ticketId);
            if (ticket != null){
                ticket.setTicketType(ticketType);
            } else System.out.println("There is no ticket with id="+ticketId);
            transaction.commit();
        }
    }

    public boolean deleteUserById(int id){
        try (Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            User user = session.get(User.class, id);
            session.remove(user);
            transaction.commit();
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
