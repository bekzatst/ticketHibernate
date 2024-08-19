package org.example;

import org.example.dao.UserTicketDAO;
import org.example.models.Ticket;
import org.example.models.TicketType;
import org.example.models.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try {
            UserTicketDAO dao = new UserTicketDAO();

            User user = new User();
            user.setName("Einstein");
            dao.saveUser(user);

            User user1 = dao.getUserById(3);

            Ticket ticket1 = new Ticket();
            ticket1.setUser(user1);
            ticket1.setTicketType(TicketType.WEEK);
            dao.saveTicket(ticket1);

            User fetchedUser = dao.getUserById(1);
            System.out.println("Fetched user " + fetchedUser.getName());

            List<Ticket> ticketList = dao.getTicketsByUserId(3);
            for (Ticket ticket : ticketList){
                System.out.println(ticket);
            }

            dao.updateTicketType(3, TicketType.MONTH);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}