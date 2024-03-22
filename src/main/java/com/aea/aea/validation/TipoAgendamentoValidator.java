package com.aea.aea.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoAgendamentoValidator implements ConstraintValidator<TipoAgendamento, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("ENTRADA") || value.equals("SAIDA");
        // isso vai ter que mudar de acordo com oq escolhermos para a classe!!!!!!!!!!!!
    }

}
