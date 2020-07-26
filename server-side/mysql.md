# MySQL

- [mysql 실행하기](#mysql-u-root-p)
- [데이터베이스 생성 및 삭제](#manage-db)
  - [데이터베이스 조회하기](#show-db)
  - [데이터베이스 생성하기](#create-db)
  - [데이터베이스 선택하기](#use-db)
  - [데이터베이스 삭제하기](#drop-db)
- [사용자계정 생성 및 삭제](#manage-user)
  - [MySQL 전체 사용자 조회하기](#show-users)
  - [사용자 생성하기](#create-user)
  - [사용자 삭제하기](#delete-user)
  - [생성한 사용자로 접속하기](#join-db-user-created)
- [데이터베이스 권한 설정](#manage-privileges)
  - [권한 부여](#grant-all)
  - [권한 조회](#show-grants)
  - [권한 삭제](#revoke-all)

<br>

## <a name="mysql-u-root-p"></a>mysql 실행하기

~~~bash
$ mysql -u root -p
~~~

그리고 비밀번호를 입력하면 mysql에 접속된다.

<br>

# <a name="manage-db"></a>데이터베이스 생성 및 삭제

## <a name="show-db"></a>데이터베이스 조회하기

~~~mysql
mysql> SHOW databases;
~~~

## <a name="create-db"></a>데이터베이스 생성하기

~~~mysql
mysql> CREATE mydb;
~~~

## <a name="use-db"></a>데이터베이스 선택하기

~~~mysql
mysql> USE mydb;
~~~

## <a name="drop-db"></a>데이터베이스 삭제하기

~~~mysql
mysql> DROP DATABASE mydb;
~~~

<br>

# <a name="manage-user"></a>사용자계정 생성 및 삭제

## <a name="show-users"></a>MySQL 전체 사용자 조회하기

root 계정으로 MySQL을 실행한다.

~~~mysql
mysql> mysql -u root -p
~~~

비밀번호를 입력해서 MySQL이 정상적으로 실행되었다면, 아래의 명령어로 현재 MySQL DBMS에 생성된 사용자 목록을 조회할 수 있다.

~~~mysql
mysql> SELECT user FROM mysql.user;
~~~

mysql 이라는 기본 데이터베이스의 user 테이블을 조회하는 쿼리이다.

![](https://lh3.googleusercontent.com/obV1FxWYSS70OSqieTMn7JZNS-M3bQPiBY6Ih2o7HuuzLkrA3bcsSVUrrh3p06ua9nOJ2M2HHAfUQsz5so2MKtVsEdqZH6bkgZYRzVnxjlEUsWkrkbwpbz2MleRT7YL4i_sy5nNCbxEGjTIFrpzoh9IjEdJ1sPGW1vJwAav5TnH7PhD1Bp8iH5XkXbIboCEe4fY585FewIYSfbg3uPK61K12cxala5B5wD_9YXFHMdTEk2H6ROnCU3edbNyax6oxYQ-CDHfC6kuyWSF3VanX3xMMIGpLuB5ArcxXw0TJUd-UVWieAGl2dqtnr8dNhzC52rwvKE2NHF5YmckexHQ-GBdage44Vlro59VUOTLnWMAXLGYj2u_aLz7f8Vn5LyAGc77P2VbRHUh4yCuTB6blBgNmo5Fk47v1r0BEuntsDJ_4r4_A-b8VZqhQYpN6K_3e8QmD2QwKr_rqTS1thuWLCj8_S55ySpzvWGWH44npASTlgwsk_D0iKT63p2HFIhlLw8ZFW9LEkoPLyh0nS9hO4-1C6zv1-P2HQSc_19gSh5Vh6g3n6LKcClxprxweIwTFrRqEqUNV8a1qO8Z04vVrTcs275F5c22iZ__0bW313uTRJs6_LuN366o3IjDy6hMkkZ8slhSdz-gNoYOLS6Q0YwQOnrJLpU42MNuPyIyXVBwhtGbvaa2sjNZWbAvg3xA=w602-h321-no?authuser=0)

## <a name="create-user"></a>사용자 생성하기

~~~mysql
mysql> CREATE USER username@'%' identified by '1q2w3e4r';
mysql> CREATE USER username@'localhost' identified by '1q2w3e4r';
~~~

## <a name="delete-user"></a>사용자 삭제하기

~~~mysql
mysql> DELETE FROM mysql.user WHERE user='username'
~~~

## <a name="join-db-user-created"></a>생성한 사용자로 접속하기

~~~shell
$ mysql -udevandy -p mydb;
~~~

<br>

# <a name="manage-privileges"></a>데이터베이스 권한 설정

## <a name="grant-all"></a>권한 부여

~~~mysql
mysql> GRANT ALL PRIVILEGES ON mydb.* TO username @ '%';
mysql> GRANT ALL PRIVILEGES ON mydb.* TO username @ 'localhost';
~~~

 마지막에 `flush` 명령어를 입력해주어야만 `privileges` 설정이 MySQL에 반영된다.

~~~mysql
mysql> FLUSH PRIVILEGES;
~~~

## <a name="show-grants"></a>권한 조회

설정이 잘 적용되었는지 확인하고 싶다면 아래의 쿼리로 확인해볼 수 있다.

~~~mysql
mysql> SHOW GRANTS for devandy@localhost;
~~~

![](https://lh3.googleusercontent.com/pw/ACtC-3eDRtMBisRn3wdR4M9lGqRUO6GwZmH1JjXuSt1LzRQ4q3W9CfHSuzq3_-eGRTbXnZqK-LPBzZp793NEW2IXAlYLScZpGUjGc5yMmVa_IKXxom1LVbr2Oc9cSx5an_y2qKSTYcuczTHqzTtytV6Ov8SBYQ=w753-h201-no?authuser=0)

## <a name="revoke-all"></a>권한 삭제

만약 권한설정이 잘못되었거나 권한을 삭제하고 싶다면, 아래의 쿼리로 입력하면 된다.

~~~mysql
mysql> REVOKE ALL on *mydb.* FROM devandy@localhost;
mysql> REVOKE ALL on *mydb.* FROM devandy@'%';
~~~

![](https://lh3.googleusercontent.com/pw/ACtC-3d6ftb99xfZOEOj9EcVcBDYVH8mnRwJNz-4cEPJqUy3PcZxqTYWaJyriHIZaxM725uQPZaLjJMp8bgsaZxZqNFk-njCaZL9cMBYFm0zNX_n-HRDu2xuBMBWGIkDbYbwDVnq53OcYnJG1iknGnn7t-8TsQ=w685-h210-no?authuser=0)

<br>