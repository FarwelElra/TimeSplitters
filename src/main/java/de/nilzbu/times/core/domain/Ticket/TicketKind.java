package de.nilzbu.times.core.domain.Ticket;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TicketKind {

    US_STORY("US-"),
    ISSUE("I-");

    private final String prefix;

}
