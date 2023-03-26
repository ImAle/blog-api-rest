package imale.blogapirest.Service.Mapper;

import imale.blogapirest.Dto.PostDto;
import imale.blogapirest.Dto.PostPageableValuesDto;
import imale.blogapirest.Entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostMapper{

    ModelMapper modelMapper = new ModelMapper();

    public PostDto toDto(Post entity){
        return modelMapper.map(entity, PostDto.class);
    }

    public Post toEntity(PostDto dto){
        return modelMapper.map(dto, Post.class);
    }

    public PostPageableValuesDto toPostPageableValues(List<PostDto> postDtos, Page<Post> dataPageable, int pageSize, int pageNumber){
        PostPageableValuesDto postPageableValuesDto = new PostPageableValuesDto();
        postPageableValuesDto.setPosts(postDtos);
        postPageableValuesDto.setPageSize(pageSize);
        postPageableValuesDto.setPageNumber(pageNumber);
        postPageableValuesDto.setNumberOfElements(dataPageable.getTotalElements());
        postPageableValuesDto.setNumberOfPages(dataPageable.getTotalPages() - 1);
        postPageableValuesDto.setLast(dataPageable.isLast());
        return postPageableValuesDto;
    }
}
