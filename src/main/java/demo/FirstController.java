package demo;

import demo.domain.Appointment;
import demo.domain.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/appointments")
public class FirstController {
    @Autowired
    AppointmentRepository appointmentRepository;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Collection<Appointment> get() {
        return appointmentRepository.findAll();
    }
}
