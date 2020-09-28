# edu-imi-ws
IMI Education Web Service


CRM: contact -> person -> Role -> PRIVILEGE -> ROLE_PRIVILEGE -> PERSON_ROLE  
EDU: EDU_LEVEL -> EDU_CATEGORY -> COURSE_CATEGORY -> TEAM -> TEAM_PRESENTED_COURSE -> TEAM_PRESENTED_GROUP ->
     STUDENT   -> REGISTER     -> 

--- --- --- CONTACT --- --- ---

   CREATE SEQUENCE  "CRM"."SEQ_CONTACT_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 NOCACHE  NOORDER  NOCYCLE ;


  CREATE TABLE "CRM"."TBL_CONTACT_API" 
     (	"ID" NUMBER NOT NULL ENABLE, 
  	"CONTACT_PUBLIC_ID" NVARCHAR2(500) NOT NULL ENABLE, 
  	"CREATOR_ID" NUMBER, 
  	"CREATE_DATE_TS" TIMESTAMP (6), 
  	"EDITOR_ID" NUMBER, 
  	"EDIT_DATE_TS" TIMESTAMP (6), 
  	"CONTACT_ID" NUMBER, 
  	"DELETED_CONTACT_ID" NUMBER, 
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


create or replace TRIGGER "CRM"."TBL_CONTACT_API_IU" AFTER INSERT OR UPDATE ON CRM.TBL_CONTACT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW WHEN (1=1)
declare
  TS_ TIMESTAMP(6);
  UUID_ nvarchar2(500 char) ;
BEGIN
    TS_ := systimestamp;
    UUID_ := CRM.my_uuid;
  if inserting then
    insert into CRM.tbl_contact_api
    (id,contact_public_id, creator_id, create_date_ts,
     editor_id, edit_date_ts, contact_id, contact_edit_date)
     values 
      (crm.seq_contact_api.nextval, UUID_, :new.user_creator_id, TS_, 
      null, null, :new.id, null);
  end if;
  if updating then
    update CRM.tbl_contact_api
    set 
     editor_id = :new.user_editor_id, 
     edit_date_ts = TS_, 
     contact_edit_date = :new.edit_date
     where contact_id = :old.id;
    end if;
END;


create or replace TRIGGER "CRM"."TBL_CONTACT_API_D" BEFORE DELETE ON CRM.TBL_CONTACT
REFERENCING OLD AS OLD NEW AS NEW
FOR EACH ROW WHEN (1=1)
declare
  TS_ TIMESTAMP(6);
  UUID_ nvarchar2(500 char) ;
  ID_API number;
BEGIN
    TS_ := systimestamp;
    UUID_ := CRM.my_uuid;
  IF DELETING THEN
    SELECT CA.ID INTO ID_API
    FROM CRM.TBL_CONTACT_API CA
    WHERE ca.contact_id = :old.id;
    
    update CRM.tbl_contact_api ca
    set  
     ca.contact_id = null,
     ca.delete_date_ts = TS_,
     ca.deleted_contact_id = :old.id
     where ca.id = ID_API;
   END IF;
END;


create or replace procedure   CRM.UUID_CONTACT_API IS
begin
  declare
    cursor c_t is
            SELECT
                ct.id as CONTACTID
            FROM
                crm.tbl_contact ct
                LEFT JOIN crm.tbl_contact_api cta ON ct.id = cta.contact_id
            WHERE
                cta.contact_id IS NULL
            ORDER BY
                CONTACTID ASC;
  begin
    for r_t in c_t loop
            INSERT INTO crm.tbl_contact_api(
                id,
                contact_public_id,
                create_date_ts,
                contact_id
            )VALUES(
                crm.seq_contact_api.nextval,
                crm.my_uuid,
                systimestamp,
                r_t."CONTACTID"
            );
     end loop;
  end;
  commit;
end;

// enable validity to user crm


-------------- PERSON ----------------

CREATE SEQUENCE CRM.SEQ_PERSON_API_ID INCREMENT BY 1 MAXVALUE 9999999999999999 MINVALUE 1 CACHE 20;

CREATE TABLE "CRM"."TBL_ROLE_API"  
    ("ID" NUMBER NOT NULL ENABLE,
    CONSTRAINT "TBL_ROLE_API_PK" PRIMARY KEY ("ID")
        USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
        TABLESPACE "USERS"  ENABLE) 
    SEGMENT CREATION DEFERRED 
    PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
    TABLESPACE "USERS";

   CREATE TABLE "CRM"."TBL_PERSON_API" 
        (	"ID" NUMBER NOT NULL ENABLE, 
     	"PERSON_ID" NUMBER, 
     	"DELETED_PERSON_ID" NUMBER, 
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
     	"DELETED_CONTACT_ID" NUMBER, 
     	"CONTACT_PUBLIC_ID" NVARCHAR2(500), 
     	"ROLE_ID" NUMBER,
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
--         CONSTRAINT "TBL_PERSON_API_UK3" UNIQUE ("CONTACT_ID")
--           USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
--           TABLESPACE "USERS"  ENABLE, 
--         	 CONSTRAINT "TBL_PERSON_API_UK4" UNIQUE ("CONTACT_PUBLIC_ID")
--           USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
--           TABLESPACE "USERS"  ENABLE, 
     	 CONSTRAINT "TBL_PERSON_API_FK1" FOREIGN KEY ("PERSON_ID")
        	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE, 
        	 CONSTRAINT "TBL_PERSON_API_FK4" FOREIGN KEY ("CONTACT_ID")
        	  REFERENCES "CRM"."TBL_CONTACT" ("ID") ENABLE, 
        	 CONSTRAINT "TBL_PERSON_API_FK5" FOREIGN KEY ("ROLE_ID")
        	  REFERENCES "CRM"."TBL_ROLE_API" ("ID") ENABLE, 
        	 CONSTRAINT "TBL_PERSON_API_FK2" FOREIGN KEY ("CREATOR_ID")
        	  REFERENCES "CRM"."TBL_PERSON" ("ID")  ENABLE, 
        	 CONSTRAINT "TBL_PERSON_API_FK3" FOREIGN KEY ("EDITOR_ID")
        	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE
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
  
  
  create or replace TRIGGER "CRM"."TBL_PERSON_API_IU" AFTER INSERT OR UPDATE ON CRM.TBL_PERSON
  REFERENCING OLD AS OLD NEW AS NEW
  FOR EACH ROW WHEN (1=1)
  declare
    TS_ TIMESTAMP(6);
    UUID_ nvarchar2(500 char) ;
    CONTACTPUBLICID_ nvarchar2(500 char);
  BEGIN
      TS_ := systimestamp;
      UUID_ := CRM.my_uuid;
    if inserting then
      SELECT ca.contact_public_id INTO CONTACTPUBLICID_
      FROM CRM.TBL_CONTACT_API CA
      WHERE ca.contact_id = :new.contact_id;
      insert into CRM.tbl_person_api
      (id, person_public_id, create_date_ts,
        person_id, contact_id, contact_public_id)
       values 
        (crm.SEQ_PERSON_API_ID.nextval, UUID_, TS_, 
        :new.id, :new.CONTACT_ID,CONTACTPUBLICID_);
    end if;
    if updating then
      update CRM.tbl_person_api
      set  
       edit_date_ts = TS_
       where person_id = :old.id;
      end if;
  END;
  
  create or replace TRIGGER "CRM"."TBL_PERSON_API_D" BEFORE DELETE ON CRM.TBL_PERSON
  REFERENCING OLD AS OLD NEW AS NEW
  FOR EACH ROW WHEN (1=1)
  declare
    TS_ TIMESTAMP(6);
    UUID_ nvarchar2(500 char) ;
    ID_API number;
  BEGIN
      TS_ := systimestamp;
      UUID_ := CRM.my_uuid;
    IF DELETING THEN
      SELECT api.ID INTO ID_API
      FROM CRM.TBL_PERSON_API api
      WHERE api.person_id = :old.id;
      update CRM.tbl_person_api api
      set  
       api.person_id = null,
       api.delete_date_ts = TS_,
       api.deleted_person_id = :old.id,
       api.contact_id = null,
       api.deleted_contact_id = :old.CONTACT_ID
       where api.id = ID_API;
     END IF;
  END;
  
  
  create or replace procedure   CRM.UUID_PERSON_API IS
  begin
    declare
      cursor c_t is
              SELECT
                  mt.id as PERSONID,
                  mt.contact_id as CONTACTID,
                  secapi.contact_public_id CONTACTPUBLICID
              FROM
                  crm.tbl_person mt
                  LEFT JOIN crm.tbl_person_api api ON mt.id = api.person_id
                  LEFT JOIN crm.tbl_contact sect ON mt.contact_id = sect.id
                  LEFT JOIN crm.tbl_contact_api secapi ON sect.id = secapi.contact_id
              WHERE
                  api.person_id IS NULL
              ORDER BY
                  PERSONID ASC;
    begin
      for r_t in c_t loop
              INSERT INTO crm.tbl_person_api(
                  id,
                  person_public_id,
                  create_date_ts,
                  person_id,
                  contact_id,
                  contact_public_id
              )VALUES(
                  crm.SEQ_PERSON_API_ID.nextval,
                  crm.my_uuid,
                  systimestamp,
                  r_t."PERSONID",
                  r_t."CONTACTID",
                  r_t."CONTACTPUBLICID"
              );
       end loop;
    end;
    commit;
  end;

----------------- ROLE -------------

CREATE SEQUENCE  "CRM"."SEQ_ROLE_API_ID"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

       :::REMOVE constraint in TBL_PERSON_API to TBL_ROLE_API
       
       DROP TABLE "CRM"."TBL_ROLE_API";

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
         BEFORE INSERT ON crm.TBL_ROLE_API 
         FOR EACH ROW 
         BEGIN
           <<COLUMN_SEQUENCES>>
           BEGIN
             NULL;
           END COLUMN_SEQUENCES;
         END;
         /
         ALTER TRIGGER "CRM"."TBL_ROLE_API_TRG" ENABLE;

        
        :::ADD constraint in TBL_PERSON_API to TBL_ROLE_API
        :::check sequence for id
        
 Insert into CRM.TBL_ROLE_API 
 (ID,NAME,PRIVILEGE_ID,CREATE_DATE_TS,EDIT_DATE_TS,DESCRIPTION,CREATOR_ID,EDITOR_ID,DELETE_DATE_TS,PERSON_API_ID,ROLE_PUBLIC_ID) 
 values 
 (CRM.SEQ_ROLE_API_ID.nextval,'ROLE_ADMIN',null,systimestamp,null,null,null,null,null,null,CRM.my_uuid);
 
 Insert into CRM.TBL_ROLE_API 
 (ID,NAME,PRIVILEGE_ID,CREATE_DATE_TS,EDIT_DATE_TS,DESCRIPTION,CREATOR_ID,EDITOR_ID,DELETE_DATE_TS,PERSON_API_ID,ROLE_PUBLIC_ID) 
 values 
 (CRM.SEQ_ROLE_API_ID.nextval,'ROLE_EDUPOWERUSER',null,systimestamp,null,null,null,null,null,null,CRM.my_uuid);
 
 Insert into CRM.TBL_ROLE_API 
 (ID,NAME,PRIVILEGE_ID,CREATE_DATE_TS,EDIT_DATE_TS,DESCRIPTION,CREATOR_ID,EDITOR_ID,DELETE_DATE_TS,PERSON_API_ID,ROLE_PUBLIC_ID) 
 values 
 (CRM.SEQ_ROLE_API_ID.nextval,'ROLE_EDUCATION',null,systimestamp,null,null,null,null,null,null,CRM.my_uuid);
 
 Insert into CRM.TBL_ROLE_API 
 (ID,NAME,PRIVILEGE_ID,CREATE_DATE_TS,EDIT_DATE_TS,DESCRIPTION,CREATOR_ID,EDITOR_ID,DELETE_DATE_TS,PERSON_API_ID,ROLE_PUBLIC_ID) 
 values 
 (CRM.SEQ_ROLE_API_ID.nextval,'ROLE_EDUCATION',null,systimestamp,null,null,null,null,null,null,CRM.my_uuid);
 
 Insert into CRM.TBL_ROLE_API 
 (ID,NAME,PRIVILEGE_ID,CREATE_DATE_TS,EDIT_DATE_TS,DESCRIPTION,CREATOR_ID,EDITOR_ID,DELETE_DATE_TS,PERSON_API_ID,ROLE_PUBLIC_ID) 
 values 
 (CRM.SEQ_ROLE_API_ID.nextval,'ROLE_EDUCATION',null,systimestamp,null,null,null,null,null,null,CRM.my_uuid);
       
             
             
---------------- PRIVILEGE --------------


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
      BEFORE INSERT ON CRM.TBL_PRIVILEGE_API 
      FOR EACH ROW 
      BEGIN
        <<COLUMN_SEQUENCES>>
        BEGIN
          NULL;
        END COLUMN_SEQUENCES;
      END;
      /
      ALTER TRIGGER "CRM"."TBL_PRIVILEGE_API_TRG" ENABLE;
      
      Insert into CRM.TBL_PRIVILEGE_API 
      (ID,NAME,ROLE_ID,CREATE_DATE_TS,EDIT_DATE_TS,CREATOR_ID,EDITOR_ID,DESCRIPTION,DELETE_DATE_TS,PRIVILEGE_PUBLIC_ID) 
      values 
      (CRM.SEQ_PRIVILEGE_API_ID.nextval,'UPDATE_PRIVILEGE',null,systimestamp,null,null,null,null,null,CRM.my_uuid);
      
      Insert into CRM.TBL_PRIVILEGE_API 
      (ID,NAME,ROLE_ID,CREATE_DATE_TS,EDIT_DATE_TS,CREATOR_ID,EDITOR_ID,DESCRIPTION,DELETE_DATE_TS,PRIVILEGE_PUBLIC_ID) 
      values 
      (CRM.SEQ_PRIVILEGE_API_ID.nextval,'DELETE_PRIVILEGE',null,systimestamp,null,null,null,null,null,CRM.my_uuid);
      
      Insert into CRM.TBL_PRIVILEGE_API 
      (ID,NAME,ROLE_ID,CREATE_DATE_TS,EDIT_DATE_TS,CREATOR_ID,EDITOR_ID,DESCRIPTION,DELETE_DATE_TS,PRIVILEGE_PUBLIC_ID) 
      values 
      (CRM.SEQ_PRIVILEGE_API_ID.nextval,'READ_PRIVILEGE',null,systimestamp,null,null,null,null,null,CRM.my_uuid);
      
      Insert into CRM.TBL_PRIVILEGE_API 
      (ID,NAME,ROLE_ID,CREATE_DATE_TS,EDIT_DATE_TS,CREATOR_ID,EDITOR_ID,DESCRIPTION,DELETE_DATE_TS,PRIVILEGE_PUBLIC_ID) 
      values 
      (CRM.SEQ_PRIVILEGE_API_ID.nextval,'CREATE_PRIVILEGE',null,systimestamp,null,null,null,null,null,CRM.my_uuid);

---------------- ROLE_PRIVILEGE --------------


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
      BEFORE INSERT ON CRM.TBL_ROLE_PRIVILEGE_API 
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
       
       
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,1,1);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,1,2);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,1,3);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,1,4);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,3,1);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,3,3);
Insert into CRM.TBL_ROLE_PRIVILEGE_API (ID,ROLE_API_ID,PRIVILEGE_API_ID) values (CRM.SEQ_ROLE_PRIVILEGE_API.nextval,3,4);
            
