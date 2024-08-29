package com.farmstory.dao.community;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.farmstory.dto.community.BoardDTO;
import com.farmstory.dto.community.BoardFileDTO;
import com.farmstory.util.BOARDSQL;
import com.farmstory.util.DBHelper;

public class BoardDAO extends DBHelper {

	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private BoardDAO() {}
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 글 등록
	public int insertBoard(BoardDTO dto) {
		
		int no = 0;
		
		try {
			
			conn = getConnection();
			conn.setAutoCommit(false); // 데이터베이스 연결 객체 conn의 자동 커밋 기능을 비활성화하는 역할(트랜잭션)
			
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(BOARDSQL.INSERT_BOARD);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getB_contents());
			pstmt.setInt(3, dto.getB_fNo());
			pstmt.setString(4, dto.getB_regip());
			pstmt.setString(5, dto.getB_writer());
			pstmt.setString(6, dto.getB_cateNo());
			pstmt.executeUpdate();
			
			rs = stmt.executeQuery(BOARDSQL.SELECT_MAX_BOARD_NO);  // no의 auto-increment를 이용하여 가장 최신글은 no값이 가장 큰 것을 이용해서 글 번호를 가져옴
			
			if(rs.next()) {
				no = rs.getInt(1);
			}
			conn.commit();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
			
			try {
				conn.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage());
			}
			
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return no;
	}
	

	//	전체 게시물 갯수 구하기
	public int selectCountTotal() {
		
		int total = 0;
		
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(BOARDSQL.SELECT_COUNT_TOTAL);
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	//	전체 게시물 카테고리별 갯수 구하기
	public int selectCountTotalCate(String b_cateNo) {
		
		int total = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_COUNT_TOTAL_CATE);
			pstmt.setString(1, b_cateNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				total = rs.getInt(1);
			}
			
		}catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return total;
	}
	
	// 글 조회
	public BoardDTO selectBoard(String boardNo) {

		BoardDTO dto = null; // BoardDTO 선언
		List<BoardFileDTO> boardFiles = new ArrayList<>(); // 파일이 2개 생성된다고 생각하고 LIST
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_BOARD);
			pstmt.setString(1, boardNo);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				if(dto == null) {
					dto = new BoardDTO(); // BoardDTO 생성
					dto.setBoardNo(rs.getInt(1));
					dto.setB_cateNo(rs.getString(2));
					dto.setTitle(rs.getString(3));
					dto.setB_contents(rs.getString(4));
					dto.setB_comNo(rs.getInt(5));
					dto.setB_fNo(rs.getInt(6));
					dto.setB_hit(rs.getInt(7));
					dto.setB_regip(rs.getString(8));
					dto.setB_writer(rs.getString(9));
					dto.setB_rdate(rs.getString(10));
				}
				
				BoardFileDTO boardFileDTO = new BoardFileDTO();
				boardFileDTO.setB_fNo(rs.getInt(11));
				boardFileDTO.setB_pNo(rs.getInt(12));
				boardFileDTO.setB_oName(rs.getString(13));
				boardFileDTO.setB_sName(rs.getString(14));
				boardFileDTO.setB_rdate(rs.getString(15));
				boardFileDTO.setB_download(rs.getInt(16));
				boardFiles.add(boardFileDTO);
			}
			
			dto.setBoardFiles(boardFiles);
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	// 글 목록
	public List<BoardDTO> selectBoards(int start) {

		List<BoardDTO> boards = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_BOARDS);
			pstmt.setInt(1, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setBoardNo(rs.getInt(1));
				dto.setB_cateNo(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setB_contents(rs.getString(4));
				dto.setB_comNo(rs.getInt(5));
				dto.setB_fNo(rs.getInt(6));
				dto.setB_hit(rs.getInt(7));
				dto.setB_regip(rs.getString(8));
				dto.setB_writer(rs.getString(9));
				dto.setB_rdateSubString(rs.getString(10));
				dto.setNick(rs.getString(11));
				dto.setCommentCount(rs.getInt(12));
				
				boards.add(dto);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boards;
	}
	
	// 카테고리별 글 목록 
	public List<BoardDTO> selectBoardsCate(int start, String cate) {
		
		List<BoardDTO> boards = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_BOARDS_CATE);
			pstmt.setString(1, cate);
			pstmt.setInt(2, start);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setBoardNo(rs.getInt(1));
				dto.setB_cateNo(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setB_contents(rs.getString(4));
				dto.setB_comNo(rs.getInt(5));
				dto.setB_fNo(rs.getInt(6));
				dto.setB_hit(rs.getInt(7));
				dto.setB_regip(rs.getString(8));
				dto.setB_writer(rs.getString(9));
				dto.setB_rdateSubString(rs.getString(10));
				dto.setNick(rs.getString(11));
				dto.setCommentCount(rs.getInt(12));
				
				boards.add(dto);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return boards;
	}
	
	// 메인페이지 카테고리별 글 목록
	public List<BoardDTO> selectBoardsCateMain(String cate) {
		
		List<BoardDTO> boardcates = new ArrayList<>();
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(BOARDSQL.SELECT_BOARDS_CATE_MAIN);
			pstmt.setString(1, cate);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				dto.setBoardNo(rs.getInt(1));
				dto.setB_cateNo(rs.getString(2));
				dto.setTitle(rs.getString(3));
				dto.setB_fNo(rs.getInt(4));
				dto.setB_writer(rs.getString(5));
				dto.setB_rdateSubString(rs.getString(6));
				
				boardcates.add(dto);
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return boardcates;
	}
	
	// 글 수정
	public void updateBoard(BoardDTO dto) {
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(BOARDSQL.UPDATE_BOARD);
			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getB_contents());
			pstmt.setInt(3, dto.getB_fNo());
			pstmt.setString(4, dto.getB_regip());
			pstmt.setString(5, dto.getB_writer());
			pstmt.setInt(6, dto.getBoardNo());
			pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	// 글 삭제
	public void deleteBoard(String boardNo) {

		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(BOARDSQL.DELETE_BOARD);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// 글 목록 조회수 증가
	public void update_board_hit(String boardNo) {
		
		try {
			
			conn = getConnection();
			stmt = conn.createStatement();
			pstmt = conn.prepareStatement(BOARDSQL.UPDATE_BOARD_HIT);
			pstmt.setString(1, boardNo);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			try {
				closeAll();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
}
