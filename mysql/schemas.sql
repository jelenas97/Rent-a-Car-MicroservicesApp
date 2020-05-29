CREATE DATABASE IF NOT EXISTS `database`;

CREATE SCHEMA IF NOT EXISTS `auth`;
CREATE SCHEMA IF NOT EXISTS `advert`;
CREATE SCHEMA IF NOT EXISTS `rent`;
CREATE SCHEMA IF NOT EXISTS `search`;
CREATE SCHEMA IF NOT EXISTS `location`;
CREATE SCHEMA IF NOT EXISTS `messages`;
CREATE SCHEMA IF NOT EXISTS `statistics`;

# create root user and grant rights
CREATE USER 'pera'@'%' IDENTIFIED BY 'pera';
GRANT ALL PRIVILEGES ON *.* TO 'pera'@'%';


