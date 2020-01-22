# 언어별 정규표현식

[프로그래머스 정규표현식](https://programmers.co.kr/learn/courses/11/) 강의를 들으면서 작성한 노트이다. 

<br>

---

### <a name="java"></a>자바 정규표현식

자바에서는 정규표현식을 작성할때 앞에 `\` 을 더 붙여줘야 한다. 자바에선 기본적으로 `\` 이 escape를 의미하기 때문이다. 

따라서 3글자 숫자로만 구성된 단어를 조회한다면, 작성할 수 있는 정규표현식은 다음과 같을 것이다. `\\d{3}`



Python에서는 `re` 를 import하고, `re.findall()` 로 조회를 했다.

자바에서는 `Pattern` 클래스와 `Matchers` 클래스를 사용한다.

```java
import java.util.regex.Pattern;
import java.util.regex.Matchers;

public class study_regex {
   public static void main(String[] args){
      String target = "Luke Skywarker 02-123-4567 luke@daum.net\n다스베이더 070-9999-9999 darth_vader@gmail.com\nprincess leia 010 2454 3457 leia@gmail.com";
    
      // 숫자를 포함한 단어(\w) 조회
      Pattern pattern = Pattern.compile("\\w+");
      Matcher matcher = pattern.matcher(target);
    
      while(matcher.find()){
         System.out.println(matcher.group(0));
      }
   }
}
```

**출력 결과**

<img src="https://www.mediafire.com/convkey/cb5a/4u2xrn4yc5joisxzg.jpg" />