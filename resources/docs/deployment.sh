sudo docker network create -d overlay jee_network
sudo docker volume create ensiasdoc_volume
sudo docker volume create mysql_con_volume
sudo docker service create --name ensiasdocs -p 80:8080 --mount type=volume,source=ensiasdoc_volume,target=/usr/local/tomcat/ --network jee_network --replicas 1 katchi7/ensias-docs
sudo docker service create --name mysql_con --network jee_network --mount type=volume,source=mysql_con_volume,target=/var/lib/mysql -e MYSQL_ROOT_PASSWORD=yeHuchahp6oYo1shug9Vishiokei7bae -d mysql