package Interface;

public class OracleDataBase implements DatabaseConnector {

	@Override
	public void connectToDataBase() {
		System.out.println("OracleDataBase");
	}

}
