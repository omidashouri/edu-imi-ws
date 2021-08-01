package edu.imi.ir.eduimiws.domain.edu;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.domain.crm.*;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodOnly;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomOne;
import edu.imi.ir.eduimiws.models.projections.edu.PeriodProjectionCustomTwo;
import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;


@NamedEntityGraphs({
        @NamedEntityGraph(name = "PeriodEntity.findPeriodSubGraphFieldApiAndLevelAndEduCategoryAndExecutor",
                attributeNodes = {
                        @NamedAttributeNode(value = "field",subgraph = "field-subGraph"),
                        @NamedAttributeNode(value = "executer",subgraph = "executer-subGraph"),
                        @NamedAttributeNode("periodApi")
                },subgraphs = {
                @NamedSubgraph(
                        name = "field-subGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "fieldApi"),
                                @NamedAttributeNode(value = "level"),
                                @NamedAttributeNode(value = "eduCategory")
                        }, type = FieldEntity.class
                ),
                @NamedSubgraph(
                        name = "executer-subGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "personApiEntity")
                        },
                        type = PersonApiEntity.class)
        }
        ),
        @NamedEntityGraph(name = "PeriodEntity.findPeriodSubGraphFieldApi",
            attributeNodes = {
                @NamedAttributeNode(value = "field",subgraph = "field-subGraph"),
                @NamedAttributeNode("periodApi")
            },subgraphs = {
                @NamedSubgraph(
                        name = "field-subGraph",
                        attributeNodes = {
                                @NamedAttributeNode(value = "fieldApi")
                        },
                        type = FieldApiEntity.class
                )
            }
        ),
        @NamedEntityGraph(name = "PeriodEntity.findPeriodSubGraphExecutorPersonApi",
                attributeNodes = {
                @NamedAttributeNode(value = "executer",subgraph = "executer-subGraph"),
                        @NamedAttributeNode("periodApi")
                },
                subgraphs = {
                        @NamedSubgraph(
                                name = "executer-subGraph",
                                attributeNodes = {
                                        @NamedAttributeNode(value = "personApiEntity")
                                },
                                type = PersonApiEntity.class)
                }
        ),
        @NamedEntityGraph(name = "PeriodEntity.periodApiEntity",
                attributeNodes = @NamedAttributeNode("periodApi")
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
            name = "periodOnly",
            classes = {
                @ConstructorResult(
                    targetClass = PeriodOnly.class,
                    columns = {
                        @ColumnResult(name = "idR", type = Long.class),
                        @ColumnResult(name = "fieldIdR", type = Long.class),
                        @ColumnResult(name = "deleteStatusR", type = Long.class),
                        @ColumnResult(name = "canRegisterOnlineR", type = String.class),
                        @ColumnResult(name = "periodEditDateR", type = String.class)
                    }
                )
            }
        ),
        @SqlResultSetMapping(
            name = "periodProjectionCustomOne",
            classes = {
                @ConstructorResult(
                    targetClass = PeriodProjectionCustomOne.class,
                    columns = {
                        @ColumnResult(name = "fieldPublicId", type = String.class),
                        @ColumnResult(name = "eduCategoryPublicId", type = String.class),
                        @ColumnResult(name = "fieldCode", type = String.class),
                        @ColumnResult(name = "periodOfferNumber", type = Long.class),
                        @ColumnResult(name = "periodName", type = String.class),
                        @ColumnResult(name = "fieldFName", type = String.class),
                        @ColumnResult(name = "eduCategoryTitle", type = String.class),
                        @ColumnResult(name = "periodStartDate", type = String.class),
                        @ColumnResult(name = "periodEndDate", type = String.class),
                        @ColumnResult(name = "periodRegisterStartDate", type = String.class),
                        @ColumnResult(name = "periodRegisterEndDate", type = String.class),
                        @ColumnResult(name = "periodMaxCapacity", type = Long.class),
                        @ColumnResult(name = "periodHoldingType", type = String.class),
                        @ColumnResult(name = "periodCanRegisterOnline", type = String.class),
                        @ColumnResult(name = "periodType", type = String.class),
                        @ColumnResult(name = "periodFee", type = Long.class),
                        @ColumnResult(name = "periodSchedule", type = String.class),
                        @ColumnResult(name = "periodActivityStatus", type = Long.class),
                        @ColumnResult(name = "periodDeleteStatus", type = Long.class),
                        @ColumnResult(name = "executorFirstName", type = String.class),
                        @ColumnResult(name = "executorLastName", type = String.class)
                    }
                )
            }
        ),
        @SqlResultSetMapping(name = "periodProjectionCustomOne.count",
                columns = @ColumnResult(name = "cnt")
        ),
        @SqlResultSetMapping(
                name = "periodProjectionCustomTwo",
                classes = {
                        @ConstructorResult(
                                targetClass = PeriodProjectionCustomTwo.class,
                                columns = {
                                        @ColumnResult(name = "fieldPublicId", type = String.class),
                                        @ColumnResult(name = "eduCategoryPublicId", type = String.class),
                                        @ColumnResult(name = "levelPublicId", type = String.class),
                                        @ColumnResult(name = "fieldCode", type = String.class),
                                        @ColumnResult(name = "offerNumber", type = Long.class),
                                        @ColumnResult(name = "name", type = String.class),
                                        @ColumnResult(name = "levelDescription", type = String.class),
                                        @ColumnResult(name = "fieldFName", type = String.class),
                                        @ColumnResult(name = "eduCategoryTitle", type = String.class),
                                        @ColumnResult(name = "startDate", type = String.class),
                                        @ColumnResult(name = "endDate", type = String.class),
                                        @ColumnResult(name = "regStartDate", type = String.class),
                                        @ColumnResult(name = "regEndDate", type = String.class),
                                        @ColumnResult(name = "maxCapacity", type = Long.class),
                                        @ColumnResult(name = "holdingType", type = String.class),
                                        @ColumnResult(name = "canRegisterOnline", type = String.class),
                                        @ColumnResult(name = "type", type = String.class),
                                        @ColumnResult(name = "fee", type = Long.class),
                                        @ColumnResult(name = "schedule", type = String.class),
                                        @ColumnResult(name = "activityStatus", type = Long.class),
                                        @ColumnResult(name = "periodDeleteStatus", type = Long.class),
                                        @ColumnResult(name = "executorFirstName", type = String.class),
                                        @ColumnResult(name = "executorLastName", type = String.class)
                                }
                        )
                }
        )
    })
