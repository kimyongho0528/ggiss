package api.autocomplete.infrastructure;

import api.autocomplete.infrastructure.dto.KeywordDTO;

import java.util.List;

public interface KeywordRepository {
    List<KeywordDTO> findKeywords();
}
