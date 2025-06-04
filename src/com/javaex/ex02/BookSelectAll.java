package com.javaex.ex02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSelectAll {

	public static void main(String[] args) {
		
		List<BookAuthorVO> aList = new ArrayList<BookAuthorVO>(); 

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
			//SQL문 준비
			String query = "";
			query += " select  au.author_name as author_name, ";
			query += " 		   au.author_desc as author_desc, ";
			query += "         au.author_id as author_id, ";
			query += "         b.title as title, ";
			query += "         b.pubs as pubs, ";
			query += "         b.book_id as book_id ";
			query += " from author au, book b ";
			query += " where au.author_id = b.author_id ";
			
			//바인딩
			pstmt = conn.prepareStatement(query);
			
			// 실행
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				//ResultSet 의 데이타를 자바의 변수에 담는다
				
				String authorName = rs.getString("author_name");
				String authorDesc = rs.getString("author_desc");
				int authorId = rs.getInt("author_id");
				String title = rs.getString("title");
				String pubs = rs.getString("pubs");
				int bookId = rs.getInt("book_id");
				
				//자바의 데이터를 VO로 묶는다
				
				BookAuthorVO bookauthorvo = new BookAuthorVO(authorName, authorDesc, authorId, title, 
						pubs, bookId);
				
				aList.add(bookauthorvo);
				
			}
			
			
			
			
		    // 4.결과처리

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
		    
		    
		    System.out.println("------------------------------------------------------------");
			
			
			
			System.out.println("------------------------------------------------------------");
			

		}

		
	}

}
