package edu.imi.ir.eduimiws.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

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
/*    @CreatedDate
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant created = Instant.now();*/

/*    @LastModifiedDate
    @UpdateTimestamp
    @Column(updatable = false)
    protected Instant edited  = Instant.now();*/

/*    public BaseEntity(Long id) {
        this.id = id;
    }*/

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
