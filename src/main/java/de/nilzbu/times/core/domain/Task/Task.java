package de.nilzbu.times.core.domain.Task;

import de.nilzbu.times.core.domain.Ticket.Ticket;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Task {

    @Id
    @Nonnull
    private UUID id;

    @Nonnull
    private String description;

    public static Task create(@Nonnull String description) {
        return new Task(UUID.randomUUID(), description);
    }

    @Override
    public String toString() {
        return description;
    }
}
