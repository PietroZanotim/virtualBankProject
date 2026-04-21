package org.Pazano.virtualBank.entities;

import jakarta.persistence.*;

public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double balance;

    @OneToOne
    @MapsId
    private User user;

    public Account() {
    }

    public Account(Long id, Double balance, User user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
    }


}
