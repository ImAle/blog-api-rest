package imale.blogapirest.Service;

import imale.blogapirest.Dto.PostDto;
import imale.blogapirest.Entity.Post;
import imale.blogapirest.Exception.ResourceNotFoundException;
import imale.blogapirest.Repository.PostRepository;
import imale.blogapirest.Service.Mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private PostMapper postMapper;

    @Override
    public PostDto newPost(PostDto postDto) {
        // dto inserted by user
        Post post = postMapper.toEntity(postDto);
        // dto turned into entity and saved, now it has Id
        Post savedPost = postRepository.save(post);
        // That entity with id is turned again to Dto and returned
        return postMapper.toDto(savedPost);
    }

    @Override
    public List<PostDto> getAllPosts() {
        // Find all posts in DB
        List<Post> posts = postRepository.findAll();
        // Convert them into a list of PostDto
        List<PostDto> postDtos = posts.stream()
                .map(post -> postMapper.toDto(post))
                .collect(Collectors.toList());
        return postDtos;
    }

    @Override
    public PostDto getPostById(Long id) {
        // Get Post By Id. if not exists, throw new Exception
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));
        return postMapper.toDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        // Get Post By Id. if not exists, throw new Exception
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));
        // Set the new values of the Post
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        // Save the Post and convert it into Dto
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public void deletePost(long id) {
        // Get Post By Id. if not exists, throw new Exception
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "ID", id));
        // Delete Post
        postRepository.delete(post);
    }


}
