package api.autocomplete.service;

import api.autocomplete.infrastructure.dto.KeywordDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class KeywordSearcher {
    private final Map<String, List<KeywordDTO>> keywordMap;

    public KeywordSearcher() {
        this.keywordMap = new HashMap<>();
    }

    public void put(String word, KeywordDTO keywordDTO) {
        if (this.keywordMap.containsKey(word)) {
            List<KeywordDTO> values = find(word);
            values.add(keywordDTO);
        } else {
            List<KeywordDTO> values = new ArrayList<>();
            values.add(keywordDTO);
            this.keywordMap.put(word, values);
        }
    }

    public List<KeywordDTO> find(String word) {
        return this.keywordMap.getOrDefault(word, new ArrayList<>());
    }

    Map<String, List<KeywordDTO>> get() {
        return this.keywordMap;
    }
}
