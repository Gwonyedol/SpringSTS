package dbquery;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class DbQuery {
	
	private DataSource dataSource; //connection 풀을 관리하기위한 객체
	
	public DbQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	
	//https://blog.outsider.ne.kr/6
	//JDBC 활용예제
	
	public int count() {
		Connection conn = null;
		try {
			conn = dataSource.getConnection(); //풀에서 구함
			try(Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery("select count(*) from MEMBER")){
				rs.next();
				return rs.getInt(1);
			}
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}finally {
			if(conn != null){
				try {
					conn.close(); //풀에 반
				}catch(SQLException e) {
					
				}
			}
		}
	}

}
