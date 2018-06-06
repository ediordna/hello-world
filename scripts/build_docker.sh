#!/bin/bash

# Build the docker image for the parcel size service
docker build -t parcelsize .

# Deploy the docker image to the resource server
docker save --output parcelsize.img parcelsize:latest

scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY parcelsize.img $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/parcelsize
rm parcelsize.img #directly delete the parcelsize image file again

# Deploy the ui component to the resource server
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY ui/ui-comp.js $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/ui/parcel-size.component.js
