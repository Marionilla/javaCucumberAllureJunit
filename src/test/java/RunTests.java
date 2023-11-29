import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/test.feature", "src/test/resources/swagger.feature"},
        glue = "step",
        // plugin = "json:target/cucumber.json"
         plugin = {"pretty", "html:target/cucumber-reports"}
)
public class RunTests {

    public static void main(String[] args) {
        // Отримання значень параметрів системи Maven
        String threadCount = System.getProperty("threadCount", "1");
        String browser = System.getProperty("browser", "chrome");

        System.out.println("!!!!!!!!Thread Count: " + threadCount);
        System.out.println("Browser: " + browser);

//        // Створюємо пул потоків та виконуємо завдання паралельно
//        ExecutorService executorService = Executors.newFixedThreadPool(Integer.parseInt(threadCount));
//        for (int i = 0; i < Integer.parseInt(threadCount); i++) {
//            final int taskNumber = i;
//            executorService.execute(() -> {
//                System.out.println("Task " + taskNumber + " is running with browser: " + browser
//                        + " in thread " + Thread.currentThread().getName());
//            });
//        }
//
//        executorService.shutdown();

//           <configuration>
//                            <jsonFiles>
//                                <param>**/cucumber.json</param>
//                            </jsonFiles>
//                            <projectName>MyTestAutomationWork21</projectName>
//                            <outputDirectory>${project.build.directory}/test-classes</outputDirectory>
//                        </configuration>

    }
}



