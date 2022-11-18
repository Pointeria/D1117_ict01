package net.ict.d1117_ict01.repository;

import net.ict.d1117_ict01.domain.Board1;
import org.springframework.data.jpa.repository.JpaRepository;
/*Spring Data JPA를 이용한 JpaRepository 인터페이스를 통해 DB의 CRUD 처리 가능*/

public interface BoardRepository1 extends JpaRepository<Board1, Integer> {



}
