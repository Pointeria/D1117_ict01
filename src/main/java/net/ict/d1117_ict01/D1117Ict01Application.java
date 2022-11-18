package net.ict.d1117_ict01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
//web-context 역할

@SpringBootApplication
@EnableJpaAuditing //D1117Ict01Application 구동 시 BaseEntity.java의 @EntityListeners를 활성화 시키는 설정
public class D1117Ict01Application {

    public static void main(String[] args) {
        SpringApplication.run(D1117Ict01Application.class, args);
    }

}
