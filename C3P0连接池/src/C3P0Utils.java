import java.sql.Connection;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
     //使用默认配置
	//private static ComboPooledDataSource dataSource=new comboPooledDataSource();
	//使用命名配置
	private static ComboPooledDataSource dataSource=new ComboPooledDataSource("itcast");
	public static DataSource getDataSource(){
		return dataSource;
	}
	public static Connection getConnection(){
		try{
			return dataSource.getConnection();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
}
