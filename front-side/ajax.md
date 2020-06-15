# Ajax

### <a name="status"></a>통신한 서버로부터 HttpStatus 코드를 반환하고 싶을때

`response` 객체를 반환받아 보면 다음과 같은 정보가 담겨있다.

버튼(`type="button"`)을 하나 만들어서 클릭(`onclick=""`)하면, fetch가 실행되고 그에 따른 response를 콘솔에 출력하는 익명함수를 실행하도록 코드를 작성했다. 

~~~javascript
<input type="button" value="fetch" onclick="
	fetch('/html').then(function(response){
     console.log(response);
  })
">
~~~

버튼을 클릭하고 콘솔을 확인해보니 Response에 담긴 정보는 다음과 같다.

![](https://lh3.googleusercontent.com/pw/ACtC-3c_lwBE1tPi6bpAnrSTK6u1SDX5lrqs8-BE29URMWKKXQxyDJkA6-oDw2ngyISVPqkInvB01cPoF-J4xadpvmKKwe45b2cfMZEVP7FZAh6MglkVKK-NWpFGWcBTB8hhNXw6XYpGRnCg7VAKfSv1yy6q5g=w1442-h348-no?authuser=0)

 각각의 정보만을 콘솔로 출력하고 싶다면, `response.status` 식으로 작성하면 확인할 수 있다.

~~~javascript
<input type="button" value="fetch" onclick="
	fetch('/html').then(function(response){
     console.log('response.status : ',response.status);
     console.log('response.url : ',response.url);
  })
">
~~~

![](https://lh3.googleusercontent.com/pw/ACtC-3cb_Fb_Wqe51xBMygb-AEQMlzTlwGOBXg5rRt7lcyOeyQHmd6mXSogWIXwIUiXtHdlR1dPvV9iBz17VF3wDfswbEmXI_H7vKxUHosAIXNqf0BV8aUcunZp2Qb8HRzDZWjb83j2-PhurXuuSj_ghL0wTng=w902-h172-no?authuser=0)

이 방식을 응용하면, response.status에 따라 alert를 줄 수도 있다.

~~~javascript
<input type="button" value="fetch" onclick="
	fetch('/html').then(function(response){
     if(response.status==404){
        alert('페이지를 찾을 수 없습니다.');
     } else if(response.status==200){
        alert('통신에 성공했습니다.');
     }
  })
">
~~~

<br>

### <a name="text"></a>통신한 서버의 응답페이지의 html 코드를 반환하고 싶을 때

`response.text()` 를 통해 html코드를 가져올 수 있다.

nested 함수를 작성하여 첫번째 함수에서는 response, 두번째 함수에서는 response 객체에서 받아온 text를 가져와서 콘솔에 출력하는 코드를 작성했다.

~~~javascript
<input type="button" value="fetch" onclick="
	fetch('/css').then(function(response){
     response.text().then(function(text){
        console.log(text);
     });
  })
">
~~~

![](https://lh3.googleusercontent.com/pw/ACtC-3eKvAHQXTeRl1q1tYuHYfR1I8uM5E1EB8oqO9anPhJH59sYLuh3H5Sqdqr_R8VPE7lLyJr_hezHMQiAZyFWYnf_bBbjpV7fLDRakDAWaer1bCmaZk5tacQswOIDNyUAqRUijUTVcrhh5ObtENAqSCZR4Q=w1442-h467-no?authuser=0)

<br>