---------------- PERSON_ROLE --------------

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
    BEFORE INSERT ON CRM.TBL_PERSON_ROLE_API 
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

    :::CORRECT TRIGGER FOR ID
    
    
    --PERSON_API_ID=4221
Insert into CRM.TBL_PERSON_ROLE_API (ID,PERSON_API_ID,ROLE_API_ID) values (CRM.SEQ_PERSON_ROLE_API.nextval,4221,1);    

------------------------------

Insert into EDU.TBL_LEVEL 
(ID,DESCRIPTION,CODE,COMPANY_ID,TERMIC_STATUS,CREATOR,EDITOR,CREATE_DATE,EDIT_DATE,PAYMENT_TYPE,TITLE,CERT_TITLE) 
values 
(65,'Post DOC','65',4,'Termic',100160,null,'1399/06/18',null,'i','d','دکترا');

Insert into EDU.TBL_LEVEL 
(ID,DESCRIPTION,CODE,COMPANY_ID,TERMIC_STATUS,CREATOR,EDITOR,CREATE_DATE,EDIT_DATE,PAYMENT_TYPE,TITLE,CERT_TITLE) 
values 
(66,'Post DBA','66',4,'Termic',100160,null,'1399/06/18',null,'i','d','دکترا');

-------------------- EDU_LEVEL --------------

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
        "DELETE_LEVEL_ID" NUMBER,  
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
    
    create or replace TRIGGER "EDU"."TBL_LEVEL_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_LEVEL
        REFERENCING OLD AS OLD NEW AS NEW
        FOR EACH ROW WHEN (1=1)
        declare
          TS_ TIMESTAMP(6);
          UUID_ nvarchar2(500 char) ;
        BEGIN
            TS_ := systimestamp;
            UUID_ := CRM.my_uuid;
          if inserting then
            insert into EDU.TBL_LEVEL_API
            (id, LEVEL_public_id, create_date_ts, LEVEL_id)
             values 
              (EDU.SEQ_EDU_LEVEL_API.nextval, UUID_, TS_, :new.id);
          end if;
          if updating then
            update EDU.TBL_LEVEL_API
            set  
             edit_date_ts = TS_, 
             LEVEL_edit_date = :new.edit_date
             where LEVEL_id = :old.id;
            end if;
        END;
    
   
    
    create or replace TRIGGER "EDU"."TBL_LEVEL_API_D" BEFORE DELETE ON EDU.TBL_LEVEL
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW WHEN (1=1)
    declare
      TS_ TIMESTAMP(6);
      UUID_ nvarchar2(500 char) ;
      ID_API number;
    BEGIN
        TS_ := systimestamp;
        UUID_ := CRM.my_uuid;
      IF DELETING THEN
        SELECT API.ID INTO ID_API
        FROM EDu.TBL_LEVEL_API API
        WHERE API.level_id = :old.id;
        
        update EDU.tbl_LEVEL_api api
        set  
         api.LEVEL_id = null,
         api.delete_date_ts = TS_,
         api.deleted_level_id = :old.id
         where api.id = ID_API;
       END IF;
    END;
    
    
    create or replace procedure   EDU.UUID_LEVEL_API IS
    begin
      declare
        cursor c_t is
                SELECT
                    mt.id as LEVELID
                FROM
                    edu.tbl_level mt
                    LEFT JOIN edu.tbl_level_api api ON mt.id = api.level_id
                WHERE
                    api.level_id IS NULL
                ORDER BY
                    LEVELID ASC;
      begin
        for r_t in c_t loop
                INSERT INTO edu.tbl_level_api(
                    id,
                    level_public_id,
                    create_date_ts,
                    level_id
                )VALUES(
                    edu.SEQ_EDU_LEVEL_API.nextval,
                    crm.my_uuid,
                    systimestamp,
                    r_t."LEVELID"
                );
         end loop;
      end;
      commit;
    end;
    
    

------------------------------

Insert into EDU.TBL_EDU_CATEGORY (ID,TITLE,PARENT_ID,COMPANY_ID,EDITOR,CREATOR) values (7,'پزشکي',null,4,null,100160);
Insert into EDU.TBL_EDU_CATEGORY (ID,TITLE,PARENT_ID,COMPANY_ID,EDITOR,CREATOR) values (8,'فناوري اطلاعات',null,4,null,100160);

-------------------- EDU_CATEGORY --------------


   CREATE SEQUENCE  "EDU"."SEQ_EDU_CATEGORY_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    
      CREATE TABLE "EDU"."TBL_EDU_CATEGORY_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
    	"EDU_CATEGORY_ID" NUMBER, 
    	"EDU_CATEGORY_PUBLIC_ID" NVARCHAR2(500), 
    	"EDU_CATEGORY_EDIT_DATE" NVARCHAR2(10), 
    	"CREATE_DATE_TS" TIMESTAMP (6), 
    	"EDIT_DATE_TS" TIMESTAMP (6), 
    	"DELETE_DATE_TS" TIMESTAMP (6), 
    	"DELETE_EDU_CATEGORY_ID" NUMBER, 
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
    

        create or replace TRIGGER "EDU"."TBL_EDU_CATEGORY_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_EDU_CATEGORY
        REFERENCING OLD AS OLD NEW AS NEW
        FOR EACH ROW WHEN (1=1)
        declare
          TS_ TIMESTAMP(6);
          UUID_ nvarchar2(500 char) ;
        BEGIN
            TS_ := systimestamp;
            UUID_ := CRM.my_uuid;
          if inserting then
            insert into EDU.TBL_EDU_CATEGORY_API
            (id, EDU_CATEGORY_public_id, create_date_ts, EDU_CATEGORY_id)
             values 
              (EDU.SEQ_EDU_CATEGORY_API.nextval, UUID_, TS_, :new.id);
          end if;
          if updating then
            update EDU.TBL_EDU_CATEGORY_API
            set  
             edit_date_ts = TS_
             where EDU_CATEGORY_id = :old.id;
            end if;
        END;
        commit;
    
   
    create or replace TRIGGER "EDU"."TBL_EDU_CATEGORY_API_D" BEFORE DELETE ON EDU.TBL_EDU_CATEGORY
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW WHEN (1=1)
    declare
      TS_ TIMESTAMP(6);
      UUID_ nvarchar2(500 char) ;
      ID_API number;
    BEGIN
        TS_ := systimestamp;
        UUID_ := CRM.my_uuid;
      IF DELETING THEN
        SELECT API.ID INTO ID_API
        FROM EDU.TBL_EDU_CATEGORY_API API
        WHERE API.EDU_CATEGORY_id = :old.id;
        
        update EDU.tbl_EDU_CATEGORY_api api
        set  
         api.EDU_CATEGORY_id = null,
         api.delete_date_ts = TS_,
         api.deleted_EDU_CATEGORY_id = :old.id
         where api.id = ID_API;
       END IF;
    END;
    
    
    create or replace procedure   EDU.UUID_EDU_CATEGORY_API IS
        begin
          declare
            cursor c_t is
                    SELECT
                        mt.id as EDU_CATEGORYID
                    FROM
                        edu.tbl_EDU_CATEGORY mt
                        LEFT JOIN edu.tbl_EDU_CATEGORY_api api ON mt.id = api.EDU_CATEGORY_id
                    WHERE
                        api.EDU_CATEGORY_id IS NULL
                    ORDER BY
                        EDU_CATEGORYID ASC;
          begin
            for r_t in c_t loop
                    INSERT INTO edu.tbl_EDU_CATEGORY_api(
                        id,
                        EDU_CATEGORY_public_id,
                        create_date_ts,
                        EDU_CATEGORY_id
                    )VALUES(
                        edu.SEQ_EDU_CATEGORY_API.nextval,
                        crm.my_uuid,
                        systimestamp,
                        r_t."EDU_CATEGORYID"
                    );
             end loop;
          end;
          commit;
        end;
    
    
        begin
        edu.UUID_EDU_CATEGORY_API;
        end;
        
------------------------------



-------------------- COURSE_CATEGORY -------------


   CREATE SEQUENCE  "EDU"."SEQ_COURSE_CATEGORY_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

     CREATE TABLE "EDU"."TBL_COURSE_CATEGORY_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"COURSE_CATEGORY_ID" NUMBER, 
   	"COURSE_CATEGORY_PUBLIC_ID" NVARCHAR2(500), 
   	"COURSE_CATEGORY_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DESCRIPTION" NVARCHAR2(500), 
   	"DELETED_COURSE_CATEGORY_ID" NUMBER, 
   	 CONSTRAINT "TBL_COURSE_CATEGORY_API_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_COURSE_CATEGORY_API_FK1" FOREIGN KEY ("COURSE_CATEGORY_ID")
   	  REFERENCES "EDU"."TBL_COURSE_CATEGORY" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_COURSE_CATEGORY_API_TRG" 
   BEFORE INSERT ON EDU.TBL_COURSE_CATEGORY_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_COURSE_CATEGORY_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_COURSE_CATEGORY_API_TRG" ENABLE;
   

    create or replace TRIGGER "EDU"."TBL_COURSE_CATEGORY_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_COURSE_CATEGORY
        REFERENCING OLD AS OLD NEW AS NEW
        FOR EACH ROW WHEN (1=1)
        declare
          TS_ TIMESTAMP(6);
          UUID_ nvarchar2(500 char) ;
        BEGIN
            TS_ := systimestamp;
            UUID_ := CRM.my_uuid;
          if inserting then
            insert into EDU.TBL_COURSE_CATEGORY_API
            (id, COURSE_CATEGORY_public_id, create_date_ts, COURSE_CATEGORY_id)
             values 
              (EDU.SEQ_COURSE_CATEGORY_API.nextval, UUID_, TS_, :new.id);
          end if;
          if updating then
            update EDU.TBL_COURSE_CATEGORY_API
            set  
             edit_date_ts = TS_, 
             COURSE_CATEGORY_edit_date = :new.edit_date
             where COURSE_CATEGORY_id = :old.id;
            end if;
        END;    
       
       create or replace TRIGGER "EDU"."TBL_COURSE_CATEGORY_API_D" BEFORE DELETE ON EDU.TBL_COURSE_CATEGORY
               REFERENCING OLD AS OLD NEW AS NEW
               FOR EACH ROW WHEN (1=1)
               declare
                 TS_ TIMESTAMP(6);
                 UUID_ nvarchar2(500 char) ;
                 ID_API number;
               BEGIN
                   TS_ := systimestamp;
                   UUID_ := CRM.my_uuid;
                 IF DELETING THEN
                   SELECT API.ID INTO ID_API
                   FROM EDU.TBL_COURSE_CATEGORY_API API
                   WHERE API.COURSE_CATEGORY_id = :old.id;
                   
                   update EDU.tbl_COURSE_CATEGORY_api api
                   set  
                    api.COURSE_CATEGORY_id = null,
                    api.delete_date_ts = TS_,
                    api.deleted_COURSE_CATEGORY_id = :old.id
                    where api.id = ID_API;
                  END IF;
               END;
        
    create or replace procedure   EDU.UUID_COURSE_CATEGORY_API IS
           begin
             declare
               cursor c_t is
                       SELECT
                           mt.id as COURSE_CATEGORYID
                       FROM
                           edu.tbl_COURSE_CATEGORY mt
                           LEFT JOIN edu.tbl_COURSE_CATEGORY_api api ON mt.id = api.COURSE_CATEGORY_id
                       WHERE
                           api.COURSE_CATEGORY_id IS NULL
                       ORDER BY
                           COURSE_CATEGORYID ASC;
             begin
               for r_t in c_t loop
                       INSERT INTO edu.tbl_COURSE_CATEGORY_api(
                           id,
                           COURSE_CATEGORY_public_id,
                           create_date_ts,
                           COURSE_CATEGORY_id
                       )VALUES(
                           edu.SEQ_COURSE_CATEGORY_API.nextval,
                           crm.my_uuid,
                           systimestamp,
                           r_t."COURSE_CATEGORYID"
                       );
                end loop;
             end;
             commit;
           end;
   
       
       begin
       edu.UUID_COURSE_CATEGORY_API;
       end;    
    
    
