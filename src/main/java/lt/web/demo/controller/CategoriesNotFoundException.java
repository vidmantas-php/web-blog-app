package lt.web.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoriesNotFoundException extends RuntimeException {
    public CategoriesNotFoundException(String message) {
        super(message);
    }
}
