package imale.blogapirest.Service;

import imale.blogapirest.Dto.PostDto;

import java.util.List;

public interface PostService {

    public PostDto newPost(PostDto postDto);
    public List<PostDto> getAllPosts();
    public PostDto getPostById(Long id);
    public PostDto updatePost(PostDto postDto, long id);
    public void deletePost(long id);
}
