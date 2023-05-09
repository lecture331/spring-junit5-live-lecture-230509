package com.example.springjunit5livelecture230509.bankapp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/")
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("withdraw")
    public Account withdrawFromAccount(@RequestBody @Valid WithdrawRequestDto requestDto) {
        return bankService.withdrawFromAccount(requestDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity processValidationError(MethodArgumentNotValidException exception) throws JsonProcessingException {
        BindingResult bindingResult = exception.getBindingResult();

        StringBuilder builder = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            builder.append("{");
            builder.append(fieldError.getField());
            builder.append("}(은)는 ");
            builder.append(fieldError.getDefaultMessage());
            builder.append(" 입력된 값: {");
            builder.append(fieldError.getRejectedValue());
            builder.append("} ");
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(new ObjectMapper().writeValueAsString(new ExceptionResponseDto(builder.toString(), HttpStatus.BAD_REQUEST.value())));
    }
}
