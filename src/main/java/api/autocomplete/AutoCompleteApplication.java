package api.autocomplete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class AutoCompleteApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutoCompleteApplication.class, args);
    }
}
