# Linux

리눅스는 <a href="https://github.com/torvalds" target="_blank">리누스 토발스</a>가 개발한 컴퓨터 운영체제(OS)이다. <a href="https://github.com/torvalds/linux" target="_blank">오픈소스 운영체제</a>이며, 다중 사용자, 다중 작업(멀티태스킹), 다중 스레드를 지원하는 네트워크 운영체제라고 한다.

리눅스를 운영체제라고 했지만, 정확히는 운영체제라기보다 리눅스 커널이라고 하는게 맞다. 그러나 통상적으로 리눅스 커널과 우분투, 페도라와 같은 운영체제들도 리눅스라고 칭하고 있다.

리눅스의 역사나 배경에 대해서도 차후 더 알아보고 정리해야 할 것 같다.

- [명령어](#commands)
  - [Shell과 Kernel](#shell-kernel)
  - [비트(32/64) 확인](#uname-m)
  - [Symbolic Link](#symboliclink)
  - [find - 파일/디렉토리 찾기](#find)
  - [grep - 문서내 검색](#grep)
  - [터미널 결과 출력 저장](#save-output)
  - [복수의 명령어 동시실행](#combine-commands)
  - [슬립모드 진입방지 \(caffeinate)](#caffeinate)
  - [시스템 재부팅](#ubuntu-reboot)
  - [ip주소 확인하기](#ifconfig)
  - [서버시간 변경하기](#change-localtime)
  - [UTF-8 인코딩설정](#setup-utf8)
  - [호스트네임 변경하기](#hostname)
  - [wget으로 파일다운로드](#wget)
  - [계정 생성하기](#adduser)
  - [우분투 패스워드 설정하기](#password)
- [Vim Editor](#vim)
  - [입력 명령어](#vi-input)
  - [이동 명령어](#vi-move)
  - [파일 상태 명령어](#vi-filestatus)
  - [IDE처럼 사용을 위한 Vim 셋팅하기](#vimrc)
  - [한 글자/한 줄씩 드래그 하기](#vim-v)
- [패키지 관리툴 (apt-get)](#apt-get)
  - [update와 upgrade의 차이](#difference-between-update-upgrade)
  - [apt-get 패키지 설치/삭제하기](#install-remove)
  - [터미널 녹화기 asciinema](#asciinema)

<br>

#<a name="commands"></a>명령어

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

## <a name="symboliclink"></a>심볼릭 링크 생성/사용하기

심볼릭 링크는 디렉토리 또는 파일에 더 빠르게 접근하기 위한 별명을 설정하는 일과 같다. `디렉토리 --심볼릭링크`

```
$ ln -s [target] [symbolic_link_name]
```

<img src="http://www.mediafire.com/convkey/1fa6/at0glqvdxyrry4czg.jpg" width="700" />

<br>

## <a name="find"></a>find - 파일/디렉토리 찾기

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

## <a name="grep"></a>grep - 문서내 검색

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

## <a name="ifconfig"></a>ip주소 확인하기

~~~
curl ifconfig.me
~~~

ip주소를 쉽게 커맨드라인을 통해 확인할 수 있다.

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

## <a name="setup-locale"></a>UTF-8 인코딩 설정(한국어 설정)

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

AWS 사용환경을 도커 컨테이너로 옮기면서, 도커에서 SSH 키페어를 저장해두고, 사용하고 싶어서 `wget`을 사용하게 되었다. 만약 우분투에서 `wget` 를 사용할 수 없다면, 설치하자

~~~
$ sudo apt-get install wget
~~~



이후의 과정은 다음과 같다.

1. 먼저 `.pem` 의 키페어 파일이 담긴 폴더를 압축(`.zip`)한다.

2. 구글 드라이브에 업로드한다.

3. 업로드된 파일의 공유가능한 링크를 클립보드로 가져온다(복사)
   ![](https://lh3.googleusercontent.com/qtDCQlHyq9uZsWldOiOvcsh_TnSWKek5EGefoGCIXXbKXthN9EhN5Y7Yrn1YzCJnq9VzvYAU7PNe5z5Iplvgm36TiIMjGrpk95QdubwlgtKmyrB2RtWtUw3wITdEInI6_hqTn9UGJyy7EB9m3gqSNrWU_FXkq4ySzC29PiUDthEdRSDzPyLD_NseectgCblVCrdDYdml1tzLreRWT9zyhTzO3goDGVx7ho0s9d04mwd0atbaPx5sZya9SJRmmR-5CMBVQ2VIVwY0M6t6F0uufFqQRTHTiNXWrD8Q-aik8ds4rLqIqF3G_31h4nvtb2VOpVNnc57yieHZy7nJA0GEXnaFVeIJLIlnUpnHm2lhwJH8W61zUFDEYGyh4ZvaeIKurWvuu8urhQvths8dJjYSAcpeVP_iJvDEA1Zg4_nof3yTcxwV4EvcWylK63xKIhoXDblVdzpXXPITUfc5xBteAU473DpuryxNGT6RRY54qT5xj547xCMYlA5x-1vKU60gwKPK4ZvSk2g0RjbVd8Oq_dHySCXzlEcDXrja5Jtv6ZiuityWGpDivcuZQANjoYA9AdopdJOf38q_OgBs3ihTGYBorGYOdHtkBO8iFbECYmcAvaZKGc7b9SecSNve9DkxyhAvs0o9URVkagnB1iorBYGcGjCD_BtPSgJLzFYb8vjApnMRp62QT24egBvrvTNf1qVJ3mDOwRDZsjj3vZn3PSkjWtDyRIVgViILTPf-U8ZA04ftzg=w1013-h500-no)

4. 클립보드에 담긴 url중 id부분만 아래의 명령어에 붙여서 명령어를 완성한다.
   `wget https://drive.google.com/uc?id=[from-gdrive]`

5. 위 명령어로 바로 명령하면, 파일 이름이 id값으로 이상하게 다운받아진다. 파일의 이름을 지정하면서 다운받고자 한다면 `-O` 키워드를 사용하여 이름을 지정한다.
   `wget -O aws-keypair.zip https://drive.google.com/uc?id=[from-gdrive]`

6. 다운로드가 완성되면 `unzip` 키워드로 압축파일을 해제한다.
   `unzip aws-keypair.zip`

   1. 만약 `unzip` 패키지가 설치되지 않았다면, 이것도 설치하면 된다.

      ~~~
      $ sudo apt-get install unzip
      ~~~

<img src="https://lh3.googleusercontent.com/-1lVdHOQrK-SgXkpiqOOTeO2KCMZzro6ajSz_EhOpyQAyyy7JBPYjI3RwUR4_4lgqjAOldR9FMgefgFHvSiQ9zb7LocRVmG8vUKQgg_Uv5QlQfstrM0uhjvl839W6rLyNnGzRZS1zmZ8FhDUllqw3UdJwQ4ogECX-_5xNXHTSUOpGeaP6yxbNbYXXo5V4-aoKzbX_AHpDZV3KbbjHll7t2EHSKEmr935zpJNwUq9G5bPtsD8-vpVClAtoRY5NPbwOU4GOozMPVvZLP4-eXaNIrpBBb_nVj1Z6KiMotykdkZhtOVsAxnioS3IEQvl5ThIr554oe8iJzgf05NmzDnQ3f-iWgnhGTRGXS9v0LyD-zk0GVoMbSCzMBtRRh7RbjE7p7V9FizSiQPIRVJX0O9iKFoESnWfIdHYU9YdVKvmdPj-7DDKb9reJ8vss61jg_HdhFW5byVL7MtcnbHXXrdcoOV_mBFTlEV7IysI7yRaXkYr6ZD5w1-4epFvHIXYEjhAez_UhejhKZaDIqscGkCLF2064dLo7FcCMo7NmTtck9dDny3_0RSLntzgAPbdk3xa0CcHQOXJ81g_rHDCrW0Ln6OGXb5YyNF9vhJ8-vqADe0lX4xBqs4Ezunf14-3Mh-axUvCGh6CFnFQykrOJZqNE4yjSXaqPJtiRiU254MWbrbcljopW_LDkS8DYC3rz_lp1GDTTDWF07Fkx9KkoN-O3LXXLINjrZicxrVz54YQNVtGS3V3Bg=w1440-h580-no" style="zoom:80%;" />

`wget`로 aws-key 라는 이름의 파일을 성공적으로 가져왔다.

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

# <a name="vi"></a>Vi Editor

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

## <a name="vimrc"></a>IDE처럼 사용을 위한 Vim 셋팅하기

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

### <a name="vim-v"></a>한 글자/한 줄씩 드래그 하기

vim 에디터 모드에서 `v` 를 입력하면, 커서가 있는 위치에서 드래그를 할 수 있다. `V` 를 입력하면, 한 줄씩 드래그가 가능하다.

<img src="https://lh3.googleusercontent.com/xSBXHEvkTJbcfJA7U9KKzABXI9SxoioUqgJiuRA3r_fJdtKV7cgfgSnsXsULMLbKzdUDCAzjIxX54fMzvMyGGZdVUyfr5ikkHQos80sTTlAv0f1LcwAdo3S3ZdEDq0MFmtEscru3QVTiaWz79romKG2K1y0R24bTl9SGZyRfoIxdP8_dm8Zjmec1RZRQHTHdjjqSc2RQwQbJCsbD0HDciPQBnfHIBmgjdXrgCDsZRuGXApoOdmvPBc5-kHAhTjMhA_tMS37sj-zJ_YEm-2dQpbhnElEFJqmQkPsOK98axPnWub27i1eEmgJveyMtm6lTu5p6Da610C5HBRWzHdts5-9akJC9gFhZONPkqMNhmjJBBR6pX-s67AnZKCq5pfHdZa7-TEKoAK2xbTp_I4hHAGCgEbAdTfKJsuqyQUHQzWO6ERvkV8BL6__1gEAgHAcpJplgb04foaJ3N8wWp_nscqRJSL44n10GVgEIxXq-fTeE7qY6a8AngQh4NwbnqX5AnpMOK1dUO18hYKXvfINeBaCyNd_9Fe1DMb2kqiJ4ifYDRqV3-26vdvZXeo-wvGNtYCG6HohfFVtvm2uFgTyFHAm8esXv1RHImrH_RFxalTLWjUVCeToOeS6nloSHBRgXsJEVoBYbJWuRkvnqbd202GtKiiKVcq9mjOXyMtXiXKJaQphjAfzvsXW6iajeJlbVw8X0KXfN4CYjtfNG8zlSjTlXJD-tAQwIr6kOXEjjHvWkw_aCnw=w702-h396-no" style="zoom:50%;" />

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

## <a name="asciinema"></a>터미널 녹화기 asciinema

터미널 화면을 녹화하는 [Asciinema](https://asciinema.org/) 패키지이다. 아래처럼 터미널 화면을 녹화할 수 있다.

<script id="asciicast-170142" src="https://asciinema.org/a/170142.js" async></script>

<br>

### 설치

**Ubuntu**

~~~
sudo apt-add-repository ppa:zanchey/asciinema
sudo apt-get update
sudo apt-get install asciinema
~~~



**MacOS (Homebrew)**

~~~
brew install asciinema
~~~



### 회원가입

asciinema를 통해 생성되는 파일(.cast)은 일반적인 미디어 플레이로 재생할 수 없다. 재생하려면 asciinema를 통해서만 가능한데, 이를 asciinema에 업로드하면, embed링크를 통해 어디서나 재생할 수 있게된다. 따라서 회원가입을 하는것을 추천한다.

웹에서 회원가입이 끝났다면, 터미널로 다시 돌아가서 asciinema 로그인 상태를 전달하자.

~~~
$ asciinema auth
~~~

![](https://lh3.googleusercontent.com/hdbRY9R91_sYu4aup6TB2KqdfbBbWMvrv_txe_EFeNqQtAT08KQendVrtxZbQhWj1bXzOs4fm7brartKOXoVGW18HgxaALauhpHmZ40b4TN5mgmB_Avo2P2DMPppISwcLHC26tLQpbAp67aPSBVtaYwfBBVDiPADRgGTH1o2iZsFyPuCLlL9mUd2ebrcNb_2rsy3KKnk9B0JcRyiaIc3XzR7VFowtfs3_mVlUTmNTBBBO2SH1qETrPNX5PcLT0xJfU9ymGMBopZONhx9ZUnvOzD3pwO9a31ws5yZVVKtqV4M2AelbvyoNPHAXRU7GmyyWn4Y_pAMspogksfEG0krM4YuePcbQBq7HxWMAg6Gjtgg_cOZkc_mRM6VnyO6g-KeFb4pKSiTAY9XiTqb4DQriZM2pD7a3-znIf2kSEgnJi9FiDYV4en4i2kmlVIaxaCts_NOIsk-h2yj-TrV4R67gCljT9Y3DPxX9VujhGc-30a_ePYBTv7SDpGoux81KvwTjJOLpO1L6-r9zvvrr01ymjlCYDGDWAWYcWrDODH6pebwN67MXXM2ww39JX9DVj2VVAYDtRT2ZrVV2WR0wwpkCV379Fis5XhGRbeaulmvUEnPaafHP-Rb-gNlagLC3jTQeg0yX45NsHndE64be6Dv1MZzUHcyZyvAvKI7MF_C2tT3-fmCkz2P09MknQJjfklkhZdmGKTcwlGS48SfXwWQQLvG1DDgFLjZGjZdj13p0fniiq8KIQ=w807-h264-no)

그럼 url이 하나 생성되는데, 생성된 url로 웹브라우저로 접속해서 로그인하면, 앞으로 터미널에서 asciinema를 통해 녹화되는 영상을 클라우드(asciinema.org)로 업로드할 수 있게 된다.



### 녹화

터미널을 녹화하는 커맨드 명령어를 알아보자.

![](https://lh3.googleusercontent.com/q4e5VsIPKE5ZVDF4qXmDRJCtNck9I4-icrkuRGiLceMBNbB_k_E5MWQXEYBHcYWuSU1zxgwgzt4Q2GyBHAyygEYUtgaDSVECS7z4Zd2SaBm3Nm1jsfrZKvFSuwwjrJGLZKqf2299Zmk2UA9AYj66dXPNJ9nGFLf6tKnwvzeM6n57I5tOfsMfzJK0Guy2PLwXffcp9ZjeNkKxlYRETx2-mtBiWkCW34zWLAU5XiHbWICM0JBuMwTekGLdyG0yUcYvWtTwqntFii2FSMqOoSAggXztKXMhABh2-upd4lfKKPhRsY29UUPIGBS-TmVj2T-2Dh_n_yed-B_CtcvwoNCXYFywCmiFucnVMIfzYbEiRREliHOQdjOLid9vmKIuehTuAffabpffVbinrGQHfzZaQKD-xq_fj1FzbT2NQNZu9V7jycYzaHWRsjwVJ3kZI4zrv0QhvUU6SrzxNt_ABz2MIEizOyravTNjEDB_Ww8zkTZ51v1UGKTI20aHxqOfcAW0_r5mhN1v2R1RBaby639CNqqSK_2sFOFOMBZIhUw0hJHzv8H-P9KH6CZ643gyISVzoR014B8cL9V_iuwBqix8g67Be4oOIBc2r144w2xkRJbs7q9laJYTmQN1HrBf-eiq6zOZl6SwrZnZDj62zXL5KfxHsH54UZR7EFy9eZCSIp4p4XW9F8A8mSmWUMHfXbiF0ZpGuhtgDFdDjyDOwSX66cgRQOLs-ZCeTd-Uxiu7Iwrvbul8mgxxy9Rm=w809-h530-no)

저장할 때 파일의 명령을 지정하면서 저장하는 명령어는 다음과 같다.

~~~
$ asciinema rec -t "new-file"
~~~



녹화를 중지하고 싶으면 exit를 입력하면 된다.

~~~
$ exit
~~~



그럼 녹화 영상을 asciinema.org로 업로드할지, 로컬에 저장할지를 묻는다. 업로드를 원한다면, Enter 로컬에만 저장을 원한다면 ctrl+c를 입력하면 된다.



**로컬에 저장했을 때.**

![](https://lh3.googleusercontent.com/ZiqelRnS6wLSQZvYAG2uqSdfdPgxVzNKr3dqG2h1PaQoWBRe-UrAMhAP-YDzVGFiUuEE3r0wbV173inj0OvF2ImfS6v--PKNOqMd5Nwvlm4_t93KpNrozmxiEoZjdDExlw1bzvRHDLtnZlXRYEw9bfmtejxC4W5hvFpxWQMMDJiMKC_r8MHkHGe7Z7E6ujJPRk4vcsGvZwR6mQO6-lHucP0V3pyNQGQpF9QL-d4CzmSi4Hik8nnLuQzANFPnFDStbX_vm8XY13n2ZH1iB648sU4r1olRx-NKX2B_Vbx1csP4oro9e45f7L-8bUfA4U2C4bbKVnpPJdnbu1qHRHFHfD8vZBAiRGu3zIm-riQo7Qc1o5g3fmmsphVTdQEp97xigYZWurf_TfK1uqKI0bsgGmtMQcwOSYx_AA3w_yZZmluyUYt5yRYEeVMFnPaPMYKOrppy8O1HBk_dlyWg76M8DZdNHwOowaOOE99xZ3XCWN_GKh1YjSI7mZDMaOlTqdNId29_zIWblcfb-UMxYtlRNw8yDZzQmpD9AmgptQjN7GIj7pfSluqvkQWvFqdpjjaeim0cnZmCJ1BCh-VMa3sHRUMHCcF40SpQd9YrtZaIvi3u4MCVYiWbpd2LDfZSGCSdtg-boN-Rmc_hHqi1hFEyydeVRbmn2JoQvBk848f1ZUxnCzssHKC-ToIDt3vmcuer4xJ91j3C0qOnMEpUaDhhQPVnW6B3-TWdZLrfVhouSzIHOLZdtiMaTNvb=w739-h143-no)



**업로드했을 때.**

![](https://lh3.googleusercontent.com/UmAK-Ni3DUpBwxxg_5KpEverW_G4yriZIDT5-UejiPdojSJEQXGd8XWA6c8i25ZrF2FYkD4qGfDdkoobvLitPBcRW0frsNqB32IKbd0l23mIeoouwxQa6PxZO1gSBJoOEyOVjJ_LFRg5SDrt3umvo4Kd4_xT4Ge83MtW2Fz5hnPkmiOjS3drbtop-O4Rw4AwMy9EHUXbWw4Q4ruuULcZCQfG_TDTju3MMwLFatx6H7RfObc22U1ijQhewnj4M0w4pXW2z0y1F00YWtyNoElJnv-re-CD0rR59gPFpgNv9iGE0uGNpfhFqeg7f5XETzZe_fqfsOMYS3sTMuxGoPwBQOcGAv8-7OD1T7T5jKpTt8TId4qe417VpLz54BAJ4-cP3efv6Qf2uvI4K86rQ_EgWMkorfr2f4Ez_Sk_EybRj2N7xeLmxubHRvVmjCkFQ13EnD35L2vZrGMdHWizcKlCyQrK8Twh-nev8mKxRBYLhfTk8OixY7SWSCzTd60lj2ibATrZIQ5IndFk7jw8Os5fC9_WK6wCq26mCxsaOtudgV3h6pkh2Gs2iSu5M_r8OZxWe3oOxqOyDXK9KsbX_Q2p-lObBuxqSyDGgpDXxiZjXRZPpiQ5AOSmVXOL9mUtbK4Hg2ZtiPUEYfpuuV9XGAM6KcCX00FD9GrX9ZbbB5s64kDuTMgi70Bxnu8SyP2Vf0qGK_s7l5kOq1xiIzL2BcY9Wr8EKUPGHTckGfhl_J17bO4U5bXjlw=w810-h218-no)

위 링크로 접속하면 방금 녹화한 영상을 확인할 수 있다.

<br>

