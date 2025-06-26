package org.iesvdm.chatreservas.service;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String bookingNumber) {
        super("Booking not found with booking number: " + bookingNumber);
    }
}
