# Sample App - Document processing status app
This is a sample application which is developed using idea-mart. The purpose of this application is to notify the user using sms with the latest status of their submissions.

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
## Sample use-cases
* Banks  
Apply for your credit card and stay in touch with the process.  
User submits the application for credit card -> Employee at the bank records the details -> User can obtain the status of the application via ``reference Number``

* Small scale restaurants  
Place your order via mobile and track your order.  
User places a purchase order via mobile-> Employee at the restaurant records the order -> User can obtain the status of the order via ``reference Number``

* Healthcare  
Check whether your lab report is ready for collection.  
User submits a blood sample-> Employee at the hospital laboratory records details -> User can obtain the status of the lab report via ``reference Number``
