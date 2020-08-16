package edu.imi.ir.eduimiws.models.dto.edu;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TermApiDto implements Serializable {

    private static final long serialVersionUID = -7906442114976402364L;

    private Long id;

    private TermDto termDto;

    private String termPublicId;

    private String termEditDate;

    private java.sql.Timestamp createDateTs;

    private java.sql.Timestamp editDateTs;

    private java.sql.Timestamp deleteDateTs;

    private String description;
}
