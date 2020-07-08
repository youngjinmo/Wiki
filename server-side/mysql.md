# MySQL

- [mysql 실행하기](#mysql-u-root-p)
- [데이터베이스 생성하기](#create)
- [사용자 생성하기](#create-user)
- [데이터베이스 권한 설정](#privileges)
- [데이터베이스 선택하기](#use)

<br>

## <a name="mysql-u-root-p"></a>mysql 실행하기

~~~bash
$ mysql -u root -p
~~~

비밀번호를 입력을 요구하는 프롬프트가 콘솔에 출력되면, 비밀번호를 입력하면 mysql에 접속된다.



## <a name="create"></a>데이터베이스 생성하기

~~~mysql
mysql> CREATE mydb;
~~~



## <a name="create-user"></a>사용자 생성하기

~~~mysql
mysql> CREATE USER username@'%' identified by '1q2w3e4r';
mysql> CREATE USER username@'localhost' identified by '1q2w3e4r';
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

