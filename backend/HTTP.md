# HTTP

HTTP는 클라이언트와 서버간의 통신을 위한 프로토콜이다. HyperText Transfer Protocol의 약자이다.

클라이언트와 서버가 request-response할 수 있도록 역할을 수행하는 프로토콜이다.

- [GET/POST](#getpost)

<br>

## <a name="getpost"></a>GET/POST

GET은 전달하는 데이터를 url 주소에 붙여서 전달하는 HTTP 메서드이다. 반면에 POST는 url 주소에 붙이지 않고 전달할 수 있는 HTTP 메서드이다.

일반적으로 게시판의 id값을 통해 게시글 상세보기 할 때엔 url뒤에 ?을 붙여서 게시글 id값을 GET 메서드로 서버에 전달한다. 반면 사용자의 아이디나 비밀번호와 같은 민간한 정보는 POST 메서드로 서버에 전달한다.

Outsider님이 블로그에 정리하신 <a href="https://blog.outsider.ne.kr/312" target="_blank">글</a>을 보면, GET과 POST의 차이를 다음과 같이 설명한다.

> **GET은 가져오는 것**이고, **POST는 (서버)수행하는 것**입니다.
>
> GET은 Select적인 성향을 가지고 있으며, POST는 서버의 값이나 상태를 바꾸기 위해서 사용한다.

w3school에서도 GET 메서드에 대해 *"GET is used to request data from a specified resource"* 라고 설명한다. POST 메서드에 대해선 *"POST is used to send data to a server to create/update a resource"* 정리했다. Outsider님의 정리와 정확히 일치한다.



w3scool에서는 다음처럼 GET/POST를 비교하였다.

| HTTP Methods | requests                                                     |
| ------------ | ------------------------------------------------------------ |
| GET          | GET 메서드의 요청은 캐싱될 수 있다.<br />GET 메서드의 요청은 브라우저 히스토리에 기록된다.<br />민감한 데이터를 다룰땐 이용해서는 안된다.<br />GET 메서드의 요청은 길이 제한을 받는다. 긴 데이터는 GET 메서드로 요청할 수 없다. |
| POST         | POST 메서드의 요청은 캐싱되지 않는다.<br />또한 브라우저 히스토리에도 기록되지 않는다.<br />POST 메서드의 요청은 GET 메서드 요청과 달리 길이에 제한을 받지 않는다. |

<br>**References**

- [Outsider - GET과 POST의 차이](https://blog.outsider.ne.kr/312)
- [w3school - HTTP Request Methods](https://www.w3schools.com/tags/ref_httpmethods.asp)

<br>