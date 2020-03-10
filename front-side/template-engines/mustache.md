- [Mustache](#mustache)
- [화면 분할하기 (중복제거)](#refactor)

<hr>

## <a name="mustache"></a>Mustache

JSP도 있고, Spring Boot에서는 Thymeleaf를 미는것도 같은데 왜 Mustache를 알아야 할까.

우선 JSP는 오래된 기술이다. 오래되었다는 이유만으로 배척할 필요는 없으나 향후 지원이 안될 가능성이 높기 때문에 실무에서 가장 많이 쓰이고 있거나 앞으로 많이 쓰일 소프트웨어를 배울 필요가 있다고 생각했다.

Thymeleaf는 잘 모르지만, 느리다는 성능 상의 이슈가 있는 편이다.

**Mustache는 템플릿 엔진중 가장 많은 언어를 지원한다.** [위키](https://en.wikipedia.org/wiki/Web_template_system#Server-side_systems)를 열어보면, C++, 커피스크립트, Go, Java, .NET, PHP, Pyhton중 내가 아는 프로그래밍언어는 거의 다 지원되는듯하다.

또 Mustache는 [심플한 문법](https://mustache.github.io/mustache.5.html)을 갖고 있다고 한다. 이 부분은 직접 경험해야 알 수 있을 것 같다.

일단 대략적으로 이정도만 알고 있는데, 향후 써보면서 계속 업데이트 해보겠다.

**Reference**

- [Baeldung - Spring Boot Mustache](https://www.baeldung.com/spring-boot-mustache)

<br>

## <a name="refactor"></a>화면 분할하기 (중복제거)

Mustache에서는 template을 기준으로 화면을 분할 할 수 있다. 

![](https://lh3.googleusercontent.com/GI4huIPN0qAYjfr1m5MDQNyPQOjEmHUILT_aC_ZHkeCTA6YTeE_HKAQGxKjUXOGSvaY1wPWJOT4-FNhlm3NYnFzmzLw-6d37UAUpkFaG_f4HhbSp36pC5a_GakDv58SqPbfvJXDvy-aHMRpK_PCQcLxltHfLN1iVnVtpNuehsrXnJOnxwgYMkfi-9X2wRmzP7AthOAHPEYOAYatg6SQV7AG9d52Vba6GYvVgZEJumn7cT828O9hIrnPKmDYCMkhkHKnMn_nFfzWytXtN3sjPfPfs0dheg4ci0SupyDZs6Rm9gRH3fvfjCtKewEZEG0Fn9Ip1GYES95Itqoz25TVe-lXzV5Xj3W-fXhTRI74HyzeVjJ7EJWYv4_moEiXYPpFMehptPF-rr77Y9FWcwAq5aD34EIBw8DD5YUX1sbXrhKoeUfUWnbOlBI6F95aTQyOOp_TPbE4RC0Ba4-cMsUu8nY99xvLqftiwSj09YgAkw5RWv5qCksi98tjk4DIyU3RmfGBSbAPyeHPiSNpM3uUwS-6CLzWfNqNuhHIAqRSBAYTYHf54wCfEsbuPBXQ6OpWLKxRteer7crHkq7P87E500dzLylg_PSmuw3VuOzzSdeNxkMhUfIgrXRcIj7cQ0ll8P9KhT6saEH61nWl0k52RBnme0kif10O9sZBwLv0yBN7uUdymnNW4KBX27Yq5iUk_KvNahkCy2CbknmpoPy1b5xxjqtbPrAxWGxRHNHBdKPY5Xe75=w231-h166-no)

~~~html
{{> /layout/navigation}}
~~~

위 코드는 mustache 템플릿엔진이 적용중인 index.html파일에서 navigation에 해당하는 코드만 따로 저장한 navigation.html을 불러오는 코드이다.

<br>