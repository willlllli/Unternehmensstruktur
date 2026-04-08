FROM postgres:16
COPY create.sql /docker-entrypoint-initdb.d/01_create.sql
COPY insert.sql /docker-entrypoint-initdb.d/02_insert.sql
