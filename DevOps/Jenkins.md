# Jenkins

![](https://upload.wikimedia.org/wikipedia/commons/thumb/e/e3/Jenkins_logo_with_title.svg/1200px-Jenkins_logo_with_title.svg.png)

- [Jenkins란?](#overview)
- [설치하기](#install)
- [실행하기](#start)

<br>

## <a name="overview"></a>Jenkins란?

[젠킨스 공식문서](https://www.jenkins.io/doc/)에는 젠킨스를  소프트웨어를 자동으로 빌드, 테스트, 배포하는 오픈소스 자동화 툴로 설명하고 있다. Jenkins는 JRE가 설치된 곳이라면 어디서나 설치할 수 있는 소프트웨어라는 설명도 덧붙였다.



젠킨스공식문서에 있는 설명을 지속적인 통합(Continuous Integration, CI)이라고 한다. CI와 함께사용하는 개념으로 CD(Continuous Delivery, Continuous Deployment)가 있다.  보통 CI와 CD를 묶어서 CI/CD라고 하며, 젠킨스는 대표적인 CD/CD 툴 중 하나이다.

젠킨스같은 CI/CD툴은 다수의 개발자들이 하나의 프로그램을 개발할때 버전 충돌을 방지하기 위해 각자 작업한 내용을 Github이나 Bitbucket과같은 레포지토리에 배포함으로써 지속적 통합이 가능하도록 돕는 툴이라고 한다.

![](https://www.redhat.com/cms/managed-files/ci-cd-flow-mobile_0.png)



CI/CD툴이 등장하기 전까지는 개발자들이 당일 작성한 소스들의 커밋이 끝난 심야 시간대에 타이머에 의해 빌드되었는데 이를 nightly-build라고 한다고 한다. 그러나 젠킨스와 같은 CI/CD툴을 사용하면, 정기적인 빌드가 가능해지며, VCS(Git, SVN)와 연동하여 소스의 커밋을 감지, 자동으로 테스트가 포함된 빌드가 작동되도록 설정할 수 있다.
*출처 : https://ict-nroo.tistory.com/31*

<br>

## <a name="install"></a>설치하기

젠킨스 공식문서에서는 젠킨스를 설치할 수 있는 최소 요건을 작성해놓았다.

- RAM 256MB 이상
- 1 GB 이상의 보조 기억장치(Docker container로 젠킨스를 사용시 10 GB 필요)

회사 또는 프로젝트에서 운용을 한다면, 필요한 서버 사양은 다음과 같다.

- RAM 1 GB 이상
- 50 GB 이상의 보조 기억장치

<br>

현재 회사에서 centos 컨테이너에서 젠킨스를 설치했으므로 본 문서엔 일단 centos에 젠킨스를 설치하는 법을 정리하겠다.

 먼저 redhat yum repository를 설치해야한다. 이후에 redhat package manager인 rpm을 사용해 jenkins를 설치할 것이다.

~~~bash
$ sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo
$ sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key && sudo yum upgrade -y
~~~



젠킨스는 Java가 설치된 곳에서 설치할 수 있다고 하였다. 따라서 JDK도 설치해주어야 한다.

~~~bash
$ sudo yum install jenkins java-1.8.0-openjdk-devel
~~~

<br>

## <a name="start"></a>실행하기

systemctl 명령어로 젠킨스를 실행한다.

~~~bash
$ sudo systemctl start jenkins
~~~



<br>