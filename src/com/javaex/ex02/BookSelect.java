package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookSelect {

	public static void main(String[] args) {
		
		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
		    // 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");

		    // 2. Connection 얻어오기
			String url = "jdbc:mysql://localhost:3306/web_db";
			conn = DriverManager.getConnection(url, "web", "1234");

		    // 3. SQL문 준비 / 바인딩 / 실행
		    // sql문 준비
			String query = "";
			query += " select  book_id, ";
			query += "         title, ";
			query += "         pubs, ";
			query += "         pub_data, ";
			query += "         author_id ";
			query += " from book ";
			
			// 바인딩
			pstmt = conn.prepareStatement(query);
			
			//실행
			rs = pstmt.executeQuery();
			
		    // 4.결과처리
			//리스트에 담기
			
			
			// ResultSet의 데이터를 자바의 변수에 담기
			while(rs.next()) {
				
				int bookID = rs.getInt("book_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				String pubDate = rs.getString("pub_data");
				int authorId = rs.getInt("author_id");
				
				//자바의 데이터를 VO로 묶기
				BookVO bookVO = new BookVO(bookID, title, pubs, pubDate, authorId);
				
				System.out.println(bookVO.toString());
				
			}

		} catch (ClassNotFoundException e) {
		    System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
		    System.out.println("error:" + e);
		} finally {
		   
		    // 5. 자원정리
		    try {
		        if (rs != null) {
		            rs.close();
		        }                
		        if (pstmt != null) {
		            pstmt.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (SQLException e) {
		        System.out.println("error:" + e);
		    }

		}

	}

}
