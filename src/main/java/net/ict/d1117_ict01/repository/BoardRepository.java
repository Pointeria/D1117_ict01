package net.ict.d1117_ict01.repository;

import net.ict.d1117_ict01.domain.Board;
import net.ict.d1117_ict01.repository.search.BoardSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/*Spring Data JPA를 이용한 JpaRepository 인터페이스를 통해 DB의 CRUD 처리 가능
* '타입'기반으로 '코드'를 이용하여 JPQL 쿼리를 생성하고 실행하는 Q도메인 클래스를 사용gksek. QBoard*/

public interface BoardRepository extends JpaRepository<Board, Long>, BoardSearch {

    @Query(value = "select now()", nativeQuery = true) //<-JPQL
    String getTime();
}
