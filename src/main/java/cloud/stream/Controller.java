package cloud.stream;


import cloud.stream.model.Employee;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@EnableBinding(EmployeeRegistrationSource.class)
public class Controller {

    EmployeeRegistrationSource employeeRegistrationSource;

    public Controller(EmployeeRegistrationSource employeeRegistrationSource) {
        this.employeeRegistrationSource = employeeRegistrationSource;
    }


    @StreamListener(target = EmployeeRegistrationSource.employeeRegistrationChannel)
    public void processRegisterEmployees(Employee employee) {
        System.out.println("Employees Registered by Client " + employee);
    }

    @StreamListener(target = EmployeeRegistrationSource.employeeRegistrationChannel1)
    public void processRegisterEmployees1(Employee employee) {
        employeeRegistrationSource.processorChannel().send(MessageBuilder.withPayload(employee).build());
        System.out.println("Employees Registered by Client " + employee.getEmpName());
    }

}
