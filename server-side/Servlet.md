# Servlet

자바 웹 애플리케이션의 구성요소중 동적인(dynamic) 처리를 하는 프로그램의 역할

서블릿은 WAS에서 동작하는 Java 클래스이며, HttpServlet 클래스를 상속받아야 한다.

일반적으로 JSP 와 같은 템플릿 엔진으로 웹 페이지를 구성하고, 프로그래밍 로직은 서블릿으로 구현한다.

## <a name="tutorial"></a>Servlet 만들어보기

**프로젝트(Dynamic Web Project) 생성하기**

![](https://lh3.googleusercontent.com/pw/ACtC-3e_WfwceYdP5cuuZ95jeXvaHFqdZ8k2LOpFJ4l2HvbJmbDTlgfmhKFL1CmmXiDKsdmMNoomt7nS0vY6SxdVx21TpAG4i_PoZfV8vMC52z3uNQMT4KcoZKbRPRlmHohpYFxPNtHw5zOw8h9pxnQPwjzKFg=w1442-h401-no?authuser=0)

서블릿은 정적 웹(Static Web)이 아닌 동적인 웹(Dynamic Web)을 위해 탄생한 기술이다. 따라서 이클립스에서 **[File] - [New] - [Other]**를 클릭하고, **[Dynamic Web Project]** 선택한다.

앞서 서블릿은 WAS에서 작동하는 자바 클래스라고 했다. 따라서 설정할때 어디서 실행될지(Terget runtime)를 정해야한다. 필자는 Apache Tomcat 9.0을 WAS로 지정했다. 이렇게 WAS를 지정하고, Next로 넘어간다.



**서블릿 클래스 생성하기**

![](https://lh3.googleusercontent.com/pw/ACtC-3d7U5AOmeMcSWTnBMQk0-S2cDNLYNYeMa74m4yWO1v4TwSuKAdgBXWgusWOWlBAJrPt2ow6yjvY6VVDAo5cvrnp3yzlECxyCegqVGXT5qnvQ03SwsTcPqtVWCslGwuwUNroepVnWpse4c0mFEWrJ-fXrg=w1442-h731-no?authuser=0)

 프로젝트가 생성되었으니 이제 프로젝트에서 서블릿 클래스를 생성할 차례이다. src 디렉토리 하위에 패키지를 하나 생성하고(생성하지 않아도 상관은 없다. default package가 생성될 것이다.) 생성된 패키지 하위에 **[New] - [Web] - [Servlet]**을 선택해서 서블릿 클래스를 생성한다. 



**서블릿 클래스 작성하기**

서블릿 클래스를 생성하면, 자동으로 doGet, doPost 메서드가 완성된 클래스 파일이 생성된다. 현 상태로도 브라우저에서 화면을 출력할 수 있지만, 상징적인 의미로 Hello World를 찍어보겠다.

서블릿의 동작원리는 다음과 같다. 

1) java 코드를 작성하고, Run on Server를 실행하면, 

2) IDE(Eclipse)에서 java코드를 class코드로 컴파일. 

3) 컴파일한 코드를 톰캣(서블릿 컨테이너)에서 서블릿 규칙에 따라 코드를 실행하고 결과를 서버에 전달.

4) 전달받은 서버는 클라이언트로부터 정해진 요청(HttpServletRequest)이 들어올 경우, 해당 요청에 맞는 응답(HttpServletResponse)을 HTTP 프로토콜을 통해 브라우저로 전송한다.

따라서 doGet() 에 코드를 작성해보겠다.

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
http://localhost:8080/{project-name}/{class-name}
~~~

위의 주소로 입력하면, 내장 톰캣 서버가 해당 요청에 맞는 응답을 클라이언트로 response하는 건데, 이 과정은 다음과 같다.

서블릿 클래스에서`@WebServlet("/HelloServlet")` 이라는 어노테이션을 작성하면, 어노테이션의 파라미터로 들어간 URI("/HelloServlet")로 접속을 하면, 서블릿 클래스에 작성된 로직이 실행되는 것이다. 그리고 이 서블릿 클래스 중에서도 `doGet()`에 작성된 로직이 웹 서버에 요청되면서 아까 PrinterWriter 객체로 작성한 html 코드가 브라우저로 반환된 것이다.



**파라미터 추가하기**

URI에 인자값을 붙여서 응답받을 수도 있다. `doGet()`에서 **HttpServletRequest** 객체의 `getParameter()`를 이용하면 URI로 넘어오는 인자값을 서버에서 받아서 처리할 수 있게 된다.

~~~java
String name = request.getParameter("name");
~~~

위의 코드를 doGet()에 추가하고, 다시 서버를 실행한 뒤 브라우저 창에 아래처럼 URL을 요청해보자 

~~~
http://localhost:8080/{project-name}/{class-name}?name={your-name}
~~~

그럼 이렇게 요청받은 인자값을 서버에서 받아서 다시 화면에 출력한 걸 확인할 수 있다.

![](https://lh3.googleusercontent.com/pw/ACtC-3c2y7yWuFE2xynmetTmsFmQc3KGwF1YIWbpIbpZwEVS6MDrb_DUR1SaPDG0DYkACXKCve2UpCF2QEJBiBGWIASe8HyjjyxjOYbH6xpE0uONEKhv_naItNbUPTX1ophkwFwhamZ4QzPRfq4hL6X3XgQYug=w1120-h348-no?authuser=0)



<details>
  <summary>전체 코드 보기</summary>
  <p>
    <script src="https://gist.github.com/devyoungjin/8e0c24b10bf70e9c2ba87d8ac2a5a3a1.js"></script>
  </p>
</details>


