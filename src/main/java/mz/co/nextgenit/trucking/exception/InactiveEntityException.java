package mz.co.nextgenit.trucking.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InactiveEntityException extends RuntimeException {
    public InactiveEntityException(String message) {
        super(message);
    }
}
