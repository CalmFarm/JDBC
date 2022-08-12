package com.my.jdbc;

import java.sql.*;
import java.sql.DriverManager;

public class MemoInsert {

	public static void main(String[] args) 
	throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?charactorEncoding=UTF-8";
		//프로토콜:dbms우형://호스트:포트/데이터베이스
		String user="root",pwd="726?E#uu[)[&1A";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		//db 연결
		
		String sql="insert into memo(name,msg,wdate) values('알파','베타',now())";
		Statement stmt=con.createStatement();
		//stmt.execute(sql); ==> 모든 sql문을 실행시키느 메서드
		//DML 문장 ( insert/update/delete)==> int executeUpdate(Stirng sql)
		int n = stmt.executeUpdate(sql);
		// n : sql문에 의해 영향받은 레코드 수를 반환
		System.out.println(n+"개의 메모글을 등록!");
		stmt.close();
		con.close();
	}//main
}//class