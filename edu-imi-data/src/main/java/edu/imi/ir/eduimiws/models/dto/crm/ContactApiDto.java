package edu.imi.ir.eduimiws.models.dto.crm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
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
