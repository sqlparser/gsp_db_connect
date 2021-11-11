package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TAzureSQLDataSource extends DbSchemaSQLDataSource {

    public TAzureSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password, String database) {
        super(EDbVendor.dbvazuresql, driver, jdbcUrl, account, password);
        setDatabase(database);
        setSystemDbsSchemas("master/dbo", "master/sys", "*/INFORMATION_SCHEMA");
    }

    public TAzureSQLDataSource(String hostName, String port, String account, String password, String database) {
        super(EDbVendor.dbvazuresql, hostName, port, account, password, database);
        setSystemDbsSchemas("master/dbo", "master/sys", "*/INFORMATION_SCHEMA");
    }

}
