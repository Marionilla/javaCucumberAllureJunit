package step;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"}, // Шлях до фіча-файлів
        glue = "step", // Пакет, де знаходяться ваши кроки
        plugin = {"pretty", "html:target/cucumber-reports"} // Звіти та інші налаштування
)
public class RunTests {
    public static void main(String[] args) {
        // Отримання значень параметрів системи Maven
        String threadCount = System.getProperty("threadCount", "1");
        String browser = System.getProperty("browser", "chrome");

        // Створюємо пул потоків та виконуємо завдання паралельно
        ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(threadCount));
        for (int i = 0; i < Integer.parseInt(threadCount); i++) {
            final int taskNumber = i;
            executorService.execute(() -> {
                System.out.println("Task " + taskNumber + " is running with browser: " + browser
                        + " in thread " + Thread.currentThread().getName());
            });
        }

        // Завершуємо роботу пулу потоків
        executorService.shutdown();
    }

}



