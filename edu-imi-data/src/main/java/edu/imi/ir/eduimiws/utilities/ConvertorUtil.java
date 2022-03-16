package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.domain.BaseEntity;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
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
                System.out.println("later correct it");
            }
        }
        return object;
    }

    public <T> T makeCharacterSetPerson(T object) {

        for (Field field : object.getClass().getDeclaredFields()) {
            try {
                if (field.getType().isAssignableFrom(String.class)) {
                    String readValue = (String) FieldUtils.readDeclaredField(object, field.getName(), true);
                    if (readValue != null) {
                        String persianChar = readValue
                                .replaceAll("\u064A", "\u06CC")      //Y
                                .replaceAll("\u0643", "\u06A9");     //K
                        FieldUtils.writeDeclaredField(object, field.getName(), persianChar, true);
                    }
                }
            } catch (IllegalAccessException e) {
                System.out.println("later correct it");
            }
        }
        return object;
    }


    public Function<String, String> characterEncodingStringRequest = (String inputString) -> {
        String encodedString = null;
        if (inputString != null) {
            encodedString = inputString
                    .replaceAll("\u06CC", "\u064A")     //Y
                    .replaceAll("\u06A9", "\u0643");    //K
        }
        return encodedString;
    };


    public Function<String, String> characterEncodingStringRequestToPersian = (String inputString) -> {
        String encodedString = null;
        if (inputString != null) {
            encodedString = inputString
                    .replaceAll("\u064A", "\u06CC")     //Y
                    .replaceAll("\u0643", "\u06A9");    //K
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
