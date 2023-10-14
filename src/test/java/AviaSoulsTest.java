import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {
    AviaSouls service = new AviaSouls();
    Ticket ticket1 = new Ticket(
            "London",
            "Moscow",
            1000,
            14,
            16
    );

    Ticket ticket2 = new Ticket(
            "Paris",
            "Moscow",
            2000,
            14,
            18
    );

    Ticket ticket3 = new Ticket(
            "London",
            "Moscow",
            6000,
            12,
            16
    );
    @Test
    public void shouldSearchNoTickets() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);

        Ticket[] expected = { };
        Ticket[] actual = service.search("London", "Pskov");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchOneTicket() {

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);

        Ticket[] expected = {ticket2};
        Ticket[] actual = service.search("Paris", "Moscow");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSearchSomeTicketsAndSortPrice() {

        Ticket ticket4 = new Ticket(
                "London",
                "Moscow",
                4000,
                11,
                12
        );

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);

        Ticket[] expected = {ticket1, ticket4, ticket3};
        Ticket[] actual = service.search("London", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void compareToTicket1Less() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                1000,
                14,
                17
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                16,
                19
        );

        service.add(ticket1);
        service.add(ticket2);

        int expected = -1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTicket1More() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                4000,
                14,
                17
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                16,
                19
        );

        service.add(ticket1);
        service.add(ticket2);

        int expected = 1;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void compareToTicket1Equals() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                6000,
                14,
                17
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                6000,
                16,
                19
        );

        service.add(ticket1);
        service.add(ticket2);

        int expected = 0;
        int actual = ticket1.compareTo(ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void searchAndSortComparator() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                1000,
                14,
                16
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                14,
                18
        );

        Ticket ticket3 = new Ticket(
                "London",
                "Moscow",
                6000,
                12,
                16
        );

        Ticket ticket4 = new Ticket(
                "London",
                "Moscow",
                4000,
                11,
                12
        );

        service.add(ticket1);
        service.add(ticket2);
        service.add(ticket3);
        service.add(ticket4);

        Ticket[] expected = {ticket4, ticket1, ticket3};
        Ticket[] actual = service.searchAndSortBy("London", "Moscow");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ComparatorTicket1Less() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                1000,
                14,
                16
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                14,
                18
        );

        TicketTimeComparator durationComparator = new TicketTimeComparator();

        int expected = -1;
        int actual = durationComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void ComparatorTicket1More() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                1000,
                14,
                20
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                14,
                18
        );

        TicketTimeComparator durationComparator = new TicketTimeComparator();

        int expected = 1;
        int actual = durationComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void ComparatorTicket1Equals() {
        Ticket ticket1 = new Ticket(
                "London",
                "Moscow",
                1000,
                14,
                16
        );

        Ticket ticket2 = new Ticket(
                "Paris",
                "Moscow",
                2000,
                14,
                16
        );

        TicketTimeComparator durationComparator = new TicketTimeComparator();

        int expected = 0;
        int actual = durationComparator.compare(ticket1, ticket2);

        Assertions.assertEquals(expected, actual);
    }
}
