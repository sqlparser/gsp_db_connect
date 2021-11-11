# gsp_db_connect
gsp tool connect to database to extract metadata

## Local debugging
Execute the script first compile, then run.

1, compile
- mac & linux
```
./compile.sh
```
- windwos
```
compile.bat
```

2, run
- mac & linux
```
./run.sh /t <database type>  [/h <host> /P <port>] [/jdbc <jdbcurl>] /u <username> /p <password> /db <database>
```
- windwos
```
run.bat /t <database type>  [/h <host> /P <port>] [/jdbc <jdbcurl>] /u <username> /p <password> /db <database>
```

## Binary version
https://www.gudusoft.com/dl/dbConnect-1.1.0.zip

> In order to run this utility, please install Oracle JDK1.8 or higher on your computer correctly.

## Usage
```
unzip dbConnect-1.1.0.zip

Usage: ./start.sh /t <database type>  [/h <host> /P <port>] [/jdbc <jdbcurl>] /u <username> /p <password> /db <database>
/t: Required, set the database type.
/h: Optional, specify the host of jdbc connection
/P: Optional, specify the port of jdbc connection, note it's capital P.
/u: Optional, specify the username of jdbc connection.
/p: Optional, specify the password of jdbc connection, note it's lowercase P.
/db: Optional, specify the database of jdbc connection.
/jdbc: Optional, specify the jdbc url of connection.
```


Here is the list of available database after /t option:
```
azure,db2,greenplum,hive,mssql,sqlserver,mysql,netezza,oracle,postgresql,postgres,redshift,snowflake,teradata
```

> 

### 1.1 connect to SQL Server
Tables are under this database: `AdventureWorksDW2019`.

```sh
./start.sh /t mssql /h localhost /P 1433 /u root /p password /db AdventureWorksDW2019  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t mssql /jdbc jdbc:sqlserver://127.0.0.1:1433;DatabaseName=AdventureWorksDW2019  /u root /p password 
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t mssql /driver com.microsoft.sqlserver.jdbc.SQLServerDriver /jdbc jdbc:sqlserver://127.0.0.1:1433;DatabaseName=AdventureWorksDW2019  /u root /p password 
```

### 1.2 connect to Oracle
Tables are under this database: `orcl`.

```sh
./start.sh /t oracle /h localhost /P 1521 /u root /p password /db orcl 
```

Connect using the specified JDBC URL.

```sh
./start.sh /t oracle /jdbc jdbc:oracle:thin:@127.0.0.1:1521/orcl /u root /p password
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t oracle /driver oracle.jdbc.driver.OracleDriver /jdbc jdbc:oracle:thin:@127.0.0.1:1521/orcl /u root /p password
```

### 1.3 connect to MySQL
Tables are under `employees` database.

```sh
./start.sh /t mysql /h localhost /P 3306 /u root /p password /db employees  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t mysql /jdbc jdbc:mysql://127.0.0.1:3306/employees  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t mysql /driver com.mysql.cj.jdbc.Driver  /jdbc jdbc:mysql://127.0.0.1:3306/employees  /u root /p password   
```

### 1.4 connect to Postgresql
Tables are under `kingland` database.

```sh
./start.sh /t postgresql /h localhost /P 5432 /u root /p password /db kingland  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t postgresql /jdbc jdbc:postgresql://127.0.0.1:5432/kingland  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t postgresql /driver org.postgresql.Driver  /jdbc jdbc:postgresql://127.0.0.1:5432/kingland  /u root /p password   
```

### 1.5 connect to Netezza
Tables are under `MASTER_DB` database.

```sh
./start.sh /t netezza /h localhost /P 5480 /u root /p password /db MASTER_DB  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t netezza /jdbc jdbc:netezza://127.0.0.1:5480/MASTER_DB  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t netezza /driver org.netezza.Driver  /jdbc jdbc:netezza://127.0.0.1:5480/MASTER_DB  /u root /p password   
```

### 1.6 connect to Greenplum
Tables are under `postgres` database.

```sh
./start.sh /t greenplum /h localhost /P 2345 /u root /p password /db postgres  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t greenplum /jdbc jdbc:pivotal:greenplum://127.0.0.1:2345;DatabaseName=postgres  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t greenplum /driver com.pivotal.jdbc.GreenplumDriver  /jdbc jdbc:pivotal:greenplum://127.0.0.1:2345;DatabaseName=postgres  /u root /p password   
```

### 1.7 connect to Snowflake
Tables are under `DEMO_DB` database.

```sh
./start.sh /t snowflake /h localhost /P 443 /u root /p password /db DEMO_DB  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t snowflake /jdbc jdbc:snowflake://127.0.0.1:443?db=DEMO_DB  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t snowflake /driver net.snowflake.client.jdbc.SnowflakeDriver  /jdbc jdbc:snowflake://127.0.0.1:443?db=DEMO_DB  /u root /p password   
```

### 1.8 connect to Teradata
Tables are under `DEMO_DB` database.

```sh
./start.sh /t teradata /h localhost /P 1025 /u root /p password /db DEMO_DB  
```

Connect using the specified JDBC URL.

```sh
./start.sh /t teradata /jdbc jdbc:teradata://127.0.0.1/DBS_PORT=1025  /u root /p password   
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t teradata /driver com.teradata.jdbc.TeraDriver  /jdbc jdbc:teradata://127.0.0.1/DBS_PORT=1025  /u root /p password   
```

### 1.9 connect to Hive
Connect to Hive server and fetch the metadata to help resolve the ambiguous columns in SQL query.
Tables are under `default` database.

You can use the command like this:
```sh
./start.sh /t hive /h localhost /P 10000 /u root /p password /db default  
```
Connect using the specified JDBC URL.

```sh
./start.sh /t hive /jdbc jdbc:hive2://localhost:10000/default /u root /p password  
```

Connect using the specified JDBC URL and you can use other driver.First, you need to place the driver package in the lib directory.

```sh
./start.sh /t hive /driver org.apache.hive.jdbc.HiveDriver  /jdbc jdbc:hive2://localhost:10000/default /u root /p password  
```

