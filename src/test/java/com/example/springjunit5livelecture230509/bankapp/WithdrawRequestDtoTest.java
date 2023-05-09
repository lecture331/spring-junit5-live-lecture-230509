package com.example.springjunit5livelecture230509.bankapp;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WithdrawRequestDtoTest {
    @Test
    @DisplayName("성공 케이스")
    void test1() {
        // given - when
        WithdrawRequestDto requestDto = new WithdrawRequestDto("654-321", "4321", 80000);

        // then
        assertEquals("654-321", requestDto.getAccount());
        assertEquals("4321", requestDto.getPassword());
        assertEquals(80000, requestDto.getCash());
    }

    @Nested
    class Fail {
        @Test
        @DisplayName("cash 음수 입력")
        void test1() {
            // given
            WithdrawRequestDto requestDto = new WithdrawRequestDto("654-321", "4321", -1);

            // when
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<WithdrawRequestDto>> constraintViolations = validator.validate(requestDto);

            // then
            Assertions.assertThat(constraintViolations)
                    .extracting(ConstraintViolation::getMessage)
                    .containsOnly("1 이상의 숫자만 입력 가능합니다.");
        }

        @Test
        @DisplayName("비밀번호 공백")
        void test2() {
            // given
            WithdrawRequestDto requestDto = new WithdrawRequestDto("654-321", "", 80000);

            // when
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<WithdrawRequestDto>> constraintViolations = validator.validate(requestDto);

            // then
            Assertions.assertThat(constraintViolations)
                    .extracting(ConstraintViolation::getMessage)
                    .contains(new String[]{"size must be between 3 and 6", "비밀번호는 필수 입력값입니다."});
        }

    }

}