@NamedNativeQueries({
        @NamedNativeQuery(name = "PeriodEntity.selectAllPeriodOnly",
                query = " select ID as idR, DELETE_STATUS as deleteStatusR, CAN_REGISTER_ONLINE as canRegisterOnlineR, " +
                        " EDIT_DATE as periodEditDateR  from EDU.TBL_PERIOD ",
                resultSetMapping = "periodOnly"),
        @NamedNativeQuery(name = "PeriodEntity.selectAllPeriodOnlyById",
                query = " select ID as idR, DELETE_STATUS as deleteStatusR, CAN_REGISTER_ONLINE as canRegisterOnlineR, " +
                        " EDIT_DATE as periodEditDateR from EDU.TBL_PERIOD where ID in (:periodIds) ",
                resultSetMapping = "periodOnly"),
        @NamedNativeQuery(name = "PeriodEntity.selectPeriodOnlyByIdGreaterThan",
                query = " select ID as idR, FIELD_ID as fieldIdR, DELETE_STATUS as deleteStatusR, CAN_REGISTER_ONLINE as canRegisterOnlineR, " +
                        " EDIT_DATE as periodEditDateR  from EDU.TBL_PERIOD where ID > :periodId ",
                resultSetMapping = "periodOnly"),
        @NamedNativeQuery(name = "PeriodEntity.selectAllPeriodOnlyByIdBetween",
                query = " select ID as idR, FIELD_ID as fieldIdR,DELETE_STATUS as deleteStatusR, CAN_REGISTER_ONLINE as canRegisterOnlineR, " +
                        " EDIT_DATE as periodEditDateR  from EDU.TBL_PERIOD where ID between :beginPeriodId and :endPeriodId ",
                resultSetMapping = "periodOnly"),
        @NamedNativeQuery(name = "PeriodEntity.selectCurrentSequenceNumber",
                query = " select EDU.SEQ_EDU_PERIOD.nextval from dual "
        ),
        @NamedNativeQuery(name = "PeriodEntity.querySelectAllPeriodCustomOne",
                query = "SELECT " +
                        "    flda.field_public_id as fieldPublicId, " +
                        "    edca.edu_category_public_id as eduCategoryPublicId, " +
                        "    fld.code as fieldCode, " +
                        "    prd.offer_number as periodOfferNumber, " +
                        "    prd.name as periodName, " +
                        "    fld.fname as fieldFName, " +
                        "    edc.title as eduCategoryTitle, " +
                        "    prd.start_date as periodStartDate, " +
                        "    prd.end_date as periodEndDate, " +
                        "    prd.reg_start_date as periodRegisterStartDate, " +
                        "    prd.reg_end_date as periodRegisterEndDate, " +
                        "    prd.max_capacity as periodMaxCapacity, " +
                        "    prd.holding_type as periodHoldingType, " +
                        "    prd.can_register_online as periodCanRegisterOnline, " +
                        "    prd.type as periodType, " +
                        "    prd.fee as periodFee, " +
                        "    prd.schedule as periodSchedule, " +
                        "    prd.activity_status as periodActivityStatus, " +
                        "    prd.delete_status as periodDeleteStatus, " +
                        "    exc.first_name as executorFirstName, " +
                        "    exc.last_name as executorLastName " +
                        " FROM " +
                        "    EDU.TBL_PERIOD prd " +
                        "    left join crm.tbl_person exc " +
                        "    ON prd.executer_id = exc.id " +
                        "    left join EDU.tbl_field fld " +
                        "    on prd.field_id = fld.id " +
                        "    left join EDU.tbl_field_api flda " +
                        "    on fld.id=flda.field_id " +
                        "    left join EDU.tbl_edu_category edc " +
                        "    ON fld.category_id = edc.id " +
                        "    left join EDU.tbl_edu_category_api edca " +
                        "    ON edc.id=edca.edu_category_id " +
                        " where " +
                        " ( :fieldPublicId is null or flda.field_public_id = :fieldPublicId ) AND " +
                        " ( :eduCategoryPublicId is null or   edca.edu_category_public_id = :eduCategoryPublicId ) AND " +
                        " ( :marja is null or fld.code = :marja ) AND " +
                        " ( :nobat is null or prd.offer_number =  TO_NUMBER(:nobat) ) AND " +
                        " ( :periodName is null or prd.name like '%:periodName%' ) AND " +
                        " ( :fieldName is null or fld.fname like '%:fieldName%' ) AND " +
                        " ( :eduCategoryName is null or edc.title = :eduCategoryName ) AND " +
                        " ( :periodStartDate is null or prd.start_date = :periodStartDate ) AND " +
                        " ( :periodEndDate is null or prd.end_date = :periodEndDate ) AND " +
                        " ( :registerStartDate is null or prd.reg_start_date = :registerStartDate ) AND " +
                        " ( :registerEndDate is null or prd.reg_end_date = :registerEndDate ) AND " +
                        " ( :periodMaxCapacity is null or prd.max_capacity =  TO_NUMBER(:periodMaxCapacity) ) AND " +
                        " ( :attendanceType is null or prd.holding_type = :attendanceType ) AND " +
                        " ( :registerOnLine is null or prd.can_register_online = :registerOnLine ) AND " +
                        " ( :termicType is null or prd.type = :termicType ) AND " +
                        " ( :periodFee is null or prd.fee =  TO_NUMBER(:periodFee) ) AND " +
                        " ( :periodSchedule is null or prd.schedule = :periodSchedule ) AND " +
                        " ( :periodActivityStatus is null or prd.activity_status =  TO_NUMBER(:periodActivityStatus) ) AND " +
                        " ( :periodDeleteStatus is null or prd.delete_status =  TO_NUMBER(:periodDeleteStatus) ) AND " +
                        " ( :periodExecutorFirstName is null or exc.first_name like '%:periodExecutorFirstName%' ) AND " +
                        " ( :periodExecutorLastName is null or exc.last_name like '%:periodExecutorLastName%' ) AND " +
                        " ( :periodExecutorFullName is null or exc.first_name || ' ' || exc.last_name  like '%:periodExecutorFullName%') "
//                        " AND  RN between ?#{ #pageable.offset +1 } and ?#{#pageable.offset + #pageable.pageSize} "
//                        " /*#{#pageable}*/ "
//                        "  /*#pageable*/  "
                ,resultSetMapping = "periodProjectionCustomOne"
        ),
        @NamedNativeQuery(name = "PeriodEntity.querySelectAllPeriodCustomOne.count",
                query = "SELECT " +
                        "  count(*)  " +
                        " FROM ( " +
                            "SELECT " +
                            "    flda.field_public_id as fieldPublicId, " +
                            "    edca.edu_category_public_id as eduCategoryPublicId, " +
                            "    fld.code as fieldCode, " +
                            "    prd.offer_number as periodOfferNumber, " +
                            "    prd.name as periodName, " +
                            "    fld.fname as fieldFName, " +
                            "    edc.title as eduCategoryTitle, " +
                            "    prd.start_date as periodStartDate, " +
                            "    prd.end_date as periodEndDate, " +
                            "    prd.reg_start_date as periodRegisterStartDate, " +
                            "    prd.reg_end_date as periodRegisterEndDate, " +
                            "    prd.max_capacity as periodMaxCapacity, " +
                            "    prd.holding_type as periodHoldingType, " +
                            "    prd.can_register_online as periodCanRegisterOnline, " +
                            "    prd.type as periodType, " +
                            "    prd.fee as periodFee, " +
                            "    prd.schedule as periodSchedule, " +
                            "    prd.activity_status as periodActivityStatus, " +
                            "    prd.delete_status as periodDeleteStatus, " +
                            "    exc.first_name as executorFirstName, " +
                            "    exc.last_name as executorLastName " +
                            " FROM " +
                            "    EDU.TBL_PERIOD prd " +
                            "    left join crm.tbl_person exc " +
                            "    ON prd.executer_id = exc.id " +
                            "    left join EDU.tbl_field fld " +
                            "    on prd.field_id = fld.id " +
                            "    left join EDU.tbl_field_api flda " +
                            "    on fld.id=flda.field_id " +
                            "    left join EDU.tbl_edu_category edc " +
                            "    ON fld.category_id = edc.id " +
                            "    left join EDU.tbl_edu_category_api edca " +
                            "    ON edc.id=edca.edu_category_id " +
                        " ) " +
                        " where " +
                        " ( :fieldPublicId is null or flda.field_public_id = :fieldPublicId ) AND " +
                        " ( :eduCategoryPublicId is null or   edca.edu_category_public_id = :eduCategoryPublicId ) AND " +
                        " ( :marja is null or fld.code = :marja ) AND " +
                        " ( :nobat is null or prd.offer_number =  TO_NUMBER(:nobat) ) AND " +
                        " ( :periodName is null or prd.name like '%:periodName%' ) AND " +
                        " ( :fieldName is null or fld.fname like '%:fieldName%' ) AND " +
                        " ( :eduCategoryName is null or edc.title = :eduCategoryName ) AND " +
                        " ( :periodStartDate is null or prd.start_date = :periodStartDate ) AND " +
                        " ( :periodEndDate is null or prd.end_date = :periodEndDate ) AND " +
                        " ( :registerStartDate is null or prd.reg_start_date = :registerStartDate ) AND " +
                        " ( :registerEndDate is null or prd.reg_end_date = :registerEndDate ) AND " +
                        " ( :periodMaxCapacity is null or prd.max_capacity =  TO_NUMBER(:periodMaxCapacity) ) AND " +
                        " ( :attendanceType is null or prd.holding_type = :attendanceType ) AND " +
                        " ( :registerOnLine is null or prd.can_register_online = :registerOnLine ) AND " +
                        " ( :termicType is null or prd.type = :termicType ) AND " +
                        " ( :periodFee is null or prd.fee =  TO_NUMBER(:periodFee) ) AND " +
                        " ( :periodSchedule is null or prd.schedule = :periodSchedule ) AND " +
                        " ( :periodActivityStatus is null or prd.activity_status =  TO_NUMBER(:periodActivityStatus) ) AND " +
                        " ( :periodDeleteStatus is null or prd.delete_status =  TO_NUMBER(:periodDeleteStatus) ) AND " +
                        " ( :periodExecutorFirstName is null or exc.first_name like '%:periodExecutorFirstName%' ) AND " +
                        " ( :periodExecutorLastName is null or exc.last_name like '%:periodExecutorLastName%' ) AND " +
                        " ( :periodExecutorFullName is null or exc.first_name || ' ' || exc.last_name  like '%:periodExecutorFullName%') "
                ,resultSetMapping = "periodProjectionCustomOne.count"
        ),
        @NamedNativeQuery(name = "PeriodEntity.querySelectAllPeriodCustomTwo", //add levelPublicId and LevelTitle
                query = "SELECT " +
                        "    flda.field_public_id as fieldPublicId, " +
                        "    edca.edu_category_public_id as eduCategoryPublicId, " +
                        "    fld.code as fieldCode, " +
                        "    prd.offer_number as offerNumber, " +
                        "    prd.name as name, " +
                        "    fld.fname as fieldFName, " +
                        "    edc.title as eduCategoryTitle, " +
                        "    prd.start_date as startDate, " +
                        "    prd.end_date as endDate, " +
                        "    prd.reg_start_date as regStartDate, " +
                        "    prd.reg_end_date as regEndDate, " +
                        "    prd.max_capacity as maxCapacity, " +
                        "    prd.holding_type as holdingType, " +
                        "    prd.can_register_online as canRegisterOnline, " +
                        "    prd.type as type, " +
                        "    prd.fee as fee, " +
                        "    prd.schedule as schedule, " +
                        "    prd.activity_status as activityStatus, " +
                        "    prd.delete_status as deleteStatus " +
                        "    prd.delete_status as periodDeleteStatus, " +
                        "    exc.first_name as executorFirstName, " +
                        "    exc.last_name as executorLastName " +
                        " FROM " +
                        "    EDU.TBL_PERIOD prd " +
                        "    left join crm.tbl_person exc " +
                        "    ON prd.executer_id = exc.id " +
                        "    left join EDU.tbl_field fld " +
                        "    on prd.field_id = fld.id " +
                        "    left join EDU.tbl_field_api flda " +
                        "    on fld.id=flda.field_id " +
                        "    left join EDU.tbl_edu_category edc " +
                        "    ON fld.category_id = edc.id " +
                        "    left join EDU.tbl_edu_category_api edca " +
                        "    ON edc.id=edca.edu_category_id "
                ,resultSetMapping = "periodProjectionCustomTwo"
        ),
        @NamedNativeQuery(name = "PeriodEntity.queryCountAllPeriodCustomTwo", //add levelPublicId and LevelTitle
                query = "SELECT " +
                        "  count(*)  " +
                        " FROM ( " +
                        "SELECT " +
                        "    flda.field_public_id as fieldPublicId, " +
                        "    edca.edu_category_public_id as eduCategoryPublicId, " +
                        "    fld.code as fieldCode, " +
                        "    prd.offer_number as periodOfferNumber, " +
                        "    prd.name as periodName, " +
                        "    fld.fname as fieldFName, " +
                        "    edc.title as eduCategoryTitle, " +
                        "    prd.start_date as periodStartDate, " +
                        "    prd.end_date as periodEndDate, " +
                        "    prd.reg_start_date as periodRegisterStartDate, " +
                        "    prd.reg_end_date as periodRegisterEndDate, " +
                        "    prd.max_capacity as periodMaxCapacity, " +
                        "    prd.holding_type as periodHoldingType, " +
                        "    prd.can_register_online as periodCanRegisterOnline, " +
                        "    prd.type as periodType, " +
                        "    prd.fee as periodFee, " +
                        "    prd.schedule as periodSchedule, " +
                        "    prd.activity_status as periodActivityStatus, " +
                        "    prd.delete_status as periodDeleteStatus, " +
                        "    exc.first_name as executorFirstName, " +
                        "    exc.last_name as executorLastName " +
                        " FROM " +
                        "    EDU.TBL_PERIOD prd " +
                        "    left join crm.tbl_person exc " +
                        "    ON prd.executer_id = exc.id " +
                        "    left join EDU.tbl_field fld " +
                        "    on prd.field_id = fld.id " +
                        "    left join EDU.tbl_field_api flda " +
                        "    on fld.id=flda.field_id " +
                        "    left join EDU.tbl_edu_category edc " +
                        "    ON fld.category_id = edc.id " +
                        "    left join EDU.tbl_edu_category_api edca " +
                        "    ON edc.id=edca.edu_category_id " +
                        " ) "
        )
})


