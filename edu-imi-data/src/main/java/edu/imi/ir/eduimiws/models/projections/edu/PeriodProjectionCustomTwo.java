package edu.imi.ir.eduimiws.models.projections.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "periodProjectionCustomTwo",
        types = { PeriodEntity.class })
public interface PeriodProjectionCustomTwo {

    @Value("#{target.field?.fieldApi?.fieldPublicId}")
    String getFieldPublicId();

    @Value("#{target.field?.eduCategory?.eduCategoryApi?.eduCategoryPublicId}")
    String getEduCategoryPublicId();

    @Value("#{target.field?.code}")
    String getFieldCode();

    @Value("#{target.offerNumber}")
    Long getOfferNumber();

    @Value("#{target.name}")
    String getName();

    @Value("#{target.field?.fname}")
    String getFieldFName();

    @Value("#{target.field?.eduCategory?.title}")
    String getEduCategoryTitle();

    @Value("#{target.startDate}")
    String getStartDate();

    @Value("#{target.endDate}")
    String getEndDate();

    @Value("#{target.regStartDate}")
    String getRegStartDate();

    @Value("#{target.regEndDate}")
    String getRegEndDate();

    @Value("#{target.maxCapacity}")
    Long getMaxCapacity();

    @Value("#{target.holdingType}")
    String getHoldingType();

    @Value("#{target.canRegisterOnline}")
    String getCanRegisterOnline();

    @Value("#{target.type}")
    String getType();

    @Value("#{target.fee}")
    Long getFee();

    @Value("#{target.schedule}")
    String getSchedule();

    @Value("#{target.activityStatus}")
    Long getActivityStatus();

    @Value("#{target.deleteStatus}")
    Long getDeleteStatus();

    @Value("#{target.executer?.firstName}")
    String getExecutorFirstName();

    @Value("#{target.executer?.lastName}")
    String getExecutorLastName();
}
