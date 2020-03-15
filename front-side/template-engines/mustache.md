- [Mustache](#mustache)
- [mustache 시작하기](#getting-started)
- [화면 분할하기 (중복제거)](#refactor)
- [update form구현하기](#update-form)

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

## <a name="getting-started"></a>mustache 시작하기

### 의존성 설정

**Maven**

~~~xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mustache</artifactId>
    <version>2.2.5.RELEASE</version>
</dependency>
~~~

**Gradle**

~~~gradle
compile group: 'org.springframework.boot', name: 'spring-boot-starter-mustache', version: '2.2.5.RELEASE'
~~~

출처 : [https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mustache/2.2.5.RELEASE](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-mustache/2.2.5.RELEASE)



### application.yml 설정

~~~yml
spring.mustache.suffix: .html
handlebars.cache=false
~~~

<br>

## <a name="refactor"></a>화면 분할하기 (중복제거)

Mustache에서는 template을 기준으로 화면을 분할 할 수 있다. 

![](https://lh3.googleusercontent.com/AXhc9FWyKXqmwRmW7oRIasjuJTp-xFaYqJg6IXR5MziUxb6romqiAYbaJnVmWjx3mRTZVReJKidupb77g16e2B1zrHxVGM6paQ-qFiekO5QAgaBZT8O6VIKzPfXWx_hpbmQdsD2iqYe2XR8gnlQCjAcdvNoX1xmoWG3Oj5hieTyR8T6z8cbq2tLAjDSI67AtZ4mZ3BIbNiQD-CC3VpyGPJVd0OVy2Y3fHgkCT_ulJchDyQzSx8UQdl5LSsriVWx4i07E32SGeHU8KIrDE6VcLVGxEq7tNfkVuGEUkkbFeudzddqrzdWg-E0ZfOeA4DNa2noegecpgc8IlvaK1XCjeP0--z5k0bg55gkiARWg9YpDXtJ7T101wap_SMZrMtDmAYR__MZuOQlBrsMIcc76aZ1kKnEYuYnDT1-de981LQBQrRDESku-X_-jijUZVMjSH4CZP-geDc5_ZYNWyECoWCU3HSsePCxzY8rPCY-fxwLpqRdVqBvU2k5ziz4HKwM3aTmUiPSzfiILt6OvYIaCXil2xreHIV3_Y2RooZJfGXxBSRoYNS8oCrq_sYw0H_V319mng_CncdCY_6Ks4gJFL9zBakhGSHgpaFc4zUXHYx2K1A2q-gRgxXP5JwoGjhYDmi0fNA9sfmGcxmZzN3CGlndkCEBk4srxz_AveCq2qsfxejrYj7XaK8YwPKmNYmqCPg0-7uJegVU03-fbZmIM-p79o0LhI9WYpnR9zjFTKGKqO90a=w182-h164-no)

~~~html
{{> /layout/navigation}}
~~~

위 코드는 mustache 템플릿엔진이 적용중인 index.html파일에서 navigation에 해당하는 코드만 따로 저장한 navigation.html을 불러오는 코드이다.

<br>

## <a name="update-form"></a>update form구현하기

Mustache로 update form을 구현할 일이 구현하면서 정리해본다. 

update form의 특징이라면, 사용자가 수정하기 위해서는 수정이 필요한 데이터를 먼저 보여주어야 한다. 그러려면 **Model 데이터를 불러와서 input 박스의 value로 자동으로 채워넣어줘야 한다.**

![](https://lh3.googleusercontent.com/ssIh7W1r9qzkd2cSV41SjSieDEAfWs78UicriO1yeP2L5ATqWEHL5TfRvVZlvEzfaTaB2qntsVS8GXBx4yux8V_AGfbTpcpm8eyO3cicyIQxytqf63at6pVKCoJWo8YQ0erZaJQjf9PrvgpPpxv0BQ6674pR16jPH9RJeQCe85TkkXlkXNAzxS9BmU8uHRPWb8RPgkJDPHcbkdYgtY6pJFR2Yn64Aat8qYQ-DcZYOETth_SFoymPgBwxRYAQU1E_Nadr8l_hYJUmHRDoF6kp8nw7GcwfzFmxjTVukz8_LSdC6HEiHZALBSWC5PY9dg9uEj-guC71cX1UvkBIJyjFoOgd1C6naeNTvVw-viPwyagWrcnG18C2ONBpS9cKZAxNvz5d7M2gUjs_W6Me3yggMyL_QG4KdA6QrXr-I2fi4eeVEiOzeH9arzuwmXqPQxLTIhojPN8UcGogVj8IeodJKjWnYFZIk2ScED14ww4hqlAX0FCZQelpsgRAmF5ILAAl4Xi5uvi_ju5d6_l-boRxVOawXYy79qO9SnQMZUwKKAag8sGfZD23aVQ64p6JT2IpZpJXbAdqdfTJvGOMMJTNyEx1oWnXlR8ye3g8wWllbnMztVVbu9KLxaM1mH3LkBe-SPnuK2VkgyEk2WOVXtMMA3a_zvkx9zJv4ZeXU0FG4i7jdV6GlZVuyC9SJS_1O1gs76-NJXjgmdt5JxS4duibP8XLHyNl2LU5nvT6HsmKRv6UeHLK=w500-h188-no)



### 컨트롤러 작성

우선 사용자 정보가 담긴 Model을 가져와야 한다. 그러려면 먼저 어떤 사용자 데이터를 수정하고자 하는지 알아야 하는데, 이 때 고유값인 `id`로 판별한다. 컨트롤러에 아래와 같은 매핑 메서드를 추가한다. 

~~~java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user")
public class userController {
  
   ...
   
   @GetMapping("/user/update/{id}")
   public String update(@PathVariable Long id, Model model) {
      model.addAttribute("users", userRepository.findById(id).get());
      return "user/update";
   }   
}
~~~

`userRepository.findById(id)`를 통해 전체 사용자 정보가 담긴 `userRepository` 에서 어노테이션 파라미터로 입력된 `id` 에 해당하는 사용자 정보를 `get()` 하는 역할을 수행한다. 이렇게 가져온 사용자 정보는 "users" 라는 이름의 `model` 로 저장한다. 



### html 페이지에 mustache 문법 작성

컨트롤러에서 가져온 사용자 정보가 담긴 `model` 을 가져오려면 mustache의 문법을 알아야 한다. mustache에서는 model을 가져와서 맵핑할 때 아래와 같은 형식을 사용한다.

~~~html
{{#model}}
<form method="" action="">
   ...
</form>
{{/#model}}
~~~



여기에 domain에 저장한 사용자 정보의 컬럼을 `{{ }}` 으로 감싸서 input 박스의 `value`로 넣어주면 된다.

> domain : 객체를 정의할 때 사용하는 언어



필자의 domain 컬럼은 다음과 같이 지정되어 있다.

~~~java
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue
  private Long id;
	
  @Column(nullable = false)
  public String userEmail;
  public String userName;
  public String userPassword;
  
  ...
}
~~~

여기서 수정에 필요한 데이터 컬럼인 userEmail, userName, userPassword를 사용할 것이다.

이를 적용하면 수정하는 페이지(update.html)에서 작성해야할 코드는 다음과 같다.

~~~html
{{#users}}
<form method="post" action="/user/list">
  <!--이메일 주소 입력 칸-->
  <div class="form-group">
    <label for="userEmail">이메일</label>
    <input type="email" class="form-control" 
      id="userEmail" name="userEmail" 
      value="{{userEmail}}">
  </div>
      
  <!--이름 입력 칸-->
  <div class="form-group">
    <label for="userName">이름</label>
    <input class="form-control" 
      id="userName" name="userName" 
      value="{{userName}}">
  </div>
      
  <!--비밀번호 입력 칸-->
  <div class="form-group">
    <label for="userPassword">비밀번호</label>
    <input type="password" class="form-control" 
      id="userPassword" name="userPassword" >
  </div>
      
  <!--수정완료 버튼-->
  <button type="submit" 
    class="btn btn-success clearfix pull-right">
      정보수정
  </button>
  <div class="clearfix" />
</form>
{{/users}}
~~~

이 때 비밀번호의 경우는 불러올 필요가 없다. 비밀번호를 수정하기 위해서는 현재의 패스워드를 사용자로부터 다시 입력받거나 그냥 새로운 비밀번호를 입력받아서 덮어씌움으로써 보안의 약점을 피해야 한다.

<br>