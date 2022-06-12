package api.autocomplete.interfaces;

import api.autocomplete.interfaces.facade.AutoCompleteFacade;
import api.autocomplete.interfaces.model.KeywordViewModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class SearchController {
    private final AutoCompleteFacade facade;

    public SearchController(AutoCompleteFacade facade) {
        this.facade = facade;
    }

    @GetMapping("/api/search/{keyword}/auto-complete")
    public List<KeywordViewModel> getItem(@PathVariable String keyword) {
        return facade.matchKeywords(keyword);
    }
}
