package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TMssqlSQLDataSource extends DbSchemaSQLDataSource {

    public TMssqlSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password) {
        super(EDbVendor.dbvmssql, driver, jdbcUrl, account, password);
        setSystemDbsSchemas("master/dbo", "master/sys", "*/INFORMATION_SCHEMA");
    }

    public TMssqlSQLDataSource(String hostName, String port, String account, String password) {
        super(EDbVendor.dbvmssql, hostName, port, account, password);
        setSystemDbsSchemas("master/dbo", "master/sys", "*/INFORMATION_SCHEMA");
    }

    public TMssqlSQLDataSource(String hostName, String port, String account, String password, String database) {
        super(EDbVendor.dbvmssql, hostName, port, account, password, database);
        setSystemDbsSchemas("master/dbo", "master/sys", "*/INFORMATION_SCHEMA");
    }
}
