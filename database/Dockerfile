FROM mysql:5.7.22

MAINTAINER PatrickUhl

ENV MYSQL_ROOT_PASSWORD SWA2018mysql

COPY ./mysqld.cnf /etc/mysql/mysql.conf.d/mysqld.cnf

COPY ./SQL_Skript.sql /SQL_Skript.sql

RUN /etc/init.d/mysql start

EXPOSE 3306
