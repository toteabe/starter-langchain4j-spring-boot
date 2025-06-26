package org.iesvdm.chatreservas.service;

import java.time.LocalDateTime;

public class BookingExistsException extends RuntimeException {
    public BookingExistsException(LocalDateTime bookingDate) {
        super("Booking already exists for date: " + bookingDate);
    }
}
