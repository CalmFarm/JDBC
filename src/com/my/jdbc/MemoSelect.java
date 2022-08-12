package com.my.jdbc;

import java.sql.*;

public class MemoSelect {

	public static void main(String[] args) throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/schooldb?charactorEncoding=UTF-8";
		//프로토콜:dbms우형://호스트:포트/데이터베이스
		String user="root",pwd="726?E#uu[)[&1A";
		
		Connection con = DriverManager.getConnection(url,user,pwd);
		String sql="select idx,name,msg,wdate from memo order by 1 desc";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//select 문 경우 : ResultSet executeQuery() 메서드 호출
		
		ResultSet rs=pstmt.executeQuery();
		//결과테이블 rs 가 참조한다.
		//ResultSet의 주요 메서드
		/* [1] boolean next() :
		 * [2] XXX getXXX("컬럼명")
		 * */
		while(rs.next()) {
			int idx=rs.getInt("idx");
			String name=rs.getString("name");
			String msg=rs.getString("msg");
			java.sql.Date wdate=rs.getDate("wdate");
			System.out.println(idx+"\t"+name+"\t"+msg+"\t"+wdate);
		}
		rs.close();
		pstmt.close();
		con.close();
	}//main
}//class