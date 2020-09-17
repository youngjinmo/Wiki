# Docker

![](https://logz.io/wp-content/uploads/2016/01/docker-facebook.png)

- [도커?](#intro)
- [도커 설치](#installation)
- [이미지 설치하기](#create-image)
- [이미지 이름 변경](#rename-image)
- [컨테이너 생성하기](#create-container)
- [컨테이너 이름 변경](#change-container)
- [컨테이너 시작/중단하기](#control-container)
- [도커 이미지 조회하기](#images)
- [도커 컨테이너 조회하기](#ps)
- [bash모드로 컨테이너 진입](#exec-imageid-bash)
- [컨테이너 포트 매핑 확인하기](#docker-port)
- [컨테이너 삭제](#rm-container)
- [이미지 삭제](#rmi-image)
- [Docker Compose](#compose)
- [Docker Volume](#volume)

<br>

<a name="intro"></a>도커란 리눅스 컨테이너에 여러 기능을 추가하여 **컨테이너 기반**으로 애플리케이션을 쉽게 사용할 수 있도록 만들어진 오픈 소스 프로젝트이다. [Go언어](https://golang.org/)로 작성되었으며, 2013년 3월 첫 번째 배포가 이루어졌다고 한다. 

도커는 가상머신과 비교하여 사용되곤 하는데, 일반적으로 말하는 가상머신(Virtual Machine)이란 Host OS의 Hipervisor 위에서 완전히 독립적인 Guest OS를 설치하여 사용하는 방식을 말한다. Host OS와 Guest OS는 서로 완전히 독립적인 구조기 때문에 용량이 크고, 비효율적이라는 단점이 존재한다. 

![](https://images.techhive.com/images/article/2016/05/virtualization-vs-containers-100663417-large.idge.png)

반면 도커는 프로세스 단위의 격리환경을 구축한다고 한다.(가상머신 대비 성능손실이 적다.) Host OS의 컴퓨팅 리소스를 Guest OS에서 공유받기 때문에 이미지 용량이 가상머신 대비 훨씬 작다.

따라서 가상머신을 통해 배포하는 것보다 도커를 사용하는 것이 더 가볍고 빠르다.

<br>

## <a name="installation"></a>도커 설치

[도커 설치페이지](https://docs.docker.com/install/)에서 각 운영체제에 맞는 버전을 설치한다.

이후 터미널에서 터미널 버전을 확인해본다. 

![](http://www.mediafire.com/convkey/e8e2/ys84iv0ru36jz09zg.jpg)

<br>

## <a name="create-image"></a>이미지 설치하기

먼저 원격 Docker Hub에서 설치할 이미지를 조회한다.

```bash
$ docker search [imageID:tag]
```



여기서 official 이미지를 다운받거나 starts가 많은 컨테이너 일수록 신뢰도가 높은 이미지를 다운받으면 된다. 가져오는 방식은 다음과 같다.

```bash
$ docker pull [imageID:tag]
```



로컬에 설치된 도커 이미지를 확인한다.

```bash
$ docker images
```



### 빠르게 이미지를 내려받고 컨테이너를 실행하는 법.

`docker run [image-id]`

위의 명령어를 입력하면 로컬에서 해당 이미지를 가져올 수 있는지 확인하고, 이미지를 가져올 컨테이너가 없으면 원격 DockerHub에서 조회해서 이미지를 가져온다.

![](http://www.mediafire.com/convkey/7c4a/0m31smg83y1l94dzg.jpg)

<br>

## <a name="rename-image"></a>이미지 이름 변경하기

생성한 이미지의 이름을 변경하는 법은 다음과 같다.

```bash
$ docker tag [image-name:tag] [new-image-name:tag]
```

또는

```bash
$ docker tag [image-ID] [new-image-name:tag]
```

<br>

## <a name="create-container"></a>컨테이너 생성하기

가져온 이미지를 통해 로컬에 컨테이너를 생성한다.

```bash
$ docker create -i -t --name [container-name] -p 80:80 [image:tag]
```

위에서 각 명령어는 다음과 같다.

- `--name` : 컨테이너의 이름을 지정합니다.
- `-i` : interactive, 표준입력인 STDIN(Standard input)을 항상 유지하겠다는 내용의 옵션입니다.
- `-t` : Pseudo-TTY를 허용한다는 옵션입니다. Pseudo-TTY(teletypewriter)란 유사 터미널을 의미합니다.
- `-p` : Host의 포트를 컨테이너의 포트로 오픈(listen)합니다.
  - `-p <host-port>:<container-port>`
  - Host의 포트를 지정하지 않으면 임의의 포트로 할당됩니다.

<br>

## <a name="change-container"></a>컨테이너 이름 변경

~~~bash
$ docker rename [old-name] [new-name]
~~~

<br>

## <a name="control-container"></a>컨테이너 시작/중단하기

```bash
$ docker start [c컨테이너-이름]
$ docker stop [컨테이너-이름]
```

<br>

## <a name="images"></a>도커 이미지 조회하기

~~~bash
$ docker images
~~~

<br>

## <a name="ps"></a>도커 컨테이너 조회하기

실행중인 컨테이너 조회하기

~~~bash
$ docker ps
~~~

전체 컨테이너 조회하기

~~~bash
$ docker ps -a
~~~

<br>

## <a name="exec-imageid-bash"></a>bash 모드로 컨테이너 진입

```bash
$ docker exec -it [컨테이너-이름] bash
```

위의 명령어를 통해 도커의 컨테이너 내부에 <a href="https://ko.wikipedia.org/wiki/%EB%B0%B0%EC%8B%9C_(%EC%9C%A0%EB%8B%89%EC%8A%A4_%EC%85%B8">bash 모드</a>로 진입할 수 있다.

<br>

## <a name="docker-port"></a>컨테이너 포트 매핑 확인하기

컨테이너가 몇번 포트로 매핑되어있는지 확인할 수 있다.

~~~bash
$ docker port [컨테이너-이름]
~~~

<br>

## <a name="rm-container"></a>컨테이너 삭제하기

~~~bash
$ docker rm [컨테이너-이름]
~~~

복수의 컨테이너를 삭제하고싶을 때는 `,` 로 구분해서 컨테이너 이름 또는 컨테이너 ID를 추가하면 된다.

<br>

## <a name="rmi-image"></a>이미지 삭제하기

~~~bash
$ docker rmi [이미지-이름]
~~~

컨테이너와 마찬가지로 `,` 로 구분해서 복수의 이미지를 삭제 가능하다.  이미지 기반으로 컨테이나 동작중이라면, 이미지를 삭제할 수 없다. 이 때엔 먼저 컨테이너부터 중지/삭제하고, 이미지를 삭제해야한다.

<br>

### 컨테이너와 이미지 동시삭제

이미지를 통해 생성된 컨테이너가 존재한다면, 이미지 삭제가 불가능하다. 컨테이너를 먼저 삭제하고, 이미지를 삭제해야 한다. 그러나 이를 동시에 할 수 있다.

~~~bash
$ docker rmi -f [이미지-이름]
~~~

해당 이미지를 통해 생성된 컨테이너와 이미지를 동시에 강제삭제된다.

<br>

## <a name="compose"></a>Docker Compose

도커 컴포즈란 다수의 컨테이너를 운용하기 위한 도구라고 한다. ELK를 공부하려던 중 Elastic Search와 Logstash, Kibana 3개의 컨테이너를 연동하고 한꺼번에 실행할 수 있는 도구라고 알게되었다.

도커 컴포즈는 3가지 절차로 진행된다.

1. `Dockerfile` : 앱 환경 설정

2. `docker-compose.yml` : 앱과 실행되는 서비스 설정

3. 도커 컴포즈로 앱 실행

   ~~~bash
   $ docker-compose up
   ~~~

4. 도커 컴포즈로 실행된 스택, 데이터 삭제하기

   ~~~bash
   $ docker-compose down -v
   ~~~

   

**docker-compose.yml 작성 폼**

~~~yml
version: '3'
services:
  web:
    build: .
    ports:
    - "5000:5000"
    volumes:
    - .:/code
    - logvolume01:/var/log
    links:
    - redis
  redis:
    image: redis
volumes:
  logvolume01: {}
~~~

출처 : https://cloudstudying.kr/lectures/306

<br>

## <a name="volume"></a>Docker Volume

도커 볼륨은 컨테이너의 부모 컨테이너 역할을 하는 컨테이너이다. 도커 볼륨을 configure하면, 해당 볼륨을 공유하는 나머지 모든 컨테이너에도 영향을 줄 수 있다.



도커 볼륨 생성

~~~bash
$ docker volume create --name [volume-name]
~~~

볼륨 확인

~~~bash
$ docker volume ls
~~~

볼륨을 공유하는 컨테이너 생성

~~~bash
$ docker create -it --name [container-name] -v [volume-name][dir-shared-volume] [image]
~~~

myVolume이라는 이름을 가진 볼륨을 공유하는 myContainer를 생성하려고 한다. 이미지는 centos를 사용할 것이며, 볼륨과 공유하는 컨테이너내 디렉토리는 `/root` 로 지정하는 예제 명령어이다.

~~~bash
$ docker create -it --name myContainer -v myVolume:/root/ centos
~~~

<br>