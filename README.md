# Spring-Boot-Hibernate-CRUD-Operations-java

Pre requirments
  1) Apache tomcat as a Application Server
  2) MySQl 
  3) Netbeans or eclipse as a IDE

Workflow of configurations
  1) go to the application.yaml file and change DB Ip Address,username,password according to your MySql Server
  2) place ddl-auto to create when you run the application in first time. 




Rest URLs

  1) Save new student to the DB (John and India passed as a parameters. You can replace any values to John and India )
      http://localhost:8081/system/restapi/save/student/john/india
          # place the application port number based on the apache tomcat configuration 
          # ex: http://ipaddress:portnumber/ ....

  2) Get all students from the DB
      http://localhost:8081/system/restapi/get/all/students
          # place the application port number based on the apache tomcat configuration 
          # ex: http://ipaddress:portnumber/ ....

  3) Find one student from the DB (1 passed as a parameter. you can pass any number( value should be exists in the DB) to the system and can get user details from the database. )
      http://localhost/system/restapi/get/one/student/1
          # place the application port number based on the apache tomcat configuration 
          # ex: http://ipaddress:portnumber/ ....
