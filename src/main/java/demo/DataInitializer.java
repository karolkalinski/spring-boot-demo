package demo;

import demo.domain.Appointment;
import demo.domain.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private AppointmentRepository appointmentRepository;

    @Autowired
    DataInitializer(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void init() {
        appointmentRepository.save(new Appointment("Stand up", "Mercury"));
        appointmentRepository.save(new Appointment("Retrospective", "Mercury"));
    }
}
