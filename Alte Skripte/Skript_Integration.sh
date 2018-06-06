vagrant up
vagrant ssh
docker load < /vagrant/DockerImagesAsTar/parcelsizecomponent.jar
docker load < /vagrant/DockerImagesAsTar/parcelwebserver.jar
docker load < /vagrant/DockerImagesAsTar/parceldatabase.jar
docker run -d --network=parcelnetwork -p:8081:8083 --name=parcelsizecomponent parcelsizecomponent
docker run -d --network=parcelnetwork -p:8080:8084 --name=parcelwebserver parcelwebserver
docker run -d --network=parcelnetwork -p:3307:3307 --name=parceldatabase parceldatabase



