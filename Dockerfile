FROM docker.elastic.co/logstash/logstash:7.13.4

COPY logstash.conf /usr/share/logstash/pipeline/