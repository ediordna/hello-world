#!/bin/bash

# Set the base directory (shared folder defined in vagrantfile)
cd /vagrant

# Import the docker images
docker load -i parcelsizecomponent.tar
docker load -i parcelwebserver.tar
# docker load -i load_balancer.img

# Cleanup
docker stop $(docker ps -a -q)
docker rm $(docker ps -a -q)

# Create the internal docker network
docker network create parcel_net || true

# Create the docker containers
echo "Starting MySQL container..."
docker run \
    --name mysql_parcelsize \
    --network="parcel_net" \
    -e "MYSQL_ROOT_PASSWORD=12345" \
    --mount type=bind,src=/vagrant/,dst=/docker-entrypoint-initdb.d/ \
    -d mysql/mysql-server:5.7
	
echo "Starting parcelsize container (1/2)..."
docker run \
    --name parcelsize1 \
    --network="parcel_net" \
    -p 8081:1101 \
    -d parcelsizecomponent
    
echo "Starting parcelsize container (2/2)..."
docker run \
    --name parcelsize2 \
    --network="parcel_net" \
    -p 1102:1102 \
    -d parcelsizecomponent
    
#echo "Starting load balancer for the parcelsize service..."
#docker run \
	#--name load_balancer \
	#--network="parcel_net" \
	#-p 1100:1100 \
	#-d load_balancer
	
echo "Starting parcel server container..."
docker run \
    --name parcelserver \
    --network="parcel_net" \
    -p 1200:8080 \
    -d parcelwebserver

echo "Docker containers successfully started."