package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;
import gudusoft.gsqlparser.TGSqlParser;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("version: 1.1.0   date: 2021-11-11.");

        List<String> cmds = Arrays.asList(args);
        validArgs(cmds);

        EDbVendor vendor = TGSqlParser.getDBVendorByName(cmds.get(cmds.indexOf("/t") + 1));
        String jdbc, host, port;
        String username = cmds.get(cmds.indexOf("/u") + 1);
        String password = cmds.get(cmds.indexOf("/p") + 1);
        String database = cmds.get(cmds.indexOf("/db") + 1);
        Class<?> driver = null;
        TSQLDataSource connect;
        if (cmds.contains("/driver")) {
            String driverStr = cmds.get(cmds.indexOf("/driver") + 1);
            try {
                driver = Class.forName(driverStr);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        if (cmds.contains("/jdbc")) {
            jdbc = cmds.get(cmds.indexOf("/jdbc") + 1);
            if (null != driver) {
                connect = toConnect(vendor, driver, jdbc, username, password);
            } else {
                connect = toConnect(vendor, jdbc, username, password, database);
            }
        } else {
            host = cmds.get(cmds.indexOf("/h") + 1);
            port = cmds.get(cmds.indexOf("/P") + 1);
            connect = toConnect(vendor, username, password, host, port, database);
        }

        System.out.println("connect success, start export metadata.");
        String metadata = connect.exportJSON();
        System.out.println("export success. metadata is :");
        System.out.println(metadata);
    }

    private static TSQLDataSource toConnect(EDbVendor vendor, String jdbc, String username, String password, String database) {
        TSQLDataSource datasource = TSQLDataSource.createSQLDataSource(vendor, jdbc, username, password);
        if (vendor == EDbVendor.dbvmysql) {
            datasource = TMysqlSQLDataSource.createSQLDataSource(jdbc, username, password);
        }
        if (vendor == EDbVendor.dbvhive) {
            datasource = THiveMetadataDataSource.createSQLDataSource(jdbc, username, password);
        }
        if (vendor == EDbVendor.dbvsnowflake) {
            datasource = TSnowflakeSQLDataSource.createSQLDataSource(jdbc, username, password);
        }
        if (null != database) {
            datasource.setDatabase(database);
        }

        if (!datasource.testConnection()) {
            System.out.println("connect failed.");
            System.exit(1);
        }
        return datasource;
    }

    private static TSQLDataSource toConnect(EDbVendor vendor, String username, String password, String host, String port, String database) {
        TSQLDataSource datasource = new TSQLDataSource(vendor, host, port, username, password);
        if (vendor == EDbVendor.dbvmysql) {
            datasource = new TMysqlSQLDataSource(host, port, username, password);
        }
        if (vendor == EDbVendor.dbvhive) {
            datasource = new THiveMetadataDataSource(host, port, username, password);
        }
        if (vendor == EDbVendor.dbvsnowflake) {
            datasource = new TSnowflakeSQLDataSource(host, port, username, password);
        }
        if (null != database) {
            datasource.setDatabase(database);
        }
        if (!datasource.testConnection()) {
            System.out.println("connect failed.");
            System.exit(1);
        }
        return datasource;
    }

    private static TSQLDataSource toConnect(EDbVendor vendor, Class<?> driver, String jdbc, String account, String password) {
        try {
            if (vendor == EDbVendor.dbvoracle) {
                return TSQLDataSource.<TOracleSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvmssql) {
                return TSQLDataSource.<TMssqlSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvpostgresql) {
                return TSQLDataSource.<TPostgreSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvgreenplum) {
                return TSQLDataSource.<TGreenplumSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvredshift) {
                return TSQLDataSource.<TRedshiftSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvmysql) {
                return TSQLDataSource.<TMysqlSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvnetezza) {
                return TSQLDataSource.<TNetezzaSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvsnowflake) {
                return TSQLDataSource.<TSnowflakeSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvteradata) {
                return TSQLDataSource.<TTeradataSQLDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
            if (vendor == EDbVendor.dbvhive) {
                return TSQLDataSource.<THiveMetadataDataSource>createSQLDataSource(vendor, driver, jdbc, account,
                        password);
            }
        } catch (Exception e) {
            System.err.println("Connect datasource failed. " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    private static void validArgs(List<String> cmds) {
        if (!cmds.contains("/t")
                || (!cmds.contains("/jdbc") && !cmds.contains("/h") && !cmds.contains("/P"))) {
            print();
            System.exit(1);
        }
    }

    private static void print() {
        System.out.println(
                "/t: Required, set the database type. " +
                        "Support access,bigquery,couchbase,dax,db2,greenplum,hana,hive,impala,informix,mdx,mssql,\n" +
                        "sqlserver,mysql,netezza,odbc,openedge,oracle,postgresql,postgres,redshift,snowflake,\n" +
                        "sybase,teradata,soql,vertica\n, " +
                        "the default value is oracle");
        System.out.println("/h: Optional, specify the host of jdbc connection");
        System.out.println("/P: Optional, specify the port of jdbc connection, note it's capital P.");
        System.out.println("/u: Required, specify the username of jdbc connection.");
        System.out.println("/p: Required, specify the password of jdbc connection, note it's lowercase P.");
        System.out.println("/db: Optional, specify the database of jdbc connection.");
        System.out.println("/jdbc: Optional, specify the jdbc url of connection.");
    }


}
