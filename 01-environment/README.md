# Data Platform on Docker

The environment for this course is completely based on docker containers. 

In order to simplify the provisioning, a single docker-compose configuration is used. All the necessary software will be provisioned using Docker.  

For Kafka we will be using the Docker images provided by Confluent and available under the following GitHub project: <https://github.com/confluentinc/cp-docker-images>. In this project, there is an example folder with a few different docker compose configuration for various Confluent Platform configurations.

You have the following options to start the environment:

 * [**(Virtual) machine running Ubuntu Linux**](./UbuntuLinuxMachine.md) - a (Virtual) Machine running with Ubuntu Linux and 50 GB free disk space.
 * [**Local Docker Environment**](./LocalDocker.md) - you have a local Docker and Docker Compose setup in place which you want to use
 * [**AWS Lightsail Environment**](./Lightsail.md) - AWS Lightsail is a service in Amazon Web Services (AWS) with which we can easily startup an environment and provide all the necessary bootstrapping as a script.

## Post Provisioning

These steps are necessary after the starting the docker environment. 

### Add entry to local `/etc/hosts` File

To simplify working with the Data Platform and for the links below to work, add the following entry to your local `/etc/hosts` file. 

```
nnn.nnn.nnn	dataplatform
```

Replace `nnn.nnn.nnn` by the IP address of the (virtual) machine, where the Data Platform is running. 

If you like to swith between multiple versions of Data Platforms (i.e. you often need to replace the IP address behin the `dataplatform` alias), there some helper utilities you can use:
 
 * On windows eiher use [HostFileEditor](https://github.com/scottlerch/HostsFileEditor) or [Host Switcher](<https://github.com/svejdo1/HostsSwitcher>) 
 * On Mac OS-X use [iHosts](https://apps.apple.com/app/id1102004240?ls=1&mt=12), which is free with some limitations

## Services accessible on Streaming Platform

Once the dataplatform is running, you can find an overview page by navigating to <http://dataplatform:80> and a list of avaialble services by navigating to <http://dataplatform:80/services>.
