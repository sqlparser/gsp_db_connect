echo off

set PATH=%PATH%;lib\gudusoft.gsqlparser.jar

REM #set java path
set JAVA_HOME=D:\environment\jdk\1.8

set JAVAC_CMD="%JAVA_HOME%\bin\javac.exe"

RMDIR target /S 
mkdir target 

REM #Set the home directory of the GSP library
set gspDemoHome=.

REM # set classpath to the GSP library Jar files and the database JDBC drivers.
set CLASSPATH=.;%gspDemoHome%\target;%gspDemoHome%\lib\gudusoft.gsqlparser.jar

set targetdir=target

%JAVAC_CMD% -d %targetdir% -classpath %CLASSPATH% src\main\java\demos\sqlenv\connect\strategy\impl\*.java src\main\java\demos\sqlenv\connect\*.java src\main\java\demos\sqlenv\connect\impl\*.java src\main\java\demos\sqlenv\connect\strategy\*.java src\main\java\demos\sqlenv\constant\*.java src\main\java\demos\sqlenv\metadata\*.java src\main\java\demos\sqlenv\metadata\model\*.java src\main\java\demos\sqlenv\operation\strategy\*.java src\main\java\demos\sqlenv\operation\*.java src\main\java\demos\sqlenv\operation\strategy\json\*.java src\main\java\demos\sqlenv\operation\strategy\json\impl\*.java src\main\java\demos\sqlenv\parser\grabit\*.java src\main\java\demos\sqlenv\parser\sqldep\*.java src\main\java\demos\sqlenv\parser\*.java src\main\java\demos\sqlenv\util\*.java src\main\java\demos\sqlenv\*.java

echo Completed.

pause

:END

