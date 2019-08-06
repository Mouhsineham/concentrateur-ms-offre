#!/bin/sh

echo "The application will start in ${NOMADE_SLEEP}s..." && sleep ${NOMADE_SLEEP}
exec java ${JAVA_OPTS} -noverify -XX:+AlwaysPreTouch -Djava.security.egd=file:/dev/./urandom -cp /app/resources/:/app/classes/:/app/libs/* "com.sofrecom.sofid.blog.BlogApp"  "$@"
