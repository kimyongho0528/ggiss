package api.autocomplete.service;

import api.autocomplete.infrastructure.KeywordRepository;
import api.autocomplete.infrastructure.KeywordRepositoryFactory;
import api.autocomplete.infrastructure.dto.KeywordDTO;
import api.autocomplete.infrastructure.type.PersistentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class KeywordServiceTest {
    private KeywordRepositoryFactory factory;
    private KeywordRepository repository;
    private KeywordService service;

    @BeforeEach
    void setup() {
        this.factory =  mock(KeywordRepositoryFactory.class);
        this.repository = mock(KeywordRepository.class);
        this.service = new KeywordServiceImpl(factory, new KeywordSearcher());
    }

    @DisplayName("getKeywordSearcherTest")
    @Test
    void getKeywordSearcherTest() {
        doReturn(repository).when(factory).create(PersistentType.MYBATIS);
        doReturn(Collections.singletonList(mockKeywordDTO())).when(repository).findKeywords();

        KeywordSearcher keywordSearcher = service.getKeywordSearcher();
        assertThat(keywordSearcher.get()).isEqualTo(mockKeywordSearcher().get());
    }

    private KeywordDTO mockKeywordDTO() {
        KeywordDTO dto = new KeywordDTO();
        dto.setKeyword("나이키");
        return dto;
    }

    private KeywordSearcher mockKeywordSearcher() {
        KeywordSearcher searcher = new KeywordSearcher();
        searcher.put("나이키", mockKeywordDTO());
        searcher.put("나이", mockKeywordDTO());
        searcher.put("나", mockKeywordDTO());
        searcher.put("이키", mockKeywordDTO());
        searcher.put("이", mockKeywordDTO());
        searcher.put("키", mockKeywordDTO());

        return searcher;
    }
}
