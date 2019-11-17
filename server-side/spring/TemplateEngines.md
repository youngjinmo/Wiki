# Template Engines

[템플릿 엔진](https://en.wikipedia.org/wiki/Web_template_system)이란, 데이터 모델에 따른 문서를 합성하여 웹 문서를 만들어주는 소프트웨어라고 한다. 

템플릿 엔진은 목적에 따라 다양한 템플릿 엔진을 사용할 수 있다. `include` 코드를 이용하여 html의 중복 코드를 제외하고 싶을 때에는 Apache Tiles와 같은 레이아웃 템플릿 엔진을 사용할 수 있다.

또 View에서 데이터를 출력하고 싶을 때는 Thymeleaf, JSP 같은 텍스트 템플릿 엔진을 쓸 수 있다. 

위 두 템플릿은 서로 베타적이지 않고, 동시에 사용이 가능하다.



- [Mustache](#mustache)

<br>

**Reference**

- [gmlwjd9405 - [Template Engine] 템플릿엔진이란](https://gmlwjd9405.github.io/2018/12/21/template-engine.html)

<br>

## <a name="mustache"></a>Mustache

JSP도 있고, Spring Boot에서는 Thymeleaf를 미는것도 같은데 왜 Mustache를 알아야 할까.

우선 JSP는 오래된 기술이다. 오래되었다는 이유만으로 배척할 필요는 없으나 향후 지원이 안될 가능성이 높기 때문에 실무에서 가장 많이 쓰이고 있거나 앞으로 많이 쓰일 소프트웨어를 배울 필요가 있다고 생각했다.

Thymeleaf는 잘 모르지만, 느리다는 성능 상의 이슈가 있는 편이다.

**Mustache는 템플릿 엔진중 가장 많은 언어를 지원한다.** [위키](https://en.wikipedia.org/wiki/Web_template_system#Server-side_systems)를 열어보면, C++, 커피스크립트, Go, Java, .NET, PHP, Pyhton중 내가 아는 프로그래밍언어는 거의 다 지원되는듯하다.

또 Mustache는 [심플한 문법](https://mustache.github.io/mustache.5.html)을 갖고 있다고 한다. 이 부분은 직접 경험해야 알 수 있을 것 같다.

일단 대략적으로 이정도만 알고 있는데, 향후 써보면서 계속 업데이트 해보겠다.

<br>

**Reference**

- [Baeldung - Spring Boot Mustache](https://www.baeldung.com/spring-boot-mustache)

<br>