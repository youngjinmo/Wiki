# HTML

HTML은 Hyper Text Markup Language이며, 웹 페이지의 뼈대를 구성한다.

<br>

## <a name="details"></a>details

ToC(Table of Contents)를 작성하면서 리스트가 길어지면서 이를 숨겨두고 사용자가 클릭했을때에만 펼쳐지도록 할 때 사용하게되었다.

`<details>` 태그로 둘러싸고, 최상위 `<summary>` 태그 사이에 이름을 작성한다. 아래 예제 코드를 참고하자.

<details>
	<summary>details 태그</summary>
  <ul>
    <li>1</li>
    <li>2</li>
    <li>3</li>
    <li>이렇게 사용합니다.</li>
  </ul>
</details>

```html
<html>
  <details>
  	<summary>details 태그</summary>
    <ul>
      <li>1</li>
      <li>2</li>
      <li>3</li>
      <li>이렇게 사용합니다.</li>
    </ul>
  </details>
</html>
```

<br>