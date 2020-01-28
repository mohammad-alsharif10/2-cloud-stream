package cloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;

@SpringBootApplication
@EnableBinding(EmployeeRegistrationSource.class)
public class Application {

    EmployeeRegistrationSource employeeRegistrationSource;

    public Application(EmployeeRegistrationSource employeeRegistrationSource) {
        this.employeeRegistrationSource = employeeRegistrationSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}
