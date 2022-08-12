package com.my.jdbc;
// JDBC : Java and DataBase Connectivity
// Java 언어 <== Driver[통역사] ==> DB sql 언어
// JDBC Driver를 다운로드받아야 한다.=> DBMS 마다 제공되는 드라이버는 다 다름
// xxx.jar 파일로 제공됨
import java.sql.*;

public class MemoCreate {

	public static void main(String[] args) {
		// 1. 드라이버 로딩
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			System.out.println("Driver Loading Success...");
			
		// 2. DB 연결
			String url="jdbc:mysql://localhost:3306/schooldb?charactorEncoding=UTF-8";
					//프로토콜:dbms우형://호스트:포트/데이터베이스
			String user="root",pwd="726?E#uu[)[&1A";
			
			Connection con = DriverManager.getConnection(url, user, pwd);
			System.out.println("DB연결 성공 !!");
		// 3. query문 작성하기	
			String sql =
			"create table if not exists memo("+
			"idx int auto_increment primary key,"+
			"name varchar(20) not null,"+
			"msg varchar(100),"+
			"wdate datetime default now() )";
			
		// 4. Statement 객체 얻어오기 ==> sql문을 실행시킬 수 있는 객체
			Statement smtm=con.createStatement();
			
		// 5. SQL문 실행시키기
			smtm.execute(sql);
			
		// 6. DB 연결자우너 해제
			smtm.close();
			System.out.println("Memo 테이블 생성 성공(테이블을 딱 한번만 생성 가능해요!!)");
			con.close();
		}catch(ClassNotFoundException e) {
			
			System.out.println("드라이버 로딩 실패 : " + e);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}//main
}//class