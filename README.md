# Faour_SMS
This application is a Java Application designed to be a simple Student Management Service where students can login, see their current courses, and register for new courses. This application is ran through the console, and can be executed by running the "SMSRunner" class in the project. The full path name is included below.
Full path name for the SMSRunner class: src/main/java/com.ahmi.jdbc.sms/SMSRunner.java
To access the validateStudentTest method, follow the path name: src/test/java/com.ahmi.jdbc.sms_maven/AppTest.java
This project was made using Java, Hibernate, Maven, and Spring Tool Suite 4.
The framework for the menu is shown below:

====== Main Menu ======
Are you a(n)
1. Student
2. Quit
Please Enter 1 or 2

(Upon login attempt)
Currently logging in...

Please Enter Your Email:
Please Enter Your Password:

====== Hello: "Name of Student" ========
My Classes:
COURSE ID     COURSE NAME     INSTRUCTOR NAME

====== Select An Option ======
1. Register to Class
2. Logout

All Courses:
COURSE ID     COURSE NAME     INSTRUCTOR NAME

Which Course?

My Classes:
COURSE ID     COURSE NAME     INSTRUCTOR NAME

(Upon successful login)
Login complete.

(Upon failed login)
Login failed.

(Upon logout)
You have successfully logged out.
