FROM mongo:3
MAINTAINER Oleksandr Kharkovskyi <double2603@gmail.com>

ADD init.sh /init.sh
ADD ./dump /dump

EXPOSE 27017:27017

RUN \
 chmod +x /init.sh && \
 apt-get update && apt-get dist-upgrade -y && \
 apt-get install psmisc -y -q && \
 apt-get autoremove -y && apt-get clean && \
 rm -rf /var/cache/* && rm -rf /var/lib/apt/lists/*

ENTRYPOINT ["/init.sh"]