------------------ TEAM ------------

    
       CREATE SEQUENCE  "EDU"."SEQ_TERM_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

         CREATE TABLE "EDU"."TBL_TERM_API" 
          (	"ID" NUMBER NOT NULL ENABLE, 
       	"TERM_ID" NUMBER, 
       	"TERM_PUBLIC_ID" NVARCHAR2(500), 
       	"TERM_EDIT_DATE" NVARCHAR2(20), 
       	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
       	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
       	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
       	"DESCRIPTION" NVARCHAR2(500), 
       	"DELETED_TERM_ID" NUMBER, 
       	 CONSTRAINT "TBL_TERM_API_PK" PRIMARY KEY ("ID")
         USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
         TABLESPACE "USERS"  ENABLE, 
       	 CONSTRAINT "TBL_TERM_API_FK1" FOREIGN KEY ("TERM_ID")
       	  REFERENCES "EDU"."TBL_TERM" ("ID") ENABLE
          ) SEGMENT CREATION DEFERRED 
         PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
         TABLESPACE "USERS" ;
       
         CREATE OR REPLACE TRIGGER "EDU"."TBL_TERM_API_TRG" 
       BEFORE INSERT ON EDU.TBL_TERM_API 
       FOR EACH ROW 
       BEGIN
         <<COLUMN_SEQUENCES>>
         BEGIN
           IF INSERTING AND :NEW.ID IS NULL THEN
             SELECT SEQ_TERM_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
           END IF;
         END COLUMN_SEQUENCES;
       END;
       /
       ALTER TRIGGER "EDU"."TBL_TERM_API_TRG" ENABLE;
       
       
       create or replace TRIGGER "EDU"."TBL_TERM_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_TERM
                     REFERENCING OLD AS OLD NEW AS NEW
                     FOR EACH ROW WHEN (1=1)
                     declare
                       TS_ TIMESTAMP(6);
                       UUID_ nvarchar2(500 char) ;
                     BEGIN
                         TS_ := systimestamp;
                         UUID_ := CRM.my_uuid;
                       if inserting then
                         insert into EDU.TBL_TERM_API
                         (id, TERM_public_id, create_date_ts, TERM_id)
                          values 
                           (EDU.SEQ_TERM_API.nextval, UUID_, TS_, :new.id);
                       end if;
                       if updating then
                         update EDU.TBL_TERM_API
                         set  
                          edit_date_ts = TS_, 
                          TERM_edit_date = :new.edit_date
                          where TERM_id = :old.id;
                         end if;
                     END;
           
          
     create or replace procedure   EDU.UUID_TERM_API IS
          begin
            declare
              cursor c_t is
                      SELECT
                          mt.id as TERMID
                      FROM
                          edu.tbl_TERM mt
                          LEFT JOIN edu.tbl_TERM_api api ON mt.id = api.TERM_id
                      WHERE
                          api.TERM_id IS NULL
                      ORDER BY
                          TERMID ASC;
            begin
              for r_t in c_t loop
                      INSERT INTO edu.tbl_TERM_api(
                          id,
                          TERM_public_id,
                          create_date_ts,
                          TERM_id
                      )VALUES(
                          edu.SEQ_TERM_API.nextval,
                          crm.my_uuid,
                          systimestamp,
                          r_t."TERMID"
                      );
               end loop;
            end;
            commit;
          end;  
           
           
          BEGIN
          EDU.UUID_TERM_API;
          END;   
       

------------------------------

   CREATE SEQUENCE  "EDU"."SEQ_PROFESSOR_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

     CREATE TABLE "EDU"."TBL_PROFESSOR_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"PROFESSOR_ID" NUMBER, 
   	"PROFESSOR_PUBLIC_ID" NVARCHAR2(500), 
   	"PERSON_ID" NUMBER, 
   	"PERSON_PUBLIC_ID" NVARCHAR2(500), 
   	"PROFESSOR_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DESCRIPTION" NVARCHAR2(500), 
   	"DELETED_PROFESSOR_ID" NUMBER, 
   	 CONSTRAINT "TBL_PEROFESSOR_API_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_PEROFESSOR_API_FK1" FOREIGN KEY ("PROFESSOR_ID")
   	  REFERENCES "EDU"."TBL_PROFESSOR" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_PEROFESSOR_API_FK2" FOREIGN KEY ("PERSON_ID")
   	  REFERENCES "CRM"."TBL_PERSON" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_PROFESSOR_API_TRG" 
   BEFORE INSERT ON EDU.TBL_PROFESSOR_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_PROFESSOR_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_PROFESSOR_API_TRG" ENABLE;


create or replace TRIGGER "EDU"."TBL_PROFESSOR_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_PROFESSOR
  REFERENCING OLD AS OLD NEW AS NEW
  FOR EACH ROW WHEN (1=1)
  declare
    TS_ TIMESTAMP(6);
    UUID_ nvarchar2(500 char) ;
    APIPUBLICID_ nvarchar2(500 char);
  BEGIN
      TS_ := systimestamp;
      UUID_ := CRM.my_uuid;
    if inserting then
      SELECT api.person_public_id INTO APIPUBLICID_
      FROM CRM.TBL_PERSON_API api
      WHERE api.person_id = :new.person_id;
      insert into EDU.tbl_PROFESSOR_api
      (id, PROFESSOR_public_id, create_date_ts,
        PROFESSOR_id, person_id, person_public_id)
       values 
        (EDU.SEQ_PROFESSOR_API.nextval, UUID_, TS_, 
        :new.id, :new.PERSON_ID, APIPUBLICID_);
    end if;
    if updating then
      update EDU.tbl_PROFESSOR_api
      set  
       edit_date_ts = TS_
       where PROFESSOR_id = :old.id;
      end if;
  END;
  
   create or replace TRIGGER "EDU"."TBL_PROFESSOR_API_D" BEFORE DELETE ON EDU.TBL_PROFESSOR
    REFERENCING OLD AS OLD NEW AS NEW
    FOR EACH ROW WHEN (1=1)
    declare
      TS_ TIMESTAMP(6);
      UUID_ nvarchar2(500 char) ;
      ID_API number;
    BEGIN
        TS_ := systimestamp;
        UUID_ := CRM.my_uuid;
      IF DELETING THEN
        SELECT api.ID INTO ID_API
        FROM EDU.TBL_PROFESSOR_API api
        WHERE api.PROFESSOR_id = :old.id;
        update EDU.tbl_PROFESSOR_api api
        set  
         api.PROFESSOR_id = null,
         api.delete_date_ts = TS_,
         api.deleted_PROFESSOR_id = :old.id,
         api.person_id = null
         where api.id = ID_API;
       END IF;
    END;
  
  
create or replace procedure   EDU.UUID_PROFESSOR_API IS
  begin
    declare
      cursor c_t is
              SELECT
                  mt.id as PROFESSORID,
                  mt.person_id as PERSONID,
                  secapi.person_public_id PERSONPUBLICID
              FROM
                  EDU.tbl_PROFESSOR mt
                  LEFT JOIN EDU.tbl_PROFESSOR_api api ON mt.id = api.PROFESSOR_id
                  LEFT JOIN CRM.tbl_person sect ON mt.person_id = sect.id
                  LEFT JOIN CRM.tbl_person_api secapi ON sect.id = secapi.person_id
              WHERE
                  api.PROFESSOR_id IS NULL
              ORDER BY
                  PROFESSORID ASC;
    begin
      for r_t in c_t loop
              INSERT INTO EDU.tbl_PROFESSOR_api(
                  id,
                  PROFESSOR_public_id,
                  create_date_ts,
                  PROFESSOR_id,
                  person_id,
                  person_public_id
              )VALUES(
                  EDU.SEQ_PROFESSOR_API.nextval,
                  crm.my_uuid,
                  systimestamp,
                  r_t."PROFESSORID",
                  r_t."PERSONID",
                  r_t."PERSONPUBLICID"
              );
       end loop;
    end;
    commit;
  end;

 begin
 edu.UUID_PROFESSOR_API;
 end;
 

------------------------------


   CREATE SEQUENCE  "EDU"."SEQ_COURSE_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    
     CREATE TABLE "EDU"."TBL_COURSE_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"COURSE_ID" NUMBER, 
   	"COURSE_PUBLIC_ID" NVARCHAR2(500), 
   	"COURSE_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DESCRIPTION" NVARCHAR2(500), 
   	"COURSE_CATEGORY_ID" NUMBER, 
   	"COURSE_CATEGORY_PUBLIC_ID" NVARCHAR2(500), 
   	"LEVEL_ID" NUMBER, 
   	"LEVEL_PUBLIC_ID" NVARCHAR2(500),
   	"DELETED_COURSE_ID" NUMBER,  
   	 CONSTRAINT "TBL_COURSE_API_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_COURSE_API_FK1" FOREIGN KEY ("COURSE_ID")
   	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_COURSE_API_FK2" FOREIGN KEY ("COURSE_CATEGORY_ID")
   	  REFERENCES "EDU"."TBL_COURSE_CATEGORY" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_COURSE_API_FK3" FOREIGN KEY ("LEVEL_ID")
   	  REFERENCES "EDU"."TBL_LEVEL" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_COURSE_API_TRG" 
   BEFORE INSERT ON EDU.TBL_COURSE_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_COURSE_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_COURSE_API_TRG" ENABLE;
   
   
create or replace TRIGGER "EDU"."TBL_COURSE_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_COURSE
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       APIPUBLICID_ nvarchar2(500 char); --CourseCategory
       APIIPUBLICID_ nvarchar2(500 char); --Level
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       if inserting then
         SELECT api.course_category_public_id INTO APIPUBLICID_
         FROM EDU.tbl_course_category_api api
         WHERE api.course_category_id = :new.course_category_id;
         --
         SELECT api.level_public_id INTO APIIPUBLICID_
         FROM EDU.tbl_LEVEl_api api
         WHERE api.level_id = :new.level_id;
         insert into EDU.tbl_COURSE_api
         (id, COURSE_public_id, create_date_ts,
           COURSE_id, course_category_id, course_category_public_id, level_id, level_public_id)
          values 
           (EDU.SEQ_COURSE_API.nextval, UUID_, TS_, 
           :new.id, :new.course_category_ID, APIPUBLICID_, :new.level_ID, APIIPUBLICID_);
       end if;
       if updating then
         update EDU.tbl_COURSE_api
         set  
          edit_date_ts = TS_
          where COURSE_id = :old.id;
         end if;
     END;
     
     
  create or replace TRIGGER "EDU"."TBL_COURSE_API_D" BEFORE DELETE ON EDU.TBL_COURSE
         REFERENCING OLD AS OLD NEW AS NEW
         FOR EACH ROW WHEN (1=1)
         declare
           TS_ TIMESTAMP(6);
           UUID_ nvarchar2(500 char) ;
           ID_API number;
         BEGIN
             TS_ := systimestamp;
             UUID_ := CRM.my_uuid;
           IF DELETING THEN
             SELECT api.ID INTO ID_API
             FROM EDU.TBL_COURSE_API api
             WHERE api.COURSE_id = :old.id;
             update EDU.tbl_COURSE_api api
             set  
              api.COURSE_id = null,
              api.delete_date_ts = TS_,
              api.deleted_COURSE_id = :old.id,
              api.course_category_id = null,
              api.level_id = null
              where api.id = ID_API;
            END IF;
         END;
     
     
   create or replace procedure   EDU.UUID_COURSE_API IS
       begin
         declare
           cursor c_t is
                   SELECT
                       mt.id as COURSEID,
                       mt.course_category_id as COURSECATEGORYID,
                       secapi.course_category_public_id COURSECATEGORYPUBLICID,
                       mt.level_id as LEVELID,
                       trdapi.level_public_id LEVELPUBLICID
                   FROM
                       EDU.tbl_COURSE mt
                       LEFT JOIN EDU.tbl_COURSE_api api ON mt.id = api.COURSE_id
                       LEFT JOIN EDU.tbl_course_category sect ON mt.course_category_id = sect.id
                       LEFT JOIN EDU.tbl_course_category_api secapi ON sect.id = secapi.course_category_id
                       LEFT JOIN EDU.tbl_level trdt ON mt.level_id = trdt.id
                       LEFT JOIN EDU.tbl_level_api trdapi ON trdt.id = trdapi.level_id
                   WHERE
                       api.COURSE_id IS NULL
                   ORDER BY
                       COURSEID ASC;
         begin
           for r_t in c_t loop
                   INSERT INTO EDU.tbl_COURSE_api(
                       id,
                       COURSE_public_id,
                       create_date_ts,
                       COURSE_id,
                       course_category_id,
                       course_category_public_id,
                       level_id,
                       level_public_id
                   )VALUES(
                       EDU.SEQ_COURSE_API.nextval,
                       crm.my_uuid,
                       systimestamp,
                       r_t."COURSEID",
                       r_t."COURSECATEGORYID",
                       r_t."COURSECATEGORYPUBLICID",
                       r_t."LEVELID",
                       r_t."LEVELPUBLICID"
                   );
            end loop;
         end;
         commit;
       end;   
  
   
    begin
    edu.UUID_COURSE_API;
    end;
   
-------------------------------


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
    	"DELETED_FIELD_ID" NUMBER,  
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


