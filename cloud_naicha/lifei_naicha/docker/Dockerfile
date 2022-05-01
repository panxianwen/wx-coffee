FROM kdvolder/jdk8
VOLUME /tmp
# 挂载的docker卷
# 自己的jar包  xxxx.jar 自定义的jar包名
ADD lifei_naicha-1.0-SNAPSHOT.jar lifei_naicha-1.0.jar
# RUN bash -c 'touch /app.jar'  上面自定义的jar包名称
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","-Xms512m", "-Xmx512m", "-XX:+PrintGCDetails", "-XX:+PrintGCTimeStamps", "-XX:+HeapDumpOnOutOfMemoryError", "-XX:HeapDumpPath=/log/lifei_naicha/OOM_log", "-Xloggc:/log/lifei_naicha/logGC","-Duser.timezone=GMT+8", "/lifei_naicha-1.0.jar"]
# 端口号
EXPOSE 9001
