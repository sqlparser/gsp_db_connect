package demos.sqlenv.connect;

import demos.sqlenv.TSQLDataSource;
import demos.sqlenv.connect.strategy.DbStrategyFactory;
import gudusoft.gsqlparser.sqlenv.util.ConnectUtil;

import java.sql.Connection;

public class ConnectionFactory {

	public static Connection getConnection(TSQLDataSource datasource) throws Exception {
		if (datasource.getDriver() != null && datasource.getJdbcUrl() != null) {
			return ConnectUtil.getConnection(datasource.getAccount(),
					datasource.getPassword(), datasource.getDriver().getName(), datasource.getJdbcUrl(), datasource.getTimeout());
		}
		return DbStrategyFactory.getInstance().getDbStrategy(datasource.getDbType()).getDbConnect()
				.toConnect(datasource);
	}
}
