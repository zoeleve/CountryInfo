import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CountryStatsId implements Serializable {
    @Column(name = "country_id")
    private int countryId;
    private Country country;

    @Column(name = "year")
    private int year;

    public CountryStatsId() {
    }

    public CountryStatsId(int countryId, int year) {
        this.countryId = countryId;
        this.year = year;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryStatsId that = (CountryStatsId) o;
        return countryId == that.countryId && year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, year);
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
}
