package military;
import java.sql.*;
import java.util.*;
public class MilitaryDB {

	public static void main(String arg[]) {
		/* Retrieve DB authentication information */
		Scanner sc= new Scanner(System.in);
		
	
		DatabaseAuthInformation db_info= new DatabaseAuthInformation();
		db_info.parse_auth_info("auth/mysql.auth");
		
		/* Prepare the URL for DB connection */
		String db_connection_url= String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", db_info.getHost(),db_info.getPort(),db_info.getDatabase_name());
		
		
		
		
		/* create Soldier table, comment if you already created it */
		
	/*
		String soldier_create= "CREATE TABLE `militarydb`.`soldier` (\r\n"
				+ "  `mil_service_number` VARCHAR(20) NOT NULL,\r\n"
				+ "  `name` VARCHAR(45) NULL,\r\n"
				+ "  `joinArmy_date` DATE NULL,\r\n"
				+ "  `outArmy_date` DATE NULL,\r\n"
				+ "  PRIMARY KEY (`mil_service_number`));\r\n"
				+ "";
				
		

		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			Statement db_statement= db_connection.createStatement();
			db_statement.executeUpdate(soldier_create);
			
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		
		
		
		
		String soldier_insert= "insert into soldier VALUES (?, ?, ?, ?)";
		
		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			
			PreparedStatement Soldier= db_connection.prepareStatement(soldier_insert);
			
		
				System.out.println("-------------- insert values --------------");	
				Soldier.setString(1, "18-70010042");
				Soldier.setString(2, "유호성");
				Soldier.setString(3, "2018-7-23");
				Soldier.setString(4, "2020-6-4");	
				int result= Soldier.executeUpdate();	
				
				System.out.println("updated: "+ result ); 
				
				Soldier.setString(1, "18-70010034");
				Soldier.setString(2, "이찬영");
				Soldier.setString(3, "2018-9-3");
				Soldier.setString(4, "2020-3-4");
				result= Soldier.executeUpdate();	
				System.out.println("updated: "+ result );
				
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		*/
		System.out.print("조건값을 입력하세요:");
		String input = sc.next();
		
		String query_string_select="select name from soldier where mil_service_number =\"" + input +"\"";
		
		
		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			Statement db_statement= db_connection.createStatement();
			
			ResultSet result_set= db_statement.executeQuery(query_string_select);
				
			while(result_set.next()){		
				System.out.println(result_set.getString(1));
	
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}

		
	}

}
