package mz.co.nextgenit.trucking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExpection extends RuntimeException {
    public ResourceNotFoundExpection(String message) {
        super(message);
    }
}
