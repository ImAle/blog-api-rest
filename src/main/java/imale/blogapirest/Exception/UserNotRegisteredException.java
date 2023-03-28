package imale.blogapirest.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UserNotRegisteredException extends RuntimeException{

    private String reason;
    private String fieldName;
    private String fieldValue;

    public UserNotRegisteredException(String reason, String fieldName, String fieldValue) {
        super(String.format("%s Not found: %s : '%s'", reason, fieldName, fieldValue));
        this.reason = reason;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
