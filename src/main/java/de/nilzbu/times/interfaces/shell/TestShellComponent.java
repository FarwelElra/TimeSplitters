package de.nilzbu.times.interfaces.shell;

import de.nilzbu.times.core.domain.BookingItem.BookingItemRepository;
import de.nilzbu.times.core.domain.Company.Company;
import de.nilzbu.times.core.domain.Company.CompanyRepository;
import de.nilzbu.times.core.domain.Task.Task;
import de.nilzbu.times.core.domain.Task.TaskRepository;
import de.nilzbu.times.core.domain.Ticket.Ticket;
import de.nilzbu.times.core.domain.Ticket.TicketKind;
import de.nilzbu.times.core.domain.Ticket.TicketRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import java.util.UUID;

@ShellComponent
@RequiredArgsConstructor
@Slf4j
public class TestShellComponent {

    private final CompanyRepository companyRepository;
    private final TaskRepository taskRepository;
    private final TicketRepository ticketRepository;
    private final BookingItemRepository bookingItemRepository;

    @ShellMethod("createCompany")
    public void createCompany(String companyName) {
        companyRepository.save(Company.create(companyName));
    }

    @ShellMethod("createTask")
    public void createTask(String description) {
        taskRepository.save(Task.create(description));
    }

    @ShellMethod("createUserStory")
    public void createUserStory(int ticketNumber) {
        createTicket(ticketNumber, TicketKind.US_STORY);
    }

    @ShellMethod("createIssue")
    public void createIssue(int ticketNumber) {
        createTicket(ticketNumber, TicketKind.ISSUE);
    }

    private void createTicket(int ticketNumber, TicketKind ticketKind) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append(ticketNumber);
        while (stringBuffer.length() < 4) {
            stringBuffer.insert(0, "0");
        }
        ticketRepository.save(Ticket.create(ticketKind, stringBuffer.toString()));
    }

    @ShellMethod("showTickets")
    public String showTickets() {
        return outputObjects(ticketRepository);
    }

    @ShellMethod("showTasks")
    public String showTasks() {
        return outputObjects(taskRepository);
    }

    @ShellMethod("showCompanies")
    public String showCompanies() {
        return outputObjects(companyRepository);
    }

    private String outputObjects(CrudRepository<?, UUID> crudRepository) {
        StringBuilder builder = new StringBuilder();
        crudRepository.findAll().forEach(entity ->
                builder.append("%s\n".formatted(entity))
        );
        return builder.substring(0, builder.lastIndexOf("\n"));
    }

}
