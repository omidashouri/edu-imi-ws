package edu.imi.ir.eduimiws.mapper;

import org.mapstruct.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class MappingUtil {

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ProjectPublicIdToProjectDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BankPublicIdToBankDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ContactPublicIdToContactDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PersonPublicIdToPersonDto {
    }

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface ExpenseCodePublicIdToExpenseCodeApiDto {
    }


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

    @Qualifier
    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface GenerateEntityPublicId {
    }

}
