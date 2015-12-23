
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

	public void insert(BoardVo board){

		System.out.println("::board Insert Start");

		try{
			con = getConnection();

			if(board.getGroup_no()==0){
				String sql = 
						"insert "+
								"into board "+
								"values (board_no_seq.nextval,?,?,?,?,SYSDATE, board_no_seq.CURRVAL, ?, ? ,?)";
				System.out.println("::sql = " + sql);

				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getContents());
				pstmt.setLong(3, board.getUserVo().getNo());
				pstmt.setInt(4, 1);

				pstmt.setInt(5, 1);//orderno
				pstmt.setInt(6, board.getDepth());//depth

				pstmt.executeQuery();
			}else{
				String sql =
						"INSERT INTO board" +
								" VALUES (BOARD_NO_SEQ.nextVAL,?,?,?,?, SYSDATE,?, nvl((SELECT MAX(order_no) FROM BOARD),0)+1,?,?)";

				System.out.println("::sql = " + sql);

				//no, title, content memberno, cnt regdate,groupno,orderno,depth
				pstmt = con.prepareStatement(sql);

				pstmt.setString(1, board.getTitle());
				pstmt.setString(2, board.getContents());
				pstmt.setLong(3, board.getUserVo().getNo());
				pstmt.setInt(4, 0);
				pstmt.setInt(5, board.getGroup_no());
				pstmt.setInt(6, board.getDepth()+1);//depth

				pstmt.executeQuery();

			}

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



	public void delete(){}


	public void update(BoardVo vo){
		System.out.println("::board update Start");		
		try{
			con = getConnection();

			String sql="update board set title=?, content=? where no="+vo.getNo();

			System.out.println("::"+sql);

			System.out.println(vo.getTitle()+"/"+vo.getContents());

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContents());

			pstmt.executeQuery();

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
		System.out.println("::board update finish");
	}

	public void updateViewCnt(BoardVo vo){
		System.out.println("::board updateViewCnt s");
		try{
			con = getConnection();
			
			String sql="update board set view_cnt=? where no=?";
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, vo.getView_cnt() + 1);
			pstmt.setInt(2, vo.getNo());
			
			pstmt.executeQuery();

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
		System.out.println("::board updateViewCnt finish");
	}

	public BoardVo getView(int no){

		System.out.println("::board getView Start");
		BoardVo vo = null;
		try{
			con = getConnection();

			stmt = con.createStatement();

			String sql ="select no, title, contents, member_no, reg_date, "
					+ "group_no, order_no, depth "
					+ "from board where no="+no;

			rs = stmt.executeQuery(sql);

			while(rs.next()){
				int no1 = rs.getInt(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				int member_no = rs.getInt(4);
				String reg_date = rs.getString(5);
				int group_no = rs.getInt(6);
				int order_no = rs.getInt(7);
				int depth = rs.getInt(8);

				vo = new BoardVo();

				vo.setNo(no1);
				vo.setTitle(title);
				vo.setContents(contents);
				vo.setMember_no(member_no);
				vo.setReg_date(reg_date);
				vo.setGroup_no(group_no);
				vo.setOrder_no(order_no);
				vo.setDepth(depth);
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

		System.out.println("::board getView Finish");

		return vo;
	}

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
					+ "a.depth,"
					+ "to_char(a.reg_date, 'yyyy-mm-dd hh:mi:ss') "
					+ "FROM board a, member b "
					+ "WHERE a.member_no = b.no "
					+ "ORDER BY a.group_no desc , a.order_no asc";

			rs = stmt.executeQuery(sql);

			while(rs.next()){
				int no = rs.getInt(1);
				String title = rs.getString(2);
				int member_no = rs.getInt(3);
				String member_name = rs.getString(4);
				int view_cnt = rs.getInt(5);
				int depth = rs.getInt(6);
				String reg_date = rs.getString(7);

				BoardVo vo = new BoardVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setMember_no(member_no);
				vo.setMember_name(member_name);
				vo.setView_cnt(view_cnt);
				vo.setDepth(depth);
				vo.setReg_date(reg_date);

				list.add(vo);
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

		return list;
	}


	public List<BoardVo> getSearch(String kwd) {
		System.out.println("::board getSearch Start");

		List<BoardVo> list = new ArrayList<BoardVo>();

		try{
			con = getConnection();

			String sql = "SELECT "
					+ "b.no, b.title, b.member_no, m.name as memberName, b.view_cnt, b.reg_date "
					+ "FROM board b ,member m "
					+ "WHERE b.member_no = m.no "
					+ "AND b.title LIKE ? "; 


			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, "%"+kwd+"%");

			rs=pstmt.executeQuery();

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
				vo.setMember_name(member_name);
				vo.setView_cnt(view_cnt);
				vo.setReg_date(reg_date);

				list.add(vo);
			}

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

		System.out.println("::board getSearch Finish");

		return list;
	}
}
