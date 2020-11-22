package bus_check;
import java.sql.*;
import java.util.*;
public class SearchBusTimeTable {

	public static void main(String arg[]) {
		/* Retrieve DB authentication information */
		Scanner sc= new Scanner(System.in);
		String nameofStartStation, nameofArriveStation;
		float timeInput;
		
		DatabaseAuthInformation db_info= new DatabaseAuthInformation();
		db_info.parse_auth_info("auth/mysql.auth");
		
		/* Prepare the URL for DB connection */
		String db_connection_url= String.format("jdbc:mysql://%s:%s/%s?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", db_info.getHost(),db_info.getPort(),db_info.getDatabase_name());
		
	
		String route_create= "CREATE TABLE route (\r\n"
				+ "  `RouteName` VARCHAR(20) NOT NULL,\r\n"
				+ "  `startStation` VARCHAR(20) NULL,\r\n"
				+ "  `arriveStation` VARCHAR(20) NULL,\r\n"
				+ "  PRIMARY KEY (`RouteName`));";
				
		String schedule_create ="CREATE TABLE busschedule (\r\n"
				+ "  `RouteName` VARCHAR(20) NOT NULL,\r\n"
				+ "  `day` VARCHAR(10) NULL,\r\n"
				+ "  `startTime` FLOAT NULL,\r\n"
				+ "  `arriveTime` FLOAT NULL,\r\n"
				+ "  `RouteCode` VARCHAR(10) NOT NULL,\r\n"
				+ "  PRIMARY KEY (`RouteName`, `RouteCode`));";
		
		String via_create = "CREATE TABLE via (\r\n"
				+ "  `RouteCode` VARCHAR(20) NOT NULL,\r\n"
				+ "  `StationName` VARCHAR(10) NULL,\r\n"
				+ "  `arriveTime` FLOAT NULL,\r\n"
				+ "  `startTime` FLOAT NULL,\r\n"
				+ "  PRIMARY KEY (`RouteCode`))"
				+ "  PRIMARY KEY (`StationName`));";
		
		
		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			Statement db_statement= db_connection.createStatement();
			db_statement.executeUpdate(route_create);
			db_statement.executeUpdate(schedule_create);
			db_statement.executeUpdate(via_create);
		}
		catch (SQLException e) {
			e.printStackTrace();	
		}
		
		
		
		String route_insert= "insert into route VALUES (?, ?, ?)";
		String via_insert= "insert into via VALUES (?,?,?,?)";
		String schedule_insert= "insert into busschedule VALUES (?, ?, ? , ? , ?)";
		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			
			PreparedStatement route= db_connection.prepareStatement(route_insert);
			PreparedStatement via= db_connection.prepareStatement(via_insert);
			PreparedStatement busschedule= db_connection.prepareStatement(schedule_insert);
				System.out.println("-------------- insert values --------------");	
				route.setString(1, "경부선");
				route.setString(2, "서울");
				route.setString(3, "부산");
				int result= route.executeUpdate();
				
				route.setString(1, "호남선");
				route.setString(2, "대전");
				route.setString(3, "목포");
				result= route.executeUpdate();
				
				route.setString(1, "호남선");
				route.setString(2, "대전");
				route.setString(3, "목포");
				result= route.executeUpdate();
				
				route.setString(1, "경인선");
				route.setString(2, "서울");
				route.setString(3, "인천");
				result= route.executeUpdate();
				
				route.setString(1, "경춘선");
				route.setString(2, "서울");
				route.setString(3, "춘천");
				result= route.executeUpdate();
				
				route.setString(1, "중앙선");
				route.setString(2, "서울");
				route.setString(3, "경주");
				result= route.executeUpdate();
				
				route.setString(1, "김포부산");
				route.setString(2, "김포");
				route.setString(3, "부산");
				result= route.executeUpdate();
				
				route.setString(1, "청주목포");
				route.setString(2, "청주");
				route.setString(3, "목포");
				result= route.executeUpdate();
				
				route.setString(1, "동대구청주");
				route.setString(2, "동대구");
				route.setString(3, "청주");
				result= route.executeUpdate();
				
				route.setString(1, "부산경주");
				route.setString(2, "부산");
				route.setString(3, "경주");
				result= route.executeUpdate();
					
	//-----------------------------------------------------------------------------------------------------			
			
