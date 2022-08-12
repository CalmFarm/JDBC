package com.my.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.*;

public class MemoInsert2 {

	public static void main(String[] args) 
	throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("작성자 : ");
		String name=sc.nextLine();
		System.out.println("메모 내용: ");
		String msg=sc.nextLine();
		System.out.println(name+"/"+msg);
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?charactorEncoding=UTF-8";
		//프로토콜:dbms우형://호스트:포트/데이터베이스
		String user="root",pwd="726?E#uu[)[&1A";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		//PreparedStatement는 동적으로 바뀌는 값 부분을 인 파라미터(?)로 대치해서
		//sql문을 작성한다.			=> 인 파라미터를 제외한 sql문을 미리 컴파일해서 준비
		
		String sql="insert into memo(name,msg,wdate) values(?,?,now())";
		
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, name);
		pstmt.setString(2, msg);
		
		int n = pstmt.executeUpdate();
		
		System.out.println(n+"개의 레코드를 등록했습니다.");
		
		pstmt.close();
		con.close();
	}
}