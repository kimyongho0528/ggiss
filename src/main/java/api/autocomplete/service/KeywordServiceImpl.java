package api.autocomplete.service;

import api.autocomplete.infrastructure.KeywordRepositoryFactory;
import api.autocomplete.infrastructure.dto.KeywordDTO;
import api.autocomplete.infrastructure.type.PersistentType;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {
    private final KeywordRepositoryFactory factory;
    private final KeywordSearcher searcher;

    public KeywordServiceImpl(KeywordRepositoryFactory factory, KeywordSearcher searcher) {
        this.factory = factory;
        this.searcher = searcher;
    }

    @Cacheable("getKeywordSearcher")
    @Override
    public KeywordSearcher getKeywordSearcher() {
        List<KeywordDTO> keywords = factory.create(PersistentType.MYBATIS)
                                           .findKeywords();

        keywords.forEach(this::createKeywordSearcher);

        return searcher;
    }

    private void createKeywordSearcher(KeywordDTO keywordDTO) {
        String keyword = keywordDTO.getKeyword();
        for (int i = 0; i < keyword.length(); i++) {
            String prefixWord = keyword.substring(i);
            for (int j = 0; j < prefixWord.length(); j++) {
                searcher.put(prefixWord.substring(0, prefixWord.length() - j), keywordDTO);
            }
        }
    }
}
