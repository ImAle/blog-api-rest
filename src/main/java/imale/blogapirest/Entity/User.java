package imale.blogapirest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"username"}), @UniqueConstraint(columnNames = {"email"})})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String name;
    private String password;
    private String username;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable
            (name="user_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private Set<Role> roles = new HashSet<>();

    public User(){}

    public User(String email, String name, String password, String username) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
    }

    public User(String email, String name, String password, String username, Set<Role> roles) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }

    public User(long id, String email, String name, String password, String username, Set<Role> roles) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.username = username;
        this.roles = roles;
    }
}
