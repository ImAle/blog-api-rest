package imale.blogapirest.Service;

import imale.blogapirest.Auth.AuthenticationResponse;
import imale.blogapirest.Configuration.JwtService;
import imale.blogapirest.Dto.LoginDto;
import imale.blogapirest.Dto.RegisterDto;
import imale.blogapirest.Entity.Role;
import imale.blogapirest.Entity.User;
import imale.blogapirest.Exception.RoleNotFoundException;
import imale.blogapirest.Exception.UserNotRegisteredException;
import imale.blogapirest.Repository.RoleRepository;
import imale.blogapirest.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterDto registerDto) {

        Set<Role> roles = new HashSet<>();
        Role userRole = roleRepository.findRoleByName("ROLE_USER")
                .orElseThrow(() -> new RoleNotFoundException("ROLE", "name", "ROLE_USER"));
        roles.add(userRole);

        var user = User.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .username(registerDto.getUsername())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .roles(roles)
                .build();

        userRepository.save(user);

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthenticationResponse login(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUseremail(),
                loginDto.getPassword()
        ));
        var user = userRepository.findUserByEmail(loginDto.getUseremail())
                .orElseThrow(()-> new UserNotRegisteredException("The user does not exist", "email", loginDto.getUseremail()));

        var jwtToken = jwtService.generateToken(user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
