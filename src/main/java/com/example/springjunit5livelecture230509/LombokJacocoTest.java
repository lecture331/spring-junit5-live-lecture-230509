package com.example.springjunit5livelecture230509;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LombokJacocoTest {
    private String test1;
    private String test2;
    private String test3;
    private String test4;
    private String test5;

    public void test1(String str) {
        if(this.test1.equals(str)){
            System.out.println("LombokJacocoTest.test1");
        }
    }
}
