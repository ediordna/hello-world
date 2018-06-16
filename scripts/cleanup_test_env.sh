#!/bin/bash

#echo Stopping DNS server...
#cd ./vms/dns_server
#vagrant suspend
#echo DNS server stopped
#cd ../..

# Start the test environment VM
echo Halting test environment VM...
cd ./vms/test_env
vagrant suspend
echo Test environment VM halted
cd ../..