import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface VipMapper {
	@Select("SELECT * FROM vips")
    List<vips> getName();
}


    
