package net.daum.dao;

import org.springframework.data.repository.CrudRepository;

import net.daum.vo.BoardVO;

public interface BoardRepository extends CrudRepository<BoardVO, Integer> {
	// CrudRepository<엔티티 빈클래스명, 빈클래스 유일 식별키 @Id로 선언된 변수명 자료형의 참조타입>
}