create or replace TRIGGER "EDU"."TBL_FIELD_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_FIELD
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       APIPUBLICID_ nvarchar2(500 char); --EDUCategory
       APIIPUBLICID_ nvarchar2(500 char); --Level
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       if inserting then
         SELECT api.edu_category_public_id INTO APIPUBLICID_
         FROM EDU.tbl_edu_category_api api
         WHERE api.edu_category_id = :new.category_id;
         --
         SELECT api.level_public_id INTO APIIPUBLICID_
         FROM EDU.tbl_LEVEl_api api
         WHERE api.level_id = :new.level_id;
         insert into EDU.tbl_FIELD_api
         (id, FIELD_public_id, create_date_ts, field_activity_status,
           FIELD_id, edu_category_id, edu_category_public_id, level_id, level_public_id)
          values 
           (EDU.SEQ_FIELD_API.nextval, UUID_, TS_, :new.activity_status,
           :new.id, :new.category_ID, APIPUBLICID_, :new.level_ID, APIIPUBLICID_);
       end if;
       if updating then
         update EDU.tbl_FIELD_api
         set  
          edit_date_ts = TS_,
          field_activity_status = :new.activity_status
          where FIELD_id = :old.id;
         end if;
     END;
     
     
    create or replace TRIGGER "EDU"."TBL_FIELD_API_D" BEFORE DELETE ON EDU.TBL_FIELD
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             ID_API number;
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             IF DELETING THEN
               SELECT api.ID INTO ID_API
               FROM EDU.TBL_FIELD_API api
               WHERE api.FIELD_id = :old.id;
               update EDU.tbl_FIELD_api api
               set  
                api.FIELD_id = null,
                api.delete_date_ts = TS_,
                api.deleted_FIELD_id = :old.id,
                api.edu_category_id = null,
                api.level_id = null
                where api.id = ID_API;
              END IF;
           END;
     
     
  create or replace procedure EDU.UUID_FIELD_API IS
         begin
           declare
             cursor c_t is
                     SELECT
                         mt.id as FIELDID,
                         mt.activity_status ACTIVITYSTATUS,
                         mt.category_id as EDUCATEGORYID,
                         secapi.edu_category_public_id EDUCATEGORYPUBLICID,
                         mt.level_id as LEVELID,
                         trdapi.level_public_id LEVELPUBLICID
                     FROM
                         EDU.tbl_FIELD mt
                         LEFT JOIN EDU.tbl_FIELD_api api ON mt.id = api.FIELD_id
                         LEFT JOIN EDU.tbl_edu_category sect ON mt.category_id = sect.id
                         LEFT JOIN EDU.tbl_edu_category_api secapi ON sect.id = secapi.edu_category_id
                         LEFT JOIN EDU.tbl_level trdt ON mt.level_id = trdt.id
                         LEFT JOIN EDU.tbl_level_api trdapi ON trdt.id = trdapi.level_id
                     WHERE
                         api.FIELD_id IS NULL
                     ORDER BY
                         FIELDID ASC;
           begin
             for r_t in c_t loop
                     INSERT INTO EDU.tbl_FIELD_api(
                         id,
                         FIELD_public_id,
                         create_date_ts,
                         field_activity_status,
                         FIELD_id,
                         edu_category_id,
                         edu_category_public_id,
                         level_id,
                         level_public_id
                     )VALUES(
                         EDU.SEQ_FIELD_API.nextval,
                         crm.my_uuid,
                         systimestamp,
                         r_t."ACTIVITYSTATUS",
                         r_t."FIELDID",
                         r_t."EDUCATEGORYID",
                         r_t."EDUCATEGORYPUBLICID",
                         r_t."LEVELID",
                         r_t."LEVELPUBLICID"
                     );
              end loop;
           end;
           commit;
         end;    
  
   
    begin
    edu.UUID_FIELD_API;
    end;


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
	"DELETE_DATE_TS" TIMESTAMP (6), 
    "PERIOD_EDIT_DATE" VARCHAR2(10 BYTE), 
    "FIELD_ID" NUMBER, 
    "FIELD_PUBLIC_ID" NVARCHAR2(500), 
    "DELETED_PERIOD_ID" NUMBER, 
	 CONSTRAINT "TBL_PERIOD_API_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "TBL_PERIOD_API_FK1" FOREIGN KEY ("PERIOD_ID")
	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE,
     CONSTRAINT "TBL_PERIOD_API_FK2" FOREIGN KEY ("FIELD_ID")
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


create or replace TRIGGER "EDU"."TBL_PERIOD_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_PERIOD
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       APIPUBLICID_ nvarchar2(500 char); --FIELD
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       if inserting then
         SELECT api.field_public_id INTO APIPUBLICID_
         FROM EDU.tbl_field_api api
         WHERE api.field_id = :new.field_id;
         --
         insert into EDU.tbl_PERIOD_api
         (id, PERIOD_public_id, create_date_ts, can_register_online,
           PERIOD_ID, field_id, field_public_id)
          values 
           (EDU.SEQ_PERIOD_API.nextval, UUID_, TS_, :new.can_register_online,
           :new.id, :new.field_ID, APIPUBLICID_);
       end if;
       if updating then
         update EDU.tbl_PERIOD_api
         set  
          edit_date_ts = TS_,
          can_register_online = :new.can_register_online
          where PERIOD_id = :old.id;
         end if;
     END;
     
     
create or replace TRIGGER "EDU"."TBL_PERIOD_API_D" BEFORE DELETE ON EDU.TBL_PERIOD
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             ID_API number;
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             IF DELETING THEN
               SELECT api.ID INTO ID_API
               FROM EDU.TBL_PERIOD_API api
               WHERE api.PERIOD_id = :old.id;
               update EDU.tbl_PERIOD_api api
               set  
                api.PERIOD_id = null,
                api.delete_date_ts = TS_,
                api.deleted_PERIOD_id = :old.id,
                api.field_id = null
                where api.id = ID_API;
              END IF;
           END;

     
     
        create or replace procedure EDU.UUID_PERIOD_API IS
           begin
             declare
               cursor c_t is
                       SELECT
                           mt.id as PERIODID,
                           mt.can_register_online CANREGISTERONLINE,
                           mt.field_id as FIELDID,
                           secapi.field_public_id FIELDPUBLICID
                       FROM
                           EDU.tbl_PERIOD mt
                           LEFT JOIN EDU.tbl_PERIOD_api api ON mt.id = api.PERIOD_id
                           LEFT JOIN EDU.tbl_field sect ON mt.field_id = sect.id
                           LEFT JOIN EDU.tbl_field_api secapi ON sect.id = secapi.field_id
                       WHERE
                           api.PERIOD_id IS NULL
                       ORDER BY
                           PERIODID ASC;
             begin
               for r_t in c_t loop
                       INSERT INTO EDU.tbl_PERIOD_api(
                           id,
                           PERIOD_public_id,
                           create_date_ts,
                           can_register_online,
                           PERIOD_id,
                           field_id,
                           field_public_id
                       )VALUES(
                           EDU.SEQ_PERIOD_API.nextval,
                           crm.my_uuid,
                           systimestamp,
                           r_t."CANREGISTERONLINE",
                           r_t."PERIODID",
                           r_t."FIELDID",
                           r_t."FIELDPUBLICID"
                       );
                end loop;
             end;
             commit;
           end;  
  
   
    begin
    edu.UUID_PERIOD_API;
    end;


// enable validity to user crm


------------------------------


   CREATE SEQUENCE  "EDU"."SEQ_PERIOD_COURSE_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

     CREATE TABLE "EDU"."TBL_PERIOD_COURSE_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"PERIOD_COURSE_ID" NUMBER, 
   	"PERIOD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
   	"PERIOD_ID" NUMBER, 
   	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
   	"COURSE_ID" NUMBER, 
   	"COURSE_PUBLIC_ID" VARCHAR2(500 BYTE), 
   	"PERIOD_COURSE_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6), 
   	"EDIT_DATE_TS" TIMESTAMP (6), 
   	"DELETE_DATE_TS" TIMESTAMP (6), 
   	"DESCRIPTION" NVARCHAR2(500),
   	"DELETED_PERIOD_COURSE_ID" NUMBER,  
   	 CONSTRAINT "TBL_PERIOD_COURSE_API_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_PERIOD_COURSE_API_FK1" FOREIGN KEY ("PERIOD_ID")
   	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_PERIOD_COURSE_API_FK2" FOREIGN KEY ("COURSE_ID")
   	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_PERIOD_COURSE_API_FK3" FOREIGN KEY ("PERIOD_COURSE_ID")
   	  REFERENCES "EDU"."TBL_PERIOD_COURSE" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_PERIOD_COURSE_API_TRG" 
   BEFORE INSERT ON EDU.TBL_PERIOD_COURSE_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_PERIOD_COURSE_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_PERIOD_COURSE_API_TRG" ENABLE;


create or replace TRIGGER "EDU"."TBL_PERIOD_COURSE_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_PERIOD_COURSE
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       APIPUBLICID_ nvarchar2(500 char); --PERIOD
       APIIPUBLICID_ nvarchar2(500 char); --COURSE
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       if inserting then
         SELECT api.period_public_id INTO APIPUBLICID_
         FROM EDU.tbl_PERIOD_api api
         WHERE api.period_id = :new.period_id;
         --
         SELECT api.course_public_id INTO APIIPUBLICID_
         FROM EDU.tbl_COURSE_api api
         WHERE api.course_id = :new.course_id;
         insert into EDU.tbl_PERIOD_COURSE_api
         (id, PERIOD_COURSE_public_id, create_date_ts,
           PERIOD_COURSE_id, period_id, period_public_id, course_id, course_public_id)
          values 
           (EDU.SEQ_PERIOD_COURSE_API.nextval, UUID_, TS_,
           :new.id, :new.period_ID, APIPUBLICID_, :new.course_ID, APIIPUBLICID_);
       end if;
       if updating then
         update EDU.tbl_PERIOD_COURSE_api
         set  
          edit_date_ts = TS_
          where PERIOD_COURSE_id = :old.id;
          --PERIOD
            if :new.PERIOD_ID != null and :new.PERIOD_ID != :old.PERIOD_ID THEN
                SELECT api.period_public_id INTO APIPUBLICID_
                 FROM EDU.tbl_PERIOD_api api
                 WHERE api.period_id = :new.period_id;
                --
                update EDU.tbl_PERIOD_COURSE_api
                set
                PERIOD_id = :new.PERIOD_id,
                PERIOD_public_id = APIPUBLICID_
                where PERIOD_COURSE_id = :old.id;
           end if;
           --COURSE
            if :new.COURSE_ID != null and :new.COURSE_ID != :old.COURSE_ID THEN
                SELECT api.COURSE_public_id INTO APIIPUBLICID_
                 FROM EDU.tbl_COURSE_api api
                 WHERE api.COURSE_id = :new.COURSE_id;
                --
                update EDU.tbl_PERIOD_COURSE_api
                set
                COURSE_id = :new.COURSE_id,
                COURSE_public_id = APIIPUBLICID_
                where PERIOD_COURSE_id = :old.id;
           end if;
         end if;
     END;
     
     
    create or replace TRIGGER "EDU"."TBL_PERIOD_COURSE_API_D" BEFORE DELETE ON EDU.TBL_PERIOD_COURSE
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             ID_API number;
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             IF DELETING THEN
               SELECT api.ID INTO ID_API
               FROM EDU.TBL_PERIOD_COURSE_API api
               WHERE api.PERIOD_COURSE_id = :old.id;
               update EDU.tbl_PERIOD_COURSE_api api
               set  
                api.PERIOD_COURSE_id = null,
                api.delete_date_ts = TS_,
                api.deleted_PERIOD_COURSE_id = :old.id,
                api.period_id = null,
                api.course_id = null
                where api.id = ID_API;
              END IF;
           END;
     
  create or replace procedure EDU.UUID_PERIOD_COURSE_API IS
         begin
           declare
             cursor c_t is
                     SELECT
                         mt.id as PERIODCOURSEID,
                         mt.period_id as PERIODID,
                         secapi.period_public_id PERIODPUBLICID,
                         mt.course_id as COURSEID,
                         trdapi.course_public_id COURSEPUBLICID
                     FROM
                         EDU.tbl_PERIOD_COURSE mt
                         LEFT JOIN EDU.tbl_PERIOD_COURSE_api api ON mt.id = api.PERIOD_COURSE_id
                         LEFT JOIN EDU.tbl_period sect ON mt.period_id = sect.id
                         LEFT JOIN EDU.tbl_period_api secapi ON sect.id = secapi.period_id
                         LEFT JOIN EDU.tbl_course trdt ON mt.course_id = trdt.id
                         LEFT JOIN EDU.tbl_course_api trdapi ON trdt.id = trdapi.course_id
                     WHERE
                         api.PERIOD_COURSE_id IS NULL
                     ORDER BY
                         PERIODCOURSEID ASC;
           begin
             for r_t in c_t loop
                     INSERT INTO EDU.tbl_PERIOD_COURSE_api(
                         id,
                         PERIOD_COURSE_public_id,
                         create_date_ts,
                         PERIOD_COURSE_id,
                         period_id,
                         period_public_id,
                         course_id,
                         course_public_id
                     )VALUES(
                         EDU.SEQ_PERIOD_COURSE_API.nextval,
                         crm.my_uuid,
                         systimestamp,
                         r_t."PERIODCOURSEID",
                         r_t."PERIODID",
                         r_t."PERIODPUBLICID",
                         r_t."COURSEID",
                         r_t."COURSEPUBLICID"
                     );
              end loop;
           end;
           commit;
         end;  
  
   
    begin
    edu.UUID_PERIOD_COURSE_API;
    end;


