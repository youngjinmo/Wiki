# Ubuntu 환경 구축하기

## **계정 추가하기**

사용할 계정의 이름을 `adduser`로 추가한다

~~~
$ adduser devandy
~~~

![](https://camo.githubusercontent.com/096c1eabf8783bf988d124bd4653ca2aeca25ec2/68747470733a2f2f6c68332e676f6f676c6575736572636f6e74656e742e636f6d2f33437a6f304863473349574f4742767a4e416f34374a634c345245632d4e67324466307a63424c4335494253665961375439476a674444326a6a535f6555616d2d3157724b4769523333763734584a546a5f4634565250767a6a473742774465656154646e3935732d636d314148417841625053564544466762556c50766675356d4b354339575f677430517143457a6570752d4b75736f75586b675f316f4841414145545f68732d716a533652337339446163453346315857653050416e4f4f5950425837384e5f387970614b3448646c574b783344357a566464644b6931593236745038306c512d6566706f486d47486f397a367470634b744e7a7a564f644f4b574a6e5f4e4f705351344c375f546d68473969323063576c7936784f766d5f37436344493079664d5f686e46303957686f394c6f72467050743070696b3354684a6348614a4a63307962374d7a667155314c6741687a53642d49624d77685f687a79375550636e6d5771366d645943506a6f34637a6c726732526133576f736e3967585132574168445834504a676a5f776e7037746a504c714172566b5a426c2d695138724d715947563241575053774b75304d784148543461596f4847434f416c3458466544386f615759564d5259314a5f65697a36485452734b46476751475957683570716b6278664f62716b4a535a39624d5a78726e78736376594e41667077526430494f4e6b5430775a5a67623344367531645f43714b516d4a68494b69584e624961413971455446442d795235576b676d50427734694450497757684f56346965754466336a6f645546454a62716e6377332d5f56546d515975533136526d42592d59735179436778447770723649367041412d545779716871522d506f567a794e7a4e63414d7a36724576764836562d764d4f6257326d3965566e30742d6b4377766d4567366d5a4364534b6373464f737744414751376f41727071414a6f307269334364595a734948716d517078766c4e6373353363312d54703531596638384b59636769696e413d77313032342d683533372d6e6f)

추가한 계정을 sudo group에 추가하기

~~~
$ usermod -aG sudo devandy
~~~

계정 전환하기

~~~
$ sudo su - devandy
~~~

추가한 계정 확인으로 전환되었는지 확인

~~~
$ whoami
~~~

<br>

## **JDK 설치 전 구버전 삭제 명령어**

openjdk 삭제

~~~
$ sudo apt-get remove openjdk*
~~~

oracle 삭제

~~~
$ sudo apt-get remove oracle*
~~~

autoremove로 사용하지 않는 패키지까지 정리

~~~
$ sudo apt-get autoremove --purge
$ sudo apt-get autoclean
~~~

<br>

## **jdk 설치하기**

default-jdk 설치하지 않고 원하는 버전으로 설치하기 위해서 파이썬 스크립트 기반의 `add-apt-repository` 사용 (참고 문서: [linuxize - How To Add Apt Repository In Ubuntu](https://linuxize.com/post/how-to-add-apt-repository-in-ubuntu/))

먼저, `add-apt-repository` 사용을 위한 `software-properties-common` 설치

~~~
$ sudo apt update
$ sudo apt install software-properties-common
~~~

add-apt-repository 이용하여 각 버전별 jdk 설치파일 소스 리스트에 추가

~~~
$ sudo add-apt-repository ppa:openjdk-r/ppa
~~~

이후 패키지 툴(apt-get)을 업데이트 후 리스트 조회

~~~
$ sudo apt-get update
$ apt-cache pkgnames | grep jdk
~~~

![](https://lh3.googleusercontent.com/_rZTBGyYXCEYGTqLqiyYS_lEF4dnv5CjNN9jiB3hdxVs0EhNjVHgHlOPgvkBpf6AHmGsxbRNRvxGTPoSydmVgbZEvJIPgbFpUb0Hr9ULne9qL5KQE6sijNEx8Q109DJWp5MS-NhChcimA3eQP0EwkjkERfG5zKK_hNL2mKf4H4Ub-EXS7tCE9cyEfTr7sKeNYbRoWPt6uBH-sOwWacUUf93HU0qGs60h_2ti2X036DAIgWIVmUxv-HSrR93Bu-Co9thaih2SoBfeG-kAed5xEoGXGETQTAFl8BmDQ6xLQDq4vFZ151rIrdb2mQNO6QgV_pz9EpfS5QvGKMQ3NzWV6HqrR_ZAsbY4sQh0obgmxpkcKg0TxmUCQux7Hplq1pZSDIKm2Li1eFcAOjrd_O0jsgj0-x_sPtuW0e2V3-WXBnA941I3TxinI_danmhQa1SMgKEsyYbG7pes4COuq63i-03pfS3Wx8Q_b0h4d_i_KY7KVqWhJdcDdZB9FylK0wYEeYN-cb5CKKUo41Bxkec60gqwHtJH3LEAtbD2FaGOz-qd4uiGc236rhpFb1mF0XIXPE8wPRUPwDAsXpa2iuAss5LFKWgl2MUcxLFogmkIFac-7-Ya4QILjI2xuQNwbYRK9JcJ4SvA0A7owwmyvN1_Jrt1q0YvJXPFwvPWh6bBdvLFnBeVrMCjtoNuvn9h0jt3Ehvjs6m-DK-FCZPIzMV1I1kzuCA-OXxx_C6arKF8LdZOEh7vm--qQGI=w999-h924-no?authuser=1)

리스트에서 원하는 버전의 jdk 설치 (필자는 jdk8 설치)

~~~
$ apt-get install openjdk-8-jdk
~~~

버전 확인

~~~
$ java -version
~~~

<br>

## Elasticsearch 설치

Elasticsearch를 설치하기 전, APT가 설치되있어야한다. Elastic의 모든 패키지는 package spoofing으로부터 시스템을 보호하기 위해 Elasticsearch signing key로 서명된다. 키를 통해 인증된 패키지는 패키지 관리자가 신뢰하는 것으로 간주된다.

따라서 Elasticsearch를 설치하기 전, Elasticsearch public GPG key를 먼저 import하고 Elastic package source list를 추가하여 Elasticsearch를 추가해야한다.

wget을 이용하여 GPG 키를 import 한다.

~~~
$ sudo apt-get install wget
$ wget -qO - https://artifacts.elastic.co/GPG-KEY-elasticsearch | sudo apt-key add -
~~~

![](https://lh3.googleusercontent.com/hiDK6ruXEl5dq2mA1xNaYZRvKQMnXjTU9iOnDGPCPN0_KtIDHjxDB9yz85mrsEAPIbJeK2uFbe2C1qAvxa967ZNx671nTGV9eOzenGGB6gi3Fv-JWmhgZMj6cbkWfqEpYIk2tgcXUPBJ28-ErxlfqkvgtiPEkYovXC8SHIyDNugoCaHd50-2G_movWdoq2DCAWgBku5bOrk67cLbH1IT4V705TXsOkZ8ucFn-yBKXMOJ-1VaBmfyfzhGSBZPPP5FLhz2rbphuv_AieMG6wYhg4ouuWtns4rDxSKlhXeIHMgKkojJXrrL3y72wVMTN-oGZubQz2vcQGiDFEJepXk5t9K0oJx8BU8uUiZRTRm_eqNfUVIPkg0Dgd2zUfOU_9TmyWZXy9MqZVrmjQo5TiSUVQBhY_sEnErqrjq8kIqPlbnQ8cR441n4tXU-BV7qaC6OzsJUabJomZVSgr_Ps1aycyFPYz2dDitNQvd5a_xFXjrGuNgT17aZd7On4W-8HrerTg9SjxScqqFUMOjnQ40wagkw5ujDxYlqJLqGPFM3HpkrBsx5pI2eFd_mMDkadzabOxyWUn4MVlGJS8HXLBQv3VDszci5-la9T89jcrxc6hVk-T_R8sEDIGuPVorbw1MmG6FGMtcCcbiwxTyUYINwxVicO-LtennRnbadNMXu_akBnBcigmCA9Apj9ozu20286e4LdYUqQHxpQU8wnsnNX19BGGXmpc2ySSYKA8PhHSK6WpXdayiToOw=w919-h158-no?authuser=1)

`OK` 가 출력되면, 성공적으로 패키지가 설치된 것이다. 
Elastic source list를 추가할 것이다. 추가되는 디렉토리는 APT가 새로운 소스를 검색하는 디렉토리이다. 

~~~
$ echo "deb https://artifacts.elastic.co/packages/7.x/apt stable main" | sudo tee -a /etc/apt/sources.list.d/elastic-7.x.list
~~~

다시 한 번 apt 패키지 리스트를 업데이트한다.

~~~
$ sudo apt update
~~~

![](https://lh3.googleusercontent.com/9EpPdP0o9sqCwuv6HvPG-9k_MM2stN7tljqvH0FbDylu_E5hpuHfzNwGukVHK3I1iDL9OJZXgSeMTirnd5_yw3Oedcn98SeMtIMHkTj-HFqm5P9a1sznOuW5V1FxF34I4I0R5kcMzP4eXnLTfG1G5OFTqt6UymBhcFM_WKBzUCbe1SPyvdoAy6TaLYmbGti45h-Zi8ELZI-a9yfu-7kfKpirzZszXTduZRRBBZ0DEgxNn_XNs-itPR3mwZb8sij-6WUgu8a4h9d7uBmvyIvuFFE85zk_rL9oryUt30ndqJnl_0X1l045zHcoT7job7NgbSZMJh6yWDM7ChFbOp3PoEEYATCeIKawjetyqFck-WQP91f9H-y6GboKgHYf7iTVeDad-O2fhxmTSQ_aeEtjbZ0fjGNieg35S8s4U6U0FKDocSH4kD4BMcrISwN92VPPGPpqrMh9chS1A2JOM1d_NjmoS34qcW6cj7dwMXyD1sH36Z5WjLw7RGY4EWC21TIvEbvq-l3soU6oG-gcEoYSi61cxJUzx3nzNRKJJnvAojh0jtH8TQG8ZcOu-_SrbOjll-LBRXl-U2UPWrCVEFS7Unta9PdHQSFX_rNCd5KLtEIgpw5L82KPPcma2BlZmu3RaXFK0Mp74BqtomvnWlXztQTSMtbp_NVwszlfO8jmBsd9AlX8-7j5bLqqIKZwOkBZP91vDNIPTl2i_aHISC53FcJmHNAGd5aTOuqbyz_e5NgJaPepcJ3XOFo=w1140-h480-no?authuser=1)

이제 Elasticsearch를 설치한다.

~~~
$ sudo apt install elasticsearch
~~~

Elasticsearch 실행하기

~~~
$ sudo service elasticsearch start
~~~

`ps aux` 명령어를 입력해보면, 현재 running 프로세스중 elasticsearch가 있음을 확인할 수 있으며, `curl`을 이용해서 조회할 수도 있다.

~~~
$ curl -XGET localhost:9200
~~~

![](https://lh3.googleusercontent.com/INhQatIUt6WJMWqfwGM37Qw58IuYrGfazOudW4aR7a46WUsWrqORg2IO7wF9J8E3SkSmRXRxgGQi25Has6O_N2llnAbtMhjIHa_RGor40V1WQlpPdcESDB68bm322MtRjakrnyymwBStOZyJBJ7WzXYcclTgJEwJNDnzff9BnA4-OAKDMVRNa8CnrrTYYBuw0HGqxBPGCCqMklJXAQ_982uc8tCJlGar6halyNwyBbXw7JqKnvYIt42ClK7_hl2A3X_ZYRWMr3viiMvkuZn2KKLL7-lw9wD8qo1xSkltu5w3vJdD9sKzQYuf8LG_tUF1UraoIzw3n-va0yYb3ibThj3XK9G9h2DsadyQXkoNYVRjqOkH_jNemjUpFYkUXNe_CzSsWQ1JRXb34AMwBlyMYxkpMjHzphzk1pz2cPzbYy_vFkd5LgT4xHSc7-Y53Q2uQ_JyRnquNt8oWQiQpNmweqYX1cbENT8kkHHBACiJqtUm7TM_Igx-9PhHsrXOcwZnQU0hLSs1BNk4Fy6EPBS-t0eyNaiCtF45KqXywtK-pyEHnGsHxU0phvlmi7yTfnQAYGVJ25EIjuM2b9SiyxRDPNGST5JAX0kizyAVabMwBFrotjKRhyqaoMGdMbQw4kourd-yRFHFEJ56e_Q4NdkZHS_j94HUiKGmNEilwURMLjTWlkrkUBGpcncxrIpOL1K99jHz1TlnfZmoFop6CFNusYR9FBeN6zlKxbxs9Z4SunCf0KiTkMpIPvA=w1147-h504-no?authuser=1)

<br>

## Elasticsearch 시작하기 (API명령어)

이제 인덱스를 추가하고, 삭제하고 수정하는등을 해보는 작업이다.

쿼리를 시작하기 앞서 Elasticsearch REST API 명령어와 RDB 명령어와 차이도 정리해보자.

<br>

## Comparison between Elastic Search and Relational Database

<table style="border: 1px solid black; text-align: center;">
    <tr style="border: 1px solid black;">
        <th style="width:50%; text-align: center; border-right: 1px solid black;">ES</th>
        <th style="text-align: center;">RDB</th>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">Index</td>
        <td>Database</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">Type</td>
        <td>Table</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">Document</td>
        <td>Row</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">Field</td>
        <td>Column</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">Mapping</td>
        <td>Schema</td>
    </tr>
</table>


<table style="border: 1px solid black; text-align: center;">
    <tr style="border: 1px solid black;">
        <th style="width:50%; text-align: center; border-right: 1px solid black;">ES</th>
        <th style="text-align: center;">RDB Commands</th>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">GET</td>
        <td>Select</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">PUT</td>
        <td>Update</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">POST</td>
        <td>Insert</td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">DELETE</td>
        <td>Delete</td>
    </tr>
</table>
<br>

<table style="border: 1px solid black;">
    <tr style="border: 1px solid black;">
        <th style="width:15%; text-align: center; border-right: 1px solid black; border-bottom: 1px solid black;">ES REST API Commands</th>
        <th style="text-align: center; border-bottom: 1px solid black;">RDB Commands</th>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">ES</td>
        <td><code>curl -XGET localhost:9200/classes/class/1</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black; border-bottom: 1px solid black;">RDB</td>
        <td style="border-bottom: 1px solid black;"><code>SELECT * FROM class WHERE id = 1;</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">ES</td>
        <td><code>curl -XPOST localhost:9200/classes/class1 -d '{xxx}'</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black; border-bottom: 1px solid black;">RDB</td>
        <td style="border-bottom: 1px solid black;"><CODE>INSERT INTO class VALUES {XXX}</CODE></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">ES</td>
        <td><code>curl -XPUT localhost:9200/classes/class1 -d '{xxx}'</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black; border-bottom: 1px solid black;">RDB</td>
        <td style="border-bottom: 1px solid black;"><code>UPDATE class SET xxx WHERE id=1;</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black;">ES</td>
        <td><code>curl -XDELETE localhost:9200/classes/class1 -d '{xxx}'</code></td>
    </tr>
    <tr>
        <td style="border-right: 1px solid black; border-bottom: 1px solid black;">RDB</td>
        <td style="border-bottom: 1px solid black;"><code>DELETE FROM class WHERE id = 1;</code></td>
    </tr>
</table>


존재하지 않는 인덱스를 요청하면 아래와 같은 화면이 출력된다. `?pretty`를 REST API 주소에 붙여서 요청하면, json 포맷으로 깔끔하게 조회가능하다는 점도 알아두자.

### 1. 인덱스 조회하기

조회시 사용하는 API 명령어는 `-XGET`이다. 여기서 `-X`가 붙는건 curl 명령어를 사용하기 때문에 함께 사용해야한다.

~~~
$ curl -XGET localhost:9200/classes?pretty
~~~

![](https://lh3.googleusercontent.com/2hLuVMoh6AQ28qzF-OP3-Q2kvxwJGrGYghhk_kvis35WobmnrSiRIkGkgG7boxT9VOmKUqX9LMPrCneMWHl8M1ioyYwGh4otmeM8b2Z5DoXkK9dc2vQazm9jVTRZ_x2p4OqeMbKn8Mzf4HmLTzU_2z2Cd-AF7DokL0n2k9DJSdGnh8fq7HZZRZ-yt_o_c3dw08QqjNvV230egU2YKUM1qMmWmA3smzlz7kZpw2-80ocu_SnoMO_6CJ8y_m198dPxYhfTDNCVHoHcmvlmnCOCoMa2P22S5u599ff-dM0DYL7evDjB1-_H6Thd5fFf94Kv6-GPWobOiPXaxaTchDkD6zx4AT5z9JOZBmNq2cD749hMjH7yVbl7HjF2OZygmeyRjEnAZyi6SNCi9IykJAzzyDbs-vGh7LS-xUVAmWiQEhIUde3TvwMb0sK-Q6JAUYU7RAprLbGWenqdv8Db9tmkT1_mZHWWhjgMY9yPB2UvA_PXb_OraYrp9dr1MoIxU1NFVSOBWrlpbB2sOQ9dsZSAYnzO1CvpI35SZf4StuW1y_EsXepoeLE8FmpRBqCs9wKRNtwAviYZiJkAyPods8fsTUnb92YiVmqM7EfeU1SK1xNLDQp7kgQgkP5Avn_3gzUuqi_LuzRdxqHOqH8fZXKp80UtoBJrCKoTe2JSLGrIqGdd_tu6LM2GGYTHdS-tpG6nPPURnNC_JY1ldegXxY3MVjmmfXY6Dt3_n33NwWVCLNWJvACDxU1diTw=w1729-h670-no?authuser=1)

존재하는 인덱스가 아니기 때문에 status로 404가 출력되는걸 알 수 있다.

<br>

### 2. 인덱스 추가하기

인덱스 추가시 사용하는 API 키워드는 `-XPUT`이다.

~~~
$ curl -XPUT localhost:9200/classes?pretty
~~~

-XGET 요청해서 확인해보면 다음과 같다.

![](https://lh3.googleusercontent.com/NTnT4OQKKy08ma4hGS_4Moawqwewxx7cPVANxDQiNzrLkcEVZwvjo347HIxvmIGE4Tn9lNG-3Ba9H6YwS7Yius4oSMF6d90MtRRpy-0m1zVL4ysJRfEv8w1nOVIuF47U6-1x_zd6rBgcbcttdHN7RknspkFAMas8WkVVfgaQ6POIzR06VNKoocMUNJCrtTJjXk5qo9RODjhr8ayVzHBg_EmEPHR82orOV9HMNxlAcfFgBSV36kuNshj3Y8GXpHK2jZl8qB5DumlJeT0YbDET_tQNRYuoGdFaozci1x7IUneedLb1aNpk8bq2qr8m6MfAfbNPTdMX1YB11nHcT4Y_9zNM37s7WbpWxXwRMQUEHPS_iEhbqw6qpQmao_NsuHoxu3Nimnu_nk9ApdlqL4mzvClZWyw1-P7cVlF8n-QPShkLwII_SBF0YcEWQm91j9laSvgQw9Kb-IIjkVAQ_EJUvyWHuN19HEYvuw4HdDtom6D7DpaKoJNtKH_Zs34WJ8FFUVVHcTTrcRgladrMpCFGTpCwEA7IV96K4l9Ydayog6BIkyn6BrhNPNG4dyyFFxHSzSl0SBNG-Z7g-ITuCu5yZpgnFDMZ038J_urTPKtP-wPPuNjAAPZSja9MzyzSHQc-f6w_VXTDOaZ4bAsuba7UjNGO1ylK-07k3BkTR9kRCcE7sOL6eKzZzawx1HW6MTiEuLg7676XDqY3qK7w9YoO4PSDkHUGaNZbsS3Y8kxqy8WkFejCZq_pGJM=w1613-h547-no?authuser=1)

"status" : 404 가 사라진걸 확인할 수 있다.

<br>

### 3. 인덱스 삭제하기

~~~
$ curl -XDELETE localhost:9200/classes
~~~

다시 `-XGET` 요청하면, status로 404가 출력되는걸 확인할 수 있다.

<br>

### 4. 도큐먼트 추가하기

도큐먼트 추가는 curl 명령어의 `-d` 옵션을 사용하며, API 명령어는 `-XPOST` 이다. 인덱스 추가시 사용했던 `-XPUT` 과 다른것을 유의하자.

명령어 `-XPUT` 으로 인덱스를 만들지 않았더라도 `-XPOST` 로 인덱스까지 생성이 가능하다. 

~~~
$ curl -XPOST http://localhost:9200/classes/class/1?pretty?pretty -d '
{"title":"Algorithm","Professor":"Bumblbee"}
'
~~~

그러나 위의 API 명령어를 입력하면, Content-Type header가 지원하지 않는다는 406 에러를 출력한다. 이 땐 curl 명령어 옵션으로 `-h` 를 추가한다.

Elasticsearch 5.5 이상 부터 header 값까지 상세히 작성해야한다고 한다.

~~~
$ curl -XPOST http://localhost:9200/classes/class/1?pretty -H 'Content-Type: application/json' -d '{"title":"Algorithm","professor":"Youngjin Mo"}'
~~~

![](https://lh3.googleusercontent.com/TEA1KRfuk0ByhmD9BWAWvJIrV0ATakNmplrHPbkWeX0jII1U978rJ3RBLXGf7x_WqxhUUFnG7b5YcFqlncnyLarqZKaGlo-y20a47llx0S15TTAc7TvVPQAp0OFrWF3K7jwwC1TS7f3LtA2MoMHxE24Cr5P63UZyAsVZu2ohvR0rYvelsqOwKUjSNWXsOtd4KAohBCGdo0C4HRu_59JDYp04-EOPhQx-WfRMlM6EB6-P13p4DTNIpH87VetbHD9guRoFT1OX_0RrrB9bG7YKLRCeq-Qn9grGSx8vlrgDt2GXkiwVr-73qQY07eT0MhETPMq8c-tvAVrDJM-sWfUYzy9Vs-a88mhEbq2shGTy52v6j7k5Urw7K4C6bKSpfYRvZippj8gq62Dz9FqT-7X_8J7UdsPfBDATLoeCA7Jnn61NcSc4JgSScFE52epKddhUAjqEqKVq__m5OPZfDmE3mCKSZ1mt3Y_cKa_z85qT4fFod-4hQJWIWIY4MVm5PRy4xxJSfwXE5sTC-HBviRlQt3bBdNsUGf5czZUA8jVWGbg87UG4IBJguaQoS5uZJLY3kLogneAh02AImSQEpFxrn6H9_gdLrp7KRfRShHub_kpkQLP0nzM8coBOanvznO2t3tEQKg8O7Olc0c2PAmozZ76pPol1Xhb4LO54qHNNI-h9JzxLTGMC74xBaGbXjGLI-NaxPpYssgDqbfJi4rYnQdgqJ06rmnR2ENnKUj0avjullAuBsue1V9M=w1613-h414-no?authuser=1)

도큐먼트를 추가할때 API 명령어로 직접 명령하는대신 json 파일을 통해 추가하는 방법도 있다.

~~~
$ curl -XPOST http://localhost:9200/classes/class/1?pretty -H 'Content-Type: application/json' -d @oneclass.json
~~~



추가한 다큐먼트에 속성 추가하기

인덱스 뒤에 `_update` 를 추가하고, 구조에 맞춰서 `-d` 옵션으로 추가하면 된다.

~~~
$ curl -X POST localhost:9200/classes/class/1/_update?pretty -H 'Content-Type: application/json' -d '
{
   "doc" : {"unit":1}
}'
~~~

`_source`에 `unit`이 추가된걸 확인할 수 있다.

<br>

### 5. 도큐먼트 업데이트

위에서 추가한 unit을 2로 수정하고자 한다면,

~~~
$ curl -XPOST localhost:9200/classes/class/1?pretty -H 'Content-Type: applicaion/json' - d '
{
   "doc" : {"unit":2}
}'
~~~

professor의 이름도 바꿔보자.

~~~
$ curl -XPOST localhost:9200/classes/class/1?pretty -H 'Content-Type: application/json' -d '
{
   "doc" : {"professor":"andy"}
}'
~~~

unit을 param을 이용해서 연산처리하는 API 명령도 있다.

param의 count로 4를 주고 이를 unit에 적용했다.

~~~
$ curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : {
        "source": "ctx._source.unit += params.count",
        "lang": "painless",
        "params" : {
            "count" : 4
        }
    }
}'
~~~

<br>

<br>

테스트를 위한 간단한 source 삽입

PUT

~~~
curl -X PUT "localhost:9200/test/_doc/1?pretty" -H 'Content-Type: application/json' -d'
{
    "counter" : 1,
    "tags" : ["red"]
}
'
~~~

**UPDATE**
counter의 숫자를 params만큼 연산처리하는 API 명령

~~~
curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : {
        "source": "ctx._source.counter += params.count",
        "lang": "painless",
        "params" : {
            "count" : 4
        }
    }
}
'
~~~



**UPDATE - add index**

params("tag":"blue")를 tags에 추가(add)하는 API 명령어

~~~
curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : {
        "source": "ctx._source.tags.add(params.tag)",
        "lang": "painless",
        "params" : {
            "tag" : "blue"
        }
    }
}
'
~~~

만약 params("tag":"blue")가 존재할 경우, 해당 tag의 인덱스를 tag로부터 삭제하는 API명령

~~~
curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : {
        "source": "if (ctx._source.tags.contains(params.tag)) { ctx._source.tags.remove(ctx._source.tags.indexOf(params.tag)) }",
        "lang": "painless",
        "params" : {
            "tag" : "blue"
        }
    }
}
'
~~~

새로운 필드를 추가하고, 값까지 대입하는 API 명령어

~~~
curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : "ctx._source.new_field = 'value_of_new_field'"
}
'

curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : "ctx._source.units = 10'"
}
'
~~~

문자열은 값에 들어가면 `illegal_argument_exception` 과 함께 400 status를 반환.



~~~
curl -X POST "localhost:9200/test/_update/1?pretty" -H 'Content-Type: application/json' -d'
{
    "script" : "ctx._source.remove('new_field')"
}
'
~~~

<br>

# systemctl

## \*현재 systemctl 을 통한 명령시 아래의 에러 출력\*

~~~
System has not been booted with systemd as init system (PID 1). Can't operate.
~~~

### **If it works,**

Elasticsearch를 편하게 끄고 켤 수 있게 하기 위해 다음과 같은 명령어를 입력한다.

~~~
$ sudo systemctl enable elasticsearch
$ sudo systemctl start elasticsearch
~~~

실행 여부를 확인하고 싶다면, 아래의 명령어를 입력해보자.
여기서 `ps aux`는 프로세스 상태를 보는 명령어이다.

~~~
$ ps aux | grep elasticsearch
~~~

![](https://lh3.googleusercontent.com/RgAD6FRlyOaUZ_stc6g3x4vRlbmXNjc61nUfCPvZpBQuxC-FBVMcYDqVd1oMUP0LcByyL1Yv0Wij0jIcmbqW3Q-V699LAplRRVL-v-lq_5RjMp52_MKIAriZIkOEYUMP3ouGANIVACteKqpCucB1Ake3JE-XV8Jol-WQZy9utuqMwXeT0A1SjR0odbLEBzQz6PrtqkXlcml9nd8M66Qegb9y8U6l4IlmY0PboB4cUXsk-7PcRQrgAx9WnungOGY4-2S9XgfQgwInninZnwnTrJFlJmlS2PqtHj4cBTrqhYkVGrGKFQylFh_1P4dWp7luTVby7R5HShpjzSsY923c_FGMUmkEsyU-SZwjZtg9PqfvApKwWau62Zv_r2ceD9jc72fHwnxZGf4WKKkBw91FH8x9H7VSy9wy_iVFm0OBuYuk79NunqOxMcDuxVFfNoiJELe1B1HKdgVO4TPZv8vsu0RxAjBhVC4-Dr9r6krVSuF0nlwmfP6ApJO0Nvf-xONqvZnKpsBtq3GcjKvPwACVddyEjGMYPv0NWgg8vsQV6GV8vPIRcSkYSuiVWmJLYDO5GT0UwfHrgGS-p8-hXiW9DQg82Ys15Cv_Z80Jdp4dbSHq-3VBSN2DnlrSgC-BxTSNT6Dis7NgmUh7c1PrxzmuXy4yy5giTgPaDz0SL07YRKOq6QHX6bR427J_SRIJOKIFyc4neSECD2uuRHCgz-uiF_hHxGhC66Ki9sLOt17YvBKxqbw2bQvveEk=w1385-h237-no?authuser=1)

<br>

~~~
curl -X POST "localhost:9200/twitter/_doc/?pretty" -H 'Content-Type: application/json' -d'
{
    "user" : "kimchy",
    "post_date" : "2009-11-15T14:12:12",
    "message" : "trying out Elasticsearch"
}
'
~~~

<br>

<br>
