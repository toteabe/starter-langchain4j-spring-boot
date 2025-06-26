package org.iesvdm.chatreservas.repository;

import org.iesvdm.chatreservas.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID> {
    Optional<Booking> findByBookingNumber(String bookingNumber);

    boolean existsByBookingDate(LocalDateTime bookingDate);
}