package imale.blogapirest.Dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {

    private String username;
    private String password;
    private String name;
    private String email;

}
