package edu.imi.ir.eduimiws.mapper.crm.v2;

import edu.imi.ir.eduimiws.domain.crm.BusinessOperationEntity;
import edu.imi.ir.eduimiws.domain.crm.InternalRequestLogEntity;
import edu.imi.ir.eduimiws.domain.crm.InternalResponseLogEntity;
import edu.imi.ir.eduimiws.models.dto.record.v2.InternalRequestResponseLogData;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseFilterDto;
import edu.imi.ir.eduimiws.models.response.crm.v2.InternalResponseInquiryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.json.JsonMapper;

import java.util.Map;

@Mapper(componentModel = "spring")
public abstract class InternalRequestLogMapper {

    private static final TypeReference<Map<String, Object>> MAP_TYPE = new TypeReference<>() {
    };

    private static final short HTTP_OK = 200;

    @Autowired
    protected JsonMapper jsonMapper;

    @Mapping(target = "businessOperation", source = "businessOperation")
    @Mapping(target = "requestUrl", source = "data.requestUrl")
    @Mapping(target = "httpMethod", source = "data.httpMethod")
    @Mapping(target = "queryString", source = "data.queryString")
    @Mapping(target = "requestId", source = "data.requestId")
    @Mapping(target = "operatorId", source = "data.operatorId")
    @Mapping(target = "ipAddress", source = "data.ipAddress")
    @Mapping(target = "requestJson", source = "data.requestJson")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "requestTimestamp", ignore = true)
    public abstract InternalRequestLogEntity toRequestLog(InternalRequestResponseLogData data,
                                                          BusinessOperationEntity businessOperation);

    @Mapping(target = "internalRequestLog", source = "requestLog")
    @Mapping(target = "responseStatus", source = "responseStatus")
    @Mapping(target = "responseJson", source = "responseJson")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "responseTimestamp", ignore = true)
    public abstract InternalResponseLogEntity toResponseLog(InternalRequestLogEntity requestLog,
                                                            int responseStatus,
                                                            String responseJson);

    @Mapping(target = "businessOperation", source = "request.businessOperation.operationName")
    @Mapping(target = "requestId", source = "request.requestId")
    @Mapping(target = "operatorId", source = "request.operatorId")
    @Mapping(target = "requestJson", source = "request.requestJson", qualifiedByName = "toRequestJsonMap")
    @Mapping(target = "requestTimestamp", source = "request.requestTimestamp")
    @Mapping(target = "responseStatus", source = "response.responseStatus")
    @Mapping(target = "responseTimestamp", source = "response.responseTimestamp")
    @Mapping(target = "errorMessage", source = "response", qualifiedByName = "toErrorMessage")
    public abstract InternalResponseInquiryDto toResponseDto(InternalRequestLogEntity request,
                                                             InternalResponseLogEntity response);

    @Mapping(target = "businessOperation", source = "request.businessOperation.operationName")
    @Mapping(target = "requestId", source = "request.requestId")
    @Mapping(target = "operatorId", source = "request.operatorId")
    @Mapping(target = "requestJson", source = "request.requestJson", qualifiedByName = "toRequestJsonMap")
    @Mapping(target = "requestTimestamp", source = "request.requestTimestamp")
    @Mapping(target = "responseStatus", expression = "java(response == null ? null : response.getResponseStatus())")
    @Mapping(target = "responseTimestamp", expression = "java(response == null ? null : response.getResponseTimestamp())")
    @Mapping(target = "errorMessage", source = "response", qualifiedByName = "toErrorMessage")
    public abstract InternalResponseFilterDto toFilterDto(InternalRequestLogEntity request,
                                                          InternalResponseLogEntity response);

    @Named("toRequestJsonMap")
    protected Map<String, Object> toRequestJsonMap(String requestJson) {
        if (requestJson == null || requestJson.isBlank()) {
            return null;
        }
        try {
            return jsonMapper.readValue(requestJson, MAP_TYPE);
        } catch (JacksonException e) {
            return null;
        }
    }

    @Named("toErrorMessage")
    protected String toErrorMessage(InternalResponseLogEntity response) {
        if (response == null) {
            return null;
        }
        Short responseStatus = response.getResponseStatus();
        if (responseStatus == null || responseStatus == HTTP_OK) {
            return null;
        }
        String responseJson = response.getResponseJson();
        if (responseJson == null || responseJson.isBlank()) {
            return null;
        }
        try {
            Map<String, Object> map = jsonMapper.readValue(responseJson, MAP_TYPE);
            Object raiseError = map.get("raiseError");
            if (!(raiseError instanceof Map<?, ?> raiseErrorMap)) {
                return null;
            }
            Object message = raiseErrorMap.get("message");
            return message == null ? null : String.valueOf(message);
        } catch (JacksonException e) {
            return null;
        }
    }
}