------------------------------


   CREATE SEQUENCE  "EDU"."SEQ_FIELD_COURSE_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
    
     CREATE TABLE "EDU"."TBL_FIELD_COURSE_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"FIELD_COURSE_ID" NUMBER, 
   	"FIELD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
   	"COURSE_ID" NUMBER, 
   	"COURSE_PUBLIC_ID" NVARCHAR2(500), 
   	"FIELD_ID" NUMBER, 
   	"FIELD_PUBLIC_ID" NVARCHAR2(500), 
   	"FIELD_COURSE_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DESCRIPTION" NVARCHAR2(500), 
   	"DELETED_FIELD_COURSE_ID" NUMBER,
   	"FIELD_COURSE_ACTIVITY_STATUS" NUMBER,
   	"FIELD_COURSE_DELETE_STATUS" NUMBER,
   	 CONSTRAINT "TBL_FIELD_COURSE_API_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_FIELD_COURSE_API_FK1" FOREIGN KEY ("FIELD_COURSE_ID")
   	  REFERENCES "EDU"."TBL_FIELD_COURSE" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_FIELD_COURSE_API_FK2" FOREIGN KEY ("COURSE_ID")
   	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_FIELD_COURSE_API_FK3" FOREIGN KEY ("FIELD_ID")
   	  REFERENCES "EDU"."TBL_FIELD" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_FIELD_COURSE_API_TRG" 
   BEFORE INSERT ON EDU.TBL_FIELD_COURSE_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_FIELD_COURSE_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_FIELD_COURSE_API_TRG" ENABLE;
   
   
create or replace TRIGGER "EDU"."TBL_FIELD_COURSE_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_FIELD_COURSE
       REFERENCING OLD AS OLD NEW AS NEW
       FOR EACH ROW WHEN (1=1)
       declare
         TS_ TIMESTAMP(6);
         UUID_ nvarchar2(500 char) ;
         APIPUBLICID_ nvarchar2(500 char); --FIELD
         APIIPUBLICID_ nvarchar2(500 char); --COURSE
       BEGIN
           TS_ := systimestamp;
           UUID_ := CRM.my_uuid;
         if inserting then
           SELECT api.field_public_id INTO APIPUBLICID_
           FROM EDU.tbl_field_api api
           WHERE api.field_id = :new.field_id;
           --
           SELECT api.course_public_id INTO APIIPUBLICID_
           FROM EDU.tbl_COURSE_api api
           WHERE api.course_id = :new.course_id;
           insert into EDU.tbl_FIELD_COURSE_api
           (id, FIELD_COURSE_public_id, create_date_ts,
             FIELD_COURSE_id, field_id, field_public_id, course_id, course_public_id,
             field_course_activity_status, field_course_delete_status)
            values 
             (EDU.SEQ_FIELD_COURSE_API.nextval, UUID_, TS_,
             :new.id, :new.field_ID, APIPUBLICID_, :new.course_ID, APIIPUBLICID_,
             :new.activity_status, :new.delete_status);
         end if;
         if updating then
           update EDU.tbl_FIELD_COURSE_api
           set  
            edit_date_ts = TS_
            where FIELD_COURSE_id = :old.id;
                --FIELD
                if :new.FIELD_ID != null and :new.FIELD_ID != :old.FIELD_ID THEN
                    SELECT api.FIELD_public_id INTO APIPUBLICID_
                     FROM EDU.tbl_FIELD_api api
                     WHERE api.FIELD_id = :new.FIELD_id;
                    --
                    update EDU.tbl_FIELD_COURSE_api
                    set
                    FIELD_id = :new.FIELD_id,
                    FIELD_public_id = APIPUBLICID_
                    where FIELD_COURSE_id = :old.id;
               end if;
               --COURSE
                if :new.COURSE_ID != null and :new.COURSE_ID != :old.COURSE_ID THEN
                    SELECT api.COURSE_public_id INTO APIIPUBLICID_
                     FROM EDU.tbl_COURSE_api api
                     WHERE api.COURSE_id = :new.COURSE_id;
                    --
                    update EDU.tbl_FIELD_COURSE_api
                    set
                    COURSE_id = :new.COURSE_id,
                    COURSE_public_id = APIIPUBLICID_
                    where FIELD_COURSE_id = :old.id;
               end if;
           end if;
       END;
       
 create or replace TRIGGER "EDU"."TBL_FIELD_COURSE_API_D" BEFORE DELETE ON EDU.TBL_FIELD_COURSE
        REFERENCING OLD AS OLD NEW AS NEW
        FOR EACH ROW WHEN (1=1)
        declare
          TS_ TIMESTAMP(6);
          UUID_ nvarchar2(500 char) ;
          ID_API number;
        BEGIN
            TS_ := systimestamp;
            UUID_ := CRM.my_uuid;
          IF DELETING THEN
            SELECT api.ID INTO ID_API
            FROM EDU.TBL_FIELD_COURSE_API api
            WHERE api.FIELD_COURSE_id = :old.id;
            update EDU.tbl_FIELD_COURSE_api api
            set  
             api.FIELD_COURSE_id = null,
             api.delete_date_ts = TS_,
             api.deleted_FIELD_COURSE_id = :old.id,
             api.field_course_activity_status = :new.activity_status,
             api.field_course_delete_status = :new.delete_status,
             api.field_id = null,
             api.course_id = null
             where api.id = ID_API;
           END IF;
        END;
       
       
 create or replace procedure EDU.UUID_FIELD_COURSE_API IS
            begin
              declare
                cursor c_t is
                        SELECT
                            mt.id as FIELDCOURSEID,
                            mt.activity_status as ACTIVITYSTATUS,
                            mt.delete_status as DELETESTATUS,
                            mt.field_id as FIELDID,
                            secapi.field_public_id FIELDPUBLICID,
                            mt.course_id as COURSEID,
                            trdapi.course_public_id COURSEPUBLICID
                        FROM
                            EDU.tbl_FIELD_COURSE mt
                            LEFT JOIN EDU.tbl_FIELD_COURSE_api api ON mt.id = api.FIELD_COURSE_id
                            LEFT JOIN EDU.tbl_field sect ON mt.field_id = sect.id
                            LEFT JOIN EDU.tbl_field_api secapi ON sect.id = secapi.field_id
                            LEFT JOIN EDU.tbl_course trdt ON mt.course_id = trdt.id
                            LEFT JOIN EDU.tbl_course_api trdapi ON trdt.id = trdapi.course_id
                        WHERE
                            api.FIELD_COURSE_id IS NULL
                        ORDER BY
                            FIELDCOURSEID ASC;
              begin
                for r_t in c_t loop
                        INSERT INTO EDU.tbl_FIELD_COURSE_api(
                            id,
                            FIELD_COURSE_public_id,
                            create_date_ts,
                            FIELD_COURSE_id,
                            field_course_activity_status,
                            field_course_delete_status,
                            field_id,
                            field_public_id,
                            course_id,
                            course_public_id
                        )VALUES(
                            EDU.SEQ_FIELD_COURSE_API.nextval,
                            crm.my_uuid,
                            systimestamp,
                            r_t."FIELDCOURSEID",
                            r_t."ACTIVITYSTATUS",
                            r_t."DELETESTATUS",
                            r_t."FIELDID",
                            r_t."FIELDPUBLICID",
                            r_t."COURSEID",
                            r_t."COURSEPUBLICID"
                        );
                 end loop;
              end;
              commit;
            end;     
    
     
      begin
      edu.UUID_FIELD_COURSE_API;
      end; 
      
      
 ---------------- TEAM --------------
 @@@
 
    CREATE SEQUENCE  "EDU"."SEQ_PERIOD_COURSE_PROFESSO_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
 
      CREATE TABLE "EDU"."TBL_PERIOD_COURSE_PROFESSO_API" 
       (	"ID" NUMBER NOT NULL ENABLE, 
    	"PERIOD_COURSE_PROFESSOR_ID" NUMBER, 
    	"PRIOD_COURS_PROFESOR_PUBLIC_ID" NVARCHAR2(500), 
    	"PERIOD_ID" NUMBER, 
    	"PERIOD_PUBLIC_ID" VARCHAR2(500 BYTE), 
    	"PERIOD_COURSE_ID" NUMBER, 
    	"PERIOD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
    	"COURSE_ID" NUMBER, 
    	"COURSE_PUBLIC_ID" NVARCHAR2(500), 
    	"PROFESSOR_ID" NUMBER, 
    	"PROFESSOR_PUBLIC_ID" NVARCHAR2(500), 
    	"PRIOD_COURS_PROFESOR_EDIT_DATE" NVARCHAR2(10), 
    	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
    	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
    	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
    	"DESCRIPTION" NVARCHAR2(20), 
    	"DELETED_PRIOD_CORS_PROFESOR_ID" NUMBER,
    	 CONSTRAINT "TBL_PERIOD_COURS_PROFESSOR_PK" PRIMARY KEY ("ID")
      USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
      TABLESPACE "USERS"  ENABLE
       ) SEGMENT CREATION DEFERRED 
      PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
      TABLESPACE "USERS" ;
    
      CREATE OR REPLACE TRIGGER "EDU"."TBL_PERIOD_COURSE_PROFESSO_AP" 
    BEFORE INSERT ON EDU.TBL_PERIOD_COURSE_PROFESSO_API 
    FOR EACH ROW 
    BEGIN
      <<COLUMN_SEQUENCES>>
      BEGIN
        IF INSERTING AND :NEW.ID IS NULL THEN
          SELECT SEQ_PERIOD_COURSE_PROFESSO_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
        END IF;
      END COLUMN_SEQUENCES;
    END;
    /
    ALTER TRIGGER "EDU"."TBL_PERIOD_COURSE_PROFESSO_AP" ENABLE;     
      
      
