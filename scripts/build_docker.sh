#!/bin/bash

# Build the docker image for the parcel size service
docker build -t parcelsizecomponent .
echo Successfully built docker image

# Deploy the docker image to the resource server
docker save --output parcelsizecomponent.tar parcelsizecomponent:latest 
echo Sucessfully created parcelsizecomponent.tar

scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY parcelsizecomponent.tar $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/images/parcelsizecomponent.tar
#rm parcelsize.img #Directly delete the parcelsize image file again
echo Successfully deployed parcelsizecomponent.tar to asset server

# Deploy the ui component to the resource server 
scp -o StrictHostKeyChecking=no -i $RESOURCE_SERVER_KEY ui/ui-comp.js $RESOURCE_SERVER_USER@$RESOURCE_SERVER:$RESOURCE_SERVER_ROOT/ui/ui-comp.js
echo Successfully deployed ui-comp.js to asset server