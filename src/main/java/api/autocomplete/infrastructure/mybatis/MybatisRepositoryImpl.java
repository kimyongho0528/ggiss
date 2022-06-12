package api.autocomplete.infrastructure.mybatis;

import api.autocomplete.infrastructure.KeywordRepository;
import api.autocomplete.infrastructure.dto.KeywordDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MybatisRepositoryImpl implements KeywordRepository {
    private final KeywordMapper mapper;

    public MybatisRepositoryImpl(KeywordMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<KeywordDTO> findKeywords() {
        return mapper.findKeywords();
    }
}
