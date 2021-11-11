package demos.sqlenv;

import gudusoft.gsqlparser.EDbVendor;

public class TSnowflakeSQLDataSource extends DbSchemaSQLDataSource {
	
	private String defaultRole;
	
	private String privateKeyFile;
	
	private String privateKeyFilePwd;

	public TSnowflakeSQLDataSource(Class<?> driver, String jdbcUrl, String account, String password) {
		super(EDbVendor.dbvsnowflake, driver, jdbcUrl, account, password);
		setSystemDbsSchemas("*/INFORMATION_SCHEMA");
	}

	public TSnowflakeSQLDataSource(String hostName, String port, String account, String password, String database) {
		super(EDbVendor.dbvsnowflake, hostName, port, account, password, database);
		setSystemDbsSchemas("*/INFORMATION_SCHEMA");
	}

	public TSnowflakeSQLDataSource(String hostName, String port, String account, String password) {
		super(EDbVendor.dbvsnowflake, hostName, port, account, password);
		setSystemDbsSchemas("*/INFORMATION_SCHEMA");
	}

	public String getDefaultRole() {
		return defaultRole;
	}

	public void setDefaultRole(String defaultRole) {
		this.defaultRole = defaultRole;
	}

	public String getPrivateKeyFile() {
		return privateKeyFile;
	}

	public void setPrivateKeyFile(String privateKeyFile) {
		this.privateKeyFile = privateKeyFile;
	}

	public String getPrivateKeyFilePwd() {
		return privateKeyFilePwd;
	}

	public void setPrivateKeyFilePwd(String privateKeyFilePwd) {
		this.privateKeyFilePwd = privateKeyFilePwd;
	}
	
}