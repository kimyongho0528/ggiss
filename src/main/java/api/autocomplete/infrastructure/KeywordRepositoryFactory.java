package api.autocomplete.infrastructure;

import api.autocomplete.infrastructure.mybatis.KeywordMapper;
import api.autocomplete.infrastructure.mybatis.MybatisRepositoryImpl;
import api.autocomplete.infrastructure.type.PersistentType;
import org.springframework.stereotype.Repository;

@Repository
public class KeywordRepositoryFactory {
    private final KeywordMapper mapper;

    public KeywordRepositoryFactory(KeywordMapper mapper) {
        this.mapper = mapper;
    }

    public KeywordRepository create(PersistentType type) {
        if (type == PersistentType.MYBATIS) {
            return new MybatisRepositoryImpl(mapper);
        }
        return new MybatisRepositoryImpl(mapper);
    }
}
