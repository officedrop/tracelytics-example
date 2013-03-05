rm -rf bin/
mkdir bin
javac -cp lib/tracelytics-agent-1.0.jar -d bin/ src/TracelyticsExample.java
java -javaagent:lib/tracelytics-agent-1.0.jar -cp bin/ TracelyticsExample 