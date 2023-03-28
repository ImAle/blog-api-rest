package imale.blogapirest.Exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;
    private String roleName;

    public RoleNotFoundException(String resourceName, String fieldName, String roleName) {
        super(String.format("%s Not found: %s : '%s'", resourceName, fieldName, roleName));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.roleName = roleName;
    }

}
