package imale.blogapirest.Service;

import imale.blogapirest.Auth.AuthenticationResponse;
import imale.blogapirest.Dto.LoginDto;
import imale.blogapirest.Dto.RegisterDto;

public interface AuthService {

    AuthenticationResponse register(RegisterDto registerDto);
    AuthenticationResponse login(LoginDto loginDto);

}
