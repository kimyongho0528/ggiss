package api.autocomplete.interfaces.facade;

import api.autocomplete.infrastructure.dto.KeywordDTO;
import api.autocomplete.interfaces.facade.assembler.KeywordViewModelAssembler;
import api.autocomplete.interfaces.model.KeywordViewModel;
import api.autocomplete.service.KeywordSearcher;
import api.autocomplete.service.KeywordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class AutoCompleteFacadeImplTest {
    private KeywordService service;
    private KeywordViewModelAssembler assembler;
    private AutoCompleteFacade facade;
    private KeywordSearcher searcher;

    @BeforeEach
    void setup() {
        this.service = mock(KeywordService.class);
        this.assembler = new KeywordViewModelAssembler();
        this.facade = new AutoCompleteFacadeImpl(service, assembler);
        this.searcher = new KeywordSearcher();
        mockKeywordSearcher();

    }

    @DisplayName("matchKeywords Test")
    @Test
    void matchKeywordsTest() {
        doReturn(searcher).when(service).getKeywordSearcher();
        List<String> result = facade.matchKeywords("다")
                                    .stream()
                                    .map(KeywordViewModel::getKeyword)
                                    .collect(Collectors.toList());

        List<String> expected = Arrays.asList("다", "가나다", "가나다라");
        assertThat(result).isEqualTo(expected);

    }

    private void mockKeywordSearcher() {
        searcher.put("다", mockKeywordDTO("가나다"));
        searcher.put("다", mockKeywordDTO("다"));
        searcher.put("다", mockKeywordDTO("가나다라"));
    }

    private KeywordDTO mockKeywordDTO(String keyword) {
        KeywordDTO dto = new KeywordDTO();
        dto.setKeyword(keyword);
        return dto;
    }
}
