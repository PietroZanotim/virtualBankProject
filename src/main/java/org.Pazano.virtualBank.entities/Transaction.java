package org.Pazano.virtualBank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "tb_transaction")
public class Transaction {

    @Id
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant data;

    @ManyToOne
    @JoinColumn(name = "senderAccount_id")
    private Account senderAccount;

    private String receiverName;
    private String receiverCpf;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    private BigDecimal total;

    public Transaction() {
    }

    public Transaction(Long id, Instant data, Account senderAccount, String receiverName, String receiverCpf, TransactionType transactionType, BigDecimal total) {
        this.id = id;
        this.data = data;
        this.senderAccount = senderAccount;
        this.receiverName = receiverName;
        this.receiverCpf = receiverCpf;
        this.transactionType = transactionType;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }

    @JsonIgnore
    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverCpf() {
        return receiverCpf;
    }

    public void setReceiverCpf(String receiverCpf) {
        this.receiverCpf = receiverCpf;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
