package edu.imi.ir.eduimiws.models.projections.edu;


import edu.imi.ir.eduimiws.domain.edu.PeriodEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "periodProjectionCustomTwo",
        types = { PeriodEntity.class })
public interface PeriodProjectionCustomTwo {

//    Attention: 1) when use projection in @NamedQuery (HQL or not native) and use Spring SPEL like  @Value("#{target.id}")
//               then name filed in projection with name field in entity and alias in @NamedQuery SHOULD BE SAME.
//               2) when using projection in @NamedNativeQuery because we have @SqlResultSetMapping then alias name in
//               @NamedNativeQuery SHOULD BE SAME with name field in @ConstructorResult or with name field in @ConstructorResult.
//               3) use @Projection for @NamedQuery . and use @Value for @NamedNativeQuery.


    String getPeriodPublicId();

//    @Value("#{target.field?.fieldApi?.fieldPublicId}")
    String getFieldPublicId();

//    @Value("#{target.field?.eduCategory?.eduCategoryApi?.eduCategoryPublicId}")
    String getEduCategoryPublicId();

//    @Value("#{target.field?.level?.levelApi?.levelPublicId}")
    String getLevelPublicId();

/*    @Value("#{target.field}")
    FieldEntity getField();*/

//    @Value("#{target.field?.code}")
    String getFieldCode();

    @Value("#{target.offerNumber}")
    Long getOfferNumber();

    @Value("#{target.name}")
    String getName();

//    @Value("#{target.field?.level?.description}")
    String getLevelDescription();

//    @Value("#{target.field?.fname}")
    String getFieldName();

//    @Value("#{target.field?.eduCategory?.title}")
    String getEduCategoryTitle(); //

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

    @Value("#{target.onlineRegCostPercent}")
    Long getOnlineRegCostPercent();

    @Value("#{target.feeEquivalentFixed}")
    Long getFeeEquivalentFixed();

    @Value("#{target.feeEquivalentVariable}")
    Long getFeeEquivalentVariable();

    @Value("#{target.schedule}")
    String getSchedule();

    @Value("#{target.activityStatus}")
    Long getActivityStatus();

    @Value("#{target.deleteStatus}")
    Long getDeleteStatus();

    @Value("#{target.totalUnit}")
    Long getTotalUnit();

    Long getPeriodId();

//    @Value("#{target.executer?.firstName}")
    String getExecutorFirstName();

//    @Value("#{target.executer?.lastName}")
    String getExecutorLastName();
}
