package imale.blogapirest.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostPageableValuesDto {

    private List<PostDto> posts;
    private int pageNumber;
    private int pageSize;
    private int numberOfPages;
    private long numberOfElements;
    private boolean last;

    public PostPageableValuesDto(){
        super();
    }

    public PostPageableValuesDto(List<PostDto> posts, int pageNumber, int pageSize, int numberOfPages, long numberOfElements, boolean last) {
        this.posts = posts;
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.numberOfPages = numberOfPages;
        this.numberOfElements = numberOfElements;
        this.last = last;
    }

}
