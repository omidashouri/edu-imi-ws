package edu.imi.ir.eduimiws.spec.crm.v2;

import edu.imi.ir.eduimiws.domain.crm.InternalRequestLogEntity;
import edu.imi.ir.eduimiws.domain.crm.InternalResponseLogEntity;
import edu.imi.ir.eduimiws.models.request.crm.v2.InternalRequestFilterDto;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public final class InternalRequestLogSpec {

    private InternalRequestLogSpec() {
    }

    public static Specification<InternalRequestLogEntity> getSpec(InternalRequestFilterDto filter) {
        List<Specification<InternalRequestLogEntity>> specs = new ArrayList<>();
        if (filter == null) {
            return combine(specs);
        }

        addIfNotNull(specs, requestIdEqual(filter.getRequestId()));
        addIfNotNull(specs, ipAddressEqual(filter.getIpAddress()));
        addIfNotNull(specs, operatorIdEqual(filter.getOperatorId()));
        addIfNotNull(specs, operationNameEqual(filter.getOperationName()));
        addIfNotNull(specs, responseStatusEqual(filter.getResponseStatus()));
        addIfNotNull(specs, requestDateTimeEqual(filter.getRequestDateTime()));

        return combine(specs);
    }

    private static Specification<InternalRequestLogEntity> requestIdEqual(String requestId) {
        return StringUtils.hasText(requestId)
                ? (root, query, cb) -> cb.equal(root.get("requestId"), requestId.trim())
                : null;
    }

    private static Specification<InternalRequestLogEntity> ipAddressEqual(String ipAddress) {
        return StringUtils.hasText(ipAddress)
                ? (root, query, cb) -> cb.equal(root.get("ipAddress"), ipAddress.trim())
                : null;
    }

    private static Specification<InternalRequestLogEntity> operatorIdEqual(String operatorId) {
        return StringUtils.hasText(operatorId)
                ? (root, query, cb) -> cb.equal(root.get("operatorId"), operatorId.trim())
                : null;
    }

    private static Specification<InternalRequestLogEntity> operationNameEqual(String operationName) {
        return StringUtils.hasText(operationName)
                ? (root, query, cb) -> cb.equal(
                root.get("businessOperation").get("operationName"), operationName.trim())
                : null;
    }

    private static Specification<InternalRequestLogEntity> responseStatusEqual(Short responseStatus) {
        if (responseStatus == null) {
            return null;
        }
        return (root, query, cb) -> {
            Subquery<Long> subquery = query.subquery(Long.class);
            Root<InternalResponseLogEntity> responseRoot = subquery.from(InternalResponseLogEntity.class);
            subquery.select(responseRoot.get("id"))
                    .where(
                            cb.equal(responseRoot.get("internalRequestLog").get("id"), root.get("id")),
                            cb.equal(responseRoot.get("responseStatus"), responseStatus)
                    );
            return cb.exists(subquery);
        };
    }

    private static Specification<InternalRequestLogEntity> requestDateTimeEqual(LocalDateTime requestDateTime) {
        return requestDateTime != null
                ? (root, query, cb) -> cb.equal(root.get("requestTimestamp"), requestDateTime)
                : null;
    }

    private static void addIfNotNull(List<Specification<InternalRequestLogEntity>> specs,
                                     Specification<InternalRequestLogEntity> spec) {
        if (spec != null) {
            specs.add(spec);
        }
    }

    private static Specification<InternalRequestLogEntity> combine(
            List<Specification<InternalRequestLogEntity>> specs) {
        return specs.stream()
                .reduce(Specification::and)
                .orElse((root, query, cb) -> cb.conjunction());
    }
}
