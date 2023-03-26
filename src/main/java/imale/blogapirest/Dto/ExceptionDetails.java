package imale.blogapirest.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ExceptionDetails {

    private Date timeMark;
    private String message;
    private String details;

    public ExceptionDetails(){

    }
    public ExceptionDetails(Date timeMark, String message, String details) {
        this.timeMark = timeMark;
        this.message = message;
        this.details = details;
    }
}
