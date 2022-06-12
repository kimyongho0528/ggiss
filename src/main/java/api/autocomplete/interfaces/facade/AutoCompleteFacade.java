package api.autocomplete.interfaces.facade;

import api.autocomplete.interfaces.model.KeywordViewModel;

import java.util.List;

public interface AutoCompleteFacade {
    List<KeywordViewModel> matchKeywords(String keyword);
}
