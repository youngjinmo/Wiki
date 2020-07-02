# Servlet

스프링을 공부하다가 모호한 부분이 많아서 시작하게된 공부이다. 

스프링 기반기술이 서블릿인데 사실 자바 언어를 사용하며 웹 애플리케이션을 개발하기 위해서는 반드시 서블릿을 사용할 수 밖에 없다. 웹 애플리케이션을 개발하기 위해서는 Http로 통신하는 애플리케이션을 개발해야하는데 서블릿은 `HttpServlet` 클래스를 상속받아서 Http 프로토콜로 요청과 응답을 구현하는, WAS에서 동작하는 클래스이기 때문이다.

그러나 요즘은 개발자가 직접 서블릿을 생성할 필요가 없는데 스프링 프레임워크와 스프링부트처럼 간단하게 웹 개발할 수 있는 프레임워크가 존재하기 때문이다. 그러나 개발자가 직접 생성하지 않을뿐이지 결국 이런 자바 기반의 웹 개발 프레임워크 모두 서블릿 기반의 프레임워크라는 사실을 잊어서는 안된다.

서블릿은 WAS에서 동작하는 자바 클래스이다.

- [Servlet 만들어보기](#tutorial)
- [파라미터 담아서 요청하기](#request-with-parameter)
- [Servlet 2.x대와 3.x대의 차이](#comparison-2-with-3)
- [Lifecycle](#lifecycle)
- [HttpServletRequest와 HttpServletResponse](#httpservlet)

<br>

## <a name="tutorial"></a>Servlet 만들어보기

**프로젝트(Dynamic Web Project) 생성하기**

![](https://lh3.googleusercontent.com/pw/ACtC-3e_WfwceYdP5cuuZ95jeXvaHFqdZ8k2LOpFJ4l2HvbJmbDTlgfmhKFL1CmmXiDKsdmMNoomt7nS0vY6SxdVx21TpAG4i_PoZfV8vMC52z3uNQMT4KcoZKbRPRlmHohpYFxPNtHw5zOw8h9pxnQPwjzKFg=w1442-h401-no?authuser=0)

서블릿은 정적 웹(Static Web)이 아닌 동적인 웹(Dynamic Web)을 위해 탄생한 기술이다. 따라서 이클립스에서 **[File] - [New] - [Other]**를 클릭하고, **[Dynamic Web Project]** 선택한다.

앞서 서블릿은 WAS에서 작동하는 자바 클래스라고 했다. 따라서 설정할때 어디서 실행될지(Terget runtime)를 정해야한다. 필자는 Apache Tomcat 9.0을 WAS로 지정했다. 이렇게 WAS를 지정하고, Next로 넘어간다.

<br>

**서블릿 클래스 생성하기**

![](https://lh3.googleusercontent.com/pw/ACtC-3d7U5AOmeMcSWTnBMQk0-S2cDNLYNYeMa74m4yWO1v4TwSuKAdgBXWgusWOWlBAJrPt2ow6yjvY6VVDAo5cvrnp3yzlECxyCegqVGXT5qnvQ03SwsTcPqtVWCslGwuwUNroepVnWpse4c0mFEWrJ-fXrg=w1442-h731-no?authuser=0)

 프로젝트가 생성되었으니 이제 프로젝트에서 서블릿 클래스를 생성할 차례이다. src 디렉토리 하위에 패키지를 하나 생성하고(생성하지 않아도 상관은 없다. default package가 생성될 것이다.) 생성된 패키지 하위에 **[New] - [Web] - [Servlet]**을 선택해서 서블릿 클래스를 생성한다. 

<br>

**서블릿 클래스 작성하기**

서블릿 클래스를 생성하면, 자동으로 `doGet()`, `doPost()` 가 완성된 클래스 파일이 생성된다. 현 상태로도 브라우저에서 화면을 출력할 수 있지만, 상징적인 의미로 Hello World를 찍어보겠다.

서블릿의 동작원리는 다음과 같다. 

1) java 코드를 작성하고, Run on Server를 실행하면, 

2) IDE(Eclipse)에서 java코드를 class코드로 컴파일. 

3) 컴파일한 코드를 톰캣(서블릿 컨테이너)에서 서블릿 규칙에 따라 코드를 실행하고 결과를 서버에 전달.

4) 전달받은 서버는 클라이언트로부터 정해진 요청(HttpServletRequest)이 들어올 경우, 해당 요청에 맞는 응답(HttpServletResponse)을 HTTP 프로토콜을 통해 브라우저로 전송한다.

따라서 `doGet()` 에 코드를 작성해보겠다.

[전체 코드 보기](https://gist.github.com/devyoungjin/8e0c24b10bf70e9c2ba87d8ac2a5a3a1)

~~~java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    PrintWriter out = response.getWriter();
    out.println("<h1>Hello World</h1>");
    out.println("My <span style=\"color: red;\">First</span> Servlet!");
		
    response.getWriter().append("Served at: ").append(request.getContextPath());
}
~~~

그리고 서버를 실행하면, 브라우저가 자동으로 실행되며 다음과 같은 화면을 뿌려줄 것이다. 서버를 실행할 때 어떤 서버에서 실행할지 실행환경을, 즉 WAS를 물어보는데 이 때 서버를 선택하고 Next로 넘어가면 된다. 아래 Always user thie server 라는 체크박스를 체크하면, 다음부터 서블릿을 실행하면 자동으로 해당 WAS로 서블릿을 실행하게 된다. 

![](https://lh3.googleusercontent.com/pw/ACtC-3fyvjOK-IiC_a3kqWJ8ExHTcV4hP0Y-vttBTsg7tIgiv2me8cqnk96tQzmODde_v23teU-3Rnx9FRy4DkGAffzOzTphHO6Pf2ZMo673j2WxFXMUtx7fbTtyGgMUUgcyG0lJsoTZdtWx2nMZjPpUHtZAkw=w1442-h828-no?authuser=0)

![](https://lh3.googleusercontent.com/pw/ACtC-3fEx_pDV-1cFUA1J_XXS9YnExDOLt3Yr1t3MHskvgWuEA8QefNIMn7tCstFTavm7qTNhP6olILbOg1tmViYNwUXVJpI9J6Z4znlu7OACzw8Qu_otPDWxcqsvxf5maishI7QmH8voZ0RjE8es9DjE3q9lw=w936-h566-no?authuser=0)

만약 브라우저가 안열린다면 이클립스의 Preference에서 browser 설정을 다음처럼 바꿔준다.

![](https://lh3.googleusercontent.com/pw/ACtC-3eEN70TZdzfsc7LO4DMRseiIvGvZp5ngHHtcd-h1wpbhe1wKPOiRLRwvBws74VN4GeRDZrIivawyiIkebUnQTLs9S67YwLWj_pkot-i8qc8Ds9-_b-0Tu3_N0T7iL5Z9KpMM5fTkVwcUoB3gfT9WSV4aw=w1442-h1105-no?authuser=0)



클라이언트로부터 요청을 받아야 서버가 응답을 한다고 했는데, 어떤 요청을 했길래 웹 서버가 자동으로 결과를 뿌려준걸까? 여기서 사용자가 한 요청은 웹 브라우저 주소창에 있는 URL이다.

~~~
http://localhost:8080/{server-name}/{annotation}
~~~

로컬 환경에서 작업중이기 때문에 localhost:8080까지는 알겠는데, server-name은 어디서 알 수 있는걸까?

이클립스의 Servers 탭에서 서버를 더블클릭한다. (이미지에서 표기한 Servers탭 말고 해당 탭에 있는 로컬서버를 클릭하셔야한다.)

![](https://lh3.googleusercontent.com/pw/ACtC-3exwOtqdnQ5csGQUNSB10kqNonLSXYuMrTA97j3xJVhiHuyoHYFBUC9rtxt8Ggf7gqtk0NN58_Z8ilTbylxeJz1t9uGM2AWO9qiHni8MxElilgNN3ubbQemLy3dW0ZxDv0cu3VlEcQl_SjJqBSsyKzK7A=w480-h218-no?authuser=0)

그리고 서버 환경설정 화면이 나오면, 하단 메뉴에서 Modules를 클릭한다.

![](https://lh3.googleusercontent.com/pw/ACtC-3eTJN6_o9tSvEvBY_JThIgeN6RkGLBgWwQK7JsSYi0t9-RA6dlIrNnVRCSYpx6-s65c0RZOM08y3Iijh68tvatblyNjI2I2ZZTyjvhNZvmyXMssqg3KQnSDDx-dCcDaBfwO8yJMqskYtYpzxAsW52M73A=w720-h201-no?authuser=0)

그럼 위와 같이 Web Modules에서 현재 서버의 Path를 볼 수 있다. 이 Path가 우리가 서블릿으로 만든 웹서버에 접속할 수 있는 요청을 할 URL에 포함시켜야할 주소이다.

간단하게 서블릿 작업만 하고 싶다면, 위의 Path를 그냥 `/` 로 바꾸는게 편할 수 있다.

<br>

위의 주소로 입력하면, 내장 톰캣 서버가 해당 요청에 맞는 응답을 클라이언트로 response하는 건데, 이 과정은 다음과 같다.

서블릿 클래스에서`@WebServlet("/HelloServlet")` 이라는 어노테이션을 작성하면, 어노테이션의 파라미터로 들어간 URI("/HelloServlet")로 접속을 하면, 서블릿 클래스에 작성된 로직이 실행되는 것이다. 그리고 이 서블릿 클래스 중에서도 `doGet()`에 작성된 로직이 웹 서버에 요청되면서 아까 `PrinterWriter` 객체로 작성한 html 코드가 브라우저로 반환된 것이다.

<br>

## <a name="request-with-parameters"></a>파라미터 담아서 요청하기

URL에 인자값을 붙여서 요청할 수도 있다. 요청할 URL에 `?`를 붙이고 파라미터 이름과 파라미터 값을 추가하면 된다.

~~~
http://localhost:8080/{server-name}/{annotation}?{parameter1}={value1}&{parameter2}={value2}
~~~

이렇게 브라우저 주소창에 입력한 파라미터를 웹서버에서 요청받고, 응답하려면 서블릿 클래스에도 파라미터를 받아줄 코드를 작성해주어야 한다.

`doGet()`에서 **HttpServletRequest** 객체의 `getParameter()`를 이용하면 URI로 넘어오는 인자값을 서버에서 받아서 처리할 수 있게 된다.

~~~java
String name = request.getParameter("name");
out.printWriter("Hello, "+name);
~~~

그럼 이렇게 요청받은 인자값을 서버에서 받아서 다시 화면에 출력한 걸 확인할 수 있다.

![](https://lh3.googleusercontent.com/pw/ACtC-3c2y7yWuFE2xynmetTmsFmQc3KGwF1YIWbpIbpZwEVS6MDrb_DUR1SaPDG0DYkACXKCve2UpCF2QEJBiBGWIASe8HyjjyxjOYbH6xpE0uONEKhv_naItNbUPTX1ophkwFwhamZ4QzPRfq4hL6X3XgQYug=w1120-h348-no?authuser=0)

<br>

## <a name="comparison-2-with-3"></a>Servlet 2.x대와 3.x대의 차이

Servlet 버전 2.0과 3.0의 작성법이 다르다고 한다. 3.0에선 `HttpServlet`을 상속받고, 어노테이션 `@WebServlet()`을 작성함으로써 간단하게 작성이 가능하지만, 2.0에선 XML 기반으로 작성해야했다.

**Servlet 2.xx**

~~~xml
<servlet>
	<description></description>
  <display-name>myServlet</display-name>
  <servlet-name>myServlet</servlet-name>
  <servlet-class>edwith.myServlet</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name></servlet-name>
  <url-pattern>/helloservlet</url-pattern>
</servlet-mapping>
~~~

**Servlet 3.xx**

~~~java
@WebServlet("/helloservlet")
public class helloservlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { ... }
  protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException { ... }
}
~~~

<br>

## <a name="lifecycle"></a>Lifecycle

서블릿의 생명주기 관련 메서드는 3가지가 있다. [HttpServlet](https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/http/HttpServlet.html)의 메서드를 오버라이딩해서 확인할 수 있다.

- .init()
- .service(request, response)
- .destroy()

servlet을 생성해서 위 3가지 HttpServlet 메서드를 오버라이딩해서 사용해보자.

생성자와 HttpServlet 3가지 메서드를 포함하여 4가지 메서드가 생성된다. Sysout으로 콘솔에서 식별할 수 있는 문구를 작성해보자.

~~~java
@WebServlet("/lifecycle")
public class LifecycleServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  public LifeCycleServlet() {
    System.out.println("LifeCycleServler 생성!!");
  }

  public void init(ServletConfig config) throws ServletException {
    System.out.println("init 호출!!");
  }

  public void destroy() {
    System.out.println("destory 호출!!");
  }

  public service(HttpServletRequest request, HttpServletResponse response) {
    System.out.println("Service 호출!!");
  }
}
~~~



서버 실행 후, URL로 호출하면, 콘솔결과에 출력되는걸 확인할 수 있다. 

- 생성자 : 서블릿이 **생성**될때 호출된다.
- init : 서블릿이 **초기화**될때 호출된다.
- service : 서블릿이 **호출**될때 호출된다.



서버를 실행하고, 브라우저에서 URL을 호출하면, WAS는 서블릿 요청을 받아서 해당 서블릿이 메모리에 있는지 여부를 확인한다. 있으면 바로 service를 호출하고, 없으면 생성자부터 init()을 호출하게 된다.

처음 실행하고 서블릿을 호출하면, 

1. 생성자 호출
2. .init() 호출
3. .service() 호출

순으로 호출된다.

브라우저에서 다시 URL을 호출하거나, 현재창에서 refresh하면, 1) 생성자, 2) init() 을 skip하고 service()만 호출한다. WAS가 서블릿 요청을 받아서 해당 서블릿이 메모리에 있는지 확인했는데 이미 존재하기 때문에 서블릿을 생성하지 않고 곧바로 service를 호출한 것이다.



그럼 destory()는 언제 실행되는걸까?

서블릿 클래스를 수정하면, eclipse가 자동으로 수정된 클래스를 바탕으로 재 빌드를 하면서 콘솔화면에 .destroy()가 실행된걸 알 수 있다.

즉, destroy()가 호출되는 경우는 WAS가 죽거나 웹 애플리케이션이 종료되는 시점이다.



## <a name="httpservlet"></a>HttpServletRequest와 HttpServletResponse

요청할 때엔 갖고있는 정보를 `HttpServletRequest`에 저장한다.

응답을 보낼때는 `HttpServletResponse` 객체를 생성해서 `HttpServletResponse`를 통해 응답한다.

## HttpServletRequest

​	• http 프로토콜의 request 정보를 서블릿에게 전달하기 위한 목적으로 사용한다.

​	• 헤더 정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어 들이는 메서드를 가진다.

​	• body의 stream을 읽어들이는 메서드가 존재한다.



header로 저장되는 정보 브라우저 화면에서 출력하는 법

~~~java
Enumeration<String> headerNames = request.getHeaderNames();
while( headerNames.hasMoreElements() ) {
  String headernames = headerNames.nextElement();
  String headerValue = request.getHeader(headernames);
  out.println(headerNames+" : "+headerValue+"<br>"); 
}
~~~

<br>

## HttpServletResponse

​	• WAS는 어떤 클라이언트가 요청을 보냈는지 알고 있고, 해당 클라이언트에게 응답을 보내기 위한 `HttpServlerResponse` 객체를 생성하여 서블릿에게 전달한다.

​	• 서블릿은 해당 객체를 이용하여 content-type, 응답 메세지 등을 `HttpServlerResponse` 에 담아서 전송한다.

<br>