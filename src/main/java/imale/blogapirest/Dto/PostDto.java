package imale.blogapirest.Dto;

import imale.blogapirest.Entity.Comment;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class PostDto {

    private Long id;
    @NotEmpty(message = "Title must not be empty")
    @NotNull(message = "Title must not be null")
    @Size(min = 2, message = "Post title must be longer than 2 characters")
    private String title;
    @NotEmpty(message = "description must not be empty")
    @Size(min = 10, message = "Post title must be longer than 10 characters")
    private String description;
    @NotEmpty(message = "content must not be empty")
    private String content;
    private Set<Comment> comments;

    public PostDto() {

    }

    public PostDto(Long id, String title, String description, String content, Set<Comment> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.comments = comments;
    }
}