create or replace TRIGGER "EDU"."TBL_PERIOD_COURSE_PROFESSOR_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_PERIOD_COURSE_PROFESSOR
          REFERENCING OLD AS OLD NEW AS NEW
          FOR EACH ROW WHEN (1=1)
          declare
            TS_ TIMESTAMP(6);
            UUID_ nvarchar2(500 char) ;
            APIPUBLICID_ nvarchar2(500 char); --PERIOD
            ID_ number;
            APIIPUBLICID_ nvarchar2(500 char); --COURSE
            IID_ number;
            APIIIPUBLICID_ nvarchar2(500 char); --PERIODCOURSE
            APIVPUBLICID_ nvarchar2(500 char); --PROFESSOR
          BEGIN
              TS_ := systimestamp;
              UUID_ := CRM.my_uuid;
            if inserting then
              SELECT api.period_id, api.period_public_id INTO ID_, APIPUBLICID_
              FROM EDU.tbl_period_course_api api
              WHERE api.period_course_id = :new.period_course_id;
              --
              SELECT api.course_id, api.course_public_id INTO IID_, APIIPUBLICID_
              FROM EDU.tbl_period_course_api api
              WHERE api.period_course_id = :new.period_course_id;
              --
              SELECT api.period_course_public_id INTO APIIIPUBLICID_
              FROM EDU.tbl_period_course_api api
              WHERE api.period_course_id = :new.period_course_id;
              --
              SELECT api.professor_public_id INTO APIVPUBLICID_
              FROM EDU.tbl_professor_api api
              WHERE api.professor_id = :new.professor_id;
              --
              insert into EDU.tbl_PERIOD_COURSE_PROFESSO_api
              (id, PRIOD_COURS_PROFESOR_PUBLIC_ID, create_date_ts,
                period_course_professor_id, period_id, period_public_id, course_id, course_public_id,
                period_course_id, period_course_public_id, professor_id, professor_public_id)
               values 
                (EDU.SEQ_PERIOD_COURSE_PROFESSO_API.nextval, UUID_, TS_,
                :new.id, ID_, APIPUBLICID_, IID_, APIIPUBLICID_,
                :new.period_course_id, APIIIPUBLICID_, :new.professor_id, APIVPUBLICID_);
            end if;
            if updating then
              update EDU.tbl_PERIOD_COURSE_PROFESSO_api
              set  
               edit_date_ts = TS_
               where period_course_professor_id = :old.id;
                -- PERIODCOURSE
               if :new.period_COURSE_ID != null and :new.period_COURSE_ID != :old.period_COURSE_ID THEN
                    SELECT api.period_id, api.period_public_id INTO ID_, APIPUBLICID_
                    FROM EDU.tbl_period_course_api api
                    WHERE api.period_course_id = :new.period_course_id;
                    --
                    SELECT api.course_id, api.course_public_id INTO IID_, APIIPUBLICID_
                    FROM EDU.tbl_period_course_api api
                    WHERE api.period_course_id = :new.period_course_id;
                    --
                    SELECT api.period_course_public_id INTO APIIIPUBLICID_
                    FROM EDU.tbl_period_course_api api
                    WHERE api.period_course_id = :new.period_course_id;
                    --
                    update EDU.tbl_PERIOD_COURSE_PROFESSO_api
                    set
                    period_id = ID_,
                    period_public_id = APIPUBLICID_,
                    course_id = IID_,
                    course_public_id = APIIPUBLICID_,
                    period_course_id = :new.period_course_id,
                    period_course_public_id = APIIIPUBLICID_
                    where period_course_professor_id = :old.id;
               end if;
               -- PROFESSOR
               if :new.professor_ID != null and :new.professor_ID != :old.professor_ID THEN
                    SELECT api.professor_public_id INTO APIVPUBLICID_
                    FROM EDU.tbl_professor_api api
                    WHERE api.professor_id = :new.professor_id;
                    --
                    update EDU.tbl_PERIOD_COURSE_PROFESSO_api
                    set
                    professor_id = :new.professor_id,
                    professor_public_id = APIVPUBLICID_
                    where period_course_professor_id = :old.id;
               end if;
            end if;
          END;      
        
  create or replace TRIGGER "EDU"."TBL_PERIOD_COURSE_PROFESSOR_API_D" BEFORE DELETE ON EDU.tbl_period_course_professor
         REFERENCING OLD AS OLD NEW AS NEW
         FOR EACH ROW WHEN (1=1)
         declare
           TS_ TIMESTAMP(6);
           UUID_ nvarchar2(500 char) ;
           ID_API number;
         BEGIN
             TS_ := systimestamp;
             UUID_ := CRM.my_uuid;
           IF DELETING THEN
             SELECT api.ID INTO ID_API
             FROM EDU.TBL_PERIOD_COURSE_PROFESSO_API api
             WHERE api.period_course_professor_id = :old.id;
             update EDU.TBL_PERIOD_COURSE_PROFESSO_API api
             set
              api.PERIOD_COURSE_PROFESSOR_ID = null,  
              api.delete_date_ts = TS_,
              api.deleted_priod_cors_profesor_id = :old.id,
              api.period_id = null,
              api.course_id = null,
              api.period_course_id = null,
              api.professor_id=null
              where api.id = ID_API;
            END IF;
         END;  
        
  create or replace procedure EDU.UUID_PERIOD_COURSE_PROFESSOR_API IS
             begin
               declare
                 cursor c_t is
                          SELECT
                             mt.id as PERIODCOURSEPROFESSORID,
                             mt.period_course_id as PERIODCOURSEID,
                             secapi.period_course_public_id as PERIODCOURSEPUBLICID,
                             secapi.period_id as PERIODID,
                             secapi.period_public_id as PERIODPUBLICID,
                             secapi.course_id as COURSEID,
                             secapi.course_public_id as COURSEPUBLICID,
                             mt.professor_id as PROFESSORID,
                             trdapi.professor_public_id PROFESSORPUBLICID
                         FROM
                             EDU.tbl_PERIOD_COURSE_PROFESSOR mt
                             LEFT JOIN EDU.TBL_PERIOD_COURSE_PROFESSO_API api ON mt.id = api.period_course_professor_id
                             LEFT JOIN EDU.tbl_period_course sect ON mt.period_course_id = sect.id
                             LEFT JOIN EDU.tbl_period_course_api secapi ON sect.id = secapi.period_course_id
                             LEFT JOIN EDU.tbl_professor trdt ON mt.professor_id = trdt.id
                             LEFT JOIN EDU.tbl_professor_api trdapi ON trdt.id = trdapi.professor_id
                         WHERE
                             api.PERIOD_COURSE_PROFESSOR_id IS NULL
                         ORDER BY
                             PERIODCOURSEPROFESSORID ASC;
               begin
                 for r_t in c_t loop
                         INSERT INTO EDU.TBL_PERIOD_COURSE_PROFESSO_API(
                             id,
                             PRIOD_COURS_PROFESOR_PUBLIC_ID,
                             create_date_ts,
                             PERIOD_COURSE_PROFESSOR_ID,
                             period_course_id,
                             period_course_public_id,
                             period_id,
                             period_public_id,
                             course_id,
                             course_public_id,
                             professor_id,
                             professor_public_id
                         )VALUES(
                             EDU.SEQ_PERIOD_COURSE_PROFESSO_API.nextval,
                             crm.my_uuid,
                             systimestamp,
                             r_t."PERIODCOURSEPROFESSORID",
                             r_t."PERIODCOURSEID",
                             r_t."PERIODCOURSEPUBLICID",
                             r_t."PERIODID",
                             r_t."PERIODPUBLICID",
                             r_t."COURSEID",
                             r_t."COURSEPUBLICID",
                             r_t."PROFESSORID",
                             r_t."PROFESSORPUBLICID"
                         );
                  end loop;
               end;
               commit;
             end;         
   
     
      
       begin
       edu.UUID_PERIOD_COURSE_PROFESSOR_API;
       end;
       
       
  ---------------------- TEAM_PRESENTED_COURSE -------------
  
  
     CREATE SEQUENCE  "EDU"."SEQ_TERM_PRESENTED_COURSE_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
  
  ////////////////////// NO_NO_NO_NO_NO_NO ----------------->
       CREATE TABLE "EDU"."TBL_TERM_PRESENTED_COURSE_API" 
        (	"ID" NUMBER NOT NULL ENABLE, 
     	"TERM_PRESENTED_COURSE_ID" NUMBER, 
     	"TRM_PRESENTED_COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"TERM_ID" NUMBER, 
     	"TERM_PUBLIC_ID" NVARCHAR2(500), 
     	"FIELD_COURSE_ID" NUMBER, 
     	"FIELD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"PERIOD_ID" NUMBER, 
     	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
     	"COURSE_ID" NUMBER, 
     	"COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"PROFESSOR_ID" NUMBER, 
     	"PROFESSOR_PUBLIC_ID" NVARCHAR2(500), 
     	"TERM_PRESENTED_GROUP_ID" NUMBER, 
     	"TERM_PRESENTED_GROUP_PUBLIC_ID" NVARCHAR2(500), 
     	"TRM_PRESENTED_COURSE_EDIT_DATE" NVARCHAR2(10), 
     	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"DESCRIPTION" NVARCHAR2(500), 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE__PK" PRIMARY KEY ("ID")
       USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
       TABLESPACE "USERS"  ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK01" FOREIGN KEY ("TERM_PRESENTED_COURSE_ID")
     	  REFERENCES "EDU"."TBL_TERM_PRESENTED_COURSE" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK02" FOREIGN KEY ("TERM_PRESENTED_GROUP_ID")
     	  REFERENCES "EDU"."TBL_TERM_PRESENTED_GROUP" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK03" FOREIGN KEY ("TERM_ID")
     	  REFERENCES "EDU"."TBL_TERM" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK04" FOREIGN KEY ("FIELD_COURSE_ID")
     	  REFERENCES "EDU"."TBL_FIELD_COURSE" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK05" FOREIGN KEY ("PERIOD_ID")
     	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK06" FOREIGN KEY ("COURSE_ID")
     	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK07" FOREIGN KEY ("PROFESSOR_ID")
     	  REFERENCES "EDU"."TBL_PROFESSOR" ("ID") ENABLE
        ) SEGMENT CREATION DEFERRED 
       PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
       TABLESPACE "USERS" ;
     
       CREATE OR REPLACE TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API" 
     BEFORE INSERT ON EDU.TBL_TERM_PRESENTED_COURSE_API 
     FOR EACH ROW 
     BEGIN
       <<COLUMN_SEQUENCES>>
       BEGIN
         IF INSERTING AND :NEW.ID IS NULL THEN
           SELECT SEQ_TERM_PRESENTED_COURSE_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
         END IF;
       END COLUMN_SEQUENCES;
     END;
     /
     ALTER TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API" ENABLE;
  ////////////////////// <------------NO_NO_NO_NO_NO_NO
     
     
     
       CREATE TABLE "EDU"."TBL_TERM_PRESENTED_COURSE_API" 
        (	"ID" NUMBER NOT NULL ENABLE, 
     	"TERM_PRESENTED_COURSE_ID" NUMBER, 
     	"TRM_PRESENTED_COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"TERM_ID" NUMBER, 
     	"TERM_PUBLIC_ID" NVARCHAR2(500), 
     	"FIELD_COURSE_ID" NUMBER, 
     	"FIELD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"PERIOD_ID" NUMBER, 
     	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
     	"COURSE_ID" NUMBER, 
     	"COURSE_PUBLIC_ID" NVARCHAR2(500), 
     	"TRM_PRESENTED_COURSE_EDIT_DATE" NVARCHAR2(10), 
     	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
     	"DESCRIPTION" NVARCHAR2(500),
     	"DELETED_TERM_PRESENTED_COUR_ID" NUMBER, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE__PK" PRIMARY KEY ("ID")
       USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
       TABLESPACE "USERS"  ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK01" FOREIGN KEY ("TERM_PRESENTED_COURSE_ID")
     	  REFERENCES "EDU"."TBL_TERM_PRESENTED_COURSE" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK03" FOREIGN KEY ("TERM_ID")
     	  REFERENCES "EDU"."TBL_TERM" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK04" FOREIGN KEY ("FIELD_COURSE_ID")
     	  REFERENCES "EDU"."TBL_FIELD_COURSE" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK05" FOREIGN KEY ("PERIOD_ID")
     	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE, 
     	 CONSTRAINT "TBL_TERM_PRESENTED_COURSE_FK06" FOREIGN KEY ("COURSE_ID")
     	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE
        ) SEGMENT CREATION DEFERRED 
       PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
       TABLESPACE "USERS" ;
     
       CREATE OR REPLACE TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API" 
     BEFORE INSERT ON EDU.TBL_TERM_PRESENTED_COURSE_API 
     FOR EACH ROW 
     BEGIN
       <<COLUMN_SEQUENCES>>
       BEGIN
         NULL;
       END COLUMN_SEQUENCES;
     END;
     /
     ALTER TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API" ENABLE;
      

 create or replace TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_TERM_PRESENTED_COURSE
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             APIPUBLICID_ nvarchar2(500 char); --PERIOD
             APIIPUBLICID_ nvarchar2(500 char); --TERM
             APIIIPUBLICID_ nvarchar2(500 char); --FIELDCOURSE
             VD_ number;
             APIVPUBLICID_ nvarchar2(500 char); --COURSE
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             if inserting then
               SELECT api.period_public_id INTO APIPUBLICID_
               FROM EDU.tbl_period_api api
               WHERE api.period_id = :new.period_id;
               --
               SELECT api.term_public_id INTO APIIPUBLICID_
               FROM EDU.tbl_term_api api
               WHERE api.term_id = :new.term_id;
               --
               SELECT api.field_course_public_id INTO APIIIPUBLICID_
               FROM EDU.tbl_field_course_api api
               WHERE api.field_course_id = :new.field_course_id;
               --
               SELECT api.course_id, api.course_public_id INTO VD_, APIVPUBLICID_
               FROM EDU.tbl_field_course_api api
               WHERE api.field_course_id = :new.field_course_id;
               --
               insert into EDU.tbl_TERM_PRESENTED_COURSE_api
               (id, trm_presented_course_public_id, create_date_ts,
                 TERM_PRESENTED_COURSE_id, period_id, period_public_id, term_id, term_public_id,
                 field_course_id, field_course_public_id, course_id, course_public_id)
                values 
                 (EDU.SEQ_TERM_PRESENTED_COURSE_API.nextval, UUID_, TS_,
                 :new.id, :new.period_id, APIPUBLICID_, :new.term_id, APIIPUBLICID_,
                 :new.field_course_id, APIIIPUBLICID_, VD_, APIVPUBLICID_);
             end if;
             if updating then
               update EDU.tbl_TERM_PRESENTED_COURSE_api
               set  
                edit_date_ts = TS_
                where TERM_PRESENTED_COURSE_id = :old.id;
                 -- FIELDCOURSE, COURSE
                if :new.field_COURSE_ID != null and :new.field_COURSE_ID != :old.field_COURSE_ID THEN
                     SELECT api.field_course_public_id, api.course_id, api.course_public_id 
                             INTO APIIIPUBLICID_, VD_, APIVPUBLICID_
                     FROM EDU.tbl_field_course_api api
                     WHERE api.field_course_id = :new.field_course_id;
                     --
                     update EDU.tbl_TERM_PRESENTED_COURSE_api
                     set
                     field_course_id = :new.field_course_id,
                     field_course_public_id = APIIIPUBLICID_,
                     course_id = VD_,
                     course_public_id = APIVPUBLICID_
                     where TERM_PRESENTED_COURSE_id = :old.id;
                end if;
                -- PERIOD
                if :new.period_ID != null and :new.period_ID != :old.period_ID THEN
                     SELECT api.period_public_id INTO APIPUBLICID_
                     FROM EDU.tbl_period_api api
                     WHERE api.period_id = :new.period_id;
                     --
                     update EDU.tbl_TERM_PRESENTED_COURSE_api
                     set
                     period_id = :new.period_id,
                     period_public_id = APIPUBLICID_
                     where TERM_PRESENTED_COURSE_id = :old.id;
                end if;
                -- TERM
                if :new.term_ID != null and :new.term_ID != :old.term_ID THEN
                     SELECT api.term_public_id INTO APIIPUBLICID_
                     FROM EDU.tbl_term_api api
                     WHERE api.term_id = :new.term_id;
                     --
                     update EDU.tbl_TERM_PRESENTED_COURSE_api
                     set
                     term_id = :new.term_id,
                     term_public_id = APIIPUBLICID_
                     where TERM_PRESENTED_COURSE_id = :old.id;
                end if;
             end if;
           END;      

        
   create or replace TRIGGER "EDU"."TBL_TERM_PRESENTED_COURSE_API_D" BEFORE DELETE ON EDU.tbl_TERM_PRESENTED_COURSE
         REFERENCING OLD AS OLD NEW AS NEW
         FOR EACH ROW WHEN (1=1)
         declare
           TS_ TIMESTAMP(6);
           UUID_ nvarchar2(500 char) ;
           ID_API number;
         BEGIN
             TS_ := systimestamp;
             UUID_ := CRM.my_uuid;
           IF DELETING THEN
             SELECT api.ID INTO ID_API
             FROM EDU.TBL_TERM_PRESENTED_COURSE_API api
             WHERE api.TERM_PRESENTED_COURSE_id = :old.id;
             --
             update EDU.TBL_TERM_PRESENTED_COURSE_API api
             set  
              api.term_presented_course_id = null,
              api.delete_date_ts = TS_,
              api.deleted_TERM_PRESENTED_COUR_id = :old.id,
              api.term_id = null,
              api.period_id = null,
              api.field_course_id = null,
              api.course_id = null
              where api.id = ID_API;
            END IF;
         END;
            
  create or replace procedure EDU.UUID_TERM_PRESENTED_COURSE_API IS
               begin
                 declare
                   cursor c_t is
                            SELECT
                               mt.id as TERMPRESENTEDCOURSEID,
                               mt.period_id as PERIODID,
                               secapi.period_public_id as PERIODPUBLICID,
                               mt.term_id as TERMID,
                               trdapi.term_public_id as TERMPUBLICID,
                               mt.field_course_id as FIELDCOURSEID,
                               frthapi.field_course_public_id FIELDCOURSEPUBLICID,
                               frtht.course_id COURSEID,
                               frthapi.course_public_id COURSEPUBLICID
                           FROM
                               EDU.tbl_TERM_PRESENTED_COURSE mt
                               LEFT JOIN EDU.TBL_TERM_PRESENTED_COURSE_API api ON mt.id = api.TERM_PRESENTED_COURSE_id
                               LEFT JOIN EDU.tbl_period sect ON mt.period_id = sect.id
                               LEFT JOIN EDU.tbl_period_api secapi ON sect.id = secapi.period_id
                               LEFT JOIN EDU.tbl_term trdt ON mt.term_id = trdt.id
                               LEFT JOIN EDU.tbl_term_api trdapi ON trdt.id = trdapi.term_id
                               LEFT JOIN EDU.tbl_field_course frtht ON mt.field_course_id = frtht.id
                               LEFT JOIN EDU.tbl_field_course_api frthapi ON frtht.id = frthapi.field_course_id
                           WHERE
                               api.TERM_PRESENTED_COURSE_id IS NULL
                           ORDER BY
                               TERMPRESENTEDCOURSEID ASC;
                 begin
                   for r_t in c_t loop
                           INSERT INTO EDU.TBL_TERM_PRESENTED_COURSE_API(
                               id,
                               trm_presented_course_public_id,
                               create_date_ts,
                               TERM_PRESENTED_COURSE_ID,
                               period_id,
                               period_public_id,
                               term_id,
                               term_public_id,
                               field_course_id,
                               field_course_public_id,
                               course_id,
                               course_public_id
                           )VALUES(
                               EDU.SEQ_TERM_PRESENTED_COURSE_API.nextval,
                               crm.my_uuid,
                               systimestamp,
                               r_t."TERMPRESENTEDCOURSEID",
                               r_t."PERIODID",
                               r_t."PERIODPUBLICID",
                               r_t."TERMID",
                               r_t."TERMPUBLICID",
                               r_t."FIELDCOURSEID",
                               r_t."FIELDCOURSEPUBLICID",
                               r_t."COURSEID",
                               r_t."COURSEPUBLICID"
                           );
                    end loop;
                 end;
                 commit;
               end;           
   
     
      
       begin
       edu.UUID_TERM_PRESENTED_COURSE_API;
       end;     


