-- ============================================================================
-- Internal request/response logging + idempotency (destination schema: crm)
-- Oracle dialect
-- Tables: TBL_BUSINESS_OPERATION, TBL_INTERNAL_REQUEST_LOG, TBL_INTERNAL_RESPONSE_LOG
-- Sequences: SEQ_BUSINESS_OPERATION_ID, SEQ_INTERNAL_REQUEST_LOG_ID, SEQ_INTERNAL_RESPONSE_LOG_ID
-- Intentionally omitted vs deposit DPS:
--   - TBL_INTERNAL_REQUEST_LOG.BRANCH_CODE / CHANNEL_ID
--   - TBL_INTERNAL_RESPONSE_LOG.REQUEST_ID (redundant with request log)
--   - EXTERNAL_REQUEST_LOG / EXTERNAL_RESPONSE_LOG
-- ============================================================================

CREATE SEQUENCE crm.SEQ_BUSINESS_OPERATION_ID
    START WITH 1
    INCREMENT BY 1
    CACHE 20
    NOCYCLE;

CREATE SEQUENCE crm.SEQ_INTERNAL_REQUEST_LOG_ID
    START WITH 1
    INCREMENT BY 1
    CACHE 20
    NOCYCLE;

CREATE SEQUENCE crm.SEQ_INTERNAL_RESPONSE_LOG_ID
    START WITH 1
    INCREMENT BY 1
    CACHE 20
    NOCYCLE;

CREATE TABLE crm.TBL_BUSINESS_OPERATION
(
    ID             NUMBER(19) NOT NULL
        CONSTRAINT PK_BUSINESS_OPERATION_ID PRIMARY KEY USING INDEX,
    OPERATION_NAME VARCHAR2(50)                                                                           NOT NULL
        CONSTRAINT UK_BUSINESS_OPERATION_NAME UNIQUE,
    DESCRIPTION    VARCHAR2(200),
    CREATED_DATE   TIMESTAMP(6),
    MODIFIED_DATE  TIMESTAMP(6),
    CREATED_BY     VARCHAR2(35),
    MODIFIED_BY    VARCHAR2(35),
    IS_ACTIVE      NUMBER(1) DEFAULT 1
        CONSTRAINT CHK_BUSINESS_OPERATION_IS_ACTIVE
            CHECK (IS_ACTIVE IN (0, 1))
);

CREATE TABLE crm.TBL_INTERNAL_REQUEST_LOG
(
    ID                    NUMBER(19) NOT NULL
        CONSTRAINT PK_INTERNAL_REQUEST_LOG_ID PRIMARY KEY USING INDEX,
    BUSINESS_OPERATION_ID NUMBER(19)                                                                             NOT NULL,
    REQUEST_URL           VARCHAR2(1000)                                                                         NOT NULL,
    HTTP_METHOD           VARCHAR2(10)                                                                           NOT NULL,
    QUERY_STRING          VARCHAR2(2000),
    -- Global idempotency claim: NOT NULL + unique. Inserted before business;
    -- never deleted. Reuse → HTTP 409 (new requestId required).
    REQUEST_ID            VARCHAR2(36)                                                                           NOT NULL
        CONSTRAINT UK_INTERNAL_REQUEST_LOG_REQUEST_ID UNIQUE,
    OPERATOR_ID           VARCHAR2(8),
    IP_ADDRESS            VARCHAR2(45),
    REQUEST_JSON          CLOB
        CONSTRAINT CHK_INTERNAL_REQUEST_LOG_REQUEST_JSON CHECK (REQUEST_JSON IS JSON),
    REQUEST_TIMESTAMP     TIMESTAMP(6) DEFAULT SYSTIMESTAMP                                                      NOT NULL
);

CREATE TABLE crm.TBL_INTERNAL_RESPONSE_LOG
(
    ID                  NUMBER(19) NOT NULL
        CONSTRAINT PK_INTERNAL_RESPONSE_LOG_ID PRIMARY KEY USING INDEX,
    INTERNAL_REQUEST_ID NUMBER(19)                                                                             NOT NULL
        CONSTRAINT UK_INTERNAL_RESPONSE_LOG_INTERNAL_REQUEST_ID UNIQUE,
    RESPONSE_STATUS     NUMBER(3),
    RESPONSE_JSON       CLOB
        CONSTRAINT CHK_INTERNAL_RESPONSE_LOG_RESPONSE_JSON CHECK (RESPONSE_JSON IS JSON),
    RESPONSE_TIMESTAMP  TIMESTAMP(6) DEFAULT SYSTIMESTAMP                                                      NOT NULL
);

CREATE INDEX crm.IDX_INTERNAL_REQUEST_LOG_IP_ADDRESS ON crm.TBL_INTERNAL_REQUEST_LOG (IP_ADDRESS);
CREATE INDEX crm.IDX_INTERNAL_REQUEST_LOG_BUSINESS_OPERATION_ID ON crm.TBL_INTERNAL_REQUEST_LOG (BUSINESS_OPERATION_ID);
CREATE INDEX crm.IDX_INTERNAL_REQUEST_LOG_OPERATOR_ID ON crm.TBL_INTERNAL_REQUEST_LOG (OPERATOR_ID);

-- Seed TBL_BUSINESS_OPERATION rows so OPERATION_NAME matches LoggedBusinessOperation.name()
-- in the destination project before enabling @LoggedOperation endpoints. Example:
-- INSERT INTO crm.TBL_BUSINESS_OPERATION (ID, OPERATION_NAME, DESCRIPTION, IS_ACTIVE)
-- VALUES (crm.SEQ_BUSINESS_OPERATION_ID.NEXTVAL, 'EXAMPLE_OP', 'Example logged operation', 1);