@NamedQueries({
        @NamedQuery(name = "PeriodEntity.queryAllPeriodCustomTwo",
                query = " select flda.fieldPublicId as fieldPublicId, " +
                        " edca.eduCategoryPublicId as eduCategoryPublicId, " +
                        " lvla.levelPublicId as levelPublicId, " +
                        " fld.code as fieldCode, " +
                        " prd.offerNumber as offerNumber, " +
                        " prd.name as name, " +
                        " lvl.description as levelDescription, " +
                        " fld.fname as fieldName, " +
                        " edc.title as eduCategoryTitle, " +
                        " prd.startDate as startDate, " +
                        " prd.endDate as endDate, " +
                        " prd.regStartDate as regStartDate, " +
                        " prd.regEndDate as regEndDate, " +
                        " prd.maxCapacity as maxCapacity, " +
                        " prd.holdingType as holdingType, " +
                        " prd.canRegisterOnline as canRegisterOnline, " +
                        " prd.type as type, " +
                        " prd.fee as fee, " +
                        " prd.schedule as schedule, " +
                        " prd.activityStatus as activityStatus, " +
                        " prd.deleteStatus as deleteStatus, " +
                        " exc.firstName as executorFirstName, " +
                        " exc.lastName as executorLastName " +
                        " from " +
                        " PeriodEntity prd left join prd.periodApi prda " +
                        " left join prd.executer exc " +
                        " left join prd.field fld left join fld.fieldApi flda " +
                        " left join fld.eduCategory edc left join edc.eduCategoryApi edca " +
                        " left join fld.level lvl left join lvl.levelApi lvla " +
                        " where " +
                        " ( :fieldPublicId is null or flda.fieldPublicId = :fieldPublicId ) AND " +
                        " ( :eduCategoryPublicId is null or edca.eduCategoryPublicId = :eduCategoryPublicId ) AND " +
                        " ( :levelPublicId is null or lvla.levelPublicId = :levelPublicId ) AND " +
                        " ( :fieldCode is null or fld.code = :fieldCode ) AND " +
                        " ( :periodOfferNumber is null or prd.offerNumber =  :periodOfferNumber ) AND " +
                        " ( :levelDescription is null or lvl.description like '%:levelDescription%' ) AND " +
                        " ( :periodName is null or prd.name like '%:periodName%' ) AND " +
                        " ( :fieldName is null or fld.fname like '%:fieldName%' ) AND " +
                        " ( :eduCategoryTitle is null or edc.title like '%:eduCategoryTitle%' ) AND " +
                        " ( :periodStartDate is null or prd.startDate = :periodStartDate ) AND " +
                        " ( :periodEndDate is null or prd.endDate = :periodEndDate ) AND " +
                        " ( :registerStartDate is null or prd.regStartDate = :registerStartDate ) AND " +
                        " ( :registerEndDate is null or prd.regEndDate = :registerEndDate ) AND " +
                        " ( :periodMaxCapacity is null or prd.maxCapacity = :periodMaxCapacity ) AND " +
                        " ( :periodHoldingType is null or prd.holdingType = :periodHoldingType ) AND " +
                        " ( :periodCanRegisterOnline is null or prd.canRegisterOnline = :periodCanRegisterOnline ) AND " +
                        " ( :periodType is null or prd.type = :periodType ) AND " +
                        " ( :periodFee is null or prd.fee = :periodFee ) AND " +
                        " ( :periodSchedule is null or prd.schedule like '%:periodSchedule%' ) AND " +
                        " ( :periodActivityStatus is null or prd.activityStatus = :periodActivityStatus ) AND " +
                        " ( :periodDeleteStatus is null or prd.deleteStatus = :periodDeleteStatus ) AND " +
                        " ( :periodExecutorFirstName is null or exc.firstName like '%:periodExecutorFirstName%' ) AND " +
                        " ( :periodExecutorLastName is null or exc.lastName like '%:periodExecutorLastName%' ) AND " +
                        " ( :periodExecutorFullName is null or concat(exc.firstName,' ',exc.lastName)  like '%:periodExecutorFullName%') "
                /*hints =  {
                        @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                        @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                        @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                        @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
                },
                lockMode = LockModeType.READ*/
        )
})

