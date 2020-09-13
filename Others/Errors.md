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

<br>

## <a name="autocrlf"></a>git에서 staging시 warning:LF will be replaced by CRLF 경고

커밋을 못하는 치명적인 오류는 아니고, 그냥 경고인것 같은데 뭘 경고하는지를 몰라서 구글링을 해보았다.

현재 개발하고 있는 스프링부트 프로젝트를 맥OS와 윈도우에서 번갈아가며 작업하다보니 발생한 이슈로 보여진다. Whitespace 에러라고 하는데, 맥OS와 같은 Unix 시스템에서는 한 줄의 끝이 LF(Line Feed)로 이루어지는 반면, 윈도우에서는 줄 하나가 CR(Carriage Return)과 LF(Line Feed), CRLF라고 한다.

![](https://lh3.googleusercontent.com/pw/ACtC-3fvgXjIyNdSU9oVyNOFaqupB6FMSRTK38GEwAOHwBPi3TzgH0OU7Njw49K_REW8gglqS_3lTXxlMFkGwrNlfUZPq2pYnKB5iByqS6VeYin3mVx6m4xlYxfZqvp4ZbGBVGu0lCub2tdk8-y8I9Y47QX-8w=w840-h152-no?authuser=0)

큰 이슈는 아니기에 그냥 넘어가도 되지만, 이를 해결하는 방법이 있다고 한다.

git에 존재하는 `core.autocrlf`라는 기능을 활성화시키면, CRLF는 LF로, LF는 CRLF로 변환해준다고 한다.

**For Windows User**

~~~bash
git config --global core.autocrlf true
~~~

**For Mac/Linux User**

~~~bash
git config --global core.autocrlf true input
~~~





