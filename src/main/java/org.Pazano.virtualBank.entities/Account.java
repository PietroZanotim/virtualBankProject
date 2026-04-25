package org.Pazano.virtualBank.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long accountNumber;
    private BigDecimal balance;

    @OneToOne
    @MapsId
    private User user;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    public Account() {
    }

    public Account(Long id, BigDecimal balance, User user) {
        this.id = id;
        this.balance = balance;
        this.user = user;
    }


}
