package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TPostgreSQLDataSource extends DbSchemaSQLDataSource {

	public TPostgreSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password) {
		super(EDbVendor.dbvpostgresql, driver, jdbcUrl, account, password);
		setSystemDbsSchemas("*/information_schema", "*/pg_catalog");
	}

	public TPostgreSQLDataSource(String hostName, String port, String account, String password) {
		super(EDbVendor.dbvpostgresql, hostName, port, account, password, "postgres");
		setSystemDbsSchemas("*/information_schema", "*/pg_catalog");
	}
	
	public TPostgreSQLDataSource(String hostName, String port, String account, String password, String database) {
		super(EDbVendor.dbvpostgresql, hostName, port, account, password, database);
		setSystemDbsSchemas("*/information_schema", "*/pg_catalog");
	}
}
