package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@Component
@Slf4j
@MappingUtil.ConvertorUtil
public class ConvertorUtil {

    public <T> T makeEmptyValueNull(T object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String readValue = (String) FieldUtils.readDeclaredField(object, field.getName(), true);
                    if (readValue != null && readValue.isEmpty()) {
                        FieldUtils.writeDeclaredField(object, field.getName(), null, true);
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("later correct it > " + e.getMessage());
            }
        }
        return object;
    }

    /**
     * use 'persian' or 'db' for Type
     *
     * @param object
     * @param type
     * @param <T>,   String
     * @return <T>
     */
    public <T> T changeInstanceCharAndNumSetByType(T object, String type) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String fieldName = field.getName();
                    if (!fieldName.toUpperCase().contains("PUBLICID")) {
                        String readValue = (String) FieldUtils.readDeclaredField(object, fieldName, true);
                        if (readValue != null) {
                            String charSet;
                            if (type != null && type.equalsIgnoreCase("db")) {
                                charSet = getDbCharAndNum(readValue);
                            } else {
                                charSet = getPersianCharAndNum(readValue);
                            }
                            FieldUtils.writeDeclaredField(object, field.getName(), charSet, true);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("later correct it > " + e.getMessage());
            }
        }
        return object;
    }


    /**
     *  change to db char, used for mapper
     * @param object
     * @param <T>
     * @return <T>
     */
    public <T> T changeInstanceCharAndNumSetByTypeDb(T object) {
        return this.changeInstanceCharAndNumSetByType(object, "db");
    }

    public <T> T makeCharacterSetPersian(T object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String readValue = (String) FieldUtils.readDeclaredField(object, field.getName(), true);
                    if (readValue != null) {
                        String persianChar = getPersianChar(readValue);
                        FieldUtils.writeDeclaredField(object, field.getName(), persianChar, true);
                    }
                }
            } catch (IllegalAccessException e) {
                log.error("later correct it > " + e.getMessage());
            }
        }
        return object;
    }

    private String getPersianCharAndNum(String readValue) {
        String persianCharAndNum = this.getPersianNum(this.getPersianChar(readValue));
        return persianCharAndNum;
    }

    private String getPersianChar(String readValue) {
        String persianChar = readValue
                .replaceAll("\u064A", "\u06CC")      //Y
                .replaceAll("\u0643", "\u06A9");     //K
        return persianChar;
    }

    private String getPersianNum(String readValue) {
        String persianNum = readValue
                .replaceAll("0", "\u06F0")         //0
                .replaceAll("1", "\u06F1")         //1
                .replaceAll("2", "\u06F2")         //2
                .replaceAll("3", "\u06F3")         //3
                .replaceAll("4", "\u06F4")         //4
                .replaceAll("5", "\u06F5")         //5
                .replaceAll("6", "\u06F6")         //6
                .replaceAll("7", "\u06F7")         //7
                .replaceAll("8", "\u06F8")         //8
                .replaceAll("9", "\u06F9");        //9
        return persianNum;
    }


    public Function<String, String> characterEncodingInputStringForDb = (String inputString) -> {
        String encodedString = null;
        if (inputString != null) {
            encodedString = this.getDbCharAndNum(inputString);
        }
        return encodedString;
    };

    public String getDbCharAndNum(String readValue) {
        String dbCharAndNum = this.getDbNum(this.getDbChar(readValue));
        return dbCharAndNum;
    }

    private String getDbChar(String readValue) {
        String dbChar = readValue
                .replaceAll("\u06CC", "\u064A")    //Y
                .replaceAll("\u06A9", "\u0643");    //K
        return dbChar;
    }

    private String getDbNum(String inputString) {
        String dbNum = inputString
                .replaceAll("\u06F0", "0")         //0
                .replaceAll("\u06F1", "1")         //1
                .replaceAll("\u06F2", "2")         //2
                .replaceAll("\u06F3", "3")         //3
                .replaceAll("\u06F4", "4")         //4
                .replaceAll("\u06F5", "5")         //5
                .replaceAll("\u06F6", "6")         //6
                .replaceAll("\u06F7", "7")         //7
                .replaceAll("\u06F8", "8")         //8
                .replaceAll("\u06F9", "9");        //9
        return dbNum;
    }

    public Function<String, String> characterEncodingStringRequestToPersian = (String inputString) -> {
        String encodedString = null;
        if (inputString != null) {
            encodedString = this.getPersianCharAndNum(inputString);

/*                    inputString
                    .replaceAll("\u064A", "\u06CC")     //Y
                    .replaceAll("\u0643", "\u06A9")    //K
                    .replaceAll("0","\u06F0")         //0
                    .replaceAll("1","\u06F1")         //1
                    .replaceAll("2","\u06F2")         //2
                    .replaceAll("3","\u06F3")         //3
                    .replaceAll("4","\u06F4")         //4
                    .replaceAll("5","\u06F5")         //5
                    .replaceAll("6","\u06F6")         //6
                    .replaceAll("7","\u06F7")         //7
                    .replaceAll("8","\u06F8")         //8
                    .replaceAll("9","\u06F9");        //9*/
        }
        return encodedString;
    };

    @MappingUtil.CharacterEncodingStringToPersian
    public String CharacterEncodingStringToPersian(String input) {
        return this.characterEncodingStringRequestToPersian.apply(input);
    }

    /**
     * Find any key matching the value, in the given map.
     *
     * @param mapOrNull Any map, null is considered a valid value.
     * @param value     The value to be searched.
     * @param <K>       Type of the key.
     * @param <T>       Type of the value.
     * @return An optional containing a key, if found.
     */
    public <K, T> Optional<T> findKey(Map<K, T> mapOrNull, T value) {
        return Optional.ofNullable(mapOrNull)
                .flatMap(map -> map.entrySet()
                        .stream()
                        .filter(e -> Objects.equals(e.getKey(), value))
                        .map(Map.Entry::getValue)
                        .findAny());
    }

    /**
     * @param optionalString
     * @param elseValue
     * @return int
     */
    public int optionalStringToInt(Optional<String> optionalString, int elseValue) {
        return optionalString.filter(Objects::nonNull)
                .map(Integer::parseInt)
                .orElse(elseValue);
    }


    public Sort getSortFromQueryParam(Optional<String> sortQuery, String defaultParameter) {
        String sortParameter = null;
        String sortDirection = null;
        Sort.Direction direction = null;

        if (sortQuery.isPresent()) {
            String[] sortQueries = sortQuery.get()
                    .trim().split(",");

            if (sortQueries.length == 2) {
                sortParameter = sortQueries[0];
                sortDirection = sortQueries[1];
            }

            if (sortDirection != null && (sortDirection.equalsIgnoreCase("asc") ||
                    sortDirection.equalsIgnoreCase("desc")))
                direction = Sort.Direction.fromString(sortDirection);
        }

        if (Objects.isNull(direction))
            direction = Sort.DEFAULT_DIRECTION;

        if (Objects.isNull(sortParameter))
            sortParameter = defaultParameter;

        return Sort.by(direction, sortParameter);
    }

    public Pageable getPageableFromQueryParam(Map<String, String> queryParams, String defaultSortParameter) {
        Optional<String> page, size, sort;

        page = this.findKey(queryParams, "page");
        size = this.findKey(queryParams, "size");
        sort = this.findKey(queryParams, "sort");

        int pageInt = this.optionalStringToInt(page, 0);
        int sizeInt = this.optionalStringToInt(size, 20);

        return PageRequest.of(pageInt, sizeInt, this.getSortFromQueryParam(sort, defaultSortParameter));
    }

    public <T extends BaseEntity, K extends Long> K getIdFromEntity(T entity) {
        return (K) entity.getId();
    }

}
