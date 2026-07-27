import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private Date booking_date;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "booking_flight",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    private List<Flight> flights;


    public Booking() {
    }

    public Booking(Date booking_date, String status) {
        this.booking_date = booking_date;
        this.status = status;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getBookingDate() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}