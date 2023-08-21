import javax.persistence.*;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @Column(name = "guest_id")
    private int guestId;

    @Column(name = "name", nullable = false)
    private String name;

  
    public Guest() {
    }

    public Guest(int guestId, String name) {
        this.guestId = guestId;
        this.name = name;
    }

    // Getters and setters

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
