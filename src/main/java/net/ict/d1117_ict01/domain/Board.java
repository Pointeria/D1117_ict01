package net.ict.d1117_ict01.domain;

import lombok.*;

import javax.persistence.*;

@Entity //=DB tbl_todo
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board extends BaseEntity {

    @Id            //tno가 auto incremenet설정돼 있으므로 GenerationType.IDENTITY 사용. ≒Oracle:squence
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bno;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 200, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String writer;

    //update는 insert, select 와 달리 별도 method 생성
    public void change(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
