import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "name")
    private String name;

    @Column(name = "area", precision = 10, scale = 2, nullable = false)
    private BigDecimal area;

    @Column(name = "national_day")
    private Date nationalDay;

    @Column(name = "country_code2", length = 2, nullable = false, unique = true)
    private String countryCode2;

    @Column(name = "country_code3", length = 3, nullable = false, unique = true)
    private String countryCode3;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    // Constructors

    public Country() {
    }

    public Country(String name, BigDecimal area, Date nationalDay, String countryCode2, String countryCode3, Region region) {
        this.name = name;
        this.area = area;
        this.nationalDay = nationalDay;
        this.countryCode2 = countryCode2;
        this.countryCode3 = countryCode3;
        this.region = region;
    }

    // Getters and setters

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Date getNationalDay() {
        return nationalDay;
    }

    public void setNationalDay(Date nationalDay) {
        this.nationalDay = nationalDay;
    }

    public String getCountryCode2() {
        return countryCode2;
    }

    public void setCountryCode2(String countryCode2) {
        this.countryCode2 = countryCode2;
    }

    public String getCountryCode3() {
        return countryCode3;
    }

    public void setCountryCode3(String countryCode3) {
        this.countryCode3 = countryCode3;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }
}
