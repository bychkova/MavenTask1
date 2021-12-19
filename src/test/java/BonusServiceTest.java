import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisteredAndPurchaseUnderLimit() {
        BonusService service = new BonusService();

        long amount = 15000_60;
        boolean registered = true;
        long expected = 450;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndBorderPurchaseUnderLimit() {
        BonusService service = new BonusService();

        long amount = 16666_60;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndBorderPurchaseOverLimit() {
        BonusService service = new BonusService();

        long amount = 16667_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateRegisteredAndPurchaseOverLimit() {
        BonusService service = new BonusService();

        long amount = 10_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
//---------//
    @Test
    void shouldCalculateNotRegisteredAndPurchaseUnderLimit() {
        BonusService service = new BonusService();

        long amount = 15000_60;
        boolean registered = false;
        long expected = 150;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndBorderPurchaseUnderLimit() {
        BonusService service = new BonusService();

        long amount = 49999_60;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndBorderPurchaseOverLimit() {
        BonusService service = new BonusService();

        long amount = 50000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateNotRegisteredAndPurchaseOverLimit() {
        BonusService service = new BonusService();

        long amount = 10_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}