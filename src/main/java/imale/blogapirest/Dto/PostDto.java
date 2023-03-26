package imale.blogapirest.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {

    private Long id;
    private String title;
    private String description;
    private String content;

    public PostDto() {

    }
    public PostDto(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }
}
