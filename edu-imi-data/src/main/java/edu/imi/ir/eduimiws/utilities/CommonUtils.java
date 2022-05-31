package edu.imi.ir.eduimiws.utilities;

import edu.imi.ir.eduimiws.exceptions.controllers.NotAcceptableException;
import edu.imi.ir.eduimiws.mapper.MappingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

@MappingUtil.CommonUtils
@Component
@Slf4j
public class CommonUtils {

    Predicate<String> isInputEqualValue(String value) {
        Predicate<String> stringPredicate = input -> input.equalsIgnoreCase(value);
        return stringPredicate;
    }

    public void nullInstanceFieldsForValues(Object instance, List values) {
        Field[] classFields = instance.getClass().getDeclaredFields();
        values.forEach(value->{
            Stream.of(classFields)
                    .peek(fld -> fld.setAccessible(true))
                    .filter(fld -> {
                        boolean fldCheck = false;
                        try {
                            if (Objects.nonNull(fld.get(instance)))
                                fldCheck = fld.get(instance).equals(value);
                        } catch (IllegalAccessException e) {
                            throw new NotAcceptableException(e.getMessage());
                        }
                        return fldCheck;
                    }).forEach(fld -> {
                try {
                    fld.set(instance, null);
                } catch (IllegalAccessException e) {
                    throw new NotAcceptableException(e.getMessage());
                }
            });
        });
    }


//    partitionBasedOnSize(list, 3)); [[1, 2, 3], [4, 5, 6], [7, 8, 9], [10]]
     public <T> Collection<List<T>> partitionBasedOnSize(List<T> inputList, int size) {
        final AtomicInteger counter = new AtomicInteger(0);
        return inputList.stream()
                .collect(Collectors.groupingBy(s -> counter.getAndIncrement()/size))
                .values();
    }

//    partitionBasedOnCondition(list, i -> i<6); [[6, 7, 8, 9, 10], [1, 2, 3, 4, 5]]
    public <T> Collection<List<T>> partitionBasedOnCondition(List<T> inputList, Predicate<T> condition) {
        return inputList.stream().collect(Collectors.partitioningBy(s-> (condition.test(s)))).values();
    }

    public <T> List<List<T>> convertCollectionListToListList(Collection<List<T>> inputCollection){
        return inputCollection.stream().collect(toCollection(ArrayList::new));
    }

//    todo: delete It Later
    public List<List<String>> partitionBasedOnCondition2(List<String> inputList, int size) {
        final AtomicInteger counter = new AtomicInteger(0);

         Collection<List<String>> collection = inputList.stream()
                .collect(Collectors.groupingBy(s -> counter.getAndIncrement()/size))
                 .values();

        List<List<String>> list = collection.stream().collect(toCollection(ArrayList::new));

        return null;
    }

//todo: delete it later
    public void methoda(){
        List<String> input = new ArrayList<>();
        int partitionSize = 10;

        Collection<List<String>> partitionedList = IntStream.range(0, input.size())
                .boxed()
                .collect(Collectors.groupingBy(partition -> (partition / partitionSize), Collectors.mapping(elementIndex -> input.get(elementIndex), Collectors.toList())))
                .values();
    }

    @MappingUtil.ListStringToCommaSeparatorString
    public String listStringToCommaSeparatorString(List<String> numbers) {
        return numbers.stream().collect(Collectors.joining(","));
    }

    @MappingUtil.CommaSeparatorStringToListString
    public List<String> stringCommaSeparatorToListString(String commaSeparateString) {
        return Arrays.stream(commaSeparateString.split(",")).collect(Collectors.toList());
    }
}