/*@NamedQueries({ //delete later
    @NamedQuery(name = "readAllByDeleteStatusIsNotNullAndDeleteStatusEqualsAndNameContains",
             query = " select p from PeriodEntity p left join fetch p.periodApi pa " +
                     " left join fetch p.executer pe left join fetch p.field pf " +
                     " left join fetch pf.fieldApi pfa left join fetch pf.level pfl left join fetch pf.eduCategory pfe " +
                     " where p.deleteStatus = :deleteStatus and p.name like '%:periodName%' ",
            hints =  {
                @QueryHint( name = QueryHints.HINT_FLUSH_MODE, value = "AUTO" ),
                @QueryHint(name = QueryHints.HINT_CACHEABLE, value = "true"),
                @QueryHint(name = QueryHints.HINT_READONLY,value = "true"),
                @QueryHint( name = QueryHints.HINT_COMMENT, value = "use cache for named query" ),
            },
            lockMode = LockModeType.READ
    )
})*/

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)//,region = "period")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@SequenceGenerator(name = "entity_sequence", schema = "EDU", sequenceName = "SEQ_EDU_PERIOD", allocationSize = 1)
@Table(schema = "EDU", name = "TBL_PERIOD")
public class PeriodEntity extends BaseEntity {

    @Column(name = "NAME", length = 500)
    private String name;

