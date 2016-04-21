#!/bin/bash
mvn clean install \
&& eval $(docker-machine env) \
&& docker-compose build \
&& docker-compose up