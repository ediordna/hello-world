#!/bin/bash

export RESOURCE_SERVER="192.168.56.100"
export RESOURCE_SERVER_USER="vagrant"
export RESOURCE_SERVER_ROOT="/home/user/resources"
export RESOURCE_SERVER_KEY="/home/patrick/AssetServerVM/ssh_key"


./scripts/build_docker.sh