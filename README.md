# edu-imi-ws
IMI Education Web Service

------------------------------

***set cascade for Role_ID to null

CREATE SEQUENCE CRM.SEQ_PERSON_API_ID INCREMENT BY 1 MAXVALUE 9999999999999999 MINVALUE 1 CACHE 20;


   CREATE TABLE "CRM"."TBL_PERSON_API" 
     (	"ID" NUMBER NOT NULL ENABLE, 
  	"PERSON_ID" NUMBER, 
  	"PERSON_PUBLIC_ID" NVARCHAR2(500), 
  	"ENCRYPTED_PASSWORD" NVARCHAR2(500), 
  	"EMAIL_VERIFICATION_TOKEN" NVARCHAR2(500), 
  	"EMAIL_VERIFICATION_STATUS" NUMBER, 
  	"CREATOR_ID" NUMBER, 
  	"CREATE_DATE_TS" TIMESTAMP (6), 
  	"EDITOR_ID" NUMBER, 
  	"EDIT_DATE_TS" TIMESTAMP (6), 
  	"DESCRIPTION" NVARCHAR2(500), 
  	"CONTACT_ID" NUMBER, 
  	"CONTACT_PUBLIC_ID" NVARCHAR2(500), 
  	"ROLE_ID" NUMBER ",
    "PERSON_EDIT_DATE" NVARCHAR2(10), 
    "CONTACT_EDIT_DATE" NVARCHAR2(10),
    "ACCOUNT_ENABLED" NUMBER, 
    "ACCOUNT_NON_EXPIRED" NUMBER, 
    "CREDENTIALS_NON_EXPIRED" NUMBER, 
    "ACCOUNT_NON_LOCKED" NUMBER, 
  	 CONSTRAINT "TBL_PERSON_API_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
    TABLESPACE "USERS"  ENABLE, 
  	 CONSTRAINT "TBL_PERSON_API_UK1" UNIQUE ("PERSON_PUBLIC_ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
    TABLESPACE "USERS"  ENABLE,
    CONSTRAINT "TBL_PERSON_API_UK2" UNIQUE ("PERSON_ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
      TABLESPACE "USERS"  ENABLE,
      CONSTRAINT "TBL_PERSON_API_UK3" UNIQUE ("CONTACT_ID")
        USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        TABLESPACE "USERS"  ENABLE, 
      	 CONSTRAINT "TBL_PERSON_API_UK4" UNIQUE ("CONTACT_PUBLIC_ID")
        USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        TABLESPACE "USERS"  ENABLE, 
  	 CONSTRAINT "TBL_PERSON_API_FK1" FOREIGN KEY ("PERSON_ID")
     	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_PERSON_API_FK4" FOREIGN KEY ("CONTACT_ID")
     	  REFERENCES "CRM"."TBL_CONTACT" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_PERSON_API_FK5" FOREIGN KEY ("ROLE_ID")
     	  REFERENCES "CRM"."TBL_ROLE_API" ("ID") ON DELETE SET NULL ENABLE, 
     	 CONSTRAINT "TBL_PERSON_API_FK2" FOREIGN KEY ("CREATOR_ID")
     	  REFERENCES "CRM"."TBL_PERSON" ("ID") ON DELETE SET NULL ENABLE, 
     	 CONSTRAINT "TBL_PERSON_API_FK3" FOREIGN KEY ("EDITOR_ID")
     	  REFERENCES "CRM"."TBL_PERSON" ("ID") ON DELETE SET NULL ENABLE
     ) SEGMENT CREATION DEFERRED 
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    TABLESPACE "USERS" ;
  
     COMMENT ON COLUMN "CRM"."TBL_PERSON_API"."EMAIL_VERIFICATION_STATUS" IS 'NUMBER(1,0)';
  
    CREATE OR REPLACE TRIGGER "CRM"."TBL_PERSON_API_TRG" 
  BEFORE INSERT ON CRM.TBL_PERSON_API 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      NULL;
    END COLUMN_SEQUENCES;
  END;
  /
  ALTER TRIGGER "CRM"."TBL_PERSON_API_TRG" ENABLE;


--- --- ---

   CREATE SEQUENCE  "CRM"."SEQ_CONTACT_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;


  CREATE TABLE "CRM"."TBL_CONTACT_API" 
     (	"ID" NUMBER NOT NULL ENABLE, 
  	"CONTACT_PUBLIC_ID" NVARCHAR2(500) NOT NULL ENABLE, 
  	"CREATOR_ID" NUMBER, 
  	"CREATE_DATE_TS" TIMESTAMP (6), 
  	"EDITOR_ID" NUMBER, 
  	"EDIT_DATE_TS" TIMESTAMP (6), 
  	"CONTACT_ID" NUMBER, 
  	"CONTACT_EDIT_DATE" NVARCHAR2(10), 
  	 CONSTRAINT "TBL_CONTACT_API_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
    TABLESPACE "USERS"  ENABLE, 
     CONSTRAINT "TBL_CONTACT_API_UK1" UNIQUE ("CONTACT_PUBLIC_ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
      TABLESPACE "USERS"  ENABLE, 
    	 CONSTRAINT "TBL_CONTACT_API_UK2" UNIQUE ("CONTACT_ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
      TABLESPACE "USERS"  ENABLE,   
  	 CONSTRAINT "TBL_CONTACT_API_FK1" FOREIGN KEY ("EDITOR_ID")
  	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE, 
  	 CONSTRAINT "TBL_CONTACT_API_FK2" FOREIGN KEY ("CREATOR_ID")
  	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE, 
  	 CONSTRAINT "TBL_CONTACT_API_FK3" FOREIGN KEY ("CONTACT_ID")
  	  REFERENCES "CRM"."TBL_CONTACT" ("ID") ENABLE
     ) SEGMENT CREATION DEFERRED 
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    TABLESPACE "USERS" ;
  
    CREATE OR REPLACE TRIGGER "CRM"."TBL_CONTACT_API_TRG" 
  BEFORE INSERT ON CRM.TBL_CONTACT_API 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      NULL;
    END COLUMN_SEQUENCES;
  END;
  /
  ALTER TRIGGER "CRM"."TBL_CONTACT_API_TRG" ENABLE;


// enable validity to user crm

------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_PERIOD_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


  CREATE TABLE "EDU"."TBL_PERIOD_API" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"PERIOD_ID" NUMBER, 
	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
	"DESCRIPTION" NVARCHAR2(500), 
	"CAN_REGISTER_ONLINE" NVARCHAR2(15), 
	"CREATE_DATE_TS" TIMESTAMP (6), 
	"EDIT_DATE_TS" TIMESTAMP (6), 
	"DELETE_TS" TIMESTAMP (6), 
    "PERIOD_EDIT_DATE" VARCHAR2(10 BYTE), 
    "FIELD_ID" NUMBER, 
    "FIELD_PUBLIC_ID" NVARCHAR2(500), 
	 CONSTRAINT "TBL_PERIOD_API_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "TBL_PERIOD_API_FK1" FOREIGN KEY ("PERIOD_ID")
	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE,
     CONSTRAINT "TBL_PERIOD_API_FK1" FOREIGN KEY ("FIELD_ID")
      REFERENCES "EDU"."TBL_FIELD" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

  CREATE OR REPLACE TRIGGER "EDU"."TBL_PERIOD_API_TRG" 
BEFORE INSERT ON EDU.TBL_PERIOD_API 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT SEQ_PERIOD_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EDU"."TBL_PERIOD_API_TRG" ENABLE;

// enable validity to user crm


------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_STUDENT_API"  MINVALUE 1 MAXVALUE 999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


   CREATE TABLE "EDU"."TBL_STUDENT_API" 
     (	"ID" NUMBER NOT NULL ENABLE, 
  	"PERSON_ID" NUMBER, 
  	"STUDENT_PUBLIC_ID" NVARCHAR2(500), 
  	"PERSON_PUBLIC_ID" NVARCHAR2(500), 
  	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
  	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
  	"STUDENT_DELETE_STATUS" NUMBER, 
  	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
  	"STUDENT_ID" NUMBER, 
  	"STUDENT_EDIT_DATE" NVARCHAR2(10), 
  	 CONSTRAINT "TBL_STUDENT_API_PK" PRIMARY KEY ("ID")
    USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
    TABLESPACE "USERS"  ENABLE, 
  	 CONSTRAINT "TBL_STUDENT_API_FK1" FOREIGN KEY ("PERSON_ID")
  	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE, 
  	 CONSTRAINT "TBL_STUDENT_API_FK2" FOREIGN KEY ("STUDENT_ID")
  	  REFERENCES "EDU"."TBL_STUDENT" ("ID") ENABLE
     ) SEGMENT CREATION DEFERRED 
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    TABLESPACE "USERS" ;
  
    CREATE OR REPLACE TRIGGER "EDU"."TBL_STUDENT_API_TRG" 
  BEFORE INSERT ON EDU.TBL_STUDENT_API 
  FOR EACH ROW 
  BEGIN
    <<COLUMN_SEQUENCES>>
    BEGIN
      NULL;
    END COLUMN_SEQUENCES;
  END;
  /
  ALTER TRIGGER "EDU"."TBL_STUDENT_API_TRG" ENABLE;


------------------------------

CREATE SEQUENCE  "EDU"."SEQ_REGISTER_API"  MINVALUE 1 MAXVALUE 999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;


CREATE TABLE "EDU"."TBL_REGISTER_API" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"REGISTER_ID" NUMBER, 
	"PERIOD_ID" NUMBER, 
	"STUDENT_ID" NUMBER, 
	"REGISTER_PUBLIC_ID" NVARCHAR2(500), 
	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
	"STUDENT_PUBLIC_ID" NVARCHAR2(500), 
	"REGISTER_DELETE_STATUS" NUMBER, 
	"REGISTER_ACTIVITY_STATUS" NUMBER, 
	"REGISTER_EDIT_DATE" NVARCHAR2(10), 
	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	 CONSTRAINT "TBL_REGISTER_API_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "TBL_REGISTER_API_FK1" FOREIGN KEY ("PERIOD_ID")
	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE, 
	 CONSTRAINT "TBL_REGISTER_API_FK2" FOREIGN KEY ("REGISTER_ID")
	  REFERENCES "EDU"."TBL_REGISTER" ("ID") ENABLE, 
	 CONSTRAINT "TBL_REGISTER_API_FK3" FOREIGN KEY ("STUDENT_ID")
	  REFERENCES "EDU"."TBL_STUDENT" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

  CREATE OR REPLACE TRIGGER "EDU"."TBL_REGISTER_API_TRG" 
BEFORE INSERT ON EDU.TBL_REGISTER_API 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT SEQ_REGISTER_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EDU"."TBL_REGISTER_API_TRG" ENABLE;




------------------------------

   CREATE SEQUENCE  "CRM"."SEQ_PRIVILEGE_API_ID"  MINVALUE 1 MAXVALUE 99999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

      CREATE TABLE "CRM"."TBL_PRIVILEGE_API" 
         (	"ID" NUMBER NOT NULL ENABLE, 
      	"NAME" NVARCHAR2(100), 
      	"ROLE_ID" NUMBER, 
      	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
      	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
      	"CREATOR_ID" NUMBER, 
      	"EDITOR_ID" NUMBER, 
      	"DESCRIPTION" NVARCHAR2(500), 
      	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
      	"PRIVILEGE_PUBLIC_ID" NVARCHAR2(500),
      	 CONSTRAINT "TBL_PRIVILEGE_API_PK" PRIMARY KEY ("ID")
        USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
        TABLESPACE "USERS"  ENABLE, 
      	 CONSTRAINT "TBL_PRIVILEGE_API_FK1" FOREIGN KEY ("ROLE_ID")
      	  REFERENCES "CRM"."TBL_ROLE_API" ("ID") ON DELETE CASCADE ENABLE
         ) SEGMENT CREATION DEFERRED 
        PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
        TABLESPACE "USERS" ;
      
        CREATE OR REPLACE TRIGGER "CRM"."TBL_PRIVILEGE_API_TRG" 
      BEFORE INSERT ON TBL_PRIVILEGE_API 
      FOR EACH ROW 
      BEGIN
        <<COLUMN_SEQUENCES>>
        BEGIN
          NULL;
        END COLUMN_SEQUENCES;
      END;
      /
      ALTER TRIGGER "CRM"."TBL_PRIVILEGE_API_TRG" ENABLE;

------------------------------

   CREATE SEQUENCE  "CRM"."SEQ_ROLE_API_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

         CREATE TABLE "CRM"."TBL_ROLE_API" 
            (	"ID" NUMBER NOT NULL ENABLE, 
         	"NAME" NVARCHAR2(100), 
         	"PRIVILEGE_ID" NUMBER, 
         	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
         	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
         	"DESCRIPTION" NVARCHAR2(500), 
         	"CREATOR_ID" NUMBER, 
         	"EDITOR_ID" NUMBER, 
         	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
         	"PERSON_API_ID" NUMBER, 
         	"ROLE_PUBLIC_ID" NVARCHAR2(500), 
         	 CONSTRAINT "TBL_ROLE_API_PK" PRIMARY KEY ("ID")
           USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
           TABLESPACE "USERS"  ENABLE, 
         	 CONSTRAINT "TBL_ROLE_API_FK1" FOREIGN KEY ("PRIVILEGE_ID")
         	  REFERENCES "CRM"."MD_PRIVILEGES" ("ID") ON DELETE SET NULL ENABLE,
         	  CONSTRAINT "TBL_ROLE_API_FK2" FOREIGN KEY ("PERSON_API_ID")
              	  REFERENCES "CRM"."TBL_PERSON_API" ("ID") ENABLE
            ) SEGMENT CREATION DEFERRED 
           PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
           TABLESPACE "USERS" ;
         
           CREATE OR REPLACE TRIGGER "CRM"."TBL_ROLE_API_TRG" 
         BEFORE INSERT ON TBL_ROLE_API 
         FOR EACH ROW 
         BEGIN
           <<COLUMN_SEQUENCES>>
           BEGIN
             NULL;
           END COLUMN_SEQUENCES;
         END;
         /
         ALTER TRIGGER "CRM"."TBL_ROLE_API_TRG" ENABLE;


------------------------------

   CREATE SEQUENCE  "CRM"."SEQ_ROLE_PRIVILEGE_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

      CREATE TABLE "CRM"."TBL_ROLE_PRIVILEGE_API" 
         (	"ID" NUMBER NOT NULL ENABLE, 
      	"ROLE_API_ID" NUMBER, 
      	"PRIVILEGE_API_ID" NUMBER, 
      	 CONSTRAINT "TBL_ROLE_PRIVILEGE_API_PK" PRIMARY KEY ("ID")
        USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
        TABLESPACE "USERS"  ENABLE, 
      	 CONSTRAINT "TBL_ROLE_PRIVILEGE_API_FK1" FOREIGN KEY ("ROLE_API_ID")
      	  REFERENCES "CRM"."TBL_ROLE_API" ("ID") ON DELETE CASCADE ENABLE, 
      	 CONSTRAINT "TBL_ROLE_PRIVILEGE_API_FK2" FOREIGN KEY ("PRIVILEGE_API_ID")
      	  REFERENCES "CRM"."TBL_PRIVILEGE_API" ("ID") ON DELETE SET NULL ENABLE
         ) SEGMENT CREATION DEFERRED 
        PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
        TABLESPACE "USERS" ;
      
        CREATE OR REPLACE TRIGGER "CRM"."TBL_ROLE_PRIVILEGE_API_TRG" 
      BEFORE INSERT ON TBL_ROLE_PRIVILEGE_API 
      FOR EACH ROW 
      BEGIN
        <<COLUMN_SEQUENCES>>
        BEGIN
          IF INSERTING AND :NEW.ID IS NULL THEN
            SELECT SEQ_ROLE_PRIVILEGE_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
          END IF;
        END COLUMN_SEQUENCES;
      END;
      /
      ALTER TRIGGER "CRM"."TBL_ROLE_PRIVILEGE_API_TRG" ENABLE;
    
    
    
------------------------------

   CREATE SEQUENCE  "CRM"."SEQ_PERSON_ROLE_API"  MINVALUE 1 MAXVALUE 999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

    CREATE TABLE "CRM"."TBL_PERSON_ROLE_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
    	"PERSON_API_ID" NUMBER, 
    	"ROLE_API_ID" NUMBER, 
    	 CONSTRAINT "TBL_PERSON_ROLE_PK" PRIMARY KEY ("ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
      TABLESPACE "USERS"  ENABLE, 
    	 CONSTRAINT "TBL_PERSON_ROLE_API_FK1" FOREIGN KEY ("PERSON_API_ID")
    	  REFERENCES "CRM"."TBL_PERSON_API" ("ID") ON DELETE CASCADE ENABLE, 
    	 CONSTRAINT "TBL_PERSON_ROLE_API_FK2" FOREIGN KEY ("ROLE_API_ID")
    	  REFERENCES "CRM"."TBL_ROLE_API" ("ID") ON DELETE SET NULL ENABLE
       ) SEGMENT CREATION DEFERRED 
      PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
      TABLESPACE "USERS" ;
    
      CREATE OR REPLACE TRIGGER "CRM"."TBL_PERSON_ROLE_API_TRG" 
    BEFORE INSERT ON TBL_PERSON_ROLE_API 
    FOR EACH ROW 
    BEGIN
      <<COLUMN_SEQUENCES>>
      BEGIN
        IF INSERTING AND :NEW.ROLE_API_ID IS NULL THEN
          SELECT SEQ_PERSON_ROLE_API.NEXTVAL INTO :NEW.ROLE_API_ID FROM SYS.DUAL;
        END IF;
      END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER "CRM"."TBL_PERSON_ROLE_API_TRG" ENABLE;




------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_EDU_LEVEL_API"  MINVALUE 1 MAXVALUE 99999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

      CREATE TABLE "EDU"."TBL_LEVEL_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
        "LEVEL_ID" NUMBER, 
        "LEVEL_PUBLIC_ID" NVARCHAR2(500), 
        "LEVEL_DELETE_STATUS" NUMBER, 
        "LEVEL_EDIT_DATE" NVARCHAR2(10), 
        "CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
        "EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
        "DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
         CONSTRAINT "TBL_LEVEL_API_PK" PRIMARY KEY ("ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
      TABLESPACE "USERS"  ENABLE, 
         CONSTRAINT "TBL_LEVEL_API_FK1" FOREIGN KEY ("LEVEL_ID")
          REFERENCES "EDU"."TBL_LEVEL" ("ID") ENABLE
       ) SEGMENT CREATION DEFERRED 
      PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
      TABLESPACE "USERS" ;
    
      CREATE OR REPLACE TRIGGER "EDU"."TBL_LEVEL_API_TRG" 
    BEFORE INSERT ON EDU.TBL_LEVEL_API 
    FOR EACH ROW 
    BEGIN
      <<COLUMN_SEQUENCES>>
      BEGIN
        IF INSERTING AND :NEW.ID IS NULL THEN
          SELECT SEQ_EDU_LEVEL_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
        END IF;
      END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER "EDU"."TBL_LEVEL_API_TRG" ENABLE;

------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_EDU_CATEGORY_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    
      CREATE TABLE "EDU"."TBL_EDU_CATEGORY_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
    	"EDU_CATEGORY_ID" NUMBER, 
    	"EDU_CATEGORY_PUBLIC_ID" NVARCHAR2(500), 
    	"EDU_CATEGORY_EDIT_DATE" NVARCHAR2(10), 
    	"CREATE_DATE_TS" TIMESTAMP (6), 
    	"EDIT_DATE_TS" TIMESTAMP (6), 
    	"DELETE_DATE_TS" TIMESTAMP (6), 
    	 CONSTRAINT "TBL_EDU_CATEGORY_API_PK" PRIMARY KEY ("ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
      TABLESPACE "USERS"  ENABLE, 
    	 CONSTRAINT "TBL_EDU_CATEGORY_API_FK1" FOREIGN KEY ("EDU_CATEGORY_ID")
    	  REFERENCES "EDU"."TBL_EDU_CATEGORY" ("ID") ENABLE
       ) SEGMENT CREATION DEFERRED 
      PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
      TABLESPACE "USERS" ;
    
      CREATE OR REPLACE TRIGGER "EDU"."TBL_EDU_CATEGORY_API_TRG" 
    BEFORE INSERT ON EDU.TBL_EDU_CATEGORY_API 
    FOR EACH ROW 
    BEGIN
      <<COLUMN_SEQUENCES>>
      BEGIN
        IF INSERTING AND :NEW.ID IS NULL THEN
          SELECT SEQ_EDU_CATEGORY_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
        END IF;
      END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER "EDU"."TBL_EDU_CATEGORY_API_TRG" ENABLE;



------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_FIELD_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

    CREATE TABLE "EDU"."TBL_FIELD_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
    	"FIELD_ID" NUMBER, 
    	"FIELD_PUBLIC_ID" NVARCHAR2(500), 
    	"FIELD_DELETE_STATUS" NUMBER, 
    	"FIELD_EDIT_DATE" NVARCHAR2(10), 
    	"LEVEL_ID" NUMBER, 
    	"LEVEL_PUBLIC_ID" NVARCHAR2(500), 
    	"EDU_CATEGORY_ID" NUMBER, 
    	"EDU_CATEGORY_PUBLIC_ID" NVARCHAR2(500), 
    	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
    	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
    	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE,
    	"FIELD_ACTIVITY_STATUS" NUMBER, 
    	 CONSTRAINT "TBL_FIELD_API_PK" PRIMARY KEY ("ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
      TABLESPACE "USERS"  ENABLE, 
    	 CONSTRAINT "TBL_FIELD_API_FK1" FOREIGN KEY ("FIELD_ID")
    	  REFERENCES "EDU"."TBL_FIELD" ("ID") ENABLE, 
    	 CONSTRAINT "TBL_FIELD_API_FK2" FOREIGN KEY ("LEVEL_ID")
    	  REFERENCES "EDU"."TBL_LEVEL" ("ID") ENABLE, 
    	 CONSTRAINT "TBL_FIELD_API_FK3" FOREIGN KEY ("EDU_CATEGORY_ID")
    	  REFERENCES "EDU"."TBL_EDU_CATEGORY" ("ID") ENABLE
       ) SEGMENT CREATION DEFERRED 
      PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
      TABLESPACE "USERS" ;
    
      CREATE OR REPLACE TRIGGER "EDU"."TBL_FIELD_API_TRG" 
    BEFORE INSERT ON EDU.TBL_FIELD_API 
    FOR EACH ROW 
    BEGIN
      <<COLUMN_SEQUENCES>>
      BEGIN
        IF INSERTING AND :NEW.ID IS NULL THEN
          SELECT SEQ_FIELD_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
        END IF;
      END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER "EDU"."TBL_FIELD_API_TRG" ENABLE;


------------------------------



------------------------------

//    (for study)  create ehcache-jsr107  to use in @Cacheable as cacheManager=
    @Bean
    public javax.cache.CacheManager jaxCacheManager(){
        return new EhcacheCachingProvider().getCacheManager();
    }
    @Bean
    public org.springframework.cache.CacheManager cacheManager(javax.cache.CacheManager jaxCacheManager) {
        return new JCacheCacheManager(jaxCacheManager);
    }
    
    --- (org.ehcache)
     @Bean
        public CacheManager ehCacheManager() {
//        java solution:
/*        CacheManager cacheManager = newCacheManagerBuilder()
                .withCache("basicCache",
                        newCacheConfigurationBuilder(Long.class, String.class, heap(100).offheap(1, MB)))
                .build(true);
        return cacheManager;*/

//        xml solution: 
/*        Configuration xmlConfig = new XmlConfiguration(AppConfig.class.getResource("ehcache.xml"));
        CacheManager cacheManager = newCacheManager(xmlConfig);*/
        
        CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
       // .with(new CacheManagerPersistenceConfiguration(new File("d:/cache"))) 
    OR // .with(CacheManagerBuilder.persistence("d:/cache/" + File.separator + "ss")) 
                .withCache("sessionCache",
                        CacheConfigurationBuilder.newCacheConfigurationBuilder(Long.class, String.class,
                            ResourcePoolsBuilder.newResourcePoolsBuilder()
                                .heap(2000, EntryUnit.ENTRIES)
                                .disk(10, MemoryUnit.MB, true)
                                .offheap(10, MemoryUnit.MB))
                            .withExpiry(Expirations.timeToLiveExpiration(Duration.of(5, TimeUnit.SECONDS))))
                            .withExpiry(Expirations.timeToIdleExpiration(Duration.of(5, TimeUnit.MINUTES))))
NotGood //      .using(new DefaultPersistenceConfiguration(new File("d:/cache")))
                .build(true);
                
        PersistentCacheManager persistentCacheManager = 
          CacheManagerBuilder.newCacheManagerBuilder()
            .with(CacheManagerBuilder.persistence(getStoragePath()
              + File.separator 
              + "squaredValue")) 
            .withCache("persistent-cache", 
                
        return cacheManager;
    
---
//    (working)  create ehcache-jsr107 and read ehcache.xml to use in @Cacheable as cacheManager=
    @Bean
    public JCacheCacheManager jCacheCacheManager() throws IOException, URISyntaxException {
        CachingProvider provider = Caching.getCachingProvider();
        CacheManager cacheManager = provider.getCacheManager(getClass().getResource("/ehcache.xml").toURI(), getClass().getClassLoader());
        cacheManager.createCache("jcacheKeyValueCopier", cacheConfiguration());
        return new JCacheCacheManager(cacheManager);
    }
        private javax.cache.configuration.Configuration<Object, Object> cacheConfiguration() {
            return new MutableConfiguration<>()
                    .setExpiryPolicyFactory(TouchedExpiryPolicy
                            .factoryOf(new Duration(TimeUnit.SECONDS, 10)))
                    .setStoreByValue(false)
                    .setStatisticsEnabled(true);
        }


---    
    
//    (not working)  create ehcache-jsr107 read ehcache.xml to use in @Cacheable as cacheManager=
    @Bean
    public JCacheCacheManager jCacheCacheManager() throws IOException {
        return new JCacheCacheManager(cacheManager());
    }

    @Bean
    public javax.cache.CacheManager cacheManager() throws IOException {
        XmlConfiguration xmlConfig = new XmlConfiguration(new ClassPathResource("ehcache.xml").getURL());
        EhcacheCachingProvider provider = (EhcacheCachingProvider) Caching.getCachingProvider();
        return provider.getCacheManager(provider.getDefaultURI(), xmlConfig);

    }
    
    //OR
    @Bean
    public javax.cache.CacheManager cacheManager() throws IOException {
    ResourcePools resourcePools = ResourcePoolsBuilder.newResourcePoolsBuilder()
                    .heap(2000, EntryUnit.ENTRIES)
                    .offheap(100, MemoryUnit.MB)
                    .build();
            CacheConfiguration<Object,Object> cacheConfiguration = CacheConfigurationBuilder.newCacheConfigurationBuilder(
                    Object.class,
                    Object.class,
                    resourcePools).
                    build();
            Map<String, CacheConfiguration<?, ?>> caches = new HashMap<>();
            caches.put("myCache", cacheConfiguration);
            org.ehcache.config.Configuration configuration = new DefaultConfiguration(caches, provider.getDefaultClassLoader());
            return  provider.getCacheManager(provider.getDefaultURI(), (org.ehcache.config.Configuration) configuration);
    }
---

//      create ehcache-jsr107 without ehcache.xml to use in @Cacheable as cacheManager=
    @Bean
    public JCacheManagerCustomizer jCacheConfigurationCustomizer() {
        return cacheManager -> {
            cacheManager.createCache("vets", cacheConfiguration());
        };
    }
    private javax.cache.configuration.Configuration<Object, Object> cacheConfiguration() {
//        return new MutableConfiguration<>().setStatisticsEnabled(true);
        return new MutableConfiguration<>()
                .setExpiryPolicyFactory(TouchedExpiryPolicy
                        .factoryOf(new Duration(TimeUnit.SECONDS, 10)))
                .setStoreByValue(false)
                .setStatisticsEnabled(true);
    }
    
    
---




---

ehcache.xml:

<?xml version="1.0" encoding="ISO-8859-1"?>

<ehcache:config
        xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
        xmlns:jsr107='http://www.ehcache.org/v3/jsr107'
        xmlns:ehcache='http://www.ehcache.org/v3'
        xsi:schemaLocation="http://www.ehcache.org/v3 http://www.ehcache.org/schema/ehcache-core-3.1.xsd">

    <ehcache:service>
        <jsr107:defaults>
            <jsr107:cache name="people" template="default"/>
        </jsr107:defaults>
    </ehcache:service>

<!-- Persistent cache directory -->
<!--    <persistence directory="/run/media/o.ashouri/Archive/0_0/cache" />-->
    <ehcache:persistence directory="D:\Office\cache" />

    <!-- Default cache template -->
    <ehcache:cache-template name="default">
<!--        <expiry>
            <ttl unit="seconds">0</ttl>
        </expiry>-->
        <ehcache:listeners>
            <ehcache:listener>
                <ehcache:class>edu.imi.ir.eduimiws.servces.CacheEventLogger</ehcache:class>
                <ehcache:event-firing-mode>ASYNCHRONOUS</ehcache:event-firing-mode>
                <ehcache:event-ordering-mode>UNORDERED</ehcache:event-ordering-mode>
                <ehcache:events-to-fire-on>CREATED</ehcache:events-to-fire-on>
                <ehcache:events-to-fire-on>EXPIRED</ehcache:events-to-fire-on>
                <ehcache:events-to-fire-on>EVICTED</ehcache:events-to-fire-on>
            </ehcache:listener>
        </ehcache:listeners>
        <ehcache:resources>
            <ehcache:heap>100</ehcache:heap>
            <ehcache:offheap unit="MB">10</ehcache:offheap>
            <ehcache:disk persistent="true" unit="MB">200</ehcache:disk>
        </ehcache:resources>
    </ehcache:cache-template>

    <ehcache:cache alias="edu.imi.ir.eduimiws.domain.edu.RegisterEntity" uses-template="default"/>
    <ehcache:cache alias="edu.imi.ir.eduimiws.domain.edu.RegisterApiEntity" uses-template="default"/>
    <ehcache:cache alias="register" uses-template="default"/>
    <ehcache:cache alias="registerApi" uses-template="default"/>
    <ehcache:cache alias="student" uses-template="default"/>
    <ehcache:cache alias="period" uses-template="default"/>
    <ehcache:cache alias="periodApi" uses-template="default"/>
    <ehcache:cache alias="field" uses-template="default"/>
    <ehcache:cache alias="fieldApi" uses-template="default"/>
    <ehcache:cache alias="level" uses-template="default"/>
    <ehcache:cache alias="eduCategory" uses-template="default"/>

    <ehcache:cache alias="myperiod" >
        <ehcache:key-type>java.lang.Object</ehcache:key-type>
        <ehcache:value-type>org.springframework.data.domain.PageImpl</ehcache:value-type>
        <ehcache:expiry>
            <ehcache:ttl unit="seconds">5</ehcache:ttl>
        </ehcache:expiry>
                <ehcache:listeners>
                    <ehcache:listener>
                        <ehcache:class>edu.imi.ir.eduimiws.servces.CacheEventLogger</ehcache:class>
                        <ehcache:event-firing-mode>ASYNCHRONOUS</ehcache:event-firing-mode>
                        <ehcache:event-ordering-mode>UNORDERED</ehcache:event-ordering-mode>
                        <ehcache:events-to-fire-on>CREATED</ehcache:events-to-fire-on>
                        <ehcache:events-to-fire-on>EXPIRED</ehcache:events-to-fire-on>
                    </ehcache:listener>
                </ehcache:listeners>
        <ehcache:resources>
            <ehcache:heap unit="B">5</ehcache:heap>
            <ehcache:offheap unit="MB">1</ehcache:offheap>
        </ehcache:resources>
    </ehcache:cache>
    
     <ehcache:cache alias="basicCache">
            <ehcache:key-type>java.lang.Object</ehcache:key-type>
            <ehcache:value-type>org.springframework.data.domain.PageImpl</ehcache:value-type>
            <ehcache:expiry>
                <ehcache:ttl unit="seconds">3</ehcache:ttl>
            </ehcache:expiry>
            <ehcache:resources>
                <ehcache:heap unit="B">5</ehcache:heap>
                <ehcache:offheap unit="MB">1</ehcache:offheap>
            </ehcache:resources>
        </ehcache:cache>
</ehcache:config>


---

        <dependency>
            <groupId>org.ehcache</groupId>
            <artifactId>ehcache</artifactId>
        </dependency>
        <dependency>
            <groupId>javax.cache</groupId>
            <artifactId>cache-api</artifactId>
        </dependency>
      <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context-support</artifactId>
        </dependency>
        
        
---

//  8.5.1. JDK ConcurrentMap-based Cache
    @Bean
    public SimpleCacheManager myCacheManager(ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(concurrentMapCacheFactoryBean.getObject());
        simpleCacheManager.setCaches(caches);
        return simpleCacheManager;
    }

    @Bean
    public ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean(){
        ConcurrentMapCacheFactoryBean concurrentMapCacheFactoryBean = new ConcurrentMapCacheFactoryBean();
        concurrentMapCacheFactoryBean.setName("ali");
        return concurrentMapCacheFactoryBean;
    }
    
    //OR
    @Bean
    public CacheManager cacheManager() {
        ConcurrentMapCacheManager concurrentMapCacheManager = new ConcurrentMapCacheManager();
        concurrentMapCacheManager.setCacheNames(Arrays.asList("periodDescriptive"));
        return concurrentMapCacheManager;
    }
    
---

//  8.5.2. Ehcache-based Cache (Ehcache 2)
    @Bean
    public EhCacheCacheManager myEhCacheCacheManager(EhCacheManagerFactoryBean ehCacheManagerFactoryBean){
        EhCacheCacheManager ehCacheCacheManager = new EhCacheCacheManager();
        ehCacheCacheManager.setCacheManager(ehCacheManagerFactoryBean.getObject());
        return ehCacheCacheManager;
    }

    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean(){
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        Resource resource = new ClassPathXmlApplicationContext().getResource("ehcache.xml");
        ehCacheManagerFactoryBean.setConfigLocation(resource);
        ehCacheManagerFactoryBean.setShared(true);
        return ehCacheManagerFactoryBean;
    }
    
---

//  8.5.5. JSR-107 Cache
    @Bean
    public JCacheCacheManager jCacheCacheManager(JCacheManagerFactoryBean jCacheManagerFactoryBean){
        JCacheCacheManager jCacheCacheManager = new JCacheCacheManager();
        jCacheCacheManager.setCacheManager(jCacheManagerFactoryBean.getObject());
        return jCacheCacheManager;
    }

    @Bean
    public JCacheManagerFactoryBean jCacheManagerFactoryBean() throws URISyntaxException {
        JCacheManagerFactoryBean jCacheManagerFactoryBean = new JCacheManagerFactoryBean();
        jCacheManagerFactoryBean.setCacheManagerUri(getClass().getResource("/ehcache.xml").toURI());
        return jCacheManagerFactoryBean;
    }
    
---
//  Video
    @Bean
        public JCacheCacheManager jCacheCacheManager() throws URISyntaxException {
            CachingProvider cachingProvider = Caching.getCachingProvider();
            javax.cache.CacheManager cacheManager = cachingProvider
                                            .getCacheManager(getClass().getResource("/ehcache.xml").toURI(),
                                                cachingProvider.getDefaultClassLoader());
            MutableConfiguration<Object,PageImpl> mutableConfiguration = new MutableConfiguration<Object,PageImpl>();
            mutableConfiguration.setStoreByValue(false);
            cacheManager.createCache("people",mutableConfiguration); //people is defined as jsr107 in ehcache.xml
            return new JCacheCacheManager(cacheManager);
        }
        
---