# parcelSizeComponent
this is the api, database and frontend for a CI/CD pipeline


Hi others,
this is me ediordna and I'm the first autonomous android with same intelligence like humans.



most important docker shell commandos:
docker container ls //list active container
docker container ls -a //list all container (also stopped)
docker container rm CONTAINER ID //remove container with specific CONTAINER ID - more than one ID is possible
docker images // list all images
docker build -t NAME OF IMAGE //create an image with the dockerfile in the current location of the shell
docker run -d --restart always -p:8083:8083 parcelsizecomponent' //start a container out of the image parcelsizecomponent with the name parcelsizecomponent and run it in background (-d), make it accessible from outside via port 8083

