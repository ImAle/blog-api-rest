package imale.blogapirest.Service.Mapper;

import imale.blogapirest.Dto.PostDto;
import imale.blogapirest.Entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostMapper{

    ModelMapper modelMapper = new ModelMapper();

    public PostDto toDto(Post entity){
        final PostDto dto = new PostDto();
        modelMapper.map(entity, dto);
        return dto;
    }

    public Post toEntity(PostDto dto){
        final Post entity = new Post();
        modelMapper.map(dto, entity);
        return entity;
    }
}
