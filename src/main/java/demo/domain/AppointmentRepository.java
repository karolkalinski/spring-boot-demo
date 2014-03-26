package demo.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    List<Appointment> findByPlace(String place);
}
