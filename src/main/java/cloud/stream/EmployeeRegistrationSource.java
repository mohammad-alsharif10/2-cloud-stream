package cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeRegistrationSource {

    String employeeRegistrationChannel="employeeRegistrationChannel";
    String employeeRegistrationChannel1="employeeRegistrationChannel1";
    String processorChannel="processorChannel";

    @Input(employeeRegistrationChannel)
    MessageChannel employeeRegistration();

    @Input("employeeRegistrationChannel1")
    MessageChannel employeeRegistration1();

    @Output(processorChannel)
    MessageChannel processorChannel();

}
