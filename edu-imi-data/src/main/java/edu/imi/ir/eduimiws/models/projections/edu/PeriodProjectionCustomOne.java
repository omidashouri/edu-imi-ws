package edu.imi.ir.eduimiws.models.projections.edu;

import edu.imi.ir.eduimiws.models.response.pmis.ExpenseCodeResponse;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.RepresentationModel;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


@Value
public class PeriodProjectionCustomOne {

    String fieldPublicId;
    String eduCategoryPublicId;
    String fieldCode;
    Long periodOfferNumber;
    String periodName;
    String fieldFName;
    String eduCategoryTitle;
    String periodStartDate;
    String periodEndDate;
    String periodRegisterStartDate;
    String periodRegisterEndDate;
    Long periodMaxCapacity;
    String periodHoldingType;
    String periodCanRegisterOnline;
    String periodType;
    Long periodFee;
    String periodSchedule;
    Long periodActivityStatus;
    Long periodDeleteStatus;
    String executorFirstName;
    String executorLastName;
}
