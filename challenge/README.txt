Kevin Katsis Fooda Coding Challenge

In order to test my submission open the project in an ide (preferably intellij) clean, build, and run the ChallengeApplication.java class

This will start a localhost instance of the api.

Download postman and see the screenshot attached to this project to get the parameters needed to hit the post endpoint.

I have pasted the body below to copy into the body section of postman.

{
    "events":[
     {
         "action":"new_customer",
         "name":"Jessica",
         "timestamp":"2020-07-01T00:00:00-05:00"
     },
     {
         "action":"new_customer",
         "name":"Will",
         "timestamp":"2020-07-01T01:00:00-05:00"
     },
     {
         "action":"new_customer",
         "name":"Elizabeth",
         "timestamp":"2020-07-01T12:00:00-05:00"
     },
     {
         "action":"new_order",
         "customer":"Jessica",
         "amount":12.50,
         "timestamp":"2020-07-01T12:15:57-05:00"
     },
     {
         "action":"new_order",
         "customer":"Jessica",
         "amount":16.50,
         "timestamp":"2020-07-01T10:01:00-05:00"
     },
     {
         "action":"new_order",
         "customer":"Will",
         "amount":8.90,
         "timestamp":"2020-07-01T12:20:00-05:00"
     },
     {
         "action":"new_order",
         "customer":"Will",
         "amount":1.50,
         "timestamp":"2020-07-01T12:21:00-05:00"
     }
    ]
}