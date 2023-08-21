import javax.persistence.*;

@Entity
@Table(name = "country_languages")
public class CountryLanguage {
    @EmbeddedId
    private CountryLanguageId id;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;

    @ManyToOne
    @MapsId("languageId")
    @JoinColumn(name = "language_id")
    private Language language;

    @Column(name = "official", nullable = false)
    private boolean official;

  
    public CountryLanguage() {
    }

    public CountryLanguage(Country country, Language language, boolean official) {
        this.country = country;
        this.language = language;
        this.official = official;
        this.id = new CountryLanguageId(country.getCountryId(), language.getLanguageId());
    }

    public CountryLanguageId getId() {
        return id;
    }

    public void setId(CountryLanguageId id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return official;
    }

    public void setOfficial(boolean official) {
        this.official = official;
    }
}