    @Column(name = "START_DATE", length = 10)
    private String startDate;

    @Column(name = "END_DATE", length = 10)
    private String endDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FIELD_ID")
    private FieldEntity field;

    @Column(name = "FIELD_ID", insertable = false, updatable = false)
    private Long fieldId;

    @Transient
    public Long getFieldId() {
        return fieldId;
    }

    @Column(name = "TYPE", length = 10)
    private String type;

    @Column(name = "FEE")
    private Long fee;

    @Column(name = "OFFER_NUMBER")
    private Long offerNumber;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CREATOR")
    private PersonEntity creator;

    @Column(name = "CREATE_DATE", length = 10)
    private String createDate;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EDITOR")
    private PersonEntity editor;

    @Column(name = "EDIT_DATE", length = 10)
    private String editDate;

    @Column(name = "ACTIVITY_STATUS", precision = 2, scale = 0)
    private Long activityStatus;

    @Column(name = "DELETE_STATUS", precision = 2, scale = 0)
    private Long deleteStatus;

    @Column(name = "PRESENT_TYPE", precision = 3, scale = 0)
    private Long presentType;

    @Column(name = "TEMP_TYPE", length = 3)
    private String tempType;

    @Column(name = "MAX_CAPACITY", precision = 3, scale = 0)
    private Long maxCapacity;

