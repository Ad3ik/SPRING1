import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Config.xml");
        context.registerShutdownHook();
        ConsoleClient consoleClient = context.getBean("consoleClient", ConsoleClient.class);
        consoleClient.run();
    }
}
