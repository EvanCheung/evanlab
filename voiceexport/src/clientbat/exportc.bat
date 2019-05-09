rem set JAVA_HOME=E:\jre1.8.0_73
rem set PATH=%PATH%;%JAVA_HOME%\bin;
rem set classpath=.;.\libs\hamcrest-core-1.3.jar;.\libs\junit-4.12.jar;.\libs\mssql-jdbc-7.0.0.jre8.jar;.\libs\voiceexport.jar
set classpath=.;.\libs\hamcrest-core-1.3.jar;.\libs\junit-4.12.jar;.\libs\msbase-1.0.jar;.\libs\msutil-1.0.jar;.\libs\mssqlserver-1.0.jar;.\libs\voiceexport-1.0.jar;.\libs\log4j-1.2.17.jar;
javac com/evanlab/VoiceContentExporter.java
jar -cvf voiceexport-1.0.jar com