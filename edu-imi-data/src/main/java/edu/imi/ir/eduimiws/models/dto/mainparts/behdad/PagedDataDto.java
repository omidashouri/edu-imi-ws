package edu.imi.ir.eduimiws.models.dto.mainparts.behdad;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PagedDataDto implements Serializable {

    private static final long serialVersionUID = 5993971974209193660L;
    private List<Object> currentPageData;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalCount;

    private List<SourceObject> sourceObjects = new ArrayList<>();

    public void addSourceObjects() {
        if (currentPageData != null && currentPageData.size() >0) {
            this.currentPageData.stream().forEach(p ->{
                SourceObject so = new SourceObject();
                so.addObject(p);
                sourceObjects.add(so);
            });
        }
    }

}
