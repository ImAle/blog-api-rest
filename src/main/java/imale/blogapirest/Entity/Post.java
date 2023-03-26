package imale.blogapirest.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Table(name = "post", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private String Content;

    @JsonBackReference
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    public Post(){}
    public Post(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        Content = content;
    }
}
