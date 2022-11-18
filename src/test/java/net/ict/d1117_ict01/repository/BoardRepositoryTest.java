package net.ict.d1117_ict01.repository;

import lombok.extern.log4j.Log4j2;
import net.ict.d1117_ict01.domain.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class BoardRepositoryTest {

    //JPA를 이용한다는 것은 persistence context(Entity객체)와 DB를 동기화해서 관리한다는 것

    @Autowired
    private BoardRepository br;

    @Test
    public void insertTest() {
        IntStream.rangeClosed(1,101).forEach(i->{
            Board b = Board.builder().
                    title("title---------" + i).
                    content("content------"+i).
                    writer("user-------------"+(i%10)).
                    build();
            Board result = br.save(b);
            //save()결과는 DB 저장 데이터와 동기화된 Board Entity 객체를 반환 확인!
            log.info("BNO : " +result.getBno());
        });
    }

    @Test
    public void selectTest() {
        Long bno = 100L;
        Optional<Board> result = br.findById(bno);
        Board board = result.orElseThrow();
        log.info(board);
    }

    @Test
    public void updateTest() {  //update는 총 3번의 과정을 거친다.
        Long bno = 100L;
        Optional<Board> result = br.findById(bno);  //1. select
        Board board = result.orElseThrow();
        board.change("update.... title 100", "update content 100"); //2. update
        br.save(board); //3. save
    }

    @Test
    public void deleteTest() {
        Long bno = 1L;
        br.deleteById(bno);
    }

    @Test
    public void pageTest() {
        //1page order by bno desc          //= limit(0,10) oder by bno desc
        Pageable pageable = PageRequest.of(0,10, Sort.by("bno").descending());
        Page<Board> result = br.findAll(pageable);
        log.info("Total count : "  + result.getTotalElements());
        log.info("Total pages : "  + result.getTotalPages());
        log.info("page number : " + result.getNumber());
        log.info("page size : " + result.getSize());
        List<Board> list = result.getContent();
        list.forEach(board -> log.info(board));
    }

    @Test
    public void testSearch1() {
        Pageable pageable = PageRequest.of(1,10,Sort.by("bno").descending());
        br.search1(pageable);
    }

}

