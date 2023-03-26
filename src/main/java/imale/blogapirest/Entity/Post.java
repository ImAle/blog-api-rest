package imale.blogapirest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    public Post(){}
    public Post(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        Content = content;
    }
}
