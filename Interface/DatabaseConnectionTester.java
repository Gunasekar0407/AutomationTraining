package Interface;

public class DatabaseConnectionTester {
	public static void main(String[] args) {
		OracleDataBase oracleDataBase = new OracleDataBase();
		SqlServerDataBase sqlServerDataBase = new SqlServerDataBase();
		MongoDataBase mongoDataBase = new MongoDataBase();

		oracleDataBase.connectToDataBase();
		sqlServerDataBase.connectToDataBase();
		mongoDataBase.connectToDataBase();
	}

}
