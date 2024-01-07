package com.vibhorkolte.solacehotel.model;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "check_In")
    private LocalDate checkInDate;

    @Column(name = "check_Out")
    private LocalDate checkOutDate;

    @Column(name = "guest_FullName")
    private String guestFullName;

    @Column(name = "guest_Email")
    private String guestEmail;

    @Column(name = "adults")
    private int numOfAdults;
    @Column(name = "kids")
    private int numOfKids;
    @Column(name = "total_Guests")
    private int totalNumOfGuests;

    @Column(name = "confirmation_Code")
    private String bookingConfirmationCode;

    private Room room;

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumOfGuests();    // recalculate when numOfAdults changed
    }

    public void setNumOfKids(int numOfKids) {
        this.numOfKids = numOfKids;
        calculateTotalNumOfGuests();    // recalculate when numOfKids changed
    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }

    public void calculateTotalNumOfGuests(){
        this.totalNumOfGuests = this.numOfAdults + this.numOfKids;
    }
}
