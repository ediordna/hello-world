#!/bin/bash

export RESOURCE_SERVER="192.168.56.100"
export RESOURCE_SERVER_USER="vagrant"
export RESOURCE_SERVER_ROOT="/home/user/resources"
export RESOURCE_SERVER_KEY="/home/patrick/AssetServerVM/ssh_key"

# Build the docker image for the load balancer
docker build -t load_balancer .

# Deploy the docker image to the load balancer
docker save --output load_balancer.tar load_balancer:latest

scp -o StrictHostKeyChecking=no \
	-i $RESOURCE_SERVER_KEY \
	load_balancer.tar \
	$RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/load_balancer.tar
	
ssh -o StrictHostKeyChecking=no \
	-i $RESOURCE_SERVER_KEY \
	$RESOURCE_SERVER_USER@$RESOURCE_SERVER \
	chmod 755 $RESOURCE_SERVER_ROOT/images/load_balancer.tar
	
rm load_balancer.tar