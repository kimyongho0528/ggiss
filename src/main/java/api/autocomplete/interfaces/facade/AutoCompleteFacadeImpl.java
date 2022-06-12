package api.autocomplete.interfaces.facade;

import api.autocomplete.infrastructure.dto.KeywordDTO;
import api.autocomplete.interfaces.facade.assembler.KeywordViewModelAssembler;
import api.autocomplete.interfaces.model.KeywordViewModel;
import api.autocomplete.service.KeywordService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoCompleteFacadeImpl implements AutoCompleteFacade {
    private final KeywordService service;
    private final KeywordViewModelAssembler assembler;

    public AutoCompleteFacadeImpl(KeywordService service, KeywordViewModelAssembler assembler) {
        this.service = service;
        this.assembler = assembler;
    }

    @Override
    public List<KeywordViewModel> matchKeywords(String keyword) {
        List<KeywordDTO> keywords = service.getKeywordSearcher()
                                           .find(keyword)
                                           .stream()
                                           .sorted(Comparator.comparing(keywordDTO -> keywordDTO.getKeyword().length()))
                                           .collect(Collectors.toList());

        return assembler.toViewModels(keywords);
    }
}
