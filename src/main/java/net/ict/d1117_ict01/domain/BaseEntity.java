package net.ict.d1117_ict01.domain;

/*DB 테이블은 데이터가 추가되거나 수정된 시간등 테이블객체 변화에 대한 정보들을 저장 및 관리한다.
 자바에서 쉽게 처리하기 위해 @MappedSuperClass 이용해서 공통 컬럼을 지정하고 해당 클래스를 상속해 처리하도록 한다.
 */

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Getter
abstract class BaseEntity {

    @CreatedDate
    @Column(name="regdate", updatable = false)
    private LocalDate regDate;

    @LastModifiedDate
    @Column(name="moddate")
    private LocalDate modDate;

}
