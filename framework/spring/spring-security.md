# Spring Security

- [OAuth2](#oauth2)

<br>

## <a name="oauth2"></a>OAuth2

소셜로그인을 지원하는 기능이다. 사용자가 보다쉽게 웹 애플리케이션에 로그인할 수있도록 지원함과 동시에 패스워드와 같은 민감한 정보를 웹 애플리케이션 개발사에서 직접 관리하지않고 대형 플랫폼기업이 관리함으로써 신뢰를 높힐 수도 있다.



### OAuth2 Flow

![출처: NAVER Engineering](http://www.mediafire.com/convkey/bdf7/v6l02eos6sch2qszg.jpg)

1. 사용자가 로그인 페이지에서 로그인 시도
2. 웹 서버에서 OAuth2 API 로그인 호출
3. 사용자가 OAuth2 로그인 시도, 인증서버로 결과 요청
4. 인증서버에서 OAuth2 로그인 시도 결과(Authrozation Code)를 웹 서버로 callback URL로 전송
5. 인증서버로부터 받은 코드를 웹서버가 Token으로 바꿔달라고 다시 인증서버에 요청
6. 인증서버는 요청받은 Access Token을 웹 서버에 발급
7. 웹 서버는 이 Token을 바탕으로 회원정보(Resource)를 요청, 가져온다.



Acess Token을 주고받는 이유는 회원정보를 callback URL로 담아서 전송시 해킹의 위험에 노출될 수 있기 때문이다.