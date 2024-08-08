package de.nilzbu.times.core.domain.Ticket;


import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Ticket {

    @Id
    @Nonnull
    private UUID id;

    @Enumerated
    @Column(nullable = false)
    @Nonnull
    private TicketKind ticketKind;

    @Column(nullable = false, unique = true, length = 4)
    @Nonnull
    private String ticketNumber;

    public static Ticket create(@Nonnull TicketKind ticketKind, @Nonnull String ticketNumber) {
        return new Ticket(UUID.randomUUID(), ticketKind, ticketNumber);
    }

    @Override
    public String toString() {
        return "%s%s".formatted(ticketKind.getPrefix(), ticketNumber);
    }
}