------------------------- TEAM_PRESENTED_GROUP -------------

   CREATE SEQUENCE  "EDU"."SEQ_TERM_PRESENTED_GROUP_API"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;

////////////////////NO_NO_NO_NO---------------------------->
     CREATE TABLE "EDU"."TBL_TERM_PRESENTED_GROUP_API" 
      (	"ID" NUMBER NOT NULL ENABLE, 
   	"TERM_PRESENTED_GROUP_ID" NUMBER, 
   	"TERM_PRESENTED_GROUP_PUBLIC_ID" NVARCHAR2(500), 
   	"PROFESSOR_ID" NUMBER, 
   	"PROFESSOR_PUBLIC_ID" NVARCHAR2(500), 
   	"TERM_PRESENTED_COURSE_ID" NUMBER, 
   	"TRM_PRESENTED_COURSE_PUBLIC_ID" NVARCHAR2(500), 
   	"TERM_PRESENTED_GROUP_EDIT_DATE" NVARCHAR2(10), 
   	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
   	"DESCRIPTION" NVARCHAR2(500), 
   	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP_A_PK" PRIMARY KEY ("ID")
     USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
     TABLESPACE "USERS"  ENABLE, 
   	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK10" FOREIGN KEY ("PROFESSOR_ID")
   	  REFERENCES "EDU"."TBL_PROFESSOR" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK20" FOREIGN KEY ("TERM_PRESENTED_GROUP_ID")
   	  REFERENCES "EDU"."TBL_TERM_PRESENTED_GROUP" ("ID") ENABLE, 
   	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK30" FOREIGN KEY ("TERM_PRESENTED_COURSE_ID")
   	  REFERENCES "EDU"."TBL_TERM_PRESENTED_COURSE" ("ID") ENABLE
      ) SEGMENT CREATION DEFERRED 
     PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
     TABLESPACE "USERS" ;
   
      COMMENT ON COLUMN "EDU"."TBL_TERM_PRESENTED_GROUP_API"."TRM_PRESENTED_COURSE_PUBLIC_ID" IS 'fill with seperate method after generating public id for term_presented_course_api
   
   ';
   
     CREATE OR REPLACE TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_" 
   BEFORE INSERT ON EDU.TBL_TERM_PRESENTED_GROUP_API 
   FOR EACH ROW 
   BEGIN
     <<COLUMN_SEQUENCES>>
     BEGIN
       IF INSERTING AND :NEW.ID IS NULL THEN
         SELECT SEQ_TERM_PRESENTED_GROUP_API.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
       END IF;
     END COLUMN_SEQUENCES;
   END;
   /
   ALTER TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_" ENABLE;
////////////////////<------------------------------NO_NO_NO_NO


