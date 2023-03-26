package imale.blogapirest.Service;

import imale.blogapirest.Dto.CommentDto;

import java.util.Set;

public interface CommentService {

    CommentDto newComment(CommentDto commentDto, long postId);
    Set<CommentDto> getAllCommentsByPost(long postId);
    CommentDto getCommentById(long id);
    CommentDto updateComment(CommentDto commentDto, long id);
    void deleteComment(long id);
}
