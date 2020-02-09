# Linux

리눅스는 <a href="https://github.com/torvalds" target="_blank">리누스 토발스</a>가 개발한 컴퓨터 운영체제(OS)이다. <a href="https://github.com/torvalds/linux" target="_blank">오픈소스 운영체제</a>이며, 다중 사용자, 다중 작업(멀티태스킹), 다중 스레드를 지원하는 네트워크 운영체제라고 한다.

리눅스를 운영체제라고 했지만, 정확히는 운영체제라기보다 리눅스 커널이라고 하는게 맞다. 그러나 통상적으로 리눅스 커널과 우분투, 페도라와 같은 운영체제들도 리눅스라고 칭하고 있다.

리눅스의 역사나 배경에 대해서도 차후 더 알아보고 정리해야 할 것 같다.

- [명령어](#linux-commands)
  - [Shell과 Kernel](#shell-kernel)
  - [비트(32/64) 확인](#uname-m)
  - [find](#linux-find)
  - [Symbolic Link](#linux-symboliclink)
  - [grep](#linux-grep)
  - [터미널 결과 출력 저장](#save-output)
  - [복수의 명령어 동시실행](#combine-commands)
  - [슬립모드 진입방지 \(caffeinate)](#caffeinate)
  - [시스템 재부팅](#ubuntu-reboot)
  - [서버시간 변경하기](#change-localtime)
  - [UTF-8 인코딩설정](#setup-utf8)
  - [호스트네임 변경하기](#hostname)
  - [wget으로 파일다운로드](#wget)
  - [계정 생성하기](#adduser)
  - [우분투 패스워드 설정하기](#password)
- [Vi Editor](#linux-vi)
  - [입력 명령어](#vi-input)
  - [이동 명령어](#vi-move)
  - [파일 상태 명령어](#vi-filestatus)
  - [IDE처럼 사용을 위한 Vim 셋팅하기](#vimrc)
- 패키지 관리툴
  - [apt-get](#apt-get)
    - [update와 upgrade의 차이](#difference-between-update-upgrade)
    - [apt-get 패키지 설치/삭제하기](#install-remove)
    - [Java 설치하기](#install-java)
    - [ubuntu에서 java 설치 경로 찾기](#which)

<br>

#<a name="linux-commands"></a>명령어

## <a name="shell-kernel"></a>Shell과 Kernel

![](https://lh3.googleusercontent.com/qxYl-vCqMIO4MaGtuc_5KFvCAyI_qoajHT0p5FwY51s1nbP1-NgSAtMtDkeVplaRZQi1H-hw5M8qqmhH-wQwIQUHNenDgWkf-OuOShPfUmsV5EVb9D8UNbZClTa0mZlVgO3EyPePY6rFfaWHoEDbp627Ay4Le3TV421uLI5BmA4PSwiKxsl7s-s4q5v_YhIQQ_-kugRF1GpRER1q1TvUKhT0jSfHdx4IDnTGqBMy4PNeUUr5rPfAlIs-A6HldTLqTMUZD-aEc73PASY59JfiWiXae3na28h0tYprlHj1RH8BZPd6ISlRihr_NzsBI1AMt7X91EJgNr2u-5WRXGMRbGiQDTETDvg6UiPYnn6hzVY-DTkKdOaVqynbNLzXfMWDY5fN818tKURtqtxGss8178Ls95cK2wbzRP1Y7KqWz5XTVE6t7qH7VwM5hWaikMtJuiZUiYtr03oEWhA2-z9Foz8HmWPHYH6-JhC-5csOy2ehpM4ucAQkjzo3K9ydWuAqZLXxWVBgHnYOOwr0jZcq8a2DgTF860xNUBr43DmWgLikcOICaCoseKXbEeoP52DewOO9po3W_Nzhxh4MYlUKOs1q2nJZDBWvbXA8gDiWjITu0vv9m0q_oEASJ_2ju-gqdXAPOrEx7hn7XwdRPxJBchkH0q2ux01-uXHeffVLT3eVMkULE7A4kITN1_Nl-z0k-HvdR45gjRj50aNb7Zs2wdcr0snL5QM1QSnnMQuXiVRxJpoJ-A=w353-h265-no)

하드웨어는 물리적인 컴퓨터 디바이스를 말한다.

커널이 하는 역할은 물리적인 하드웨어를 제어하는 역할을 수행하며, 운영체제의 코어에 해당한다.

커널을 감싸는 쉘은 개발자가 직접 제어할 수 없는 커널 대신 쉘 명령어를 입력하면, 쉘에 해당하는 응용프로그램들이 해석해서 커널이 이해할 수 있는 방식으로 해석해서 전달하는 역할을 수행한다.

<a href="https://ko.wikipedia.org/wiki/%EB%B0%B0%EC%8B%9C_(%EC%9C%A0%EB%8B%89%EC%8A%A4_%EC%85%B8)" target="_blank">bash</a>, <a href="https://ko.wikipedia.org/wiki/Z_%EC%85%B8" target="_blank">zsh</a> 등이 쉘에 해당한다.

커널과 쉘을 구분했을 때의 장점 : 

커널과 쉘을 구분하면, 다양한 쉘을 만들어 낼 수 있다. 이렇게 되면 개발자의 선호에 따라 다양하고 편리하게 쉘을 사용할 수 있다.

출처 : <a href="https://www.youtube.com/watch?v=HYQ65yUlJDg&list=PLuHgQVnccGMBT57a9dvEtd6OuWpugF9SH&index=20&t=0s" target="_blank">생활코딩 - Linux Shell 1. Intro</a>

<br>

## <a name=""></a>비트(32/64) 확인

~~~
$ uname -m
~~~

간단하게 현재 접속되어 있는 리눅스 커널의 비트를 확인할 수 있다.

<br>

## <a name="linux-find"></a>find

**리눅스에서 파일이나 디렉토리를 검색**할 때 사용하는 명령어이다.

- 경로 Desktop/test 에서 용량 3mb 미만의 파일을 콘솔에 출력할 때 다음과 같이 명령한다.

  - `$ find Desktop/test -size -3M -type f`

&nbsp;

- 경로 Desktop/test 에서 용량 10mb이상의 디렉토리를 `ls -l` 형태로 출력할 때 다음과 같이 명령한다.

  - `$ find Desktop/test -size +10M -type d -exec ls -l {} \;`

 &nbsp;

- 파일명 중간에 'guide'이 포함된 파일을 찾으려고 할 때.
  - `$ find /Desktop -name '*guide*' `

 &nbsp;

- 폴더명 중간에 'tomcat'이 포함된 폴더를 찾으려고 할 때.
  - `$ find /Desktop -name '*tomcat*' -type d `

<br>

## <a name="linux-symboliclink"></a>심볼릭 링크 생성/사용하기

심볼릭 링크는 디렉토리 또는 파일에 더 빠르게 접근하기 위한 별명을 설정하는 일과 같다. `디렉토리 --심볼릭링크`

```
$ ln -s [target] [symbolic_link_name]
```

<img src="http://www.mediafire.com/convkey/1fa6/at0glqvdxyrry4czg.jpg" width="700" />

<br>

## <a name="linux-grep"></a>grep

유닉스를 위해 만들어진 텍스트 검색 기능의 명령어이다. <i>**g**rep | **r**egular **e**xpression | **p**rint</i>의 약자라고 한다.

```
$ grep [pattern] [file]
```

포맷으로 입력하면 [file]에서 [pattern]이 어디있는지를 알려준다.

![](http://www.mediafire.com/convkey/0dc1/t7dwrw36pfdc0l2zg.jpg)

`grep`은 옵셥으로 검색할 수도 있다.

[lorem-ipsum](https://www.lipsum.com/)에서 텍스트를 가져와서 lorem-ipsum.txt라는 파일을 만들었다. 여기서 **There**를 검색하면 다음과 같이 출력된다.

![](http://www.mediafire.com/convkey/c3d8/9azmf260ppue6huzg.jpg)



그런데 자세히 보면 대문자가 없을뿐 중간에 there가 쓰인 다른 문장도 찾을 수 있다. 이럴 때 `-i` 옵션을 사용해서 검색하면, 대소문자를 구분하지 않고 검색결과를 출력해준다.

![](http://www.mediafire.com/convkey/fff7/75me6ct6gtfe6odzg.jpg)

`grep` 의 옵션은 다음과 같다.

옵션은 중복해서 사용할 수 있다. 대소문자를 구별하지 않으면, 패턴이 일치하는 라인의 수를 출력하고 싶다면, `grep -ic "PATTERN" FILE` 형식으로 검색하면 된다.

| option | description                             | example                    |
| ------ | --------------------------------------- | -------------------------- |
| -i     | 비교시 대소문자를 구별 안함             | `grep -i "PATTERN" FILE `  |
| -c     | 패턴이 일치하는 라인의 수를 출력        | `grep -c "PATTERN" FILE`   |
| -v     | 지정한 패턴과 일치하지 않는 라인만 출력 | `grep -v "PATTERN" FILE`   |
| -n     | 행의 번호를 함께 출력                   | `grep -n "PATTERN" FILE`   |
| -w     | 패턴이 전체 단어와 일치하는 행만 출력   | `grep -w "PATTERN" FILE`   |
| -m     | 최대 검색 결과 갯수 제한                | `grep -m 1 "PATTERN" FILE` |

**References**

- [개발자를 위한 레시피 - 리눅스 grep 명령어 사용법](https://recipes4dev.tistory.com/157)

<br>

##<a name="save-output"></a>터미널 결과 출력

```
$ ls -al > "file.txt"
```

![](https://www.mediafire.com/convkey/716d/zfjd6vv45y4m2xzzg.jpg)

<br>

##<a name="combine-commands"></a>복수의 명령어 실행하기

```
$ command1 && command2
```

![](https://www.mediafire.com/convkey/e96a/nunbbvezumvc1rxzg.jpg)

또는 `;` 로 구분하는 방법이 있다.

```
$ command1; command2; command3;
```

<br>

##<a name="caffeinate"></a>슬립모드 진입방지 (caffeinate)

맥OS에서 잠자기모드 진입을 방지하는 앱이 있다. 맥 사용자라면 누구나 아는 Caffein이라는 앱인데, 터미널 명령어 하나면 이 앱처럼 맥이 슬립모드에 진입하는걸 막는 기능을 사용할 수 있다.

```
$ caffeinate
```

만약 종료하고 싶다면, `ctrl + c` 를 입력하여 종료하면 된다.

<br>

## <a name="ubuntu-reboot"></a>시스템 재부팅

![](https://lh3.googleusercontent.com/Bsxa1KiiuFD3qtQH-tbxksfPqDOWPBUXhiJ5Lv99WBsG45sfjaZWu2rfcdnfh1udobwEtIyOZc7K9uC-YA1PGyX6BykW1QwZkeaE8u11qfkLWIBn9d1mUJ12vlWxjRTeQaIV3isqxzDdykQYBaXYTqPyqj3f2ymmj7R116kT9xcXS18XNBTg-abd2wDmtvDVoYB9JhPJ6AGlsGqDUEJvzMLTVl4kXAQsYr1Oht8i94BMqBO7eTrBk0sZ8GrowJDPb0qK1K4lEijIFD7Wj664ljyd-vJaYMfaeDrMh-NOObn-mkNCyDSIjCcqycNRoc43qdlMLIAUWXCdPqipeI0UBgXs9bCknOR4ZXt7miNb4XcV7I8aKBho2oLNiX-WcQnjb09dP1NMBMz517xrPAlaCfBkad7sfhEmFN3hHP9DUx4vkf30MLvuuS4-cbkRdLpzTbZKfkNxJ4zZW3QKKcw7yvP9n93rpe2g9Hl8UBc1fo7IqI81cffcMV008ZXtGdkCybJSyUjPnbOxfg6YYCWjiORcGOrb6_FrN7BUEg_PK8zlGL1xRkdKTE9cemp7pCgqoai779nvL1z6dmRDOPcIn8N7bMsXxc0-SxGYpy64yj6LFCGLDjEegq8VA0ZVQhmoKaLdUiQq4x_SUC1qGbvjtrayB8lELhO7bg-2c41VtQuipJIUgtulqKnT0XgdlP9GA7tytce63uNq1RNA6lZ5P7AIrkNjGH-N1r8OOvTFBFMJnA4O=w720-h238-no)

Ubuntu EC2에 접속했는데, 이런 메세지를 발견했다. 커널의 보안을 위해서 업데이트해야할 패키지들이 있으니 시스템을 재부팅하라는 메세지인 것 같다. 

```
$ sudo reboot
```

<br>

## <a name="change-localtime"></a>서버시간 변경하기

```
$ date
```

서버에 적용된 시간과 날짜를 확인할 수 있다.

이제 이 서버의 시간을 우리나라 시간으로 변경해보겠다.

```
$ sudo rm /etc/localtime
$ sudo ln -s /usr/share/zoneinfo/Asia/Seoul /etc/localtime
```

<br>

## <a name="setup-locale"></a>UTF-8 인코딩 설정

```
$ sudo locale-gen ko_KR.EUC-KR ko_KR.UTF-8
$ sudo dpkg-reconfigure locales
```

그리고 `.bash_profile` 을 생성해서 아래의 명령어를 입력해둔다.

```
$ vim .bash_profile

LANG="ko_KR.UTF-8"
LANGUAGE="ko_KR:ko:en_US:en"
```

마지막으로 아래 명령어로 위에서 입력한 `.bash_profile` 을 적용? 한다고 한다. 

```
$ source .bash_profile
```

솔직히 아직 잘 이해못했다. 아래 출처의 박재성님이 알려주신대로 따라했다..

출처 : <a href="https://youtu.be/8MzyAFPDC1I?t=838" target="_blank">박재성님 - 원격 서버에 소스 코드 배포하기 1단계</a>

<br>

## <a name="hostname"></a>호스트네임 변경하기

터미널에서 아래 순서대로 명령어를 입력한다.

~~~
$ sudo vim /etc/hostname
~~~

![](https://lh3.googleusercontent.com/CovxqZ2tNzXsP7Kzj4JvwtHkQoWwv6RK5tEDGZR-dehIEstCErw6sHfU46nY3Q_-p2VdgioMF6W0Lc-7-LY1m_zIwT3zhqeccitNnY7hS9p20fJKoh0HyY8vF9xNC7GmuMs3WrCz9uUoR-tooyHb69XnxA4GiIXW9A1oJhSQN4r5iTPriwSJ4ppXNyoI4NNA9E5OC3wue5D7u-aigTDPwSRukpNdh7xN51ONj_hGBIJTiwTPVADIARskG2ijqrZG6-NHBKmVhEhW1-qvFzBD8otyuyyvfkT9Q3U3OxdLJ3qxz6qX54_3WVvvZYr2KQNP1dnguJusPZjC0XF8zjBTVv4yTzYHhqf9MJQ4wCqemHwjSkSFj2h9-AddEMY-XudMKRu7sMKsq2GAOCoW5NPnqRGJ_3NDV1HsEWDEWUxMN4Nml08rvD0-VVS0h36LwfDSvI6WPTT6b1oQv_--uP_gdjyKG17zQkxpPoiohMVF5n2eir-d-J6gme5g7wwtRbImYKYEiMyRAFep3uNNlBhMtRm7d6q_r6EjsXsu_WEir90WNNerPztvNS2oAOzYqcDhsG6KtsRJHbCzjFSUUFghA6ch8tzIpc4X_e-4wzx6z_eoonLkH7OiLajNzycYQgfH3UZlHjz1nyiV7FsPctOGeuWNMGFA4xiFkTXPkjAoelWRPjZcJ0p50FQ8Lma3i8MuOCuLow-afFG1I2MLQ9wAOW0I8XfjIJGoG0d3ppNcQdUK8tH-1A=w804-h136-no)



~~~
$ sudo vim /etc/hosts
~~~

![](https://lh3.googleusercontent.com/5ngAxtISJNgOidVWDgImqatjy4bzcl3cJqOhm2UBpAsE4o3wB53afTeEt_Gb_L_-lXvUBUlN4OcK7sqepXZu6TfnFc2nMnuXtraSvrha9d0d94ArYREp7hK0NdV6Vd0fPd7p9fxBB_Stne9UN5oRutGP0F1FT2FHmAawj8ep5_RkXgSUAAY7rOf8hp4sTUoBClv03lFqK-PvdEf7YRovmjLeLXVS_6muITlUbVGcFX_4Y7jGvhMYhXzQExzzBe7ajgnt71v6Dmyp6Wmio6cWP8RulIXhSoGc5ssuEhhDwHXW-Zk8P8CLpPW3UoB4q0-X1-pB69LvE-xzwQMpg-0kOXdiUToFAlGWv_6ZJ0ZEU3OCKPprd0wIi2oJ170rXkodmqWO-H1ymVW-0M-43nciuYfgyql2ocm9En5X9j9ZtM-00Tyd-uX6u-NXbeYYl4UYB_0HXgZs4ueMzlQ8eE7U5aSfxU2B1WIHPxqSQqitfOaPTKV8s_uF0Gx1ODbQTTfJPKV9lobXe7UMGWddrLIZfX9zwT_4_H2EWeVIT1nLUhJET8opdvHFAoMPPtclqCCtSroGU10qzjVxzh0VKr73N2uY8y1VLiXNBJEI3sKYU9JINutdvj9fkwCOjepYqUljB3F9kI2SEVgzqyMsAmLnxZOJVcLVh3-U0-7eob-8KlakTsrzc5P69VjRnqKpPGqlLSH9OZfBj9V1NKJrheW8sWe_21cToFumPaza3Vs67z2aXwuCMg=w809-h248-no)



이를 적용하려면 우분투를 종료하고 다시 켜야한다.

~~~
$ sudo reboot
~~~



바뀐 호스트네임을 확인해본다.

~~~
$ hostname
~~~

![](https://lh3.googleusercontent.com/EOuji_KjIgPw2TqJNazo5rbTDfu6Yr10faVEMjq0BgRDcgWUnWDkMWglAZGwIlMIO7BANshH8EpQy6sB77ykL7oFAicMyc5ysBA_gI6obnc0wO_DNkKO4JY5_x6NkzTIbHpBUddpM8D5qYmKdXZsNc8NjXwd1Ui7fhG_28vZOO6iUmMi5Sd9lQTZhJchOVu5RMk9albijFGoJoW4P2lFEt8NT3yRmeErkojrwM7t-ZHS7o-nbcCq1RjYffGPrI7b_Ff51ja4tniQhE6W4-6SBEtu8g7j7KvxV3rF58WSnqGEIKB1E5H8z6hdfSdqGlD6DFq3QScg7TcRyVs4axRMwwa4-S_NwRQEOae4l-W-rPEgmUIMbTRtKzbrpvREFoHUfuWSTsyxzHi28Ky0KW1ORXEyQncwszL4zi-EyQLL8om6IMK5fEXvxufm2_gB9Vb4F9W0iAdiKiMxr_pwAzGcMvfhkq3wCZg9p8nn6zAYHL-RLfW9Y1cArmOWzTFFhhSN8kEbhYuqOi2Lfb1OwRBHrQtoTvV5ef0wokxkwGC_qiIHIR-ROWxUORwQNbFurvFb3UmKAn4AwS_pudUmD_NXpbU4dSZUh2nZghk-A4nXS8KQaVJ3KV1xYGTpjuFVTMnTuL4yNlnOdtpGGgLnofXhXekhXX5mXUq5KQeLwBn_UWwJ7lu0_XI12QPktYTf9qm2A36FNFTHXrGZjn4RvWZSKufILW2Ri8IBhWsVaXj7exu_55CtVQ=w674-h117-no)

<br>

<br>

## <a name="wget"></a>wget으로 파일 다운로드

우분투를 GUI가 아니라 CLI로 사용다가 파일을 다운받아야 할 상황이 발생하곤 하는데, 이 때 사용하는 패키지가 `wget` 이다.

aws 우분투 인스턴스에 SSH 키페어를 저장해두고, 사용하고 싶어서 `wget`을 사용하게 되었다.

1. 먼저 `.pem` 의 키페어 파일이 담긴 폴더를 압축(`.zip`)한다.
2. 구글 드라이브에 업로드한다.
3. 업로드된 파일의 공유가능한 링크를 클립보드로 가져온다(복사)
   ![](https://lh3.googleusercontent.com/qtDCQlHyq9uZsWldOiOvcsh_TnSWKek5EGefoGCIXXbKXthN9EhN5Y7Yrn1YzCJnq9VzvYAU7PNe5z5Iplvgm36TiIMjGrpk95QdubwlgtKmyrB2RtWtUw3wITdEInI6_hqTn9UGJyy7EB9m3gqSNrWU_FXkq4ySzC29PiUDthEdRSDzPyLD_NseectgCblVCrdDYdml1tzLreRWT9zyhTzO3goDGVx7ho0s9d04mwd0atbaPx5sZya9SJRmmR-5CMBVQ2VIVwY0M6t6F0uufFqQRTHTiNXWrD8Q-aik8ds4rLqIqF3G_31h4nvtb2VOpVNnc57yieHZy7nJA0GEXnaFVeIJLIlnUpnHm2lhwJH8W61zUFDEYGyh4ZvaeIKurWvuu8urhQvths8dJjYSAcpeVP_iJvDEA1Zg4_nof3yTcxwV4EvcWylK63xKIhoXDblVdzpXXPITUfc5xBteAU473DpuryxNGT6RRY54qT5xj547xCMYlA5x-1vKU60gwKPK4ZvSk2g0RjbVd8Oq_dHySCXzlEcDXrja5Jtv6ZiuityWGpDivcuZQANjoYA9AdopdJOf38q_OgBs3ihTGYBorGYOdHtkBO8iFbECYmcAvaZKGc7b9SecSNve9DkxyhAvs0o9URVkagnB1iorBYGcGjCD_BtPSgJLzFYb8vjApnMRp62QT24egBvrvTNf1qVJ3mDOwRDZsjj3vZn3PSkjWtDyRIVgViILTPf-U8ZA04ftzg=w1013-h500-no)
4. 클립보드에 담긴 url중 id부분만 아래의 명령어에 붙여서 명령어를 완성한다.
   `wget https://drive.google.com/uc?id=[from-gdrive]`
5. 위 명령어로 바로 명령하면, 파일 이름이 id값으로 이상하게 다운받아진다. 파일의 이름을 지정하면서 다운받고자 한다면 `-O` 키워드를 사용하여 이름을 지정한다.
   `wget -O [new-name] https://drive.google.com/uc?id=[from-gdrive]`
6. 다운로드가 완성되면 `unzip` 키워드로 압축파일을 해제한다.
   `unzip aws-keypair.zip`

<br>

## <a name="adduser"></a>계정 생성하기

입력하고 싶은 **[new-user]**을 추가한다.

~~~
$ adduser [new-user]
~~~

그럼 계정의 정보를 입력하는 창이 출력되는데 이것저것 나오는데 그냥 엔터로 넘어가고 비밀번호만 신경써서 입력한다.

![](https://lh3.googleusercontent.com/3Czo0HcG3IWOGBvzNAo47JcL4REc-Ng2Df0zcBLC5IBSfYa7T9GjgDD2jjS_eUam-1WrKGiR33v74XJTj_F4VRPvzjG7BwDeeaTdn95s-cm1AHAxAbPSVEDFgbUlPvfu5mK5C9W_gt0QqCEzepu-KusouXkg_1oHAAAET_hs-qjS6R3s9DacE3F1XWe0PAnOOYPBX78N_8ypaK4HdlWKx3D5zVdddKi1Y26tP80lQ-efpoHmGHo9z6tpcKtNzzVOdOKWJn_NOpSQ4L7_TmhG9i20cWly6xOvm_7CcDI0yfM_hnF09Who9LorFpPt0pik3ThJcHaJJc0yb7MzfqU1LgAhzSd-IbMwh_hzy7UPcnmWq6mdYCPjo4czlrg2Ra3Wosn9gXQ2WAhDX4PJgj_wnp7tjPLqArVkZBl-iQ8rMqYGV2AWPSwKu0MxAHT4aYoHGCOAl4XFeD8oaWYVMRY1J_eiz6HTRsKFGgQGYWh5pqkbxfObqkJSZ9bMZxrnxscvYNAfpwRd0IONkT0wZZgb3D6u1d_CqKQmJhIKiXNbIaA9qETFD-yR5WkgmPBw4iDPIwWhOV4ieuDf3jodUFEJbqncw3-_VTmQYuS16RmBY-YsQyCgxDwpr6I6pAA-TWyqhqR-PoVzyNzNcAMz6rEvvH6V-vMObW2m9eVn0t-kCwvmEg6mZCdSKcsFOswDAGQ7oArpqAJo0ri3CdYZsIHqmQpxvlNcs53c1-Tp51Yf88KYcgiinA=w1024-h537-no)



생성된 계정을 sudo group에 추가하는 작업이다.

~~~
$ usermod -aG sudo [new-user]
~~~

 

이제 sudo 권한으로 생성된 계정으로 전환한다.

~~~
$ su - [new-user]
~~~



출처 : <a href="https://linuxize.com/post/how-to-create-a-sudo-user-on-ubuntu/" target="_blank">Linuxize - How To Create a Sudo User on Ubuntu</a>

<br>

## <a name="password"></a>우분투 패스워드 설정하기

root 계정의 패스워드 설정하기

~~~
$ sudo passwd
~~~

 root 계정에서 다른 계정의 패스워드 설정하기

~~~
$ passwd [user]
~~~

현재 로그인된 계정의 패스워드 설정하기

~~~
$ passwd
~~~

<br>

# <a name="linux-vi"></a>Vi Editor

## <a name="vi-input"></a>입력 명령어

| 입력키 | 작업                                                      |
| ------ | --------------------------------------------------------- |
| i      | 커서의 <u><b>현재 위치</b></u>에서 <b>입력</b> 시작       |
| a      | 현재 커서보다 <b><u>한 칸 뒤</u></b>에서 <b>입력</b>시작  |
| A      | 현재 커서 위치의 <u><b>줄의 끝</b></u>에서 <b>입력</b> 시 |
| o      | 현재 커서의 **<u>다음줄</u>**에서부터 **입력시작**        |
| u      | 직전 작업 되돌리기(undo)                                  |
| U      | 전체 변경사항 되돌리기                                    |
| ESC    | 입력모드 종료                                             |
| dd     | 커서가 가리키는 <b><u>한 줄</u></b> **삭제**              |
| 3dd    | 커서가 가리키는 줄부터 <b><u>3줄</u></b> **삭제**         |
| dw     | 커서가 가리키는 <b><u>단어 하나</u></b> **삭제**          |
| 4dw    | 커서가 가리키는 <b><u>단어 4개</u></b> **삭제**           |
| D      | 현재 커서로부터 <b><u>뒤의 컨텐츠</u></b> **삭제**        |
| x      | 한 문자형(char) <b><u>삭제</u></b>                        |
| r      | 한 문자형(char) <b><u>변경</u></b>                        |
| yw     | 커서가 가리키는 <b><u>한 단어</u></b> <b>복사</b>         |
| y$     | 커서가 가리키는 <b><u>줄의 끝까지</u></b> <b>복사</b>     |
| yy     | 커서가 가리키는 <b><u>줄 전체</u></b> <b>복사</b>         |
| yj     | 커서가 가리키는 <b><u>줄과 다음 줄</u></b> 복사           |
| yk     | 커서가 가리키는 <b><u>줄과 앞의 줄</u></b> <b>복사</b>    |
| p      | 붙여넣기 (paste)                                          |

<br>

## <a name="vi-move"></a>이동 명령어

| 입력키 | 작업 |
| ------ | ---- |
| k      | ↑    |
| j      | ↓    |
| h      | ←    |
| l      | →    |

<br>

## <a name="vi-filestatus"></a>파일 상태 변경 명령어

| 입력키 | 작업              |
| ------ | ----------------- |
| :w     | 파일 저장         |
| :q     | 종료하기          |
| :wq    | 저장하고 종료하기 |

**References**

- [VI Text Edito with Commonds: Linux/Unix Tutorial](https://www.guru99.com/the-vi-editor.html)

<br>

## <a name=""></a>IDE처럼 사용을 위한 Vim 셋팅하기

![](https://camo.githubusercontent.com/e03b1147d5d7ca3294db48a228f352a048715280/68747470733a2f2f646e70347065686b766f6f366e2e636c6f756466726f6e742e6e65742f34336335616635393762643563316136346562313832396630313163323038662f61732f556c74696d61746525323056696d72632e737667)

간단한 코딩을 위해서 IDE를 실행하기가 부담스러워 Vim 에디터를 드디어 셋팅해보았다.

현재는 <a href="https://github.com/amix/vimrc" target="_blank">amix/vimrc</a>에서 basic vim으로 설치해서 사용중인데, 어느정도 사용하다가 awesome vim을 설치해볼 생각이다.

참고로 basic vim은 많은 플러그인이 필요하지 않은 원격 서버에 용이하다고 한다.

루트 디렉토리로 이동한다.

~~~
cd -
~~~

여기에서 basic vim 에디터에 필요한 설정파일을 clone한다.

~~~
git clone --depth=1 https://github.com/amix/vimrc.git ~/.vim_runtime
~~~

이제 <a href="https://en.wikipedia.org/wiki/Bourne_shell" target="_blank">sh</a> 명령어로 이를 현재 OS에 적용하는 명령어이다.

~~~
sh ~/.vim_runtime/install_basic_vimrc.sh
~~~



그럼 이제 Vim 에디터를 IDE처럼 사용할 수 있는 최소한의 셋팅을 마무리했다.

며칠 써보다가 Awesome Vim을 설치해보고 여기에도 설치법을 작성해보겠다.

<br>

## <a name="apt-get"></a>apt-get

Ubuntu에서 자주 사용하는 패키지 툴이다. `apt-get` 패키지 툴을 이용하여 git, apache 웹 서버등 필요한 패키지 들을 설치할 수 있다.

### <a name="difference-between-update-upgrade"></a>apt-get update와 apt-get upgrade의 차이

```
$ sudo apt-get update
```

**설치가 가능한 패키지 리스트**들을 업데이트. 
설치하는게 아니라 설치 가능한 리스트를 업데이트하는 것.



```
$ sudo apt-get upgrade
```

**설치된 패키지**들을 최신 버전으로 재설치하는 것

출처 : [ask ubuntu - What is the difference between apt-get update and upgrade?](https://askubuntu.com/questions/94102/what-is-the-difference-between-apt-get-update-and-upgrade)

<br>

### <a name="install-remove"></a>apt-get 패키지 설치/삭제하기

apt-get으로 패키지를 설치할 땐,

~~~
$ sudo apt-get install [package-name]
~~~

apt-get으로 패키지를 삭제할 땐,

~~~
$ sudo apt-get remove [package-name]
~~~

<br>

### <a name="install-java"></a>Java 설치하기

```
$ sudo apt install openjdk-8-jdk-headless
```

<br>

### <a name="which"></a>ubuntu에서 java 설치 경로 찾기

```
$ which java
$ which javac
```

<br>