package br.com.devspraticar.gestaousuario.controller.validator;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;
import java.util.function.Consumer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FieldValidator {

    public static <T> void validateAndUpdate(T fieldValue, Consumer<T> setter) {
        Optional.ofNullable(fieldValue)
            .filter(value -> StringUtils.isNotBlank(value.toString()))
            .ifPresent(setter);
    }

}