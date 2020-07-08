# 내가 만난 에러들

하루에도 수십번씩 만나는 다양한 에러들을 한 번쯤은 사전처럼 정리하고 싶다는 생각이 들었는데, 더이상 미루기 싫어서 시작해본다.

**에러 목록들**

## <a name="mysql-8-grant"></a>MySQL 8 버전에서 계정 생성과 동시에 권한을 주려고 하는데 ERROR 1064가 발생할 때.

![](https://lh3.googleusercontent.com/pw/ACtC-3eXvKWtKGClCV0F3-eU5TCf-0HJ9Qxz2GTv_RM1MLI_QmnBgSDbGFjPo0AZ4s6UdSBkX5HIHkK_s3Hnf1NIYmQ7ppBpaiY2T7MNgsn7GfHt7VUhC9EHHXT-SuxzN_5zEed6XGtk5b0yb9MvWVklZ5AtCA=w1792-h1040-no?authuser=0)

- MySQL에서 `GRANT` 명령어로 사용자를 생성하려고 하면, ERROR 1064가 발생한다.
  
- MySQL 8버전부터는 권한설정과 사용자계정 생성을 분리해서 해야한다.
  
- ```mysql
  CREATE USER devandy@'%' identified by '1q2w3e4r';
  CREATE USER devandy@'localhost' identified by '1q2w3e4r';
  
  GRANT ALL PRIVILEGES ON connectdb.* TO 'devandy'@'%';
  GRANT ALL PRIVILEGES ON connectdb.* TO 'devandy'@'localhost';
  FLUSH PRIVILEGS;
  ```

