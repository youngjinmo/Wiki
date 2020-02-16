# Django

![](https://miro.medium.com/max/2400/1*HVKOLLX7wprRbHTl2IPDcQ.png)

python으로 작성된 오픈 소스 웹 애플리케이션 프레임워크이다. 

Django도 Java기반 Spring Framework처럼 MVC 방식의 디자인패턴을 주로 사용하지만 용어가 조금 다르다. **Django의 디자인패턴은 MTV(Model-Templete-View)**라고 한다.

<br>

- [MTV](#mtv)
- [Django 실행환경 구성하기](#start-django)
- [서버 실행하기](#runserver)

<br>

## <a name="mtv"></a>MTV

Django에서 사용하는 디자인패턴이다. MVC와 같지만, 용어가 다르다. 

Data를 Model, Controller를 View, View를 Template로 표현하여 MTV라고 한다.

![](http://www.mediafire.com/convkey/66d8/3hztlgrdxkhiilszg.jpg)

### View

Model과 Template 사이에서 중개하는 역할을 하며 Client로부터 요청을 받고, 응답을 하는 역할을 한다.

### Template

클라이언트에게 보여줄 화면에 해당한다. 

### Model

Modeling을 통해 나온 객체를 Model이라고 하는데, 데이터라고 생각하면 될 것 같다.

DB에서 객체를 가져오거나 저장/수정 등의 기능을 한다.

DB와 통신할 때 ORM(Object-relational Mapping)이 사용되는데, 데이터베이스는 SQL을 사용하고, Django 애플리케이션은 Python으로 서로 언어가 다르기 때문에 이를 매핑하는 작업이 필요하다.  이 때 사용되는 프레임워크가 ORM이다. 
향후 ORM에 대해 정리하게 된다면 여기에도 링크에 남길 예정.

---

### MTV 처리과정

**Client -<sup>(Request)</sup>-> View(server)**

- 사용자가 브라우저 검색창에 쿠팡(www.coupang.com)의 주소를 입력한다. 

**Client <-<sup>(Response)</sup>- View <-<sup>(Rendering)</sup>-> Template**

- 서버에서 요청이 들어오면, View에서 요청받은 주소에 해당하는 메인 페이지를 Template을 통해 가져와서 사용자에게 보여준다.

**Client -<sup>(Request)</sup>-> View**

- 쿠팡에 접속한 사용자는 구입하고자 하는 상품을 쿠팡 상품검색창에서 검색한다.
- 사용자가 "양말"을 검색한다.

**View <-<sup>(Modeling)</sup>-> Model <-<sup>(ORM)</sup>-> DB**

Djang 애플리케이션이 자장면 가게라고 비유하고, Client는 자장면 가게의 손님이라고 상상해보자. 손님이 가게에 와서 자장면을 하나 주문한다.(**Request**) 

주문을 받으면, 주방에 어떤 음식을 주문받았는지를 이야기한다. 그럼 주방에서

주문받은 가게는 주문서에 해당하는 자장면 한 그릇을 손님에게 내어드린다. (**Response**)

이 때 자장면은 그릇에 담겨서 단무지와 함께 나가게 되는데, 이 때의 그릇과 단무지 역할에 해당되는게 **Template**이고, 자장면을 그릇에 담는 과정을 rendering이라고 한다.

<br>

## <a name="start-django"></a>Django 실행환경 구성하기

파이썬을 설치한다.

~~~
$ brew update
$ brew install python3
~~~



장고를 설치한다.

~~~
$ python3 -m pip install django
~~~



장고가 잘 설치되었다면 아래 명령어로 장고의 버전까지 확인이 가능하다.

~~~shell
$ python3
Python 3.7.4 (default, Sep  7 2019, 18:27:02)
[Clang 10.0.1 (clang-1001.0.46.4)] on darwin
Type "help", "copyright", "credits" or "license" for more information.
>>> import django
>>> print(django.get_version())
~~~

<br>

## <a name="runserver"></a>서버 실행하기

manage.py 가 있는 디렉토리에서 아래의 명령어를 입력한다.

~~~
$ python3 manage.py runserver
~~~

그럼 브라우저에서 django app을 실행할 수 있다. 브라우저에서 접속할 때엔 아래의 주소 중 하나로 접속한다.

- `localhost:8000`
- `127.0.0.1:8000`

<br>