    @Column(name = "MIN_CAPACITY", precision = 3, scale = 0)
    private Long minCapacity;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORGANIZATION_ID")
    private OrganizationEntity organization;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EXECUTER_ID")
    private PersonEntity executer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACADEMIC_ID")
    private PersonEntity academic;

    //    TBL_PLAN_OLD
    @Column(name = "PLAN_ID")
    private Long planId;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_ID")
    private AccountEntity account;

    @Column(name = "TOTAL_UNIT")
    private Long totalUnit;

    @Column(name = "THESIS_UNIT", length = 20)
    private String thesisUnit;

    @Column(name = "TUNIT", precision = 3, scale = 0)
    private Long tunit;

    @Column(name = "PUNIT", precision = 3, scale = 0)
    private Long punit;

    @Column(name = "VARIABLE_NAME", length = 200)
    private String variableName;

    //    TBL_CERTIFICATE_TEMPLATE
    @Column(name = "CERTIFICATE_TEMPLATE_ID")
    private Long certificateTemplateId;

    @Column(name = "EXECUTER_CAPACITY", precision = 6, scale = 0)
    private Long executerCapacity;

    @Column(name = "FEE_FOREIGN")
    private Long feeForeign;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CURRENCY_ID")
    private ParameterEntity currency;

