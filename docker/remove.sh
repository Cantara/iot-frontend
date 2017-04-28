#!/usr/bin/env bash
echo stopping IotFrontend
docker stop IotFrontend
echo removing IotFrontend
docker rm IotFrontend
echo list active docker containers
docker ps
