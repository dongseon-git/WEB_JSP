package com.pcwk.cmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class SawonDao implements WorkDiv<SawonVO> {
    final Logger LOG = Logger.getLogger(this.getClass());
	
    private PConnection pConnection;
    
	public SawonDao() {
		pConnection = new PConnection();
	}

	/**
	 * 총글수 
	 * @param dto
	 * @return 총건수 
	 */
	public int totalCount(DTO dto) {
		int totalCnt = 0;
		SearchVO  inVO = (SearchVO) dto;
		//-----------------------------------------------------------
		// JDBC연결
		// 1. JDBC DRIVER LOADING
		// 2. CONNECTION생성
		// 3. PreparedStatement 생성
		// 4. 쿼리 실행
		// 5. 쿼리 실행 결과 처리
		// 6. 자원 반납(CLOSE)
		//    --ResultSet
		//    --PreparedStatement
		//    --Connection
		//-----------------------------------------------------------
		
		Connection conn = null;//DB연결 정보
		PreparedStatement  pstmt = null;// SQL + 데이터
		ResultSet rs = null;//DB에서 전달된 정보 추출
		StringBuilder sb=new StringBuilder(50);
		
		//검색조건 처리
		StringBuilder sbWhere=new StringBuilder(50);
		
		
		//1. DB연결
		conn = pConnection.connect();
		//검색조건 : searchDiv(검색조건), searchWord(검색어)
		//"" : 전체
		//10 : 사번
		//20 : 이름
		//30 : 부서번호		
		
		if(null != inVO) {
			if(inVO.getSearchDiv().equals("30")) {
				sbWhere.append("WHERE deptno LIKE ? ||'%' ");
			}else if(inVO.getSearchDiv().equals("20")) {
				sbWhere.append("WHERE ename LIKE ? ||'%'  ");
			}else if(inVO.getSearchDiv().equals("10")) {
				sbWhere.append("WHERE empno LIKE ? ||'%'  ");
			}			
		}
		
		// 2. SQL작성
		sb.append(" SELECT COUNT(*) totalCnt \n");
		sb.append(" FROM sawon               \n");
		//조건절
		sb.append(  sbWhere.toString());
		
		LOG.debug("query: \n "+sb.toString());
		LOG.debug("param: "+inVO.toString());
		
		try {
			
			pstmt = conn.prepareStatement(sb.toString());
			if(null !=inVO && !inVO.getSearchDiv().equals("")) {//검색조건이 있으면
				pstmt.setString(1, inVO.getSearchWord());
			}
			
			// 4. SQL실행: ResultSet
			rs = pstmt.executeQuery();
			if(rs.next()) {
				totalCnt = rs.getInt("totalCnt");
			}
			
			LOG.debug("totalCnt: "+totalCnt);
		}catch(SQLException e) {
			LOG.debug("SQLException: "+e.getMessage());
			e.printStackTrace();
		}finally {
			//rs 자원반납
			JDBCUtil.close(rs);
			
			//pstmt 자원반납
			JDBCUtil.close(pstmt);
			
			//conn 자원반납
			JDBCUtil.close(conn);				
		}
		
		return totalCnt;
	}
	
	
	


	// 목록조회
	@Override
	public List<SawonVO> doRetrieve(DTO dto) {
		List<SawonVO> sawonList=new ArrayList<SawonVO>();
		SearchVO  inVO = (SearchVO) dto;
		
		//-----------------------------------------------------------
		// JDBC연결
		// 1. JDBC DRIVER LOADING
		// 2. CONNECTION생성
		// 3. PreparedStatement 생성
		// 4. 쿼리 실행
		// 5. 쿼리 실행 결과 처리
		// 6. 자원 반납(CLOSE)
		//    --ResultSet
		//    --PreparedStatement
		//    --Connection
		//-----------------------------------------------------------
		
		Connection conn = null;// DB연결 정보
		PreparedStatement pstmt = null;// SQL + 데이터
		ResultSet rs    = null;//DB에서 전달된 정보 추출
		StringBuilder  sb=new StringBuilder(300);
		
		//검색 조건 처리
		StringBuilder  sbWhere = new StringBuilder(100);
		
		// 1. DB연결
		conn = pConnection.connect();
		
		//검색조건 : searchDiv(검색조건), searchWord(검색어)
		//"" : 전체
		//10 : 사번
		//20 : 이름
		//30 : 부서번호
		if(null != inVO) {
			
			if(inVO.getSearchDiv().equals("30")) {
				sbWhere.append("WHERE deptno LIKE ? ||'%' ");
			}else if(inVO.getSearchDiv().equals("20")) {
				sbWhere.append("WHERE ename LIKE ? ||'%'  ");
			}else if(inVO.getSearchDiv().equals("10")) {
				sbWhere.append("WHERE empno LIKE ? ||'%'  ");
			}
				
		}
		
		
		// 2. SQL작성
		sb.append(" SELECT tt1.rnum as num,		                                      \n");
		sb.append("        tt1.empno,		                                          \n");
		sb.append("        tt1.ename,		                                          \n");
		sb.append("        TO_CHAR(tt1.hiredate,'YYYY/MM/DD') AS hiredate,		      \n");
		sb.append("        tt1.deptno		                                          \n");
		sb.append(" FROM (		                                                      \n");
		sb.append("         SELECT ROWNUM AS rnum,t1.*		                          \n");
		sb.append("         FROM (		                                              \n");
		sb.append("                 SELECT *		                                  \n");
		sb.append("                 FROM sawon		                                  \n");
		//조건절
		sb.append(sbWhere.toString());
		
		sb.append("                 --조건		                                      \n");
		sb.append("                 ORDER BY hiredate DESC		                      \n");
		sb.append("         )t1		                                                  \n");
		sb.append("         WHERE ROWNUM <=(?*(?-1)+?)	                              \n");
		sb.append(" )tt1		                                                      \n");
		sb.append(" WHERE rnum >=(?*(?-1)+1)		                                  \n");
		
		LOG.debug("query:\n"+sb.toString());
		LOG.debug("param:"+inVO.toString());
		try {
			pstmt = conn.prepareStatement(sb.toString());
			
			if(null !=inVO && !inVO.getSearchDiv().equals("")) {//검색조건이 있으면
				pstmt.setString(1, inVO.getSearchWord());
				pstmt.setInt(2, inVO.getPageSize());
				pstmt.setInt(3, inVO.getPageNum());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageSize());
				pstmt.setInt(6, inVO.getPageNum());				
				
			}else {//검색조건 전체
			
				pstmt.setInt(1, inVO.getPageSize());
				pstmt.setInt(2, inVO.getPageNum());
				pstmt.setInt(3, inVO.getPageSize());
				pstmt.setInt(4, inVO.getPageSize());
				pstmt.setInt(5, inVO.getPageNum());
			}
			
			
			
			// 4. SQL실행: ResultSet
			rs = pstmt.executeQuery();
			
			// 5. return 받은 ResultSet에서 DB에서 전달된 데이터 추출!
			while(rs.next()) {
				SawonVO outVO=new SawonVO();
				outVO.setNo(rs.getInt("num"));
				outVO.setEmpno(rs.getInt("empno"));
				outVO.setEname(rs.getString("ename"));
				outVO.setHiredate(rs.getString("hiredate"));
				outVO.setDeptno(rs.getInt("deptno"));
				
				sawonList.add(outVO);
			}
			
		}catch(SQLException e) {
			LOG.debug("SQLException:"+e.getMessage());
			e.printStackTrace();
		}finally {
			//rs 자원반납
			JDBCUtil.close(rs);
			
			//pstmt 자원반납
			JDBCUtil.close(pstmt);
			
			//conn 자원반납
			JDBCUtil.close(conn);	
		}
		
		
		return sawonList;
	}

	// insert
	@Override
	public int doSave(SawonVO dto) {
		int flag = 0;
		Connection conn = null;// DB연결 정보
		PreparedStatement pstmt = null;// sql+data
		StringBuilder sb = new StringBuilder(200);

		// 1. DB연결
		conn = pConnection.connect();

		// 2. SQL작성
		sb.append(" INSERT INTO sawon (  \n");
		sb.append("     empno,           \n");
		sb.append("     ename,           \n");
		sb.append("     hiredate,        \n");
		sb.append("     deptno           \n");
		sb.append(" ) VALUES (           \n");
		sb.append("     ?,               \n");
		sb.append("     ?,               \n");
		sb.append("     sysdate,         \n");
		sb.append("     ?                \n");
		sb.append(" )                    \n");
		LOG.debug(sb.toString());
		LOG.debug("param: " + dto.toString());

		// 3. param전달
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getEmpno()); // ?첫번째, int(사번)값을 넣어 주겠다.
			pstmt.setString(2, dto.getEname());// ?두번째, String(이름)값을 넣어 주겠다.
			pstmt.setInt(3, dto.getDeptno()); // ?세번째, int(부서번호)값을 넣어 주겠다.

			// 4. SQL실행
			flag = pstmt.executeUpdate();
			// 5. SQL실행결과
			LOG.debug("flag: " + flag);
		} catch (SQLException e) {
			LOG.debug("SQLException:" + e.getMessage());
			e.printStackTrace();
			// 6. 자원반납
		} finally {
			// pstmt 자원반납
			JDBCUtil.close(pstmt);

			// conn 자원반납
			JDBCUtil.close(conn);

		}

		return flag;
	}

	// delete
	@Override
	public int doDelete(SawonVO dto)  {
		int flag = 0;

		Connection conn = null;// DB연결 정보
		PreparedStatement pstmt = null;// SQL + 데이터
		StringBuilder sb = new StringBuilder(100);

		// 1. DB연결
		conn = pConnection.connect();
		
		// 2. SQL작성
		sb.append(" DELETE FROM sawon   \n");
		sb.append(" WHERE   empno = ?   \n");

		LOG.debug("query:\n" + sb.toString());
		LOG.debug("param: " + dto.toString());

		try {
			//트랜잭션 처리
			//conn.setAutoCommit(true);//트랜잭션 자동 commit
			
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getEmpno());
			// 4. SQL실행
			flag = pstmt.executeUpdate();
			// 5. SQL실행결과
			LOG.debug("flag: " + flag);
			
			//트랜잭션 처리
//			if(1==flag) {
//				conn.commit();
//			}else {
//				conn.rollback();
//			}
			
			
		} catch (SQLException e) {
			//conn.rollback();
			LOG.debug("SQLException:" + e.getMessage());
			e.printStackTrace();
		} finally {
			// pstmt 자원반납
			JDBCUtil.close(pstmt);

			// conn 자원반납
			JDBCUtil.close(conn);

		}

		return flag;
	}

	// 단건조회
	@Override
	public SawonVO doSelectOne(SawonVO dto) {
		SawonVO outVO = null;//return
		Connection conn = null;// DB연결 정보
		PreparedStatement pstmt = null;// SQL + 데이터
		ResultSet         rs    = null;//DB에서 전달된 정보 추출
		StringBuilder     sb    =new StringBuilder(50);
		
		// 1. DB연결
		conn = pConnection.connect();
		
		// 2. SQL작성
		
		sb.append(" SELECT empno,                                             \n");
	    sb.append("        ename,                                             \n");
	    sb.append("        TO_CHAR(hiredate,'YYYY/MM/DD HH24:MI:SS') hiredate,\n");
	    sb.append("        deptno                                             \n");
		sb.append(" FROM sawon                                                \n");
		sb.append(" WHERE empno = ?		                                      \n");
		
		LOG.debug("query: \n "+sb.toString());
		LOG.debug("param: "+dto.toString());
		
		try {
		
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getEmpno());
			
			// 4. SQL실행: ResultSet
			rs = pstmt.executeQuery();
			
			// 5. return 받은 ResultSet에서 DB에서 전달된 데이터 추출!
			if(rs.next()) {
				outVO = new SawonVO();
				outVO.setEmpno(rs.getInt("empno"));
				outVO.setEname(rs.getString("ename"));
				outVO.setHiredate(rs.getString("hiredate"));
				outVO.setDeptno(rs.getInt("deptno"));
			}
			
			LOG.debug("outVO:"+outVO);
			
		}catch(SQLException e) {
			LOG.debug("SQLException:"+e.getMessage());
		}finally {
			//rs 자원반납
			JDBCUtil.close(rs);
			
			//pstmt 자원반납
			JDBCUtil.close(pstmt);
			
			//conn 자원반납
			JDBCUtil.close(conn);
		}
		
		return outVO;
	}

	
	
	
	
	
	// update
	@Override
	public int doUpdate(SawonVO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}



















