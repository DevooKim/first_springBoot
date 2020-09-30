package com.example.web.dto;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test() {
        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name, amount);

        assertThat(dto.getName()).isEqualTo(name);  //assertj라는 테스트 검증 라이브러리의 검증 메소드
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
        Junit의 assertThat이 아닌 assertj의 assertThat을 사용
        assertj의 장점
        1. CoreMatchers와 달리 추가적인 라이브러리가 필요 없다
        2. 자동완성이 좀 ㅓㄷ 확실하게 지원된다.
        bit.ly/30vm9Lg 참고
         */
    }
}
