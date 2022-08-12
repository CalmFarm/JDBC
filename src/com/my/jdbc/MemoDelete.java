package com.my.jdbc;

import java.sql.*;
import java.util.*;

public class MemoDelete {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("Index Number : ");
		String idx=sc.nextLine();
		//[1] 스캐너로 삭제할 글 번호를 입력받으세요
				//[2] DB에 연결해서 해당 글을 삭제 하는 프로그램을 작성하세요
				// delete문 작성해서 실행시키기
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?charactorEncoding=UTF-8";
		//프로토콜:dbms우형://호스트:포트/데이터베이스
		String user="root",pwd="726?E#uu[)[&1A";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		
		String sql="delete from memo where idx=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		
		pstmt.setString(1, idx);
		
		int n = pstmt.executeUpdate();
		System.out.println(n+"개 삭제 되었습니다.");
		pstmt.close();
		con.close();
	}

}
