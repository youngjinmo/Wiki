# Jenkins

![](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Jenkins_logo_with_title.svg/1200px-Jenkins_logo_with_title.svg.png)

- [Jenkins란?](#overview)
- [CentOS 실행하고 환경 구축하기](#initialized)
- [Jenkins 설치하기](#install)
- [Systemctl로 Jenkins 실행하기](#start)

<br>

## <a name="overview"></a>Jenkins란?

[젠킨스 공식문서](https://www.jenkins.io/doc/)에는 젠킨스를  소프트웨어를 자동으로 빌드, 테스트, 배포하는 오픈소스 자동화 툴로 설명하고 있다. Jenkins는 JRE가 설치된 곳이라면 어디서나 설치할 수 있는 소프트웨어라는 설명도 덧붙였다.



젠킨스공식문서에 있는 설명을 지속적인 통합(Continuous Integration, CI)이라고 한다. CI와 함께사용하는 개념으로 CD(Continuous Delivery, Continuous Deployment)가 있다.  보통 CI와 CD를 묶어서 CI/CD라고 하며, 젠킨스는 대표적인 CD/CD 툴 중 하나이다.

젠킨스같은 CI/CD툴은 다수의 개발자들이 하나의 프로그램을 개발할때 버전 충돌을 방지하기 위해 각자 작업한 내용을 Github이나 Bitbucket과같은 레포지토리에 배포함으로써 지속적 통합이 가능하도록 돕는 툴이라고 한다.

![](https://www.redhat.com/cms/managed-files/ci-cd-flow-mobile_0.png)



CI/CD툴이 등장하기 전까지는 개발자들이 당일 작성한 소스들의 커밋이 끝난 심야 시간대에 타이머에 의해 빌드되었는데 이를 nightly-build라고 한다고 한다. 그러나 젠킨스와 같은 CI/CD툴을 사용하면, 정기적인 빌드가 가능해지며, VCS(Git, SVN)와 연동하여 소스의 커밋을 감지, 자동으로 테스트가 포함된 빌드가 작동되도록 설정할 수 있다.
*출처 : https://ict-nroo.tistory.com/31*

<br>

## <a name="initialized"></a>CentOS 실행하고 환경 구축하기

Jenkins를 CentOS에서 systemctl로 사용하기 위해서는 CentOS/systemd라는 [도커 이미지](https://hub.docker.com/r/centos/systemd/)를 빌드해서 사용하는 것이 좋다.

~~~bash
$ docker search centos/systemd
$ docker pull centos/systemd
$ docker create -i -t -p [port:port] --name [container-name] [image-name] 
~~~

이미지를 빌드하고, 컨테이너를 생성했다. 이제 컨테이너에 진입한다.

~~~bash
$ docker exec -it -u 0 [container-name] /bin/bash
~~~

`-u 0`  은 컨테이너 진입시 root 권한으로 접근할수 있도록 하는 옵션어이다.

이제 CentOS 에서 Jenkins를 설치할 수 있는 환경을 구축한다.

젠킨스는 Java가 설치된 곳에서 설치할 수 있다고 하였다. 따라서 JDK도 설치해주어야 한다.

~~~bash
$ sudo yum install jenkins java-1.8.0-openjdk-devel -y
~~~

<br>

## <a name="install"></a>Jenkins 설치하기

젠킨스 공식문서에서는 젠킨스를 설치할 수 있는 최소 요건을 작성해놓았다.

- RAM 256MB 이상
- 1 GB 이상의 보조 기억장치(Docker container로 젠킨스를 사용시 10 GB 필요)

회사 또는 프로젝트에서 운용을 한다면, 필요한 서버 사양은 다음과 같다.

- RAM 1 GB 이상
- 50 GB 이상의 보조 기억장치

<br>

Jenkins를 설치하기 위해서는 Jenkins repository를 사용할 수 있도록 환경을 구축해야한다.

우선 웹 서버로부터 컨텐츠를 가져오는 프로그램인 Wget부터 설치한다.

~~~bash
$ sudo yum install wget -y
~~~

이후엔 jenkins repository를 wget을 이용해 가져온다.

~~~bash
$ sudo wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat-stable/jenkins.repo
~~~

그리고 Redhat Package Manager인 RPM을 이용해 jenkins key를 가져온다.

~~~bash
$ sudo rpm --import https://jenkins-ci.org/redhat/jenkins-ci.org.key
~~~

마지막으로 이제 Jenkins를 yum으로 설치하면 된다.

~~~bash
$ sudo yum install jenkins
~~~

jenkins가 잘 설치되었는지 확인하기 위해서는 rpm을 통해 확인한다.

~~~bash
$ rpm -qa | grep jenkins
~~~

설치된 jenkins의 버전을 확인하는 다른 방법으로는 `/var/lib/jenkins` 디렉토리내 config.xml을 읽는 방법도 있다.

~~~bash
$ cat /var/lib/jenkins/config.xml | grep version
~~~

<br>

## <a name="start"></a>Systemctl로 Jenkins 실행하기

Systemctl로 Jenkins를 실행.

~~~bash
$ systemctl start jenkins
~~~

현재 상태에서 Jenkins를 실행하면, 에러가 발생할 수 있습니다. `/etc/init.d` 디렉토리의 functions 파일에 문제가 있기 때문인데, 이걸 해결하기 위해서는 yum으로 initscripts 패키지를 설치해주어야 한다.

~~~bash
$ yum install initscripts -y
~~~

그래도 jenkins가 실행되지 않거나 실행되지 않는다면 status를 확인한다.

~~~bash
$ systemctl status jenkins
~~~

이제 jenkins 포트도 컨테이너 포트와 맞춰주어야한다.

~~~bash
$ vi /etc/sysconfig/jenkins
~~~

그리고 vi 입력모드에서 `/port` 를 검색하여 도커 컨테이너의 포트와 젠킨스의 포트를 맞춰준다.

그리고 브라우저 창에서 `ip주소:port` 로 접속하면, Jenkins 로그인창을 띄울 수 있다.

![](https://lh3.googleusercontent.com/pw/ACtC-3cjZ1H3HErfTcuhXLsJ8cTl12nEJwly_2tCSw06YjwNgS8moiIG3xyp2FYBCmbI2kQ6vr9ulYwXM83CHp4C8APPYQ0j8AuWhe0vQsaq1_lqaSvGCvm_s82TObOMoRIXfkZEVAYN_s4bACpQc9dvJuk=w1650-h909-no?authuser=0)

그럼 이런 로그인창이 출력되는데, 다시 콘솔로 돌아가서 화면에서 알려주는 디렉토리에가서 비밀번호를 가져온다.

![](https://lh3.googleusercontent.com/pw/ACtC-3cZrLNZm_ai23aEpeUagIhxdjh37y_BKFfJYfS8ecF94Ag7WJhIKqafZIBW8qYYXVi_x_U2_SoGdtIbICiu9s6nVcFJwAy-Pj0xMq-Pdj25jO5weCtExMm6gBKgNyClxqHAI_H7OXQUREfh77flPi0=w1270-h424-no?authuser=0)

비밀번호를 복사해서 브라우저에 붙여넣으면 Jenkins 플러그인을 설치할 수 있는 화면으로 넘어간다. 설치 끝.

![](https://lh3.googleusercontent.com/pw/ACtC-3cAGJGoM_PONx74nd0QcOj4-jJSIjNsXPes9lwufLslzgZYFIWUkEYJnyXO0kyMOAh1ByxUufONpVey_5Ayz1PlcDFGGW5p3B4B7CznW8W_XWSqbF-VqAbPWzXpYwWuoEj_4QjBiOLvNAvdVpItnpw=w1741-h914-no?authuser=0)

<br>