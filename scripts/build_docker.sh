#!/bin/bash

# Build the docker image for the parcel size service
docker build -t parcelsize .
echo Successfully built docker image

# Deploy the docker image to the resource server
docker save --output parcelsize.img parcelsize:latest 
echo Sucessfully created parcelsize.img

scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY parcelsize.img $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/parcelsize
rm parcelsize.img #Directly delete the parcelsize image file again
echo Successfully deployed parcelsize.img to asset server

# Deploy the ui component to the resource server 
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY ui/ui-comp.js $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/ui/parcel-size.component.js
echo Successfully deployed ui-comp.js to asset server