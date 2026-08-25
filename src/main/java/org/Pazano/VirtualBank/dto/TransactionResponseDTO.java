package org.Pazano.VirtualBank.dto;

import java.math.BigDecimal;
import java.time.Instant;

public class TransactionResponseDTO {

    private Long transactionId;
    private String senderName;
    private String receiverName;
    private BigDecimal total;
    private Instant data;

    public TransactionResponseDTO() {
    }

    public TransactionResponseDTO(Long transactionId,String senderName, String receiverName, BigDecimal total, Instant data) {
        this.transactionId = transactionId;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.total = total;
        this.data = data;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Instant getData() {
        return data;
    }

    public void setData(Instant data) {
        this.data = data;
    }
}
