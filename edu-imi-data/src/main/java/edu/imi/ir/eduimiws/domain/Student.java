package edu.imi.ir.eduimiws.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(schema = "EDU",name = "TBL_STUDENT")
public class Student implements Serializable {

    @Id
    private Long id;
}
