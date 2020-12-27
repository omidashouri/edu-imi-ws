package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactApiDto implements Serializable {

    private static final long serialVersionUID = 7393361902026892471L;

    private String contactPublicId;

    private PersonDto creatorId;

    private java.sql.Timestamp createDateTs;

    private PersonDto editorId;

    private java.sql.Timestamp editDateTs;
}
