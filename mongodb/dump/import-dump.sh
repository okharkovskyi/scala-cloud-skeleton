#!/usr/bin/env bash
if test -z "$MONGODB_PASSWORD"; then
    echo "MONGODB_PASSWORD not defined"
    MONGODB_PASSWORD=user
    echo "MONGODB_PASSWORD set to $MONGODB_PASSWORD"
fi
echo "Importing users"
mongoimport -u user -p $MONGODB_PASSWORD -d scalacloud -c user --type=json /dump/user-service-dump.json
echo "Importing cars"
mongoimport -u user -p $MONGODB_PASSWORD -d scalacloud -c car --type=json /dump/car-service-dump.json