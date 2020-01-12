package life.light.referentielAppareilPhoto.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AppareilIntrouvableException extends Throwable {
    public AppareilIntrouvableException(String s) {
        super(s);
    }
}
