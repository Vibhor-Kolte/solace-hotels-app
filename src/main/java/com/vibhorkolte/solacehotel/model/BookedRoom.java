package com.vibhorkolte.solacehotel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {
    private Long bookingId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String guestFullName;
    private String guestMail;

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumOfGuests();    // recalculate when numOfAdults changed
    }

    public void setNumOfKids(int numOfKids) {
        this.numOfKids = numOfKids;
        calculateTotalNumOfGuests();    // recalculate when numOfKids changed
    }

    private int numOfAdults;

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    private int numOfKids;
    private int totalNumOfGuests;
    private String bookingConfirmationCode;
    private Room room;

    public void calculateTotalNumOfGuests(){
        this.totalNumOfGuests = this.numOfAdults + this.numOfKids;
    }
}
