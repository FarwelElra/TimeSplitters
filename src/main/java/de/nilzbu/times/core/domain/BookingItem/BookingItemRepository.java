package de.nilzbu.times.core.domain.BookingItem;

import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.UUID;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface BookingItemRepository extends CrudRepository<BookingItem, UUID> {

    default Stream<BookingItem> ofPeriod(LocalDate start, LocalDate end) {
        return StreamSupport.stream(
                findAll().spliterator(),
                false
        ).filter(bookingItem -> bookingItem.isBetween(start, end));
    }
}
