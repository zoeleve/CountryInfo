import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "region_areas")
public class RegionArea {
    @Id
    @Column(name = "region_name")
    private String regionName;

    @Column(name = "region_area", nullable = false)
    private BigDecimal regionArea;

  
    public RegionArea() {
    }

    public RegionArea(String regionName, BigDecimal regionArea) {
        this.regionName = regionName;
        this.regionArea = regionArea;
    }


    public String getRegionName() {
    	
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public BigDecimal getRegionArea() {
        return regionArea;
    }

    public void setRegionArea(BigDecimal regionArea) {
        this.regionArea = regionArea;
    }
}
