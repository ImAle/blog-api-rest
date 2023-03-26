package imale.blogapirest.Service;

import imale.blogapirest.Dto.PostPageableValuesDto;
import imale.blogapirest.Dto.PostDto;
import imale.blogapirest.Entity.Post;
import imale.blogapirest.Exception.ResourceNotFoundException;
import imale.blogapirest.Repository.PostRepository;
import imale.blogapirest.Service.Mapper.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
    public PostPageableValuesDto getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir) {
        // Choosing if asc or desc sorting
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        // Posts Pageable
        PageRequest pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<Post> postPaged = postRepository.findAll(pageable);
        List<Post> postList = postPaged.getContent();
        List<PostDto> postsToDisplay =  postList.stream().map(post -> postMapper.toDto(post)).collect(Collectors.toList());
        // Get more data as the number of elements, pages, if it is the last page, pageNumber and pageSize to display
        return postMapper.toPostPageableValues(postsToDisplay, postPaged, pageSize, pageNumber);
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
