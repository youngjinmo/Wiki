# AWS

서버리스(Serverless)라는 것이 유행이다. 따로 서버를 구축하기보다는 클라우드 컴퓨팅서버를 이용함으로써 서버 운영에 필요한 리소스를 절약하는 것이다. 이에 이 글을 작성하는 시점(2020년 1월)에는 아마존의 AWS가 시장 1위를 달리고 있다.

<img src="https://miro.medium.com/max/2000/0*XSE7U6J366ZIFqGL.jpg" style="zoom:75%;" />

<img src="https://miro.medium.com/max/2276/0*XJ3gOPA67yLmXMrv.png" style="zoom:50%;" />



### ToC

- [Region과 Availability zone](#region)
- [EC2 인스턴스의 기능](#ec2)
- [터미널로 EC2 인스턴스 접속](#entering-ec2)
- [시스템 재부팅](#reboot-ec2)
- [EC2 인스턴스에 한글 언어팩 설치](#locale-ko-utf8)
- [EC2 인스턴스(Ubuntu)에 JDK 설치하기](#install-jdk-ec2)
- [awscli 설치하기](#awscli)
- [Apache2 웹서버 실행](#start-apache2)
- [키페어(.pem) 자동으로 읽어오기](#autoload-pem)
- [호스트네임 변경하기](#change-hostname)

---

## <a name="region"></a>Region과 Availability zone

Region(지역)은 (서울, 대한민국) 또는 도쿄, 일본 처럼 물리적인 지역을 이야기한다. Availability zone(가용구역, 이하 'az')은 Region을 커버하는 데이터센터를 의미한다. 

az은 **<u>장애가 발생했을 경우 이를 복구하기 위한 백업</u>**으로 활용된다고 한다. 

각 az는 전용선으로 연결되어 있기 때문에 서로 데이터 전송이 가능하다고 한다. 

<img src="https://lh3.googleusercontent.com/TONsAI-379iXqsuA3DqYg2qbNFEdUQS1lntuM_k_NZ6jiaPY5YU0zl1fE88jCuWYtaTArnlUpV-nlFrgMG7rMVsO04oTYziLBR6IfYkxTh1U89WEW7JXzz9QiluADRfizVDcHImd4XDvbwd52djebVfrdV1VjZMUJUMfXbJinyeS8xKuDyxEGXmik6N0Rb3y_1a2nNfGpEwREWWA19WTpI9-yQ-idbbgY1Fn9k_Ks196UzL2zdpv40JrqphnM6MiwEZ6Vs6faW-2KgrUGoYQ9Fj1gnN0dU8n1g_g6tscFFmOjjavf6jB1Oq7iWTnyOtoOHcG8yev00N3ogioF2_nYmuFbN9Q0m2DCIdkAEwzFlXA2UtoB9mRSstznP8jeOLV8_gyG8n6QTr0aYmmr0g6XdLTGrMFal9h02rbKfyKjdvc2fuhhC2KvZpfxzTVFDZ52Q7YeJaqIqW2qY0hZKrLNqC-b8qnMTg6tC98hGPcDcdcJjt1IkcrIYy1vWv3mnTmf1h2OqbL-xzQIu-smoYJTDznFdiBGdN0DgGuilBfLl3FAmVyhePHupmhVDHdd20vjM57l74lcd5BqeWAEknR2pd5OHcwxVHr5VHLE_WVK2UMWP4wpWw4EnFBvdL1iEcBKJK7l47uF_OiwfUuoFnxTVODvRZmbYjKyPhv5VLzIU_WZ2N0aVeA4Run-okNYq_Etu0c2gyD8TnVKcRpErPUgxuhQfvaMYldWk8qL_owSp13Ys3HCA=w650-h488" style="zoom:80%;" />

<img src="https://lh3.googleusercontent.com/krTHLfBrqWKkOYE4sJzZWGXjYqxKu2SH4L_4LjNitBHjAW7LTSUvEAkdhRedCGwN_9YzIKX19arwPX5KYlI33VXpxJ6AatCOaWyz9616OG1hd1D2Ma9k18-7cWl7-q40WyLtnc1_xRJle_L6ltSPBbTn2q2tCrbtVpJJfEjE-MSyThtvAYPuVYyAjdW0oeq2N9NeYEJOcU1qf4O7XLhvtDPoCyZyYLrv9m-fqgshqbcIpmXCUAkgBFUj2_qnHH2071dh_g2Jt9lpCCyDdtGuTRvt_cy7ZD-Y5fqazthcLMQoy70gfKzC7JSWoQuNITNV1t0DIeJnFlsDdT3c_3RlwgIZVMTi_MteysLH-9GVQGkWzMHNBusQNqmY4dFFnPXXj5sYAvWtyyxkCd6WjLPz3OzRfQgbmW567NOqQKTvnXf2FnhJl8D5S59wwW3diMy6NMS3o57ppNSz5lU4ohrqLOEum3rgzNxnc8hqrAKMVEPsiEySV-s7afyJXTxbpShfUK7Wg3_jAK8bMFCAHrLz-uMZqYJx909Mcsw3f2fk9N3HlXuCE_qCjPf5M61FVCAhUJtmGaJzcr2JVuNe0XE4BAW2nGbI1XtKdTGhkYvI0Vux8nqyGFtIWr3n3VgHcGt781v7x4yCDHbXJjo0FCj0R-dTAleUJicT2gok683btEGE2JYv8nGvVp6IIbxDW1iOYvqQqHeqS_1CrpSxvTl-aAYmz1npEKz8Bu0rnu3wXt_iTQATpg=w650-h326" style="zoom:80%;" alt="AWS" />

<br>

##<a name="ec2"></a>EC2 인스턴스의 기능

AWS에서 EC2 인스턴스는 하나의 가상 컴퓨팅 환경을 의미한다. 컴퓨터 한 대를 생각하면 된다.

AMI(Amazon Machine Image)은 서버에 필요한 운영체제와 여러 소프트웨어들이 적절히 구성된 상태로 제공되는 템플릿인데 이를 통해 인스턴스를 쉽게 만들 수 있는 것이다.

인스턴스 유형 : 인스턴스를 위한 CPU, 메모리, 스토리지, 네트워킹 용량의 여러 가지 구성을 제공한다.

![](https://lh3.googleusercontent.com/cEIWa2xJAONLQJSDaGuvVr91VwV2xTdSsHL4YCt9ngyM72ep4OWMC8G6FTd4W8p5K4yBpui9YB53l_lb5nVUIasYNQ20KSnBChfKxtMU34tBVV9gkrOCT8A6hITRfrarMhl8Ot6iEUMLLWMifzbfVY46FukiZOQ43ZFbo9mOsKXSeTFnZiRmThpCwTQtapZZudxXFJwxtq5Ntz03YMw1jxfcIvvRN6X35cs-HDrA7mAwfUib8y2-b2bD9FXGQoVHxLKIJFd_jWh5YuUd6A9e-VqdtEjW57b-sA6z3N36iddlnPCdLL-2fZBCkIg_tHhaNVjSPaffv2X3GBQDnqyNNlUXEoJilqVYQhVW4Egl0qSW2Pn-JXfnw2DwHjan_RWFRoIvdupuHRpRlosthfYuIwjnu0lk53Zpdw6eChZhihubHZZvhecPVcyMzYAcoe0_vAiQGlcnU0Y5cITnGijYpSdrqCklBQTgnj-fvm75sLOG6miUuzPDy4JoSra0vmGsrN5oqIgZ4mou76aXQEGiLP6NtY6geP9hhHZR6Kq4wN0KCAdTUhZRKge_9KZ-d-psgN9xivLdN7CeWcopHGZnsxON5EetAyl95dm7pcCy938TG-dNgFmTEjVKIG6I_94118hTCBBgvO3iyvjyX4oTFH5_RWEMsS-p7o3CJEaNRroAFukPMrew3Z3MEpBzYDNA9aSj_O3uHaJ2EP5nisuLcc1WQCz7xt828r8ApxhLjD4j34zq2A=w720-h415-no)

출처 : [AWS 공식문서](https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/concepts.html)

<br>

## <a name="entering-ec2"></a>터미널로 EC2 인스턴스 접속

aws에서 발급받은 key 디렉토리와 접속하고자 하는 EC2 ip주소를 함께 입력한다.

`$ ssh -i aws-key/keypair.pem ec2-user@ec2-public-ip-address`
![](https://lh3.googleusercontent.com/MSEtddwUB8DHXaK0GMxWhokA1MvyZF3gY3LfJf75IY7ocJ_l8sC6K3g8OzWDMFFGtqekR1XvV_rU8eeFIOAd_-KG2-0pP5MNkfDKtC1QBf_Q4AfADtPnaDb3a3jtqS9_upjqXq8gCIKE3-41qfcUaJpzLMDF0Zr46TFWqH3DohkscDZlev9mXC5W_VO7zqdRBlPv3yfNnNhlI6qpXQEc4CsWHDRh0DwktBe3A1IIYBT391gTSMhsC3hr3mZQMLl-CmoOtWDu1fKtkXXL6f6CM3bUTCnz8ON2hQKvhNS6XMtAqqg8Ns8MgrQfqd34PLovOE2Q1iEFwvHWIm9Q4oXKG-L75VOq1EDYtrPCOUduYhJrVy3JCj4oZHamVWFpOkzfZwGmnNVl1DWA6zotVzqo6QzqU4MUwemuK3-jRmxaTdV2FWZ-lmJwSlopRxieGiFcYagAswf9tylPqwiRGKxGiTL4GL9RmZBv-yi2RhWKnGznTgdWXc8b5ygBGnui9zWRvqzlv5RADBUiaxfjiCONtUPnRu5gefQSxvQCtYkeXKmrZ7qCS6dAlgU4QMTpoXylM3u82BUbnpE1Ig9wyLvjXIZbHH751yLKgDYSXXCdVTwFOIoWQMOAMZKIBZp8UcnX2nu7ChXMyN2WOazqhAIjj9DWWWhK3vTc2JekDzAeDmeMCla5SMWXF-176xulpEBAtf7qJOchfrRijHVKar8NaOSe_HZGIkNxYVRd8N4nuiqYgy06oA=w720-h349-no)

<br>

## <a name="reboot-ec2"></a>시스템 재부팅

AWS에서는 일반적인 Ubuntu 재부팅 <a href="https://github.com/youngjinmo/TIL/blob/master/DevOps/Linux.md#ubuntu-reboot" target="_blank">명령어</a>만으로는 재부팅이 불가능하다. 쉘모드로 진입한 상태이기 때문에 연결이 끊어질뿐 시스템의 호스트인 AWS EC2는 여전히 실행중이기 때문이다. 따라서 EC2 콘솔에서 인스턴스를 재부팅 해야만 한다.

![](https://lh3.googleusercontent.com/Nhx3IEXSONGBGpeiHYMB0RRGNdjJ22TMe3DDhaQztbJ0tZN0wBK61ZwV7vp4WO4zpUc91NRzR8fQY3b-52H40OML9AMcfg1NyW7qUu_NGeUvXns4ns3CRvoNTzbY7ONyh2Wrp2vXQBPACqSJisyZRc33OE0n8qN7inzYv5FJPMNG4A3sN3-y-7-NjAjzALT_GVebMWO-OAAR1vdM2_sXXKlCoK6V-2k3qJOFvhtnPQXdPxzlgih7zy3dxLRiC3KhiN1CIAFqRO4uGIcsii3tpYnkHQeG6xne-L0WcDwdnF8LbdbKWpXJcBRqfzmwScjnJasAM6WhuavM-yA7juK5ZijA84yzjzvanBf_GVvmXKNvg37tYT6ueCcZk1pq6JcWfh34SAuu1-gLimucKT1bB_SkKVmP7zea1CYsVu71Vxb02SQuF7-GyWgXL6JPFoVo51zqsEaG9Aaqv8MsecsQOvXv3mFwPeAKnKrNK4Nd_aYfPegBxGP8ZZ8kjIevhiEbleG3KbldHXV5oLomwJJalmUWg9uaQapx0qTYPVvcSp55aSYU0x4Gk9pyMNQ-koi0n1iBF17_1KvjaLukHW3d5JPssHXxExbAZ_miGw_f3_qCAMChmDqPEx79Hd4NbuBry6ny4uyRl1KOR_I-8X31262J2qPl6tyGs773b4-DcDCY1RV8-YuALt0VG1kTdTYAUJdls_lHgdAZHQ4g3ix-uDXhBjpv90HgTjfjLiYcUnsIPrAt=w720-h276-no)

<br>

## <a name="locale-ko-utf8"></a>EC2 locale 설정

인스턴스에 접속해서 `locale` 을 입력하면 현재 설정된 locale을 확인할 수 있다.

**Ubuntu EC2 인스턴스라면,**

인스턴스 접속해서 아래 명령어 명령.

`$ sudo apt-get install language-pack-ko`

그 다음으로

`$ sudo locale-gen ko_KR.UTF-8`

**Amazon Linux 인스턴스라면,**

`/etc/sysconfig/i18n` 파일을 수정

`LANG=ko_KR.UTF-8`

출처 : [Beomi's Tech Blog - ubuntu Locale 한글로 바꾸기](https://beomi.github.io/2017/07/10/Ubuntu-Locale-to-ko_KR/)

<br>

## <a name="install-jdk-ec2"></a>EC2 인스턴스(Ubuntu)에 JDK 설치하기

- `$ sudo apt install default-jdk`
- 구버전 설치할 경우, [Oracle Java Archive](https://www.oracle.com/technetwork/java/archive-139210.html)에서 버전을 찾아서 설치.
  
- `$ ssh -i [aws-public-key].pem ubuntu@[ip-port@aws]`
- AWS 서버를 실행할 때마다 ip주소가 바뀐다. 바뀐 ip주소를 입력해야 정상적으로 AWS 웹서버에 접속할 수 있다.

<br>

## <a name="awscli"></a>AWS-CLI 설치하기

AWS Command Line Interface(AWS CLI)는 명령줄 shell의 명령을 사용하여 AWS 서비스와 상호 작용할 수 있는 오픈 소스 도구이다. AWS CLI를 사용하면 원하는 터미널 프로그램에 있는 명령 프롬프트(Terminal, iTerm2)에서 브라우저 기반 AWS Management 콘솔에서 제공하는 것과 동일한 기능을 구현하는 명령을 실행할 수 있다.

```
$ aws configure
AWS Access Key ID [None]: AKIAIOSFODNN7EXAMPLE
AWS Secret Access Key [None]: wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY
Default region name [None]: us-west-2
Default output format [None]: ENTER
```

출처 : <a href="https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/cli-chap-welcome.html" target="_blank">ASW - AWS Command Line Interface란 무엇입니까?</a>



설치는 아래의 명령어로 설치한다.

```
$ sudo apt install awscli 
```

<br>

## <a name="start-apache2"></a>Apache2 웹서버 실행하기

**Apache2 웹서버 실행하는 방법**

```
$ sudo /etc/init.d/apache2 start
$ sudo service apache2 start
```

<br>

## <a name="autoload-pem"></a>키페어(.pem) 자동으로 읽어오기

쉘 모드로 진입하기 위해 아래와 같은 명령어를 계속 입력해야한다.

```
$ ssh -i aws-pem-경로 ubuntu@ip주소
```

이제부터 키페어를 자동으로 읽어오도록 할 것이다. 그럼 앞으로 EC2 인스턴스에 쉘 모드로 진입할 때마다 키페어 경로를 입력하지 않아도 된다.

```
$ cp /aws-pem-경로 ~/.ssh/
$ chmod 600 ~/.ssh/pem이름
```

키를 `~/.ssh/` 에 복사하고 키의 권한도 변경했다. 이제 config 파일을 수정한다.

```
$ vim ~/.ssh/config
```

vim 에디터모드로 입력창이 열리면 아래와 같이 입력한다.

```config
Host 서비스명
	HostName ec2-ip주소
	User ubuntu #AmazonLinux면 ec2-user
	IdentityFile ~/.ssh/pem이름
```

마지막으로 해당 파일의 권한을 변경한다.

```
$ chmod 700 ~/.ssh/config
```

이제 간단한 명령어로 EC2 인스턴스에 접속이 가능한다.

```
$ ssh 서비스명
```

<br>

## <a name="change-hostname"></a>호스트네임 변경하기

호스트네임을 변경하면, AWS keypair를 자동으로 연결하도록 [설정](#autoloard-pem)한 후 아래처럼 간단하게 접속할 수 있다.

```
$ ssh DevAndy-SpringBoot
```

AWS 우분투 EC2에서 호스트네임을 변경하는 방법은 다음과 같다.

```
$ sudo vim /etc/sysconfig/network
```

~~~
NETWORKING=yes
HOSTNAME=[바꾸고 싶은 hostname]
NOZEROCONF=yes
~~~

변경 후 서버를 reboot하면 바뀐 hostname으로 적용된다.

그리고 확인해본다. 

```
$ hostname
```

이제 쉘 모드에서 보여지는 ip주소(`ubuntu@ip-172-xxx-xx-xxx`) 대신 호스트네임(`ubuntu@Devandy-lectureSearch`)으로 보여질 것이다.

<br>