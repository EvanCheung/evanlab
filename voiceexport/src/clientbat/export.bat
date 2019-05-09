set JAVA_HOME=E:\jre1.8.0_73
set PATH=%PATH%;%JAVA_HOME%\bin;
rem set classpath=.;.\lib\hamcrest-core-1.3.jar;.\lib\junit-4.12.jar;.\lib\mssql-jdbc-7.0.0.jre8.jar;.\lib\voiceexport.jar
set classpath=.;.\lib\hamcrest-core-1.3.jar;.\lib\junit-4.12.jar;.\lib\msbase-1.0.jar;.\lib\msutil-1.0.jar;.\lib\mssqlserver-1.0.jar;.\lib\voiceexporter-1.0.jar;.\lib\log4j-1.2.17.jar;
java com.evanlab.VoiceContentExporter "d:/export/voice1/" "atwriteinfo" " id < 30000 "