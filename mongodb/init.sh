#!/bin/bash
if test -z "$MONGODB_PASSWORD"; then
    echo "MONGODB_PASSWORD not defined"
    MONGODB_PASSWORD=user
    echo "MONGODB_PASSWORD set to $MONGODB_PASSWORD"
fi

auth="-u user -p $MONGODB_PASSWORD"

# MONGODB USER CREATION
(
echo "setup mongodb auth"
create_user="if (!db.getUser('user')) { db.createUser({ user: 'user', pwd: '$MONGODB_PASSWORD', roles: [ {role:'readWrite', db:'scalacloud'} ]}) }"
until mongo scalacloud --eval "$create_user" || mongo scalacloud $auth --eval "$create_user"; do sleep 5; done
killall mongod
sleep 1
killall -9 mongod
) &

# INIT DUMP EXECUTION
(
    sleep 3
    chmod +x ./dump/import-dump.sh
    echo "execute dump file"
	./dump/import-dump.sh
) &

echo "start mongodb without auth"
chown -R mongodb /data/db
gosu mongodb mongod "$@"

echo "restarting with auth on"
sleep 5
exec gosu mongodb mongod --auth "$@"