CREATE TABLE "EDU"."TBL_TERM_PRESENTED_GROUP_API" 
   (	"ID" NUMBER NOT NULL ENABLE, 
	"TERM_PRESENTED_GROUP_ID" NUMBER, 
	"TERM_PRESENTED_GROUP_PUBLIC_ID" NVARCHAR2(500), 
	"PROFESSOR_ID" NUMBER, 
	"PROFESSOR_PUBLIC_ID" NVARCHAR2(500), 
	"TERM_PRESENTED_COURSE_ID" NUMBER, 
	"TRM_PRESENTED_COURSE_PUBLIC_ID" NVARCHAR2(500), 
	"TERM_PRESENTED_GROUP_EDIT_DATE" NVARCHAR2(10), 
	"CREATE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	"EDIT_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	"DELETE_DATE_TS" TIMESTAMP (6) WITH TIME ZONE, 
	"DESCRIPTION" NVARCHAR2(500), 
	"TERM_ID" NUMBER, 
	"TERM_PUBLIC_ID" NVARCHAR2(500), 
	"FIELD_COURSE_ID" NUMBER, 
	"FIELD_COURSE_PUBLIC_ID" NVARCHAR2(500), 
	"PERIOD_ID" NUMBER, 
	"PERIOD_PUBLIC_ID" NVARCHAR2(500), 
	"COURSE_ID" NUMBER, 
	"COURSE_PUBLIC_ID" NVARCHAR2(500),
	"DELETED_TERM_PRESENTED_GROU_ID" NUMBER, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP_A_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK10" FOREIGN KEY ("PROFESSOR_ID")
	  REFERENCES "EDU"."TBL_PROFESSOR" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK20" FOREIGN KEY ("TERM_PRESENTED_GROUP_ID")
	  REFERENCES "EDU"."TBL_TERM_PRESENTED_GROUP" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK30" FOREIGN KEY ("TERM_PRESENTED_COURSE_ID")
	  REFERENCES "EDU"."TBL_TERM_PRESENTED_COURSE" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK40" FOREIGN KEY ("TERM_ID")
	  REFERENCES "EDU"."TBL_TERM" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK50" FOREIGN KEY ("FIELD_COURSE_ID")
	  REFERENCES "EDU"."TBL_FIELD_COURSE" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK60" FOREIGN KEY ("COURSE_ID")
	  REFERENCES "EDU"."TBL_COURSE" ("ID") ENABLE, 
	 CONSTRAINT "TBL_TERM_PRESENTED_GROUP__FK70" FOREIGN KEY ("PERIOD_ID")
	  REFERENCES "EDU"."TBL_PERIOD" ("ID") ENABLE
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;


   COMMENT ON COLUMN "EDU"."TBL_TERM_PRESENTED_GROUP_API"."TRM_PRESENTED_COURSE_PUBLIC_ID" IS 'fill with seperate method after generating public id for term_presented_course_api';


  CREATE OR REPLACE TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_" 
BEFORE INSERT ON EDU.TBL_TERM_PRESENTED_GROUP_API 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    NULL;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_" ENABLE;

 
   
create or replace TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_TERM_PRESENTED_GROUP
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             APIPUBLICID_ nvarchar2(500 char); --POFESSOR
             APIIPUBLICID_ nvarchar2(500 char); --PRESENTEDCOURSE
             IIID_ number;
             APIIIPUBLICID_ nvarchar2(500 char); --FIELDCOURSE
             VD_ number;
             APIVPUBLICID_ nvarchar2(500 char); --COURSE
             I5D_ number;
             API5PUBLICID_ nvarchar2(500 char); --TERM
             I6D_ number; 
             API6PUBLICID_ nvarchar2(500 char); --PERIOD
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             if inserting then
               --PROFESSOR
               SELECT api.professor_public_id INTO APIPUBLICID_
               FROM EDU.tbl_professor_api api
               WHERE api.professor_id = :new.professor_id;
               --TERMPRESENTEDCOURSE
               SELECT api.trm_presented_course_public_id INTO APIIPUBLICID_
               FROM EDU.tbl_term_presented_course_api api
               WHERE api.term_presented_course_id = :new.presented_course_id;
               --FIELDCOURSE
               SELECT api.field_course_id, api.field_course_public_id INTO IIID_, APIIIPUBLICID_
               FROM EDU.tbl_term_presented_course_api api
               WHERE api.term_presented_course_id = :new.presented_course_id;
               --COURSE
               SELECT api.course_id, api.course_public_id INTO VD_, APIVPUBLICID_
               FROM EDU.tbl_term_presented_course_api api
               WHERE api.term_presented_course_id = :new.presented_course_id;
               --TERM
               SELECT api.term_id, api.term_public_id INTO I5D_, API5PUBLICID_
               FROM EDU.tbl_term_presented_course_api api
               WHERE api.term_presented_course_id = :new.presented_course_id;
               --PERIOD
               SELECT api.period_id, api.period_public_id INTO I6D_, API6PUBLICID_
               FROM EDU.tbl_term_presented_course_api api
               WHERE api.term_presented_course_id = :new.presented_course_id;
               --
               insert into EDU.tbl_TERM_PRESENTED_GROUP_api
               (id, term_presented_group_public_id, create_date_ts,
                 TERM_PRESENTED_GROUP_id, professor_id, professor_public_id, term_presented_course_id, trm_presented_course_public_id,
                 field_course_id, field_course_public_id, course_id, course_public_id,
                 term_id, term_public_id, period_id, period_public_id)
                values 
                 (EDU.SEQ_TERM_PRESENTED_GROUP_API.nextval, UUID_, TS_,
                 :new.id, :new.professor_id, APIPUBLICID_, :new.presented_course_id, APIIPUBLICID_,
                 IIID_, APIIIPUBLICID_, VD_, APIVPUBLICID_,
                 I5D_, API5PUBLICID_, I6D_, API6PUBLICID_);
             end if;
             if updating then
               update EDU.tbl_TERM_PRESENTED_GROUP_api
               set  
                edit_date_ts = TS_
                where TERM_PRESENTED_GROUP_id = :old.id;
                -- PROFESSOR
                if :new.professor_ID != null and :new.professor_ID != :old.professor_ID THEN
                     SELECT api.professor_public_id INTO APIPUBLICID_
                     FROM EDU.tbl_professor_api api
                     WHERE api.professor_id = :new.professor_id;
                     --
                     update EDU.tbl_TERM_PRESENTED_GROUP_api
                     set
                     professor_id = :new.professor_id,
                     professor_public_id = APIPUBLICID_
                     where TERM_PRESENTED_GROUP_id = :old.id;
                end if;
                 -- TERMPRESENTEDCOURSE, FIELDCOURSE, COURSE, TERM, PERIOD
                if :new.presented_course_ID != null and :new.presented_course_ID != :old.presented_course_ID THEN
                     SELECT api.trm_presented_course_public_id, 
                            api.field_course_id, api.field_course_public_id, api.course_id, api.course_public_id,
                            api.term_id, api.term_public_id, api.period_id, api.period_public_id
                     INTO 
                            APIIPUBLICID_, 
                            IIID_, APIIIPUBLICID_, VD_, APIVPUBLICID_, 
                            I5D_, API5PUBLICID_, I6D_, API6PUBLICID_
                     FROM EDU.tbl_term_presented_course_api api
                     WHERE api.term_presented_course_id = :new.presented_course_id;
                     --
                     update EDU.tbl_TERM_PRESENTED_GROUP_api
                     set
                     term_presented_course_id = :new.presented_course_id,
                     trm_presented_course_public_id = APIIPUBLICID_,
                     field_course_id = IIID_,
                     field_course_public_id = APIIIPUBLICID_,
                     course_id = VD_,
                     course_public_id = APIVPUBLICID_,
                     term_id = I5D_,
                     term_public_id = API5PUBLICID_,
                     period_id = I6D_,
                     period_public_id = API6PUBLICID_
                     where TERM_PRESENTED_GROUP_id = :old.id;
                end if;
             end if;
           END;                    

     create or replace TRIGGER "EDU"."TBL_TERM_PRESENTED_GROUP_API_D" BEFORE DELETE ON EDU.tbl_TERM_PRESENTED_GROUP
           REFERENCING OLD AS OLD NEW AS NEW
           FOR EACH ROW WHEN (1=1)
           declare
             TS_ TIMESTAMP(6);
             UUID_ nvarchar2(500 char) ;
             ID_API number;
           BEGIN
               TS_ := systimestamp;
               UUID_ := CRM.my_uuid;
             IF DELETING THEN
               SELECT api.ID INTO ID_API
               FROM EDU.TBL_TERM_PRESENTED_GROUP_API api
               WHERE api.TERM_PRESENTED_GROUP_id = :old.id;
               --
               update EDU.TBL_TERM_PRESENTED_GROUP_API api
               set  
                api.TERM_PRESENTED_GROUP_id = null,
                api.delete_date_ts = TS_,
                api.deleted_term_presented_grou_id = :old.id,
                api.professor_id = null,
                api.term_presented_course_id = null,
                api.term_id = null,
                api.field_course_id = null,
                api.course_id = null,
                api.period_id = null
                where api.id = ID_API;
              END IF;
           END;
            
 --SEQ_TERM_PRESENTED_GROUP_API
        
 create or replace procedure EDU.UUID_TERM_PRESENTED_GROUP_API IS
               begin
                 declare
                   cursor c_t is
                            SELECT
                               mt.id as TERMPRESENTEDGROUPID,
                               mt.presented_course_id as TERMPRESENTEDCOURSEID,
                               fifthapi.trm_presented_course_public_id as TERMPRESENTEDCOURSEPUBLICID,
                               mt.professor_id as PROFESSORID,
                               sixthapi.professor_public_id as PROFESSORPUBLICID,
                               fifth.period_id as PERIODID,
                               fifthapi.period_public_id as PERIODPUBLICID,
                               fifth.term_id as TERMID,
                               trdapi.term_public_id as TERMPUBLICID,
                               fifth.field_course_id as FIELDCOURSEID,
                               frthapi.field_course_public_id FIELDCOURSEPUBLICID,
                               frthapi.course_id COURSEID,
                               seventhapi.course_public_id COURSEPUBLICID
                           FROM
                               EDU.tbl_TERM_PRESENTED_GROUP mt
                               LEFT JOIN EDU.TBL_TERM_PRESENTED_GROUP_API api ON mt.id = api.TERM_PRESENTED_GROUP_id
                               LEFT JOIN EDU.tbl_term_presented_course fifth ON mt.presented_course_id = fifth.id
                               LEFT JOIN EDU.tbl_term_presented_course_api fifthapi ON fifth.id = fifthapi.term_presented_course_id
                               LEFT JOIN EDU.tbl_professor sixth ON mt.professor_id = sixth.id
                               LEFT JOIN EDU.tbl_professor_api sixthapi ON sixth.id = sixthapi.professor_id
                               LEFT JOIN EDU.tbl_period sect ON fifth.period_id = sect.id
                               LEFT JOIN EDU.tbl_period_api secapi ON sect.id = secapi.period_id
                               LEFT JOIN EDU.tbl_term trdt ON fifth.term_id = trdt.id
                               LEFT JOIN EDU.tbl_term_api trdapi ON trdt.id = trdapi.term_id
                               LEFT JOIN EDU.tbl_field_course frth ON fifth.field_course_id = frth.id
                               LEFT JOIN EDU.tbl_field_course_api frthapi ON frth.id = frthapi.field_course_id
                               LEFT JOIN EDU.tbl_course seventh ON frth.course_id = seventh.id
                               LEFT JOIN EDU.tbl_course_api seventhapi ON seventh.id = seventhapi.course_id
                           WHERE
                               api.TERM_PRESENTED_GROUP_id IS NULL
                           ORDER BY
                               TERMPRESENTEDGROUPID ASC;
                 begin
                   for r_t in c_t loop
                           INSERT INTO EDU.TBL_TERM_PRESENTED_GROUP_API(
                               id,
                               term_presented_group_public_id,
                               create_date_ts,
                               TERM_PRESENTED_GROUP_ID,
                               term_presented_course_id,
                               trm_presented_course_public_id,
                               period_id,
                               period_public_id,
                               term_id,
                               term_public_id,
                               field_course_id,
                               field_course_public_id,
                               course_id,
                               course_public_id
                           )VALUES(
                               EDU.SEQ_TERM_PRESENTED_GROUP_API.nextval,
                               crm.my_uuid,
                               systimestamp,
                               r_t."TERMPRESENTEDGROUPID",
                               r_t."TERMPRESENTEDCOURSEID",
                               r_t."TERMPRESENTEDCOURSEPUBLICID",
                               r_t."PERIODID",
                               r_t."PERIODPUBLICID",
                               r_t."TERMID",
                               r_t."TERMPUBLICID",
                               r_t."FIELDCOURSEID",
                               r_t."FIELDCOURSEPUBLICID",
                               r_t."COURSEID",
                               r_t."COURSEPUBLICID"
                           );
                    end loop;
                 end;
                 commit;
               end;         
      
       begin
       edu.UUID_TERM_PRESENTED_GROUP_API;
       end; 


------------------------- STUDENT -------------


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
  	"DELETED_STUDENT_ID" NUMBER, 
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
  
  
create or replace TRIGGER "EDU"."TBL_STUDENT_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_STUDENT
  REFERENCING OLD AS OLD NEW AS NEW
  FOR EACH ROW WHEN (1=1)
  declare
    TS_ TIMESTAMP(6);
    UUID_ nvarchar2(500 char) ;
    APIPUBLICID_ nvarchar2(500 char);
  BEGIN
      TS_ := systimestamp;
      UUID_ := CRM.my_uuid;
    if inserting then
      SELECT api.person_public_id INTO APIPUBLICID_
      FROM CRM.TBL_PERSON_API api
      WHERE api.person_id = :new.person_id;
      insert into EDU.tbl_STUDENT_api
      (id, STUDENT_public_id, create_date_ts,
        STUDENT_id, person_id, person_public_id)
       values 
        (EDU.SEQ_STUDENT_API.nextval, UUID_, TS_, 
        :new.id, :new.PERSON_ID, APIPUBLICID_);
    end if;
    if updating then
      update EDU.tbl_STUDENT_api
      set  
       edit_date_ts = TS_
       where STUDENT_id = :old.id;
        -- PERSON
        if :new.person_ID != null and :new.person_ID != :old.person_ID THEN
             SELECT api.person_public_id INTO APIPUBLICID_
             FROM CRM.tbl_person_api api
             WHERE api.person_id = :new.person_id;
             --
             update EDU.tbl_STUDENT_api
             set
             person_id = :new.person_id,
             person_public_id = APIPUBLICID_
             where STUDENT_id = :old.id;
        end if;
    end if;
  END;
   
    create or replace TRIGGER "EDU"."TBL_STUDENT_API_D" BEFORE DELETE ON EDU.TBL_STUDENT
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       ID_API number;
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       IF DELETING THEN
         SELECT api.ID INTO ID_API
         FROM EDU.TBL_STUDENT_API api
         WHERE api.STUDENT_id = :old.id;
         --
         update EDU.tbl_STUDENT_api api
         set  
          api.STUDENT_id = null,
          api.delete_date_ts = TS_,
          api.deleted_STUDENT_id = :old.id,
          api.person_id = null
          where api.id = ID_API;
        END IF;
     END;
   
   
 create or replace procedure   EDU.UUID_STUDENT_API IS
   begin
     declare
       cursor c_t is
               SELECT
                   mt.id as STUDENTID,
                   mt.person_id as PERSONID,
                   secapi.person_public_id PERSONPUBLICID
               FROM
                   EDU.tbl_STUDENT mt
                   LEFT JOIN EDU.tbl_STUDENT_api api ON mt.id = api.STUDENT_id
                   LEFT JOIN CRM.tbl_person sect ON mt.person_id = sect.id
                   LEFT JOIN CRM.tbl_person_api secapi ON sect.id = secapi.person_id
               WHERE
                   api.STUDENT_id IS NULL
               ORDER BY
                   STUDENTID ASC;
     begin
       for r_t in c_t loop
               INSERT INTO EDU.tbl_STUDENT_api(
                   id,
                   STUDENT_public_id,
                   create_date_ts,
                   STUDENT_id,
                   person_id,
                   person_public_id
               )VALUES(
                   EDU.SEQ_STUDENT_API.nextval,
                   crm.my_uuid,
                   systimestamp,
                   r_t."STUDENTID",
                   r_t."PERSONID",
                   r_t."PERSONPUBLICID"
               );
        end loop;
     end;
     commit;
   end;
 
  begin
  edu.UUID_STUDENT_API;
  end; 
  
  
------------------------ REGISTER -------------


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
	"DELETED_REGISTER_ID" NUMBER, 
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


create or replace TRIGGER "EDU"."TBL_REGISTER_API_IU" AFTER INSERT OR UPDATE ON EDU.TBL_REGISTER
     REFERENCING OLD AS OLD NEW AS NEW
     FOR EACH ROW WHEN (1=1)
     declare
       TS_ TIMESTAMP(6);
       UUID_ nvarchar2(500 char) ;
       APIPUBLICID_ nvarchar2(500 char); --PERIOD
       APIIPUBLICID_ nvarchar2(500 char); --STUDENT
     BEGIN
         TS_ := systimestamp;
         UUID_ := CRM.my_uuid;
       if inserting then
         SELECT api.PERIOD_public_id INTO APIPUBLICID_
         FROM EDU.tbl_PERIOD_api api
         WHERE api.PERIOD_id = :new.PERIOD_id;
         --
         SELECT api.STUDENT_public_id INTO APIIPUBLICID_
         FROM EDU.tbl_STUDENT_api api
         WHERE api.STUDENT_id = :new.STUDENT_id;
         insert into EDU.tbl_REGISTER_api
         (id, REGISTER_public_id, create_date_ts,
           REGISTER_id, PERIOD_id, PERIOD_public_id, STUDENT_id, STUDENT_public_id,
           register_activity_status, register_delete_status)
          values 
           (EDU.SEQ_REGISTER_API.nextval, UUID_, TS_, 
           :new.id, :new.PERIOD_ID, APIPUBLICID_, :new.STUDENT_ID, APIIPUBLICID_,
           :new.delete_status, :new.activity_status);
       end if;
       if updating then
         update EDU.tbl_REGISTER_api
         set  
          edit_date_ts = TS_
          where REGISTER_id = :old.id;
            -- PERIOD
            if :new.period_ID != null and :new.period_ID != :old.period_ID THEN
                 SELECT api.period_public_id INTO APIPUBLICID_
                 FROM EDU.tbl_period_api api
                 WHERE api.period_id = :new.period_id;
                 --
                 update EDU.tbl_REGISTER_api
                 set
                 period_id = :new.period_id,
                 period_public_id = APIPUBLICID_
                 where register_id = :old.id;
            end if;
            -- STUDENT
            if :new.student_ID != null and :new.student_ID != :old.student_ID THEN
                 SELECT api.student_public_id INTO APIIPUBLICID_
                 FROM EDU.tbl_student_api api
                 WHERE api.student_id = :new.student_id;
                 --
                 update EDU.tbl_REGISTER_api
                 set
                 student_id = :new.student_id,
                 student_public_id = APIIPUBLICID_
                 where register_id = :old.id;
            end if;
            -- ACTIVITYSTATUS
            if :new.activity_status != null and :new.activity_status != :old.activity_status THEN
                 update EDU.tbl_REGISTER_api
                 set
                 register_activity_status = :new.activity_status
                 where register_id = :old.id;
            end if;
            -- DELETESTATUS
            if :new.delete_status != null and :new.delete_status != :old.delete_status THEN
                 update EDU.tbl_REGISTER_api
                 set
                 register_delete_status = :new.delete_status
                 where register_id = :old.id;
            end if;
         end if;
     END;
     
     
  create or replace TRIGGER "EDU"."TBL_REGISTER_API_D" BEFORE DELETE ON EDU.TBL_REGISTER
         REFERENCING OLD AS OLD NEW AS NEW
         FOR EACH ROW WHEN (1=1)
         declare
           TS_ TIMESTAMP(6);
           UUID_ nvarchar2(500 char) ;
           ID_API number;
         BEGIN
             TS_ := systimestamp;
             UUID_ := CRM.my_uuid;
           IF DELETING THEN
             SELECT api.ID INTO ID_API
             FROM EDU.TBL_REGISTER_API api
             WHERE api.REGISTER_id = :old.id;
             --
             update EDU.tbl_REGISTER_api api
             set  
              api.REGISTER_id = null,
              api.delete_date_ts = TS_,
              api.deleted_REGISTER_id = :old.id,
              api.period_id = null,
              api.register_id = null,
              api.register_activity_status = :new.delete_status,
              api.register_activity_status = :new.activity_status
              where api.id = ID_API;
            END IF;
         END;
     
     
 create or replace procedure   EDU.UUID_REGISTER_API IS
       begin
         declare
           cursor c_t is
                   SELECT
                       mt.id as REGISTERID,
                       mt.delete_status as REGISTERDELETESTATUS,
                       mt.activity_status as REGISTERACTIVITYSTATUS,
                       mt.PERIOD_id as PERIODID,
                       secapi.PERIOD_public_id PERIODPUBLICID,
                       mt.STUDENT_id as STUDENTID,
                       trdapi.student_public_id STUDENTPUBLICID
                   FROM
                       EDU.tbl_REGISTER mt
                       LEFT JOIN EDU.tbl_REGISTER_api api ON mt.id = api.REGISTER_id
                       LEFT JOIN EDU.tbl_PERIOD sect ON mt.period_id = sect.id
                       LEFT JOIN EDU.tbl_period_api secapi ON sect.id = secapi.period_id
                       LEFT JOIN EDU.tbl_student trdt ON mt.student_id = trdt.id
                       LEFT JOIN EDU.tbl_student_api trdapi ON trdt.id = trdapi.student_id
                   WHERE
                       api.REGISTER_id IS NULL
                   ORDER BY
                       REGISTERID ASC;
         begin
           for r_t in c_t loop
                   INSERT INTO EDU.tbl_REGISTER_api(
                       id,
                       REGISTER_public_id,
                       create_date_ts,
                       REGISTER_id,
                       PERIOD_id,
                       PERIOD_public_id,
                       STUDENT_id,
                       STUDENT_public_id,
                       register_delete_status,
                       register_activity_status
                   )VALUES(
                       EDU.SEQ_REGISTER_API.nextval,
                       crm.my_uuid,
                       systimestamp,
                       r_t."REGISTERID",
                       r_t."PERIODID",
                       r_t."PERIODPUBLICID",
                       r_t."STUDENTID",
                       r_t."STUDENTPUBLICID",
                       r_t."REGISTERDELETESTATUS",
                       r_t."REGISTERACTIVITYSTATUS"
                   );
            end loop;
         end;
         commit;
       end;     
  
   
    begin
    edu.UUID_REGISTER_API;
    end;

------------------------------




------------------------------




------------------------------



















































































































































































































































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