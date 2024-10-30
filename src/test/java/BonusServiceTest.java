import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.example.BonusService;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // Вызываем целевой метод
        long actual = service.calculate(amount, registered);

        // Проверяем результат
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // Подготавливаем данные
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // Вызываем целевой метод
        long actual = service.calculate(amount, registered);

        // Проверяем результат
        Assertions.assertEquals(expected, actual);
    }
}
