package de.nilzbu.times.core.domain.BookingItem;

import de.nilzbu.times.core.domain.Company.Company;
import de.nilzbu.times.core.domain.Task.Task;
import de.nilzbu.times.core.domain.Ticket.Ticket;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BookingItem {

    @Id
    @Nonnull
    private UUID id;

    @Nonnull
    @ManyToOne
    private Task task;

    @Nonnull
    @ManyToOne
    private Company company;

    @Nonnull
    @ManyToOne
    private Ticket ticket;

    @Nonnull
    private LocalDate date;

    private int minutes;

    public static BookingItem create(Task task, Company company, Ticket ticket, LocalDate localDate, int minutes) {
        return new BookingItem(UUID.randomUUID(), task, company, ticket, localDate, minutes);
    }

    @Override
    public String toString() {
        return "BookingItem: %s , %s, %s Date: %s, Minutes: %d".formatted(company, ticket, task, date, minutes);
    }

    public boolean isBetween(@Nonnull LocalDate start,@Nonnull LocalDate end) {
        if(date.equals(start) || date.equals(end)) {
            return true;
        }
        return date.isAfter(start) && date.isBefore(end);
    }
}
