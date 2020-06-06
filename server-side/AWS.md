# AWS

서버리스(Serverless)라는 것이 유행이다. 따로 서버를 구축하기보다는 클라우드 컴퓨팅서버를 이용함으로써 서버 운영에 필요한 리소스를 절약하는 것이다. 이에 이 글을 작성하는 시점(2020년 1월)에는 아마존의 AWS가 시장 1위를 달리고 있다.

<img src="https://miro.medium.com/max/2000/0*XSE7U6J366ZIFqGL.jpg" style="zoom:75%;" />

<img src="https://miro.medium.com/max/2276/0*XJ3gOPA67yLmXMrv.png" style="zoom:50%;" />



### ToC

- [Region과 Availability zone](#region)
- [EC2 인스턴스](#ec2)
- [EC2 인스턴스 SSH 접속](#ssh-i)
- [EC2 언어 설정](#locale-ko-utf8)
- [Amazon Linux 비밀번호 변경/설정하기](#setpasswd)
- [awscli 설치하기](#awscli)
- [Apache2 웹서버 실행](#start-apache2)
- [키페어(.pem) 자동으로 읽어오기](#autoload-pem)
- [Amazon Linux에 Java 설치하기](#install-jdk-amazonlinux)
- [Java 설치 경로 찾기](#which)
- [Amazon Linux에 메이븐 설치하기](#install-maven)
- [Java 프로그램 빌드하기 (maven/gradle)](#java-build)
- [Java 프로그램 실행하기 (jar파일 실행)](#java-jar)
- [포트번호 8080으로 리다이렉트 하기](#redirect-8080)
- [터미널 백그라운드에서 서버 실행하기(tmux)](#tmux)

---

## <a name="region"></a>Region과 Availability zone

Region(지역)은 (서울, 대한민국) 또는 도쿄, 일본 처럼 물리적인 지역을 이야기한다. Availability zone(가용구역, 이하 'az')은 Region을 커버하는 데이터센터를 의미한다. 

az은 **<u>장애가 발생했을 경우 이를 복구하기 위한 백업</u>**으로 활용된다고 한다. 

각 az는 전용선으로 연결되어 있기 때문에 서로 데이터 전송이 가능하다고 한다. 

<img src="https://lh3.googleusercontent.com/TONsAI-379iXqsuA3DqYg2qbNFEdUQS1lntuM_k_NZ6jiaPY5YU0zl1fE88jCuWYtaTArnlUpV-nlFrgMG7rMVsO04oTYziLBR6IfYkxTh1U89WEW7JXzz9QiluADRfizVDcHImd4XDvbwd52djebVfrdV1VjZMUJUMfXbJinyeS8xKuDyxEGXmik6N0Rb3y_1a2nNfGpEwREWWA19WTpI9-yQ-idbbgY1Fn9k_Ks196UzL2zdpv40JrqphnM6MiwEZ6Vs6faW-2KgrUGoYQ9Fj1gnN0dU8n1g_g6tscFFmOjjavf6jB1Oq7iWTnyOtoOHcG8yev00N3ogioF2_nYmuFbN9Q0m2DCIdkAEwzFlXA2UtoB9mRSstznP8jeOLV8_gyG8n6QTr0aYmmr0g6XdLTGrMFal9h02rbKfyKjdvc2fuhhC2KvZpfxzTVFDZ52Q7YeJaqIqW2qY0hZKrLNqC-b8qnMTg6tC98hGPcDcdcJjt1IkcrIYy1vWv3mnTmf1h2OqbL-xzQIu-smoYJTDznFdiBGdN0DgGuilBfLl3FAmVyhePHupmhVDHdd20vjM57l74lcd5BqeWAEknR2pd5OHcwxVHr5VHLE_WVK2UMWP4wpWw4EnFBvdL1iEcBKJK7l47uF_OiwfUuoFnxTVODvRZmbYjKyPhv5VLzIU_WZ2N0aVeA4Run-okNYq_Etu0c2gyD8TnVKcRpErPUgxuhQfvaMYldWk8qL_owSp13Ys3HCA=w650-h488" style="zoom:80%;" />

<img src="https://lh3.googleusercontent.com/krTHLfBrqWKkOYE4sJzZWGXjYqxKu2SH4L_4LjNitBHjAW7LTSUvEAkdhRedCGwN_9YzIKX19arwPX5KYlI33VXpxJ6AatCOaWyz9616OG1hd1D2Ma9k18-7cWl7-q40WyLtnc1_xRJle_L6ltSPBbTn2q2tCrbtVpJJfEjE-MSyThtvAYPuVYyAjdW0oeq2N9NeYEJOcU1qf4O7XLhvtDPoCyZyYLrv9m-fqgshqbcIpmXCUAkgBFUj2_qnHH2071dh_g2Jt9lpCCyDdtGuTRvt_cy7ZD-Y5fqazthcLMQoy70gfKzC7JSWoQuNITNV1t0DIeJnFlsDdT3c_3RlwgIZVMTi_MteysLH-9GVQGkWzMHNBusQNqmY4dFFnPXXj5sYAvWtyyxkCd6WjLPz3OzRfQgbmW567NOqQKTvnXf2FnhJl8D5S59wwW3diMy6NMS3o57ppNSz5lU4ohrqLOEum3rgzNxnc8hqrAKMVEPsiEySV-s7afyJXTxbpShfUK7Wg3_jAK8bMFCAHrLz-uMZqYJx909Mcsw3f2fk9N3HlXuCE_qCjPf5M61FVCAhUJtmGaJzcr2JVuNe0XE4BAW2nGbI1XtKdTGhkYvI0Vux8nqyGFtIWr3n3VgHcGt781v7x4yCDHbXJjo0FCj0R-dTAleUJicT2gok683btEGE2JYv8nGvVp6IIbxDW1iOYvqQqHeqS_1CrpSxvTl-aAYmz1npEKz8Bu0rnu3wXt_iTQATpg=w650-h326" style="zoom:80%;" alt="AWS" />

<br>

##<a name="ec2"></a>EC2 인스턴스

AWS에서 EC2 인스턴스는 하나의 가상 컴퓨팅 환경을 의미한다. 컴퓨터 한 대를 생각하면 된다.

AMI(Amazon Machine Image)은 서버에 필요한 운영체제와 여러 소프트웨어들이 적절히 구성된 상태로 제공되는 템플릿인데 이를 통해 인스턴스를 쉽게 만들 수 있는 것이다.

인스턴스 유형 : 인스턴스를 위한 CPU, 메모리, 스토리지, 네트워킹 용량의 여러 가지 구성을 제공한다.

![](https://lh3.googleusercontent.com/cEIWa2xJAONLQJSDaGuvVr91VwV2xTdSsHL4YCt9ngyM72ep4OWMC8G6FTd4W8p5K4yBpui9YB53l_lb5nVUIasYNQ20KSnBChfKxtMU34tBVV9gkrOCT8A6hITRfrarMhl8Ot6iEUMLLWMifzbfVY46FukiZOQ43ZFbo9mOsKXSeTFnZiRmThpCwTQtapZZudxXFJwxtq5Ntz03YMw1jxfcIvvRN6X35cs-HDrA7mAwfUib8y2-b2bD9FXGQoVHxLKIJFd_jWh5YuUd6A9e-VqdtEjW57b-sA6z3N36iddlnPCdLL-2fZBCkIg_tHhaNVjSPaffv2X3GBQDnqyNNlUXEoJilqVYQhVW4Egl0qSW2Pn-JXfnw2DwHjan_RWFRoIvdupuHRpRlosthfYuIwjnu0lk53Zpdw6eChZhihubHZZvhecPVcyMzYAcoe0_vAiQGlcnU0Y5cITnGijYpSdrqCklBQTgnj-fvm75sLOG6miUuzPDy4JoSra0vmGsrN5oqIgZ4mou76aXQEGiLP6NtY6geP9hhHZR6Kq4wN0KCAdTUhZRKge_9KZ-d-psgN9xivLdN7CeWcopHGZnsxON5EetAyl95dm7pcCy938TG-dNgFmTEjVKIG6I_94118hTCBBgvO3iyvjyX4oTFH5_RWEMsS-p7o3CJEaNRroAFukPMrew3Z3MEpBzYDNA9aSj_O3uHaJ2EP5nisuLcc1WQCz7xt828r8ApxhLjD4j34zq2A=w720-h415-no)

출처 : [AWS 공식문서](https://docs.aws.amazon.com/ko_kr/AWSEC2/latest/UserGuide/concepts.html)

<br>

## <a name="ssh-i"></a>EC2 인스턴스 SSH 접속

바로 ssh 접속을 시도하면, 키페어의 접근권한이 문제될 수 있다. 따라서 키페어의 접근권한을 변경한다.

~~~
$ chmod 600 aws/secure/aws-lecturesearch.pem
~~~

chmod(관련 포스팅:[리눅스에서 권한 변경하기](https://youngjinmo.github.io/2019/07/linux-permission/))는 접근권한을 변경하는 리눅스 명령어이다. `chmod 600` 은 사용자 그룹에서 읽고(r:4)/쓰는(w:2) 권한을 허용하는 명령어이다.



aws에서 발급받은 key 디렉토리와 접속하고자 하는 EC2 ip주소를 함께 입력한다.

~~~
$ ssh -i aws-key/keypair.pem ec2-user@ec2-public-ip-address
~~~



![](https://lh3.googleusercontent.com/MSEtddwUB8DHXaK0GMxWhokA1MvyZF3gY3LfJf75IY7ocJ_l8sC6K3g8OzWDMFFGtqekR1XvV_rU8eeFIOAd_-KG2-0pP5MNkfDKtC1QBf_Q4AfADtPnaDb3a3jtqS9_upjqXq8gCIKE3-41qfcUaJpzLMDF0Zr46TFWqH3DohkscDZlev9mXC5W_VO7zqdRBlPv3yfNnNhlI6qpXQEc4CsWHDRh0DwktBe3A1IIYBT391gTSMhsC3hr3mZQMLl-CmoOtWDu1fKtkXXL6f6CM3bUTCnz8ON2hQKvhNS6XMtAqqg8Ns8MgrQfqd34PLovOE2Q1iEFwvHWIm9Q4oXKG-L75VOq1EDYtrPCOUduYhJrVy3JCj4oZHamVWFpOkzfZwGmnNVl1DWA6zotVzqo6QzqU4MUwemuK3-jRmxaTdV2FWZ-lmJwSlopRxieGiFcYagAswf9tylPqwiRGKxGiTL4GL9RmZBv-yi2RhWKnGznTgdWXc8b5ygBGnui9zWRvqzlv5RADBUiaxfjiCONtUPnRu5gefQSxvQCtYkeXKmrZ7qCS6dAlgU4QMTpoXylM3u82BUbnpE1Ig9wyLvjXIZbHH751yLKgDYSXXCdVTwFOIoWQMOAMZKIBZp8UcnX2nu7ChXMyN2WOazqhAIjj9DWWWhK3vTc2JekDzAeDmeMCla5SMWXF-176xulpEBAtf7qJOchfrRijHVKar8NaOSe_HZGIkNxYVRd8N4nuiqYgy06oA=w720-h349-no)

<br>

## <a name="locale-ko-utf8"></a>EC2 언어 설정

인스턴스에 접속해서 `locale` 을 입력하면 현재 설정된 locale을 확인할 수 있다.

### Ubuntu EC2

인스턴스 접속해서 아래 명령어 명령.

~~~
$ sudo apt-get install language-pack-ko
~~~

그 다음으로

~~~
$ sudo locale-gen ko_KR.UTF-8
~~~

<br>

### Amazon Linux EC2

/etc/sysconfig/i18n 파일을 수정한다.

~~~
$ vim /etc/sysconfig/i18n
$ LANG=ko_KR.UTF-8
~~~

만약 권한 문제로 수정할 수 없다면, [chmod](https://youngjinmo.github.io/2019/07/linux-permission/)이용하여 권한을 수정해서 파일을 수정한후 다시 아래의 명령어를 통해 권한을 돌려놓자.

~~~
$ chmod 644 /etc/sysconfig/i18n
~~~

<br>

## <a name="setpasswd"></a>Amazon Linux 비밀번호 변경/설정하기

![](https://lh3.googleusercontent.com/kHDUxeqoOu0i5VV2DbUsCB6xp7ETpry3lQUZvg4pV08zrrgP6XhaKyQf7bYaUu_qFbhU9pnzllUrdQV6PZMNmpRQB9rK6ckJwCDDr2R3groqc28prxw3NQjhBu0wk-zap5Hj3BGDmB_pdSRvvUk5t7ea3fXIbnf0b0uKCjWzyaf2LY1tN4phFOuhZ33l-8VfIstsmZ9Eh0jS0qcqZ4UuXythJkIHoO0OOiH_WfrkpaM1vPBiWLtbH-WBauhP93M5vNgti9bKRJdgZCW8tpTVnQibgpKG2EwpjIwUbzahS7dwmBZA_pz9xOrGmIpT0IUZcXgAUJEn2-9xI2GEgR1IbPr-2AOc3Ggc-PL-3i6gKxZb-vMHx5xcDab3-9fi3zvagDK-5AYbhOaqhtR8yaHCvRAbsLA0MPlve0TjVJeFvqjTi95mCiwDCqjzp-fhIgJJWxZY9LQMU5NUTcsiSdUFv7P7CEPrCeXkSvne_AnNofPT9Yn3ruUGhaIs5lgUnQ1puk_bCFBnOmYml1c_2v1aZWFsjtxb8c7SC2uX1YxSUXHKxYbx_Y3M0m--8-ct8qbMaGeupg1CXEAsqNtQ2K-2EG3Aj9Qdc1y9chpRgcAHhKMaBrGqNFv-Rm2Z0V2R4hvEXMCzfIU9RjC4DU2nFm733tTPzezf0qexkKH3U69UlrcP_xrE2mGtBI4dw-AhhX5np9jZWON75PZO5tNVuiUmvM2JeD2eHI4lkxzj-XGMe3TPzrF2F0qV0LUj=w1438-h181-no)

`sudo`를 계속해서 입력하는게 번거로워서 사용자를 변경하려고 하니 비밀번호를 요구한다. 그러나 ec2를 생성할 때 특별히 비밀번호를 셋팅한적이 없는데 무슨 비밀번호를 입력해야하는거지..?

[AWS 공식문서](https://aws.amazon.com/ko/premiumsupport/knowledge-center/ec2-password-login/)를 확인해보니 비밀번호를 설정해야 사용할 수 있었다. 

~~~
$ sudo passwd ec2-user
~~~

![](https://lh3.googleusercontent.com/Uh0FcUdbxDgUELB2CfQnSSRc_BK_q7zmDGYgqCJEtm5Km1AsyuavkBVL9V6gXDeI9IoP6hTl0whTOeTFXeD2vn4lhMfoGPEq_TbLwQGHJeKWrMoEI0oen76CDM8Zh1HsDZ-uYD6icSTt_CkW9hAi6RrL3Ya5oVJezz5ougFlK76d8yAc4VAeNsY47am3UktMH2K7kNUvX31eFUl3kPZZl05zC9Tjm7QLuxvfOYwCuDAVVIDoLZww9-7KF73xn68Egs7bN6xvci0tHkDn2vtY56NTEAGu7STmpwb1QLcQJ2qFn-QrvvaCW_De5HootFzDUzH8acRkbZhWShrnXcoWAHrJVm_KbkN6mKJgtNpv6qTsqEVMgEElZHNEXWrFt52VBnuAJJ9cj-DsBf09g61c0lvfQEh6OSRUID3qvAlD3Q0t-3xbkkKUH8p4NtaRDhEDTYzLq-Slf7ZzPks53rgZWuRzopEXeC2wWbgdX4Vdz7BOHgSobHkbbImDPCT4z02WG1kotOZ1rhMBeMTNSTxk6HPVsjLsA_dZfElNV0kauh_lRvejc9cRjW3YTeL3bF2gTn_YQVoF3UAQyxU3M4sIdI-s6cZI4bjFRWKp-7Dp847rMUpjHc78g1V5HvHq4axLMDcPc7riuonM3ODPaFM2XfzCBmaQ-xhWrJdzxKjs0DdB6bEm2g6HSjlGDr4VtRB0XkNxw8VKjzomNzRan2Xg0x40bkBmCdbNJSJRgz0PFIRGGpFVeHOEHOw9=w1434-h304-no)



그리고 PasswodAuthenticaion을 활성화해야 한다.

~~~
$ sudo vim /etc/ssh/sshd_config
~~~

sshd_config안에 PasswordAuthentication을 찾아서 no를 yes로 바꾸면 된다.

![](https://lh3.googleusercontent.com/QGtNbNSfEiWiAEQ8O4BQGULE-Q9roC0PascPYFWl0W94AqkAMuZczwHxRshqsfdOVgPdKyA1niUMFHhSUZ27kCYTquhQe6nPcPvwnHgqKjOgZEKfzXRBgyrAjwqaZYaoUo9Sbt6eRuNsyvCxNCbcKo6738Z8fjg0htkL1qIaCMCFvjKagwYqFP_odhKib9Zrm4GJfYI_p-hSl-hX7hrO-DL2OHVLX_PFILsWI31WlExuN53NXQcGL7Z5GFWyvNCCFKYXUEOLW4424darsjbZYOIGbvLrsaRhmeKStsDKT0esqiB7AuuHI_Eha91POJq1oRCavecI7glXLJ5CSG8kFTAe9zmRA2upSjp8WyT40MZkxc6A9xSdnpqyOb_tOof1AwD3H7fp9NIWd64w8UNUdB79UMfReTJxauqevNbnEUMcM72-5wg2VCbbUiRgjyGLFKnuHuR0IVUxrFFdvDv2os8k-QQxOhXiRvpyGUA__uaVwf-uJakUGi0JJSvgjveJXZQMfo9qs3wNMqyWjHQytM-cA4EFuwuGCPZ49xNPD8IzEHFpelCd7x3rewsLjAJhCb5Ib4XqAdsiRZ0Iui1s_x0NcskVNTZFxPKmA6RnOihNhLtppFEs2vZ7JsQq6KHGp9BHimryeI6kCcgbMpVVELlhqSxx3iK_S7AxlXDPTy9TFNCVOQRiqOkthTKoDuKSzHrAySyEnd0x69RWWqdYccUu2QJLp4HRjAdTnlhXIhdb4kppqpWS0hso=w1440-h220-no)

이제 SSH를 재시작하면 바뀐 패스워드가 적용된다.

~~~
$ sudo service sshd restart
~~~

![](https://lh3.googleusercontent.com/Px0CX5SR8iERwo6WrxnChem8s15AgubiyoKFwHXZyjoBsYo1AE4JhaXSAaNGM_zPKh-4vyYGCItMnMYf-feWOxflFOgfEASnHVGa92_90Ofu8Wa4pY6uUSh6bmeNaMdpeW2O4XM7bs4AugOej7EOczHSeRbEtqlpIqbBT73gJDBoYwGEOHG22qpz8rRv2Ox_h_wZ5T0VT64na8FmgaBYzpq4UhH7xY2dYOcO9tf6eHBCSc1oU03Ec-rO8ykYUWtxg2gYU6Brn7K0K9Wwgg1PGR7Uo_7v7xkiK_yzSW8VFLXCqSIAKlqwNcVwlI7Yuf9dnzWMOLYe3IqrRzVMNWHraVMU8TKFqM2KuqnTzBTwGziYpPA-j1O-8snTYjVABl7S89fBVzw-5HN2RwqtqRPI6fVMFe2ApUHfgigSjzloVONRkNI-ikc2ZKOEVKAi-OcMQr_0yj_opVKIXg9xwtDtQnLQVoFb8VsDCEUhNoVKGFsNnEbB1GTKsEaimh1ksJMshOyTHNGUIDLPMaejk3D_HgF54fj6X2weMzV3zOpACL2YBxo5nsnqlcgle69JopCjEnmdB_5TF8Fu8VU7zkpXIj5ShOnLbHD1bf7rpETyiAtPCd7DC-3DOe19y-jfyyBONA9DrcuDTdVXny1jhm2mcV8pqM1c5nsFZP-tnHlhGq36rgG3VdavIKrLQfVQ89T_VdD9pQUvU3Wh-B08ob1KQPInpqLHJWicJZb-N8k5taryxPcX34XDUbZ2=w1444-h139-no)

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

만약 `.ssh` 디렉토리를 찾을 수 없다면, 우선 `ssh`로 원격접속을 최초 1회시도(`ssh -i aws-pem-경로 ubuntu@ip`)를 한 후 다시 시도해보기 바란다.

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

<hr>

### 여기부터 ec2 인스턴스의 타입을 Amazon Linux로 사용하였습니다.

![](https://lh3.googleusercontent.com/wQ_h6mtmotLmbZHlWwEY4tV7G9eozL_ZRZEFfckGiiIiKK03BihC_5Ohy-QzO_NKc2YJJ5OEZNyOkZ6GapUyI3H1pb75oinNedlBp-prOgZl2CnW20CdvqJmWkoHp3-TP6lysnoSJER1-EdUA2VZcrkPJKfXXKGCrTdrspwTbpd1nu9qd-pz8YMUM5M68IMhTn9KcDWoFqRZm-P9bMSYbNj7RYyiRSrkLEeJl7TrTAHE7td5bG0KsY8THV3J9Y6XbE4znnDSHfOeVcNR01IUhawivG_RUWmNeKAT26yDfN6sjBOawEgOcmPyTbs0qGarUMwyu0w96od2d7PmclT_b2dWZuVobWOV6W6Ts2FNQiBr4BmWHytZH4WA_ggM03Cih1tmZJUOi2pHDHJi2jT6CkTmP0pUAPdls5ZaTC6NMG2pFuVrJh63tFEtG1Q6d4vzAwXQb1qoj2dNBNnlROGxmgTKAzatl00v4njX9TLXahjDBkVMWyWaV_nzKPy2QNwwghhqacFL2o2wzy0-fMmL5vXpC7rX-u3eUAvQlrvuMcFiemSQ4y3sj8FjtkgnoWrFZwQDS_nqgERxgt7EIb3_fqBVUf7jUpg1xojptG-lS-HicvAsumGstZvGltHP7--LsTBZ6tCqDoO9BsQJT8wXCJyfMd658_OvD_1RyfXDiWTIxyGrNIjZ8i-j5RXVs21zlOkZlUs7B7DwVOtaOstwGyGEpibE_L05X94Fi1xHrpLWe1HYHA=w1440-h708-no)

<hr>

<br>

## <a name="install-jdk-amazonlinux"></a>Amazon Linux에 Java 설치하기

yum list를 업데이트 해준다. 안해줘도 Java를 설치할 수 있지만 패키지를 설치하기 전에는 패키지 관리툴을 업데이트하는 걸 선호한다.

~~~
$ sudo yum update 
~~~



**Java 1.8 jdk 설치하기**

~~~
$ sudo yum install -y java-1.8.0-openjdk-devel.x86_64
~~~



설치했다면, 인스턴스의 Java버전을 방금 설치한 Java 1.8로 변경한다.

~~~
$ sudo /usr/sbin/alternatives --config java
~~~

![](https://lh3.googleusercontent.com/G9pdacK0rNY2U58xFShcwprYtWRNZ3zuEq6gJSyOOg8g6Kd1sZGLKlbaq-vlBI28ti6n12NM82yw_Ghx1kVHFaXSCtHLuVtRnApbnRVC3YCmEO6GPct0SHpw-MYd1XmDQHGBfcOweNezZkoAIVMfKB-NV-BZXWJCK-7uEr7Bzi7qLksVHS47U9d9eOfZ3X59yYjYFo3wBnjGVs0NKEQ-Um6WkNO-b_eK0MjgFdntLu8uT5qYhIBPc32GEOisj2NEoZKcflgZd5ef_wlPfJVxP95p-pv6UpL6O16KS1qeaXijc64ThatP8-uUdekKGeb5ffdq_ZRHoTbCSVtRenhXFukWxommkHBdqgmoJPZm_DWMD_2fs4C4rL-qoJmwRfKwxxcNL9yicbUu4jGIrcvPBLGP3P47ZUT2U5N1eC_HML_HXwluH3WZKWkP11n9FMCrebaxyGjd7__9jY7kxExGtGU-yBS_ue0k7VfFwChISbPvFx6hyXWf1XyY44lGzjsB75i3tF4CbeNj1MIhV0knbU555FFU1BV4XR0iDiPSx14VHeVAM80OHtdaiFwLfxBbd8AfINJdd_NUs0ZV7qNrhSvlIfdLqJycqZmqOTFc88yu70913sVonh1ynFAIskwX4P5qo5HehnFwp55ySOZsiMcE0oIyyFVBGc2p1v8WEUzrv9Tut_SEnnBJiHP0oqpKAR_Zqcswml5eFigzovGR-Jmq8x0-0dSkYOKgN9QZ6WR0QBpISg=w1440-h375-no)

화면에 저렇게 나올텐데 +가 있는 곳이 현재의 Java 버전이다. 따라서 버전을 바꾸고 싶다면 바꾸고 싶은 버전의 숫자를 입력하고 엔터를 하면 된다.

이후엔 필요없는 jdk를 삭제한다.

~~~
$ sudo yum remove java-1.7.0-openjdk
~~~

<br>

## <a name="which"></a>Java 설치 경로 찾기

```
$ which java
$ which javac
```

<br>

## <a name="install-maven"></a>Amazon Linux에 메이븐 설치하기

~~~
$ sudo wget http://repos.fedorapeople.org/repos/dchen/apache-maven/epel-apache-maven.repo -O /etc/yum.repos.d/epel-apache-maven.repo
$ sudo sed -i s/\$releasever/6/g /etc/yum.repos.d/epel-apache-maven.repo
$ sudo yum install -y apache-maven
$ mvn --version
~~~

<br>

## <a name="java-build"></a>Java 프로그램 빌드하기(maven/gradle)

**Maven**

~~~
$ chmod +x ./mvnw
$ ./mvnw clean package
~~~

**Gradle**

~~~
$ chmod +x ./gradlew
$ ./gradlew build
~~~

<br>

## <a name="java-jar"></a>Java 프로그램 실행하기 (jar파일 실행)

메이븐이나 gradle로 빌드를 했다면, 빌드된 디렉토리내에 `.jar` 로 끝나는 파일이 생성된 것을 확인할 수 있다. 

gradle로 빌드를 했을때엔 프로젝트 디렉토리내에 `/build/libs/` 안에 jar파일이 생성되었다.

해당 파일을 실행하면 프로그램이 실행된다.

~~~
$ java -jar my_project-0.0.1-SNAPSHOT.jar
~~~

<br>

## <a name="redirect-8080"></a>포트번호 8080으로 리다이렉트 하기

~~~
$ sudo iptables -A PREROUTING -t nat -i eth0 -p tcp --dport 80 -j REDIRECT --to-port 8080
~~~

<br>

## <a name="tmux"></a>터미널 백그라운드에서 서버 실행하기(tmux)

**tmux 설치하기**

~~~
$ sudo yum install tmux
~~~



**백그라운드에서 실행할 세션 시작하기**

~~~
$ tmux new -s [name]
~~~

[name]에 세션이름 지정



**현재 실행중인 세션 확인하기**

~~~
$ tmux ls
~~~



**실행중인 세션 종료하기**

~~~
$ tmux kill-session -t [name]
~~~



출처 : [tmux cheatsheet](https://gist.github.com/henrik/1967800)

<br>