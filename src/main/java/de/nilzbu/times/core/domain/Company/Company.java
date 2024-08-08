package de.nilzbu.times.core.domain.Company;


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
public class Company {

    @Id
    @Nonnull
    private UUID id;

    @Nonnull
    private String name;

    public static Company create(String name) {
        return new Company(UUID.randomUUID(), name);
    }

    @Override
    public String toString() {
        return name;
    }
}
