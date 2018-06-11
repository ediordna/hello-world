#!/bin/bash

# Create a temporary folder that is synched with the VM
[ -e ./vm_data ] && rm -rf ./vm_data
mkdir ./vm_data

# Copy the database int script to the synched folder
cp ./scripts/integration_test_data.sql ./vm_data

# Download the docker images from the resource server
echo "Downloading docker images from resource server(1/3)..."
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/parcelsize ./vm_data/parcelsize.img

echo "Downloading docker images from resource server(2/3)..."
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/parcelserver ./vm_data/parcelserver.img

echo "Downloading docker images from resource server(3/3)..."
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/load_balancer ./vm_data/load_balancer.img

echo Download of docker images finished.

# Start the test environment VM 
vagrant up

# Run the init script in the VM
cat ./scripts/create_test_container.sh | vagrant ssh

sleep 10s

echo "VM setup finished"