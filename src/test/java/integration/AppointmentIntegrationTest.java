package integration;

import demo.BootDemo;
import demo.domain.Appointment;
import demo.domain.AppointmentRepository;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.RestTemplates;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

@SuppressWarnings("SpringJavaAutowiredMembersInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootDemo.class)
@IntegrationTest
@WebAppConfiguration
public class AppointmentIntegrationTest {
    public static final Appointment APPOINTMENT = new Appointment("Stand up", "Mercury");

    @Autowired private AppointmentRepository repository;

    @Test
    public void shouldReturnAllAppointments() {
        //given
        thereIsAppointmentInRepository();

        //when
        ResponseEntity response = restClientAsksForAllApointments();

        //then
        assertThat(response, isProper());
    }

    private Matcher<? super ResponseEntity> isProper() {
        return notNullValue();
    }

    private ResponseEntity<String> restClientAsksForAllApointments() {
        return RestTemplates.get().getForEntity(
                "http://localhost:8080/appointments", String.class);
    }

    private void thereIsAppointmentInRepository() {
        repository.save(APPOINTMENT);
    }

}
