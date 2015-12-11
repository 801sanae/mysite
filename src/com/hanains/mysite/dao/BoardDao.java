package com.hanains.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hanains.mysite.vo.BoardVo;

public class BoardDao {
	
	Connection con=null;
	PreparedStatement pstmt = null;
	Statement stmt = null;
	ResultSet rs = null;

	private Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			//1.드라이버 로딩
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		
			//2.커넥션 만들기(ORACLE DB)
			String dbURL  = "jdbc:oracle:thin:@localhost:1521:xe";
			connection = DriverManager.getConnection( dbURL, "webdb", "webdb" );
			
		} catch( ClassNotFoundException ex ){
			System.out.println( "드라이버 로딩 실패-" + ex );
		}
		
		return connection;
	}
	
	//TODO
	public void insert(BoardVo boardVo){
		
		System.out.println("::board Insert Start");
		
		try{
		con = getConnection();
		
		String sql = 
				"insert "+
				"into board "+
				"values (board_no_seq.nextval,?,?,?,?,SYSDATE)";
		
		System.out.println("::sql = " + sql);
		
		pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, boardVo.getTitle());
		pstmt.setString(2, boardVo.getContents());
		pstmt.setLong(3, boardVo.getUserVo().getNo());
/*		pstmt.setInt(4, boardVo.getView_cnt());*/
		pstmt.setInt(4, 1);
		pstmt.executeQuery();
		
		} catch( SQLException ex ) {
			System.out.println( "sql error:" + ex );
			ex.printStackTrace();
		} finally {
			//5. clear resources
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("::board Insert Finish");
	}
	//TODO
	public void delete(){}
	
	
	public void modify(){
		
	}
	//TODO
	public BoardVo getView(int no){
		BoardVo vo = null;
		try{
			con = getConnection();
			
			stmt = con.createStatement();
			
			String sql ="select no, title, content, member_no from board where no="+no;
			
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int no1 = rs.getInt(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				int member_no = rs.getInt(4);
				
				vo = new BoardVo();
				
				vo.setNo(no1);
				vo.setTitle(title);
				vo.setContents(content);
				vo.setMember_no(member_no);

			}
			
		}catch( SQLException ex ) {
			System.out.println( "sql error:" + ex );
			ex.printStackTrace();
		} finally {
			//5. clear resources
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("::board getList Finish");
		
		return vo;
	}
	
	//TODO
	public List<BoardVo> getList(){
		System.out.println("::board getList Start");
		List<BoardVo> list = new ArrayList<BoardVo>();
		
		try{
		
			con = getConnection();
			
			stmt = con.createStatement();
			
			String sql="SELECT "
					+ "a.no,"
					+ "a.title,"
					+ "a.member_no,"
					+ "b.name as member_name,"
					+ "a.view_cnt,"
					+ "to_char(a.reg_date, 'yyyy-mm-dd hh:mi:ss') "
					+ "FROM board a, member b "
					+ "WHERE a.member_no = b.no "
					+ "ORDER BY a.reg_date desc";
			
//			System.out.println(":::sql= " + sql);
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				int no = rs.getInt(1);
				String title = rs.getString(2);
				int member_no = rs.getInt(3);
				String member_name = rs.getString(4);
				int view_cnt = rs.getInt(5);
				String reg_date = rs.getString(6);
				
				BoardVo vo = new BoardVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setMember_no(member_no);
				vo.setView_cnt(view_cnt);

				list.add(vo);
			}
			
			System.out.println("::"+list);
		
		}catch( SQLException ex ) {
			System.out.println( "sql error:" + ex );
			ex.printStackTrace();
		} finally {
			//5. clear resources
			try{
				if( pstmt != null ) {
					pstmt.close();
				}
				if( con != null ) {
					con.close();
				}
			} catch( SQLException ex ) {
				ex.printStackTrace();
			}
		}
		
		System.out.println("::board getList Finish");
		
		return list;
	}
}
