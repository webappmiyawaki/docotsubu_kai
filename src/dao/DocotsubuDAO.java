package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import model.Mutter;

public class DocotsubuDAO {
	private final String URL = "jdbc:postgresql://localhost:5432/docotsubu";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "test";

	protected final String DRIVER_NAME = "org.postgresql.Driver";
	protected Connection conn;

    public Map<String,Mutter> toMutterAll(){
   		Map<String, Mutter> mutterList = new HashMap<>();
    	Mutter mutter = new Mutter();

    	try {
    		Class.forName(DRIVER_NAME);
    	} catch (ClassNotFoundException e) {
			e.printStackTrace();
    	}
    	try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    	        Statement stmt = conn.createStatement()){
	   		ResultSet rs=stmt.executeQuery("SELECT * FROM mutter");
	   		while(rs.next()) {
	   			mutterList.put(rs.getString("id"),
	   					Mutter.builder()
	   					.userName(rs.getString("name"))
	   					.text(rs.getString("text"))
	   					.build());
	   		}
    	} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return mutterList;
    }
}
