package imale.blogapirest.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String name;
    private String email;
    @Column(nullable = false)
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false)
    private Post post;


    public Comment() {
    }

    public Comment(long id, String name, String email, String comment, Post post) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.comment = comment;
        this.post = post;
    }
}
