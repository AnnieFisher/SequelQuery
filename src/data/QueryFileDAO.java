package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class QueryFileDAO implements QueryDAO {
	private static final String url = "jdbc:mysql://localhost:3306/sdvid";
	private static final String user = "student";
	private static final String pword = "student";

	@Override
	public List<List<String>> getQueryInfo(String info) {
		List<List<String>> statement = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, pword);
			Statement stmt = conn.createStatement();

			int count = 0;
			if (info.trim().toUpperCase().startsWith("SELECT")) {

				ResultSet rs = stmt.executeQuery(info);
				ResultSetMetaData rsmd = rs.getMetaData();
				int cols = rsmd.getColumnCount();

				List<String> queries = new ArrayList<>();
				for (int c = 1; c <= cols; c++) {
					queries.add(rsmd.getColumnName(c));
				}	
				statement.add(queries);

				while (rs.next())
				{
					queries = new ArrayList<>();

					for (int c = 0; c < cols; c++)
					{
						queries.add(rs.getString(c + 1));
					}	
					statement.add(queries);
				}
			}
			else
			{
				count = stmt.executeUpdate(info);
				List<String> queries = new ArrayList<>();
				queries.add(""+ count);
				statement.add(queries);
			}
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (ClassNotFoundException cnf)
		{
			cnf.printStackTrace();
		}
		return statement;
	}	
}
