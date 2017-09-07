# kafka-admin

Go to the directory which has pom.xml file and run the following command which builds your project.
Cmd: 
mvn -DskipTests=true assembly:assembly
 
After the success message, run the below command from the same directory.

java -cp target/KSS-jar-with-dependencies.jar com.aps.admin.CreateAdminService <zookeeperHosts> <topicName> <partitions> <replicationFactor>

Cmd: 
java -cp target/KSS-jar-with-dependencies.jar com.aps.admin.CreateAdminService dev-qa-pliny09.kendall.corp.akamai.com test 3 3 
 
