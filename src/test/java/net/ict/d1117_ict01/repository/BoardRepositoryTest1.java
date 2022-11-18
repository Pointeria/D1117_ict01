package net.ict.d1117_ict01.repository;

import lombok.extern.log4j.Log4j2;
import net.ict.d1117_ict01.domain.Board1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest1 {

    @Autowired
    private BoardRepository1 boardRepository;

    @Test
    public void insertTeset() {
        IntStream.rangeClosed(1,51).forEach(i -> {
            Board1 b1 = Board1.builder().
                    foodName("stake "+i).
                    price(i*1000).
                    content("content "+i).
                    build();
            Board1 result = boardRepository.save(b1);
            log.info("num " + result.getNum());
        });
    }

    @Test
    public void selectTest() {
        int num = 10;
        Optional<Board1> result = boardRepository.findById(num);
        Board1 board1 = result.orElseThrow();
        log.info(board1);
    }

    @Test
    public void updateTest() {
        int num = 1;
        Optional<Board1> result = boardRepository.findById(num);
        Board1 board1 = result.orElseThrow();
        board1.change("update", 999999);
        boardRepository.save(board1);
    }

    @Test
    public void deleteTest() {
        boardRepository.deleteAllById(Collections.singleton(2));
    }
}
