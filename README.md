# Sample App - Document processing status app

## Prerequisites  
* Java 8.x
* MySQL 8.x
* Maven 3.x
## Required Configurations  
* Create following 'passport_request_store' Databases in MySQL and create table 'passport_request' using following attributes.
```
id                  INT             AUTO_INCREAMENT    
ref_no              VARCHAR(20)     UNIQUE KEY  
full_name           VARCHAR(200)  
address             VARCHAR(200)  
nic                 VARCHAR(20)    
status              VARCHAR(20)    
created_date        DATE  
last_updated_date   DATE
```
* Add following DNS to '/etc/hosts' file.  
```  
  127.0.0.1       db.mysql.passport
  127.0.0.1       core.passport.service
```
