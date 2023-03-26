package imale.blogapirest.Service.Mapper;

import imale.blogapirest.Dto.CommentDto;
import imale.blogapirest.Entity.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentMapper {

    ModelMapper modelMapper = new ModelMapper();

    public CommentDto toDto(Comment entity){
        return modelMapper.map(entity, CommentDto.class);
    }

    public Comment toEntity(CommentDto dto){
        return modelMapper.map(dto, Comment.class);
    }
}