    @Column(name = "REG_START_DATE", length = 10)
    private String regStartDate;

    @Column(name = "REG_END_DATE", length = 10)
    private String regEndDate;

    @Column(name = "DESCRIPTION", length = 4000)
    private String description;

    @Column(name = "SCHEDULE", length = 250)
    private String schedule;

    @Column(name = "PERIOD_ORG_FEE")
    private Long periodOrgFee;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPANY_ID")
    private CompanyEntity company;

    @Column(name = "CAN_REGISTER_ONLINE", length = 15)
    private String canRegisterOnline;

    @Column(name = "CARD_NO_PERFIX", length = 20)
    private String cardNoPerfix;

    @Column(name = "FEE_VARIABLE")
    private Long feeVariable;

    @Column(name = "FEE_EQUIVALENT_FIXED")
    private Long feeEquivalentFixed;

    @Column(name = "FEE_EQUIVALENT_VARIABLE")
    private Long feeEquivalentVariable;

    @Column(name = "ONLINE_REG_COST_PERCENT")
    private Long onlineRegCostPercent;

    @Column(name = "CARD_NO_PERFIX_R", length = 20)
    private String cardNoPerfixR;

    //    TBL_PERIOD_HOLDING_REQ_ITEM
    @Column(name = "PERIOD_HOLDING_ID")
    private Long periodHoldingId;

    @Column(name = "HOLDING_TYPE", length = 20)
    private String holdingType;

    @Column(name = "HOLDING_LANGUAGE", length = 2)
    private String holdingLanguage;

    @Column(name = "CERTIFICATE_DESC", length = 3000)
    private String certificateDesc;

    @Column(name = "ALLOW_TERM", precision = 6, scale = 0)
    private Long allowTerm;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private ParameterEntity city;

    @Column(name = "VARIABLE_CERTIFICATE_NAME", length = 500)
    private String variableCertificateName;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(mappedBy = "period", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private PeriodApiEntity periodApi;

}