				via.setString(1, "A");
				via.setString(2, "대구");
				via.setFloat(3, (float) 14.10);
				via.setFloat(4, (float) 14.30);
				result= via.executeUpdate();
				
				via.setString(1, "A");
				via.setString(2, "대전");
				via.setFloat(3, (float) 15.10);
				via.setFloat(4, (float) 15.30);
				result= via.executeUpdate();
				
				via.setString(1, "A");
				via.setString(2, "충주");
				via.setFloat(3, (float) 16.10);
				via.setFloat(4, (float) 17.30);
				result= via.executeUpdate();
				
				via.setString(1, "B");
				via.setString(2, "광주");
				via.setFloat(3, (float) 16.10);
				via.setFloat(4, (float) 17.30);
				result= via.executeUpdate();
				
				via.setString(1, "C");
				via.setString(2, "수원");
				via.setFloat(3, (float)12.00);
				via.setFloat(4, (float)12.30);
				result= via.executeUpdate();
				
				via.setString(1, "C");
				via.setString(2, "성남");
				via.setFloat(3, (float)14.00 );
				via.setFloat(4, (float)14.30);
				result= via.executeUpdate();
				
				via.setString(1, "D");
				via.setString(2, "고양");
				via.setFloat(3, (float)8.00 );
				via.setFloat(4, (float)8.30 );
				result= via.executeUpdate();
				
				via.setString(1, "D");
				via.setString(2, "성남");
				via.setFloat(3, (float)9.00 );
				via.setFloat(4, (float)9.30 );
				result= via.executeUpdate();
				
				via.setString(1, "D");
				via.setString(2, "원주");
				via.setFloat(3, (float)11.30 );
				via.setFloat(4, (float)12.00);
				result= via.executeUpdate();
				
				via.setString(1, "D");
				via.setString(2, "강릉");
				via.setFloat(3, (float)13.00 );
				via.setFloat(4, (float)13.10 );
				result= via.executeUpdate();
				
				via.setString(1, "E");
				via.setString(2, "충주");
				via.setFloat(3, (float)8.40 );
				via.setFloat(4, (float)9.00 );
				result= via.executeUpdate();
				
				via.setString(1, "E");
				via.setString(2, "청주");
				via.setFloat(3, (float)10.00 );
				via.setFloat(4, (float)10.20 );
				result= via.executeUpdate();
				
				via.setString(1, "E");
				via.setString(2, "대전");
				via.setFloat(3, (float)11.00 );
				via.setFloat(4, (float)11.30 );
				result= via.executeUpdate();
				
				via.setString(1, "E");
				via.setString(2, "상주");
				via.setFloat(3, (float)12.00 );
				via.setFloat(4, (float)13.00 );
				result= via.executeUpdate();
				
				via.setString(1, "F");
				via.setString(2, "문경");
				via.setFloat(3, (float)9.00 );
				via.setFloat(4, (float)11.00 );
				result= via.executeUpdate();
				//-----------------------------------------------------------------------------------
				 
 
				busschedule.setString(1, "경부선");
				busschedule.setString(2, "수");
				busschedule.setFloat(3, (float) 13.00);
				busschedule.setFloat(4, (float)20.00);
				busschedule.setString(5, "A");
				result= busschedule.executeUpdate();
				
