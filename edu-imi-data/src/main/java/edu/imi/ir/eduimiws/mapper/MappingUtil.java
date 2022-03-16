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


    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorIdFromSecurityContext {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface CreatorFromSecurityContext {
    }


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

}
