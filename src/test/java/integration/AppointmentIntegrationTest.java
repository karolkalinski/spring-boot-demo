package integration;

import demo.BootDemo;
import demo.FirstController;
import demo.domain.Appointment;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import demo.domain.AppointmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;

import static org.hamcrest.Matchers.hasSize;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootDemo.class)
public class AppointmentIntegrationTest {
    public static final Appointment APPOINTMENT = new Appointment("Stand up", "Mercury");
    @Autowired
    FirstController controller;

    @Autowired
    AppointmentRepository repository;

    @Test
    public void shouldReturnAllAppointments() {
        //given
        thereIsAppointmentInRepository();

        //when
        Collection<Appointment> actual = controller.get();

        //then
        assertThat(actual , hasSize(1));
    }

    private void thereIsAppointmentInRepository() {
        repository.save(APPOINTMENT);
    }

}
