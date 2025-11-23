#!/bin/bash
DATABASE_PASS='11111111'
sudo apt update -y
sudo apt install git zip unzip -y
sudo apt install mariadb-server -y


# starting & enabling mariadb-server
sudo systemctl start mariadb
sudo systemctl enable mariadb
cd /tmp/
git clone -b DEV https://github.com/seohan1010/ch8_4.git
#restore the dump file for the application
sudo mysqladmin -u root password "$DATABASE_PASS"
sudo mysql -u root -p"$DATABASE_PASS" -e "UPDATE mysql.user SET Password=PASSWORD('$DATABASE_PASS') WHERE User='root'"
sudo mysql -u root -p"$DATABASE_PASS" -e "DELETE FROM mysql.user WHERE User='root' AND Host NOT IN ('localhost', '127.0.0.1', '::1')"
sudo mysql -u root -p"$DATABASE_PASS" -e "DELETE FROM mysql.user WHERE User=''"
sudo mysql -u root -p"$DATABASE_PASS" -e "DELETE FROM mysql.db WHERE Db='test' OR Db='test\_%'"
sudo mysql -u root -p"$DATABASE_PASS" -e "FLUSH PRIVILEGES"
sudo mysql -u root -p"$DATABASE_PASS" -e "create database fp_ch8"
sudo mysql -u root -p"$DATABASE_PASS" -e "grant all privileges on fp_ch8.* TO 'ch8'@'localhost' identified by '11111111'"
sudo mysql -u root -p"$DATABASE_PASS" -e "grant all privileges on fp_ch8.* TO 'ch8'@'%' identified by '11111111'"
sudo mysql -u root -p"$DATABASE_PASS" fp_ch8 < /tmp/ch8_4/src/ch8.sql

sudo mysql -u root -p"$DATABASE_PASS" -e "FLUSH PRIVILEGES"

# Restart mariadb-server
sudo systemctl restart mariadb


#starting the firewall and allowing the mariadb to access from port no. 3306
sudo apt install firewalld -y
sudo systemctl start firewalld
sudo systemctl enable firewalld
sudo systemctl start firewalld
sudo systemctl enable firewalld
sudo firewall-cmd --get-active-zones
sudo firewall-cmd --zone=public --add-port=3306/tcp --permanent
sudo firewall-cmd --reload
sudo systemctl restart mariadb
