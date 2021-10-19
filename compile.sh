#!/bin/bash

function compile(){
   rm -rf target
   mkdir target

  javac -d target -classpath lib/gudusoft.gsqlparser.jar  src/main/java/demos/sqlenv/connect/strategy/impl/*.java src/main/java/demos/sqlenv/connect/*.java src/main/java/demos/sqlenv/connect/impl/*.java src/main/java/demos/sqlenv/connect/strategy/*.java src/main/java/demos/sqlenv/constant/*.java src/main/java/demos/sqlenv/metadata/*.java src/main/java/demos/sqlenv/metadata/model/*.java src/main/java/demos/sqlenv/operation/strategy/*.java src/main/java/demos/sqlenv/operation/*.java src/main/java/demos/sqlenv/operation/strategy/json/*.java src/main/java/demos/sqlenv/operation/strategy/json/impl/*.java src/main/java/demos/sqlenv/parser/grabit/*.java src/main/java/demos/sqlenv/parser/sqldep/*.java src/main/java/demos/sqlenv/parser/*.java src/main/java/demos/sqlenv/util/*.java src/main/java/demos/sqlenv/*.java

}

compile
exit 0

