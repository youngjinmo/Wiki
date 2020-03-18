- [Mustache](#mustache)
- [mustache 시작하기](#getting-started)
- [화면 분할하기 (중복제거)](#refactor)
- [update form구현하기](#update-form)

<br>


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

## <a name="refactor"></a>레이아웃 리팩토링

Mustache에서는 template을 기준으로 화면을 분할 할 수 있다. 

![](https://lh3.googleusercontent.com/AXhc9FWyKXqmwRmW7oRIasjuJTp-xFaYqJg6IXR5MziUxb6romqiAYbaJnVmWjx3mRTZVReJKidupb77g16e2B1zrHxVGM6paQ-qFiekO5QAgaBZT8O6VIKzPfXWx_hpbmQdsD2iqYe2XR8gnlQCjAcdvNoX1xmoWG3Oj5hieTyR8T6z8cbq2tLAjDSI67AtZ4mZ3BIbNiQD-CC3VpyGPJVd0OVy2Y3fHgkCT_ulJchDyQzSx8UQdl5LSsriVWx4i07E32SGeHU8KIrDE6VcLVGxEq7tNfkVuGEUkkbFeudzddqrzdWg-E0ZfOeA4DNa2noegecpgc8IlvaK1XCjeP0--z5k0bg55gkiARWg9YpDXtJ7T101wap_SMZrMtDmAYR__MZuOQlBrsMIcc76aZ1kKnEYuYnDT1-de981LQBQrRDESku-X_-jijUZVMjSH4CZP-geDc5_ZYNWyECoWCU3HSsePCxzY8rPCY-fxwLpqRdVqBvU2k5ziz4HKwM3aTmUiPSzfiILt6OvYIaCXil2xreHIV3_Y2RooZJfGXxBSRoYNS8oCrq_sYw0H_V319mng_CncdCY_6Ks4gJFL9zBakhGSHgpaFc4zUXHYx2K1A2q-gRgxXP5JwoGjhYDmi0fNA9sfmGcxmZzN3CGlndkCEBk4srxz_AveCq2qsfxejrYj7XaK8YwPKmNYmqCPg0-7uJegVU03-fbZmIM-p79o0LhI9WYpnR9zjFTKGKqO90a=w182-h164-no)

~~~html
{{> /layout/navigation}}
~~~

위 코드는 mustache 템플릿엔진이 적용중인 index.html파일에서 navigation에 해당하는 코드만 따로 저장한 navigation.html을 불러오는 코드이다.

<br>

## <a name="update-form"></a>update form 구현하기

update form의 특징이라면, 사용자가 수정하기 위해서는 수정이 필요한 데이터를 먼저 보여주어야 한다. 그러려면 **Model 데이터를 불러와서 input 박스의 value로 자동으로 채워넣어줘야 한다.** 이 과정에서 mustache 문법이 어떻게 사용되는지를 알아보자.

> Hexo 에서는 mustache의 <span ><img src="https://lh3.googleusercontent.com/sRmC4DvxbjwddajrxPqvCHfG9gptu1U_jgTNiYzeyQztj8kku5kWu1q6vgQqNo36j0EXUZMO9rTxMqGFUgRmWgKZAQG-BM8vQGCSk1AYCRalHk8b9ZJL0lwwHL2jwQG_oGD3z-XbYhB_V5nJCNdS5WU4hz4onfn-uAUNDWEs9xYTo1RgZJ3CwG3qe1H8ubR58nq0pcG0X8389Dng5s7R_GTDAojIuZZqJ4SfANc41yu80jycrJey0ShstttMhd98U33lDP6dZ-R_LjBd-UGOvywwynhz3gW2BOp1WjjCyMCUdZvzWemgBCEfaA6fhr_b3BQ4rAlqlUVeO3aABOSLtRc5PNKtvGf6sL-GfruZnvzuDIM9VRCpHv0L8aM1cWQ_smCx3E7ys4UwRzEdPnOf9RVLLd0toqI1xUm23DJigy2vF_Ae2OUDbfNBANt-B08gYpP7IvlbVH-HLIhjjzvuconGOuF9y3neNWpwEvE-v9lc-VXieFs3BfVFGqOdyQuyCFPk2R9Nvw98EHG9ANXAn9cV75nuvly9wCTYJUrEqxDmmbbGVCfgDrTY9f-_G6hD0GxmMlL3rcm39ngkj5PKRy9LzH0p90R2CHVmjCPdFxLPtXJV5ZIdfUIsFaAHHrDpWg6lIr6gJmEb5D5mt-YslcLIujyI9hIKJ-FPsaizxzUBO9E2dehAJPZADTPJS48ZLVnp2FEy0kNyGIjvixs9ds0URHWvuj-W95b8rkJSkGokDl9UxsTSSHpg=w129-h61-no" style="height: 20px; display: inline;"></span>사용할 경우 화면에 출력되지 않아 이렇게 이미지로 표기를 대체하였다.

<br>

- [update.html로 id값 전달하기](#a-href)
- [update.html여는 get요청 처리하는 맵핑메서드](#update-id)
- [데이터 가져와서 화면에서 출력하기](#update-html)
- [수정된 데이터 post요청 처리하는 맵핑메서드](#user-id)

<br>

### <a name="a-href"></a>update.html로 id값 전달하기

update form 페이지로 이동하기 위해서는 `a` 태그를 이용해서 페이지를 전달하는게 기본적이다. 

개인정보 수정 기능을 하는 update form을 구현하기 위해서는 **어떤 사용자의 정보**를 수정하고자 하는지를 알아야 한다. 그래야 서버에서 사용자 정보를 가져와서 수정하고 다시 서버에 저장할 수 있기 때문이다. 이 때 사용되는게 **id값**이다. 그리고 이 id값을 전달받아야 repository에서도 사용자 정보를 꺼내어서 model을 이용해 화면에 사용자 정보를 전달할 수 있다.

그러려면 `a`태그의 `href` 속성값에 mustache 문법으로 id값을 전달해줘야 한다.

~~~html
<a href="/user/{{id}}/update" class="btn btn-success" role="button">개인정보 수정하기</a>
~~~



그럼 이렇게 update form 페이지로 이동했을 때 사용자 정보를 불러와서 화면에 전달해서 보여준다.

![](https://lh3.googleusercontent.com/q-99Q1PVirLazawTg_npWns51IwNyIVUxotnSspEeIdxnCLjmVpIXTRzDNSfw9fH_iQfsqrZCgIQLIf3EjhVdv0XCr-9YI1Exn_-ZhRQsTk-blBBOuPwUDlSI1EKDEYFUOnXfkN6FJglOwsWunTrTuG6g73HM_eavyYk9OW6bjSnjnwTKrCLHU2JCH7tVgmwh0T7Nt7GQ0w4CRq3kUuOG73ZztdnGVMbc9VPjREX8TMstB7mXItGF-4g6TieJ9yzaCqEuAGoGaAt31RjtiNCU_qZ5f3woTxAaealNqDLNyCQyjpsHugKqJ-W90eiXqlq6P7LQhe-Gd9Hrjdow9HH8dUDivmznI0kZkY4Xb9xjMpOnA7cWpZ2bjAXEyuYWJlV2v_i5vo3IuPw3hGZ5PEM14sUZZBW0yXncXJniBbzLjJgLbuWMT9Np1M8xdIMwn0Hdi3LMd2x0VOUo4WMordrrhrBlufSEd_geZc7gDVK74cEkO1ofzjavRUQ-BECHEMej3jP7tgSOuTxKcqiu0JS_A1D4Ddb1b8FabKErivQLpOlx2JIzs2VWLjCCLuuxn6udmGeuZS8c7uX_NBamKYqoGH4a3jc3wnlAn5GW3uaIetQEEzP7xkSyluqEdGJ4r-iKItuqBi1kOBHirYCSaglFyFQiZKEhW47SZQ8VV_IeTHD31QUfHyeO9cABSP7gyB0cz6fECm2muf6CYMhviKCR_pG12LlbW4rxbHKwU4OjClYO3FqS5w6tvt6=w500-h282-no)

<br>

### <a name="update-id"></a>update.html여는 get요청 처리하는 맵핑메서드

`a` 태그를 통해 `/user{{id}}/update` URI를 처리해줄 메서드가 컨트롤러에서 필요하다.

~~~java
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/user")
public class userController {
  
   ...
   
   @GetMapping("/update/{id}")
   public String update(@PathVariable Long id, Model model) {
      model.addAttribute("users", userRepository.findById(id).get());
      return "user/update";
   }   
}
~~~

userController의 경우 URI에 공통적으로 `/user/` 가 사용되므로 `@RequestMapping("/user")` 어노테이션을 사용해서 리팩토링하였다.

update 메서드를 들여다보면.. 
화면에 데이터를 뿌려줄 `model` 객체에 데이터를 추가하고 있는데, 이 데이터는 전체 사용자 정보가 담긴 `userRepository` 에서 어노테이션 파라미터로 입력된 `id` 에 해당하는 사용자 정보를 찾아서(`findById()`) 가져오는(`get()`) 역할을 수행하고 있다. 

~~~java
model.addAttribute("users", userRepository.findById(id).get());
~~~

그리고 마지막으로 updatem.html을 return하고 있다.



컨트롤러(`class`)와 화면(`html`)에서의 특징이 하나 있다. 이것때문에 삽질을 좀 오래했었는데....
html페이지에서는 id값을 가져올 때 <span ><img src="https://lh3.googleusercontent.com/sRmC4DvxbjwddajrxPqvCHfG9gptu1U_jgTNiYzeyQztj8kku5kWu1q6vgQqNo36j0EXUZMO9rTxMqGFUgRmWgKZAQG-BM8vQGCSk1AYCRalHk8b9ZJL0lwwHL2jwQG_oGD3z-XbYhB_V5nJCNdS5WU4hz4onfn-uAUNDWEs9xYTo1RgZJ3CwG3qe1H8ubR58nq0pcG0X8389Dng5s7R_GTDAojIuZZqJ4SfANc41yu80jycrJey0ShstttMhd98U33lDP6dZ-R_LjBd-UGOvywwynhz3gW2BOp1WjjCyMCUdZvzWemgBCEfaA6fhr_b3BQ4rAlqlUVeO3aABOSLtRc5PNKtvGf6sL-GfruZnvzuDIM9VRCpHv0L8aM1cWQ_smCx3E7ys4UwRzEdPnOf9RVLLd0toqI1xUm23DJigy2vF_Ae2OUDbfNBANt-B08gYpP7IvlbVH-HLIhjjzvuconGOuF9y3neNWpwEvE-v9lc-VXieFs3BfVFGqOdyQuyCFPk2R9Nvw98EHG9ANXAn9cV75nuvly9wCTYJUrEqxDmmbbGVCfgDrTY9f-_G6hD0GxmMlL3rcm39ngkj5PKRy9LzH0p90R2CHVmjCPdFxLPtXJV5ZIdfUIsFaAHHrDpWg6lIr6gJmEb5D5mt-YslcLIujyI9hIKJ-FPsaizxzUBO9E2dehAJPZADTPJS48ZLVnp2FEy0kNyGIjvixs9ds0URHWvuj-W95b8rkJSkGokDl9UxsTSSHpg=w129-h61-no" style="height: 20px; display: inline;"></span>  로 표기하지만, 컨트롤러에서는 `{id}` 로 표기해야 정상적으로 작동한다.

<br>

### <a name="update-html"></a>데이터 가져와서 화면에서 출력하기

컨트롤러에서 가져온 사용자 정보가 담긴 `model` 을 가져오려면 mustache의 문법을 알아야 한다. mustache에서는 model을 가져와서 화면에 맵핑할 때 아래와 같은 형식을 사용한다.

~~~html
{{#model}}
<form method="" action="">
   ...
</form>
{{/#model}}
~~~



여기에 User에 저장한 사용자 정보의 컬럼을 <span ><img src="https://lh3.googleusercontent.com/sRmC4DvxbjwddajrxPqvCHfG9gptu1U_jgTNiYzeyQztj8kku5kWu1q6vgQqNo36j0EXUZMO9rTxMqGFUgRmWgKZAQG-BM8vQGCSk1AYCRalHk8b9ZJL0lwwHL2jwQG_oGD3z-XbYhB_V5nJCNdS5WU4hz4onfn-uAUNDWEs9xYTo1RgZJ3CwG3qe1H8ubR58nq0pcG0X8389Dng5s7R_GTDAojIuZZqJ4SfANc41yu80jycrJey0ShstttMhd98U33lDP6dZ-R_LjBd-UGOvywwynhz3gW2BOp1WjjCyMCUdZvzWemgBCEfaA6fhr_b3BQ4rAlqlUVeO3aABOSLtRc5PNKtvGf6sL-GfruZnvzuDIM9VRCpHv0L8aM1cWQ_smCx3E7ys4UwRzEdPnOf9RVLLd0toqI1xUm23DJigy2vF_Ae2OUDbfNBANt-B08gYpP7IvlbVH-HLIhjjzvuconGOuF9y3neNWpwEvE-v9lc-VXieFs3BfVFGqOdyQuyCFPk2R9Nvw98EHG9ANXAn9cV75nuvly9wCTYJUrEqxDmmbbGVCfgDrTY9f-_G6hD0GxmMlL3rcm39ngkj5PKRy9LzH0p90R2CHVmjCPdFxLPtXJV5ZIdfUIsFaAHHrDpWg6lIr6gJmEb5D5mt-YslcLIujyI9hIKJ-FPsaizxzUBO9E2dehAJPZADTPJS48ZLVnp2FEy0kNyGIjvixs9ds0URHWvuj-W95b8rkJSkGokDl9UxsTSSHpg=w129-h61-no" style="height: 20px; display: inline;"></span>  으로 감싸서 input 박스의 `value`로 넣어주면 된다.

필자의 유저 컬럼은 다음과 같이 지정되어 있다.

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

이를 적용하면 수정하는 페이지(update.html)에서 작성해야할 코드는 다음과 같다. `form` 태그 안의 속성값(`method`, `action`)에 주목하자. 



**/user/update.html**

~~~html
{{#users}}
<form method="post" action="/user/{{id}}">
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
  <!-- 비밀번호의 경우 value를 가져오기보다 -->
  <!-- 새비밀번호를 덮어씌워서 바로 수정이 가능하도록 하자 -->
      
  <!--수정완료 버튼-->
  <button type="submit" 
    class="btn btn-success clearfix pull-right">
      정보수정
  </button>
  <div class="clearfix" />
</form>
{{/users}}
~~~

model로 가져온 값을 보여줄때 사용하는 mustache 문법은 마찬가지로 `value`를 <span ><img src="https://lh3.googleusercontent.com/sRmC4DvxbjwddajrxPqvCHfG9gptu1U_jgTNiYzeyQztj8kku5kWu1q6vgQqNo36j0EXUZMO9rTxMqGFUgRmWgKZAQG-BM8vQGCSk1AYCRalHk8b9ZJL0lwwHL2jwQG_oGD3z-XbYhB_V5nJCNdS5WU4hz4onfn-uAUNDWEs9xYTo1RgZJ3CwG3qe1H8ubR58nq0pcG0X8389Dng5s7R_GTDAojIuZZqJ4SfANc41yu80jycrJey0ShstttMhd98U33lDP6dZ-R_LjBd-UGOvywwynhz3gW2BOp1WjjCyMCUdZvzWemgBCEfaA6fhr_b3BQ4rAlqlUVeO3aABOSLtRc5PNKtvGf6sL-GfruZnvzuDIM9VRCpHv0L8aM1cWQ_smCx3E7ys4UwRzEdPnOf9RVLLd0toqI1xUm23DJigy2vF_Ae2OUDbfNBANt-B08gYpP7IvlbVH-HLIhjjzvuconGOuF9y3neNWpwEvE-v9lc-VXieFs3BfVFGqOdyQuyCFPk2R9Nvw98EHG9ANXAn9cV75nuvly9wCTYJUrEqxDmmbbGVCfgDrTY9f-_G6hD0GxmMlL3rcm39ngkj5PKRy9LzH0p90R2CHVmjCPdFxLPtXJV5ZIdfUIsFaAHHrDpWg6lIr6gJmEb5D5mt-YslcLIujyI9hIKJ-FPsaizxzUBO9E2dehAJPZADTPJS48ZLVnp2FEy0kNyGIjvixs9ds0URHWvuj-W95b8rkJSkGokDl9UxsTSSHpg=w129-h61-no" style="height: 20px; display: inline;"></span>  로 감싸서 보여준다.

여기까지 작성하면 아래 이미지를 구현할 수 있다.

![](https://lh3.googleusercontent.com/q-99Q1PVirLazawTg_npWns51IwNyIVUxotnSspEeIdxnCLjmVpIXTRzDNSfw9fH_iQfsqrZCgIQLIf3EjhVdv0XCr-9YI1Exn_-ZhRQsTk-blBBOuPwUDlSI1EKDEYFUOnXfkN6FJglOwsWunTrTuG6g73HM_eavyYk9OW6bjSnjnwTKrCLHU2JCH7tVgmwh0T7Nt7GQ0w4CRq3kUuOG73ZztdnGVMbc9VPjREX8TMstB7mXItGF-4g6TieJ9yzaCqEuAGoGaAt31RjtiNCU_qZ5f3woTxAaealNqDLNyCQyjpsHugKqJ-W90eiXqlq6P7LQhe-Gd9Hrjdow9HH8dUDivmznI0kZkY4Xb9xjMpOnA7cWpZ2bjAXEyuYWJlV2v_i5vo3IuPw3hGZ5PEM14sUZZBW0yXncXJniBbzLjJgLbuWMT9Np1M8xdIMwn0Hdi3LMd2x0VOUo4WMordrrhrBlufSEd_geZc7gDVK74cEkO1ofzjavRUQ-BECHEMej3jP7tgSOuTxKcqiu0JS_A1D4Ddb1b8FabKErivQLpOlx2JIzs2VWLjCCLuuxn6udmGeuZS8c7uX_NBamKYqoGH4a3jc3wnlAn5GW3uaIetQEEzP7xkSyluqEdGJ4r-iKItuqBi1kOBHirYCSaglFyFQiZKEhW47SZQ8VV_IeTHD31QUfHyeO9cABSP7gyB0cz6fECm2muf6CYMhviKCR_pG12LlbW4rxbHKwU4OjClYO3FqS5w6tvt6=w500-h282-no)

<br>

`form` 태그 안의 `action`은 해당 form이 실행해서 어떤 URI로 값을 전달하는지를 알려준다. 위의 코드는 `/user/{id}` 로 값을 전달할 것이다. 따라서 해당 URI를 맵핑하는 컨트롤러를 작성해주어야 한다.



### <a name="user-id"></a>수정된 데이터 post요청 처리하는 맵핑메서드

지금까지 update.html 페이지를 작성하고, 여기에서 요구하는 URI를 처리하는 메서드(컨트롤러)를 만드는 방식으로 진행되고 있음을 알 수 있다.



**/controller/userController.class**

~~~java
package com.devandy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devandy.domain.User;
import com.devandy.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class userController {
	
	@Autowired
	private UserRepository userRepository;
	
	...
  
	@GetMapping("/{id}/update")
	public String update(@PathVariable Long id, Model model) {
		model.addAttribute("users", userRepository.findById(id).get());
		return "user/update";
	}
	
  // 추가로 작성한 메서드
	@PostMapping("/{id}")
	public String update(@PathVariable Long id, User updatedUser) {
		User user =  userRepository.findById(id).get(); // 업데이트 전의 프로필
		user.update(updatedUser); // User 정보 업데이트
		userRepository.save(user); // 업데이트된 user정보 userRepository에 저장
		return "redirect:/user/list";
	}
}
~~~

아까 작성한 get요청을 처리하는 메서드 아래에 post요청을 처리하는 메서드를 작성했다. id값은 노출되도 상관이 없기 때문에 get요청으로 처리했지만, `id`값 외의 사용자 정보는 유출되면 안되므로 값을 노출하지 않고 전달할 수 있는 post요청으로 처리한다.

메서드 이름이 같아도 상관은없다. <i><span style="color: gray;">(진짜 상관이 없는건지는 모르겠으나 아직 문제를 발견하지 못했다.)</span></i>



이번엔 `User` 객체의 인스턴스를 2개 생성해서 사용했다. 하나는 DB(`repository`)에서 가져온 사용자 정보, 즉 업데이트 전의 사용자 정보(`user`), 다른 하나는 화면에서 생성해서 전달받은 새로운 사용자 정보(`updatedUser`).



메서드의 작동과정은 다음과 같다.

URI를 통해 전달받은 id에 해당하는 사용자를 DB(`repository`)에서 찾아서

~~~java
User user =  userRepository.findById(id).get();
~~~



아직 생성하지 않았지만, User 도메인의 `update` 메서드를 통해 파라미터로 전달받은 새로운 사용자정보로 수정한다.

~~~java
user.update(updatedUser);
~~~



`update`된 사용자정보를 다시 DB(`repository`)에 저장한다.

~~~java
userRepository.save(user);
~~~



그리고 원래의 페이지였던 list.html로 리다이렉트 보낸다.



이제 데이터를 불러와서 수정하는 일이 끝났다. 이렇게 `id`값 1번에 해당하는 사용자 정보중 devandy라는 이름을 andy로 수정할 수 있다.

![](https://lh3.googleusercontent.com/JvG1mH7h4KVnsjY98upkAJjo_MIu-d9HDHl2CnRqCNRGsSDud-E_r3Zvo3XvPDRPshFwSJ2fy47ZPEqkZ3r-zRBLaPIjwKdGW1nK-dThkwuGL3hBowJvoOUcwGN_3MDHj8wWM8wuEMJPxRZqqk7BFm7KnjCk5TH00HFWqzPAc3hlRbr7IlbNi421ZnjjCFmVw7F-EUGVfyxsnn7qQqXPkb1RXFcsiIZS7y1eKvLHPhIZP7vhp6RJ4KLkguFlWtbMj5XBIq5u5Z-XfW1xkzlPhU0e5WbbYcJEySfXmbCPQQG-mHK0nfMS_Fw8Ecgeqddlvhpv9wFIiiCtVa_V288DSEK-slrrmcDB6biekvPja5Xjk6jxWVZ1i-xLopk1iFVe62cguEj9VGcqF8FwoQABfxon2o8D7SnIkr2ZWe6JuC4tc7PztpUJFAbwch45bHbGnAIO1Zpm_-UJDCn1PzGCZSzc9oNqPtp05AuBYcv2KskUQS9B_5bWnFJwY82m7X86mr7F1g6tmD3fw9TBvK1hu2WYCn9lrjMKxmHgStlO0GXN4U0LFxXJJ0MzhXSmstzTIrdDJcl1wKL7b3bgcIn2k4ybtq2U7ODkazYd1_gE-qhOko3XRtL7n11HzFbi2LjShgBEtAv-ZzgnMkU0r0A-HIGDo6qsz7tlKnhAqLBvlKEun7jvgNo7eZr6Lr6xnlvYTgY4YiXNNcrvsH38CUaPPRR2FP7GPdTazKmVcG34JHI0jABm-rGWiIHz=w500-h282-no)

<br>