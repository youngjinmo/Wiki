# MySQL

- [mysql 실행하기](#mysql-u-root-p)
- [데이터베이스 생성하기](#create)
- [사용자 생성하기](#create-user)
- [root아닌 사용자로 데이터 베이스 접근하기](#mysql-h-u-p)
- [MySQL 전체 사용자 조회하기](#show-users)
- [사용자 삭제하기](#delete-from-where-user)
- [데이터베이스 권한 설정](#privileges)
- [데이터베이스 선택하기](#use)

<br>

## <a name="mysql-u-root-p"></a>mysql 실행하기

~~~bash
$ mysql -u root -p
~~~

그리고 비밀번호를 입력하면 mysql에 접속된다.



## <a name="create"></a>데이터베이스 생성하기

~~~mysql
mysql> CREATE mydb;
~~~



## <a name="create-user"></a>사용자 생성하기

~~~mysql
mysql> CREATE USER username@'%' identified by '1q2w3e4r';
mysql> CREATE USER username@'localhost' identified by '1q2w3e4r';
~~~



## <a name="mysql-h-u-p"></a>root아닌 사용자로 데이터 베이스 접근하기

~~~mysql
mysql> -u사용자명 -p 데이터베이스명 
~~~



## <a name="show-users"></a>MySQL 전체 사용자 조회하기

root 계정으로 MySQL을 실행한다.

~~~mysql
mysql> mysql -u root -p
~~~

비밀번호를 입력해서 MySQL이 정상적으로 실행되었다면, 아래의 명령어로 현재 MySQL DBMS에 생성된 사용자 목록을 조회할 수 있다.

~~~mysql
mysql> SELECT user FROM mysql.user;
~~~



## <a name="delete-from-where-user"></a>사용자 삭제하기

~~~mysql
mysql> DELETE FROM mysql.user WHERE user='username'
~~~



## <a name="privileges"></a>데이터베이스 권한 설정

~~~mysql
mysql> GRANT ALL PRIVILEGES ON mydb.* TO username @ '%' identified BY 'password';
mysql> GRANT ALL PRIVILEGES ON mydb.* TO username @ 'localhost' identified BY 'password';
mysql> FLUSH PRIVILEGES;
~~~

 마지막에 `flush` 명령어를 입력해주어야만 `privileges` 설정이 MySQL에 반영된다.



## <a name="use"></a>데이터베이스 선택하기

~~~mysql
mysql> USE mydb;
~~~

