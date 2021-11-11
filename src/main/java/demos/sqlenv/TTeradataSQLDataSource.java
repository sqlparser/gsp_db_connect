package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TTeradataSQLDataSource extends DatabaseSQLDataSource {

    public TTeradataSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password) {
        super(EDbVendor.dbvteradata, driver, jdbcUrl, account, password);
        setSystemDatabases("DBC");
    }

    public TTeradataSQLDataSource(String hostName, String port, String account, String password, String database) {
        super(EDbVendor.dbvteradata, hostName, port, account, password, database);
        setSystemDatabases("DBC");
    }
}
