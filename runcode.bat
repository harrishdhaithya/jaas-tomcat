set JAVA_OPTS=$JAVA_OPTS "-Djava.security.auth.login.config==conf/jaas.config"
javac src/com/auth/* -d WEB-INF/classes
catalina start
