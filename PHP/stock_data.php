<?php

/**
 * Imagine you are building some sort of service that will be called by up to 1000
 * client applications to get simple end-of-day stock price information (open, close,
 * high, low). You may assume that you already have the data, and you can store
 * it in any format you wish. How would you design the client-facing service that
 * provides the information to client applications? 
 * You are responsible for the development, rollout, and ongoing monitoring and
 * maintenance of the feed. Describe the different methods you considered and why
 * you would recommend your approach. Your service can use any technologies you
 * wish, and can distribute the information to the client applications in any
 * mechanism you choose.
 */

// 1. Constraints and use cases
// - 3000 requests per 18 hours
// - ~ 4 requests every minute
// - client applications: ios, web, android
// - data as json data
// - clients can get any day data he wishes
// - development 
// - rollout
// - ongoing
// - monitoring
// - maintenance

// 2. abstract design
// - clients will be calling the server via HTTP request, GET
// - client will hit a Load Balancer, which will distribute requests over 2 machines
// - web app layer will be built on a typical mvc framework that can serve HTTP requests
// and responses
// - web app layer will talk to a NoSQL database of key(date) => value(open close high low) string
// via a load balancer
// - any sharing requirements will be base on date segments. etc all 2016 data in 1 shard etc.