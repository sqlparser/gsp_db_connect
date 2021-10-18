# gsp_db_connect
gsp tool connect to database to extract metadata


## Install
```
mvn install 
```

## Usage
```
Usage: java -jar dbConnect-1.0.0.jar /t <database type>  [/h <host> /P <port>] [/jdbc <jdbcurl>] /u <username> /p <password> /db <database>
/t: Required, set the database type.
/h: Optional, specify the host of jdbc connection
/P: Optional, specify the port of jdbc connection, note it's capital P.
/u: Required, specify the username of jdbc connection.
/p: Required, specify the password of jdbc connection, note it's lowercase P.
/db: Optional, specify the database of jdbc connection.
/jdbc: Optional, specify the jdbc url of connection.
```


Here is the list of available database after /t option:
```
azure,db2,greenplum,hive,mssql,sqlserver,mysql,netezza,oracle,postgresql,postgres,redshift,snowflake,teradata
```



### 1.1 connect to SQL Server
Tables are under this database: `AdventureWorksDW2019`.

```sh
java -jar dbConnect-1.0.0.jar /t mssql /h localhost /P 1433 /u root /p password /db AdventureWorksDW2019  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t mssql /jdbc jdbc:sqlserver://127.0.0.1:1433;DatabaseName=AdventureWorksDW2019  /u root /p password 
```

### 1.2 connect to Oracle
Tables are under this database: `orcl`.

```sh
java -jar dbConnect-1.0.0.jar /t oracle /h localhost /P 1521 /u root /p password /db orcl 
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t oracle /jdbc jdbc:oracle:thin:@127.0.0.1:1521/orcl /u root /p password
```

### 1.3 connect to MySQL
Tables are under `employees` database.

```sh
java -jar dbConnect-1.0.0.jar /t mysql /h localhost /P 3306 /u root /p password /db employees  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t mysql /jdbc jdbc:mysql://127.0.0.1:3306/employees  /u root /p password   
```

### 1.4 connect to Postgresql
Tables are under `kingland` database.

```sh
java -jar dbConnect-1.0.0.jar /t postgresql /h localhost /P 5432 /u root /p password /db kingland  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t postgresql /jdbc jdbc:postgresql://127.0.0.1:5432/kingland  /u root /p password   
```

### 1.5 connect to Netezza
Tables are under `MASTER_DB` database.

```sh
java -jar dbConnect-1.0.0.jar /t netezza /h localhost /P 5480 /u root /p password /db MASTER_DB  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t netezza /jdbc jdbc:netezza://127.0.0.1:5480/MASTER_DB  /u root /p password   
```

### 1.6 connect to Greenplum
Tables are under `postgres` database.

```sh
java -jar dbConnect-1.0.0.jar /t greenplum /h localhost /P 2345 /u root /p password /db postgres  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t greenplum /jdbc jdbc:pivotal:greenplum://127.0.0.1:2345;DatabaseName=postgres  /u root /p password   
```

### 1.7 connect to Snowflake
Tables are under `DEMO_DB` database.

```sh
java -jar dbConnect-1.0.0.jar /t snowflake /h localhost /P 443 /u root /p password /db DEMO_DB  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t snowflake /jdbc jdbc:snowflake://127.0.0.1:443?db=DEMO_DB  /u root /p password   
```

### 1.8 connect to Teradata
Tables are under `DEMO_DB` database.

```sh
java -jar dbConnect-1.0.0.jar /t teradata /h localhost /P 1025 /u root /p password /db DEMO_DB  
```

Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t teradata /jdbc jdbc:teradata://127.0.0.1:1025/DEMO_DB  /u root /p password   
```

### 1.9 connect to Hive
Connect to Hive server and fetch the metadata to help resolve the ambiguous columns in SQL query.
Tables are under `default` database.

You can use the command like this:
```sh
java -jar dbConnect-1.0.0.jar /t hive /h localhost /P 10000 /u root /p password /db default  
```
Connect using the specified JDBC URL.

```sh
java -jar dbConnect-1.0.0.jar /t hive /jdbc jdbc:hive2://localhost:10000/default /u root /p password  
```

## Binary version
https://www.gudusoft.com/dl/dbConnect-1.0.0.jar

In order to run this utility, please install Oracle JDK1.8 or higher on your computer correctly.
Then, run this utility like this:

```
java -jar dbConnect-1.0.0.jar /t dbtype /h hostname /P port /u username /p password /db database  
```
