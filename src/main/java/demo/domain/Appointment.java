package demo.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String subject;
    private String place;

    protected Appointment() {
    }

    public Appointment(String subject, String place) {
        this.subject = subject;
        this.place = place;
    }

    @Override
    public String toString() {
        return String.format("Appointment[id=%d, subject='%s', place='%s']", id, subject, place);
    }

    public String getSubject() {
        return subject;
    }

    public String getPlace() {
        return place;
    }

}

