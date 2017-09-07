package com.aps.admin;

import java.util.Properties;

import org.I0Itec.zkclient.ZkClient;

import kafka.admin.AdminUtils;
import kafka.utils.ZKStringSerializer$;

public class CreateAdminService {

	public static void main(String[] args) {
		// String zookeeperHosts = "dev-qa-pliny09.kendall.corp.akamai.com";

		String zookeeperHosts = args[0];
		String topicName = args[1];
		int replicationFactor = Integer.parseInt(args[2]);
		int partitions = Integer.parseInt(args[3]);

		int sessionTimeOut = 10000;
		int connectionTimeOut = 10000;
		ZkClient zkClient = new ZkClient(zookeeperHosts, sessionTimeOut, connectionTimeOut,
				ZKStringSerializer$.MODULE$);
		if (!AdminUtils.topicExists(zkClient, topicName)) {
			AdminUtils.createTopic(zkClient, topicName, partitions, replicationFactor, new Properties());
			if (AdminUtils.topicExists(zkClient, topicName)) {
				System.out.println("Topic " + topicName + " created.");
			} else {
				System.out.println("Topic " + topicName + " couldnot be created.");
			}
		} else {
			System.out.println("Topic " + topicName + " already exists.");
		}
	}
}
