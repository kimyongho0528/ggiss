package api.autocomplete.interfaces.facade.assembler;

import api.autocomplete.infrastructure.dto.KeywordDTO;
import api.autocomplete.interfaces.model.KeywordViewModel;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class KeywordViewModelAssembler {
    public List<KeywordViewModel> toViewModels(List<KeywordDTO> keywords) {
        return keywords.stream()
                       .map(this::toViewModel)
                       .collect(Collectors.toList());
    }

    public KeywordViewModel toViewModel(KeywordDTO keyword) {
        return KeywordViewModel.builder()
                               .keyword(keyword.getKeyword())
                               .build();
    }
}
