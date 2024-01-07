package com.vibhorkolte.solacehotel.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/*
* @author Vibhor Kolte
* */
public class Room {
    public Room() {
        this.bookings = new ArrayList<>();  // to handle null-pointer exception
    }

    private Long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked = false;
    private List<BookedRoom> bookings;
}
