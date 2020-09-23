# 내가 만난 에러들

하루에도 수십번씩 만나는 다양한 에러들을 한 번쯤은 사전처럼 정리하고 싶다는 생각이 들었는데, 더이상 미루기 싫어서 시작해본다.

- [MySQL 8 버전에서 계정 생성과 동시에 권한을 주려고 하는데 ERROR 1064가 발생할 때.](#mysql-8-grant)
- [git에서 staging시 warning:LF will be replaced by CRLF 경고](#autocrlf)
- [ Eclipse 실행 오류 발생할 때](#eclipse-launch-error)

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

<br>

## <a name="eclipse-launch-error"></a> Eclipse 실행 오류 발생할 때

![출처 : 일상, IT블로그](https://user-images.githubusercontent.com/33862991/93956845-02a87800-fd8e-11ea-8321-bac8e8e232af.PNG)

JDK 버전을 올렸을 때, Eclipse가 jdk를 찾지못해서 발생하는 현상이다.

이 땐 먼저 jdk 버전을 확인한다. cmd 창을 열어서 아래 명령어를 조회한다.

~~~bash
$ java -version
~~~

 jdk version이 업데이트 전의 버전을 바라보고 있다면, 환경변수 설정부터 변경한다.

1. [내 PC] 마우스 우클릭

2. 속성

3. 고급 시스템 설정

4. [고급] 탭에서 환경변수 클릭

5. 시스템 변수의 Path 변경

6. 1. Java 설치경로(bin 디렉토리까지)를 작성한다.
   2. C:\Program Files\jdk1.8.0\bin

7. cmd에서 java -version을 확인한다.

[출처 : 몽고's 개발블로그 - 이클립스 실행이 되지 않을 경우, 환경변수를 등록해주자](https://mongodev.tistory.com/28)

jdk 버전이 제대로 출력된다면, 환경설정 문제는 아니다.

eclipse 설정에서 아직 jdk 업그레이드 전의 버전을 바라보기 때문에 발생하는 현상이다.

~~~
C:\Users\DevAndy\eclipse\jee-2020-06\eclipse
~~~

여기서 이클립스 설정파일을 연다.

![출처 : 일상, IT블로그](https://user-images.githubusercontent.com/33862991/93956841-01774b00-fd8e-11ea-965c-9fc76c8a875c.PNG)

[출처 : eclipse 실행오류 고치기](https://m.blog.naver.com/PostView.nhn?blogId=pgh7092&logNo=221130560840&proxyReferer=https:%2F%2Fwww.google.com%2F)

<br>

