import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CountryLanguageId implements Serializable {
    @Column(name = "country_id")
    private int countryId;

    @Column(name = "language_id")
    private int languageId;

    public CountryLanguageId() {
    }

    public CountryLanguageId(int countryId, int languageId) {
        this.countryId = countryId;
        this.languageId = languageId;
    }

    // Equals and hashCode methods

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLanguageId that = (CountryLanguageId) o;
        return countryId == that.countryId && languageId == that.languageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, languageId);
    }
}
