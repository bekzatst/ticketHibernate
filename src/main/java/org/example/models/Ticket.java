package org.example.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "Tickets")
@Getter
@Setter
@AllArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticket_type", nullable = false)
    private TicketType ticketType;

    @Column(name = "creation_date")
    private Timestamp creationDate = new Timestamp(System.currentTimeMillis());

    public Ticket(){

    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", ticketType=" + ticketType +
                ", creationDate=" + creationDate +
                '}';
    }
}
