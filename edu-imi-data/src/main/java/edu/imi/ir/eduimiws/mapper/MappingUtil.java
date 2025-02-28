package edu.imi.ir.eduimiws.mapper;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MappingUtil {

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface ProjectService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProjectPublicIdToProjectDto {
    }

//  ---

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface BankService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BankPublicIdToBankDto {
    }

//    ---

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface ContactService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ContactPublicIdToContactDto {
    }

//  ---

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface PersonService {
    }

//    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PersonPublicIdToPersonDto {
    }

//  ---


    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface SecurityUtil {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorIdFromSecurityContext {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorFromSecurityContextFakeDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorFullNameFromSecurityContext {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorFromSecurityContext {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PersonIdFromSecurityContext {
    }

//  ---

//    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface PublicIdUtil {
    }

//    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface GenerateEntityPublicId {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MelliTripleDesEncrypt {
    }


//    ---------------------------------------

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface ConvertorUtil {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface CharacterEncodingStringToPersian {
    }


//    ---------------------------------------


    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface ExpenseCodeService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExpenseCodePublicIdToExpenseCodeApiDto {
    }

    //    3.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ProjectPublicIdToExpenseCodePublicId {
    }

    //    4.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ProjectPublicIdToExpenseCodeApi {
    }


//    ---------------------------------------

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface AccountService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface AccountPublicIdToAccountDto {
    }


//    ---------------------------------------


    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface CompanyService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface ImiCompanyPublicId {
    }


//    ---------------------------------------

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface MessageApiUtil {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.CLASS)
    public @interface MessageIdToMessagePublicId {
    }


//    ---------------------------------------

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface PersonApiService {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PersonIdToPersonPublicId {
    }


//    ---------------------------------------

    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface CommonUtils {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ListStringToCommaSeparatorString {
    }

    //    3.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CommaSeparatorStringToListString {
    }


//    ---------------------------------------


    //    1.define Element Type for class
    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface DateConvertor {
    }

    //    2.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface JalaliDateFromLocalDateTime {
    }

    //    3.define Element Type for method
    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface TimeFromLocalDateTime {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface XMLGregorianCalendarToJalaliDate {
    }


//    ---------------------------------------

    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface DayOfWeekConverter {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface DayOfWeekByPersianName {
    }

//    ---------------------------------------

    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface RecordIoTypeConverter {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface RecordIoTypeByName {
    }


//    ---------------------------------------

    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface AcceptanceStateConverter {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface AcceptanceStateByName {
    }


//    ---------------------------------------

    @Qualifier
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.CLASS)
    public @interface IoSourceTypeConverter {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface IoSourceTypeByName {
    }


//    ---------------------------------------

}
