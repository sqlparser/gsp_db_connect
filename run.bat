echo off

REM #set java path
set JAVA_HOME=D:\environment\jdk\1.8

set JAVA_CMD="%JAVA_HOME%\bin\java.exe"

REM #Set the home directory of the GSP library
set gspDemoHome=.

REM # set classpath to the GSP library Jar files and the database JDBC drivers.
set CLASSPATH=.;%gspDemoHome%\target;%gspDemoHome%\lib\*

REM # Run the gsp demo 
set a1=%1 
set a2=%2 
set a3=%3 
set a4=%4 
set a5=%5 
set a6=%6 
set a7=%7 
set a8=%8 
set a9=%9
shift
shift
shift
set a10=%7 
set a11=%8 
set a12=%9
%JAVA_CMD% -cp %CLASSPATH% demos.sqlenv.Main  %a1% %a2% %a3% %a4% %a5% %a6% %a7% %a8% %a9% %a10% %a11% %a12%
echo %a1%
pause

:END