				busschedule.setString(1, "호남선");
				busschedule.setString(2, "목");
				busschedule.setFloat(3, (float) 14.00);
				busschedule.setFloat(4, (float) 20.00);
				busschedule.setString(5, "B");
				result= busschedule.executeUpdate();
				
				
				busschedule.setString(1, "경인선");
				busschedule.setString(2, "화");
				busschedule.setFloat(3, (float)9.00 );
				busschedule.setFloat(4, (float)18.00 );
				busschedule.setString(5, "C");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "경춘선");
				busschedule.setString(2, "월");
				busschedule.setFloat(3, (float)7.00 );
				busschedule.setFloat(4, (float)21.00 );
				busschedule.setString(5, "D");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "중앙선");
				busschedule.setString(2, "금");
				busschedule.setFloat(3, (float)7.00 );
				busschedule.setFloat(4, (float)21.00 );
				busschedule.setString(5, "E");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "김포부산");
				busschedule.setString(2, "월");
				busschedule.setFloat(3, (float)9.00 );
				busschedule.setFloat(4, (float)20.00 );
				busschedule.setString(5, "A");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "청주목포");
				busschedule.setString(2, "화");
				busschedule.setFloat(3, (float)7.00 );
				busschedule.setFloat(4, (float)21.00 );
				busschedule.setString(5, "B");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "동대구청주");
				busschedule.setString(2, "수");
				busschedule.setFloat(3, (float)6.00 );
				busschedule.setFloat(4, (float)19.00 );
				busschedule.setString(5, "A");
				result= busschedule.executeUpdate();
				
								
				busschedule.setString(1, "부산경주");
				busschedule.setString(2, "금");
				busschedule.setFloat(3, (float)7.00);
				busschedule.setFloat(4, (float)14.00 );
				busschedule.setString(5, "F");
				result= busschedule.executeUpdate();
				
								
				
				} catch (SQLException e) {
				e.printStackTrace();
				}
		
		
		
		System.out.print("승차 지역, 하차 지역, 현재 시각을 입력하세요:");
		nameofStartStation =sc.next();
		nameofArriveStation =sc.next();
		
		timeInput=(float)sc.nextDouble();
		
		
		/* Prepare the query statement */
		String query_string_select="with startInfo_ as(select route.RouteName as \"노선명\", busschedule.RouteCode as \"경유코드\",  route.startStation as \"노선출발지\", route.arriveStation as \"노선도착지\",\r\n"
				+ "busschedule.startTime as \"노선출발시간\", busschedule.arriveTime as \"노선도착시간\",\r\n"
				+ " via1.StationName as \"경유출발지\", via1.startTime as \"경유출발시간\", via2.StationName as \"경유도착지\", via2.arriveTime as \"경유도착시간\",\r\n"
				+ " busschedule.day as \"요일\"\r\n"
				+ "					from busschedule, route, via as via1, via as via2\r\n"
				+ "					where busschedule.RouteCode = via1.RouteCode and\r\n"
				+ "					busschedule.RouteName = route.RouteName and\r\n"
				+ "                    busschedule.RouteCode = via2.RouteCode and\r\n"
				+ "                    via1.startTime <=via2.startTime\r\n"
				+ "                 ) ,\r\n"
				+ "	startofuserInput as (select* from startInfo_ where (노선출발지=" + "\""+nameofStartStation+"\"" +" and 노선출발시간 > " + timeInput +" ) or (경유출발지 =" + "\"" + nameofStartStation + "\""+" and 경유출발시간 >" + timeInput +") )\r\n"
				+ "    \r\n"
				+ "select * from startofuserInput  where (노선도착지 =" + "\""+ nameofArriveStation + "\""+" or 경유도착지 = " + "\""+ nameofArriveStation +"\""+" )";
		try {
			Connection db_connection= DriverManager.getConnection(db_connection_url, db_info.getUsername(), db_info.getPassword());
			Statement db_statement= db_connection.createStatement();
			
			ResultSet result_set= db_statement.executeQuery(query_string_select);
			
			System.out.println("-------------- select values --------------");
			String nameofRoute="";
			int i=0;
			while(result_set.next()){
				String tempRouteName="";
				String start="";
				String arrive="";
				String startTime="";
				String arriveTime="";
				
				if((result_set.getString(3)).equals(nameofStartStation)) {
					start = result_set.getString(3);
					startTime=result_set.getString(5);
					
				}
				else if((result_set.getString(7)).equals(nameofStartStation)) {
					start = result_set.getString(7);
					startTime=result_set.getString(8);
					
				}
				else
					continue;
				
				if((result_set.getString(4)).equals(nameofArriveStation)) {
					arrive=result_set.getString(4);
					arriveTime=result_set.getString(6);
				}
				else if((result_set.getString(9)).equals(nameofArriveStation)) {
					arrive=result_set.getString(9);
					
					arriveTime=result_set.getString(10);
				}
				else 
					continue;
				
				
				tempRouteName= result_set.getString(1);
				
				if(i==0) {
					System.out.println(result_set.getString(1)+ ", " + result_set.getString(11)+ "요일" +", " + start +", " + arrive + ", " + startTime +", "+arriveTime);
					nameofRoute =  result_set.getString(1);
				}	
				else {
					if(!nameofRoute.equals(tempRouteName)) {
						System.out.println(result_set.getString(1)+ ", " + result_set.getString(11)+ "요일" +", " + start +", " + arrive + ", " + startTime +", "+arriveTime);
						nameofRoute =  result_set.getString(1);
						
					}
					
				}
				i++;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
			}

	}

}
