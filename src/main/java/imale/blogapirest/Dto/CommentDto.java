package imale.blogapirest.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {

    private long id;
    @NotEmpty(message = "The name must not be empty")
    private String name;
    @Email(message = "email not valid")
    @NotEmpty(message = "The email must not be empty")
    private String email;
    @NotEmpty(message = "The comment must not be empty")
    @Size(min=10, message = "The comment must be contain at least 10 characters")
    private String comment;

    public CommentDto(){}
    public CommentDto(long id, String name, String email, String comment) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.comment = comment;
    }
}
