package testJobApp.phonedb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;





public class PhoneRecordDb {
	
	private static String url = "jdbc:mysql://localhost/phonebook?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "12345";
    
    public static ArrayList<PhoneRecord> select() {
        
        ArrayList<PhoneRecord> records = new ArrayList<PhoneRecord>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM phones");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int number = resultSet.getInt(3);
                    String note = resultSet.getString(4);
                    PhoneRecord record = new PhoneRecord(id, name, number, note);
                    records.add(record);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return records;
    }
    
    public static PhoneRecord selectOne(int id) {
        
    	PhoneRecord record = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM phones WHERE id=?";
                try(PreparedStatement prepStat = conn.prepareStatement(sql)){
                    prepStat.setInt(1, id);
                    ResultSet resultSet = prepStat.executeQuery();
                    if(resultSet.next()){
 
                    	int recId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int number = resultSet.getInt(3);
                        String note = resultSet.getString(4);
                        record = new PhoneRecord(recId, name, number, note);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return record;
    }
    
    public static int insert(PhoneRecord record) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "INSERT INTO phones (name, phone, note) Values (?, ?, ?)";
                try(PreparedStatement prepStat = conn.prepareStatement(sql)){
                	prepStat.setString(1, record.getName());
                	prepStat.setInt(2, record.getNumber());
                	prepStat.setString(3, record.getNote());
                      
                    return  prepStat.executeUpdate();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    
    public static int update(PhoneRecord record) {
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE phones SET name = ?, phone = ?, note = ? WHERE id = ?";
                try(PreparedStatement prepStat = conn.prepareStatement(sql)){
                	prepStat.setString(1, record.getName());
                	prepStat.setInt(2, record.getNumber());
                	prepStat.setString(3, record.getNote());
                	prepStat.setInt(3, record.getId());
                      
                    return  prepStat.executeUpdate();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }
    
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM phones WHERE id = ?";
                try(PreparedStatement prepStat = conn.prepareStatement(sql)){
                	prepStat.setInt(1, id);
                      
                    return  prepStat.executeUpdate();
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return 0;
    }

}
