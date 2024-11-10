import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.BonusService;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30; // для зарегистрированного пользователя бонус 3%

        // Вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // Производим проверку:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500; // бонус ограничен лимитом 500

        // Вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // Производим проверку:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные:
        long amount = 1000;
        boolean registered = false;
        long expected = 10; // для незарегистрированного пользователя бонус 1%

        // Вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // Производим проверку:
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnregisteredAndOverLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500; // бонус ограничен лимитом 500

        // Вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // Производим проверку:
        Assertions.assertEquals(expected, actual);
    }
}

