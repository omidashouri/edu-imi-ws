package edu.imi.ir.eduimiws.models.dto.record.v2;

public record InternalRequestResponseLogData(
        String businessOperationName,
        String requestUrl,
        String httpMethod,
        String queryString,
        String requestId,
        String operatorId,
        String ipAddress,
        String requestJson) {
}
