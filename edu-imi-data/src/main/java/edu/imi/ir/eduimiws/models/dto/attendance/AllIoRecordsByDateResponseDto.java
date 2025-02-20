package edu.imi.ir.eduimiws.models.dto.attendance;

import lombok.*;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AllIoRecordsByDateResponseDto implements Serializable {

    private static final long serialVersionUID = -4141540432333308341L;

    private IoRecordDataModelDto ioRecordDataModelDto;

}
