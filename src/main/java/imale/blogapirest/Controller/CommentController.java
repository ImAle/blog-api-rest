package imale.blogapirest.Controller;

import imale.blogapirest.Dto.CommentDto;
import imale.blogapirest.Service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDto> newComment(@PathVariable("postId") long postId, @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.newComment(commentDto,postId), HttpStatus.CREATED);
    }

    @GetMapping("/post/{postId}/comments")
    public ResponseEntity<Set<CommentDto>> getCommentsByPost(@PathVariable("postId") long postId){
        return new ResponseEntity<>(commentService.getAllCommentsByPost(postId), HttpStatus.OK);
    }

    @GetMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getCommentById(@PathVariable("commentId") long commentId){
        return new ResponseEntity<>(commentService.getCommentById(commentId), HttpStatus.OK);
    }

    @PutMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> updateCommentById(@PathVariable("commentId") long commentId, @Valid @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.updateComment(commentDto, commentId), HttpStatus.OK);
    }

    @DeleteMapping("/post/{postId}/comments/{commentId}")
    public ResponseEntity<String> deleteCommentById(@PathVariable("commentId") long commentId){
        commentService.deleteComment(commentId);
        return new ResponseEntity<>("Comment has been deleted successfully", HttpStatus.OK);
    }

}
