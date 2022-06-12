package api.autocomplete.interfaces.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class KeywordViewModel {
    private final String keyword;
}
