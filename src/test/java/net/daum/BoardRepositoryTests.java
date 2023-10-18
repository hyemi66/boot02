package net.daum;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import net.daum.dao.BoardRepository;
import net.daum.vo.BoardVO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {
	
	@Autowired // 자동 의존성 주입
	private BoardRepository boardRepo;
	
	@Test
	public void testInsertBoard() {
		BoardVO board = new BoardVO();
		
		board.setWriter("홍길동");
		board.setTitle("게시판 제목입니다");
		board.setContent("게시판 내용입니다");
		
		this.boardRepo.save(board); // 게시판 저장
	} // 게시판에 자료 저장(tbl_boards2테이블)
	
	@Test
	public void testReadBoard() {
		Optional<BoardVO> b = this.boardRepo.findById(2);
		System.out.println(b.toString()); // .toString()메소드 생략가능
	} // 게시판 읽기
	
	@Test
	public void testUpdateBoard() {
		Optional<BoardVO> eb = this.boardRepo.findById(2);
		
		eb.ifPresent(ebBoard -> {
			ebBoard.setWriter("수정홍길동");
			ebBoard.setTitle("수정 게시판 제목입니다");
			ebBoard.setContent("수정 게시판 내용입니다");
			
			System.out.println("2번 레코드의 작성자, 제목, 내용을 수정 -> ");
			this.boardRepo.save(ebBoard); // 게시판 수정
		});
	} // 게시판 수정
	
	@Test
	public void testDelBoard() {
		System.out.println("JPA 엔티티빈 레코드 삭제");
		this.boardRepo.deleteById(1);
	} // 게시판 삭제
	
}
