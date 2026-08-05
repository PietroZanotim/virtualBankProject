package org.Pazano.VirtualBank.dto;

import org.Pazano.VirtualBank.entities.enums.TransactionType;

import java.math.BigDecimal;

public class TransactionRequestDTO {

    private Long senderAccountId;
    private BigDecimal total;
    private String receiverCpf;
    TransactionType transactionType;

    public TransactionRequestDTO() {
    }

    public TransactionRequestDTO(Long senderAccountId, BigDecimal total, String receiverCpf, TransactionType transactionType) {
        this.senderAccountId = senderAccountId;
        this.total = total;
        this.receiverCpf = receiverCpf;
        this.transactionType = transactionType;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
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
}
