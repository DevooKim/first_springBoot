package com.example.domain.posts;

import com.example.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/*
Entity 클래스에서는 절대로 Setter를 생성하지 않는다
=> 해당 클래스의 인스턴스 값이 언제 어디서 변해야 하는지 코드상으로 명확하게 구분할 수가 없어
차후에 변경 시 복잡해진다.
해당 필드의 값 변경이 필요하면 목적과 의도를 나타낼 수 있는 메소드를 추가해야한다.
 */
@Getter
@NoArgsConstructor  //기본 생성자 자동 추가
@Entity //테이블과 링크될 클래스, 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭
public class Posts extends BaseTimeEntity {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //A.I
    private Long id;

    @Column(length = 500, nullable = false) //@Column은 생략 가능하지만 옵션을 변경할 때 사용한다.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder    //해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    //생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 있다.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
