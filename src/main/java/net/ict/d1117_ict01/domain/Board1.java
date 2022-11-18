package net.ict.d1117_ict01.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Board1 extends BaseEntity1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int num;

    @Column(length = 100, nullable = false)
    private String foodName;

    @Column(length = 100, nullable = false)
    private int price;

    @Column(length = 100, nullable = false)
    private String content;

    public void change(String new_foodName, int new_price) {
        this.foodName = new_foodName;
        this.price = new_price;
    }
}
