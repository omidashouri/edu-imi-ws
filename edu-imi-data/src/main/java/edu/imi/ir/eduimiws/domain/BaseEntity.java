package edu.imi.ir.eduimiws.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    private static final long serialVersionUID = 4675110684223223320L;


    @Id
    @GeneratedValue(generator = "entity_sequence", strategy = GenerationType.SEQUENCE)
    protected Long id;

//    add for test
    @CreatedDate
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant created = Instant.now();

    @LastModifiedDate
    @UpdateTimestamp
    @Column(updatable = true)
    protected Instant edited  = Instant.now();

    public BaseEntity(Long id) {
        this.id = id;
    }

/*   public BaseEntity() {
    }

    public BaseEntity(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }*/
}
