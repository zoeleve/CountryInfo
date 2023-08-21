import javax.persistence.*;

@Entity
@Table(name = "country_stats")
public class CountryStats {
    @EmbeddedId
    private CountryStatsId id;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "year", insertable = false, updatable = false)
    private int year;

    @Column(name = "population")
    private Integer population;

    @Column(name = "gdp", precision = 15, scale = 0)
    private Long gdp;

    // Constructors, getters, and setters

    // Constructors
    public CountryStats() {
    }

    public CountryStats(Country country, int year, Integer population, Long gdp) {
        this.country = country;
        this.year = year;
        this.population = population;
        this.gdp = gdp;
        this.id = new CountryStatsId(country.getCountryId(), year);
    }

    // Getters and setters

    public CountryStatsId getId() {
        return id;
    }

    public void setId(CountryStatsId id) {
        this.id = id;
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

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Long getGdp() {
        return gdp;
    }

    public void setGdp(Long gdp) {
        this.gdp = gdp;
    }
}
