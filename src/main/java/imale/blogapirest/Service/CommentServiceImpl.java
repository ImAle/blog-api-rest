package imale.blogapirest.Service;

import imale.blogapirest.Dto.CommentDto;
import imale.blogapirest.Entity.Comment;
import imale.blogapirest.Entity.Post;
import imale.blogapirest.Exception.ResourceNotFoundException;
import imale.blogapirest.Repository.CommentRepository;
import imale.blogapirest.Repository.PostRepository;
import imale.blogapirest.Service.Mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDto newComment(CommentDto commentDto, long postId) {
        Comment comment = commentMapper.toEntity(commentDto);
        Post post = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        comment.setPost(post);
        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public Set<CommentDto> getAllCommentsByPost(long postId) {
        Set<Comment> commentSet = commentRepository.findCommentsByPostId(postId);
        Set<CommentDto> commentDtoSet = commentSet.stream().map(comment -> commentMapper.toDto(comment)).collect(Collectors.toSet());
        return commentDtoSet;
    }

    @Override
    public CommentDto getCommentById(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment","id", id));
        return commentMapper.toDto(comment);
    }

    @Override
    public CommentDto updateComment(CommentDto commentDto, long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment","id", id));
        // Set new Values
        comment.setName(commentDto.getName());
        comment.setComment(commentDto.getComment());
        comment.setEmail(commentDto.getEmail());

        return commentMapper.toDto(commentRepository.save(comment));
    }

    @Override
    public void deleteComment(long id) {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("comment", "id", id));
        commentRepository.delete(comment);
    }
}
