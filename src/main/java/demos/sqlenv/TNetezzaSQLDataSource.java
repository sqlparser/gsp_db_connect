package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TNetezzaSQLDataSource extends DbSchemaSQLDataSource {

	public TNetezzaSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password) {
		super(EDbVendor.dbvnetezza, driver, jdbcUrl, account, password);
		setSystemDbsSchemas("SYSTEM/ADMIN");
	}

	public TNetezzaSQLDataSource(String hostName, String port, String account, String password, String database) {
		super(EDbVendor.dbvnetezza, hostName, port, account, password, database);
		setSystemDbsSchemas("SYSTEM/ADMIN");
	}

}