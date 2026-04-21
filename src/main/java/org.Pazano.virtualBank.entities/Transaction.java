package org.Pazano.virtualBank.entities;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public class Transaction {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant data;

}
