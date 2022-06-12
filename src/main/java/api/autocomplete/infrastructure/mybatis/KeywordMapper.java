package api.autocomplete.infrastructure.mybatis;

import api.autocomplete.infrastructure.dto.KeywordDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KeywordMapper {
    List<KeywordDTO> findKeywords();
}
