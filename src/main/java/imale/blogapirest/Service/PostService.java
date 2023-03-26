package imale.blogapirest.Service;

import imale.blogapirest.Dto.PostPageableValuesDto;
import imale.blogapirest.Dto.PostDto;

public interface PostService {

    PostDto newPost(PostDto postDto);
    PostPageableValuesDto getAllPosts(int pageNumber, int pageSize,String sortBy, String sortDir);
    PostDto getPostById(Long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePost(long id);
}
