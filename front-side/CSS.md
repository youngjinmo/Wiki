# CSS

웹 페이지의 스타일을 책임지는 CSS 영역이다. 만만히 보기 쉽지만, 결코 쉽지 않으며 잘 다루면 판타스틱한 뷰를 만들어낼 수 있는 실용적인 기술이다. 그러나 정말 쉽지 않다. 앞으로 유용한 코드는 여기에 기록해두고 꺼내보려고 한다.

<br>

- [word-break](#word-break)
- [복수의 id에 CSS 적용](#apply-style-to-multiple-ids)

<br>

## <a name="word-break"></a>word-break

가끔 포털 뉴스나 기사를 읽다보면, 문장을 띄우는 포인트가 애매해서 보기 어려울 때가 있다. 애매하다는 의미는 단어간격으로 문장의 줄을 나누는게 아니라 "한 글자" 단위로 자르다보니 단어중간에 줄이 띄어지는 경우가 있다.

`word-break: keep-all;` 을 적용하지 않은 문장이 출력되는 화면이다. `"대한민국"`이라는 한 단어가 완성되지 못하고 잘린 상태에서 줄이 나뉘었다. 이 경우에는 기사를 읽는 독자관점에서 좀 불편할 수 있다. 따라서 이 때엔 `"대한민국"` 을 다음 줄로 넘겨서 보여주는게 훨씬 나을 것이다.

![](http://www.mediafire.com/convkey/cbb1/eeqzb4niwbls0c3zg.jpg)

다음은 `word-break: keep-all;` 을 적용한 모습이다.

![](http://www.mediafire.com/convkey/0b2b/zwlwz6qc4uazsg2zg.jpg)

<br>

아직 CSS에 대해 아는게 거의 없을정도로 무지하지만, 지금까지 배운 CSS 코드중 `display: flex;` 만큼 매력적인 코드였다.

![](https://i.ytimg.com/vi/in9SX3enCHU/maxresdefault.jpg)

아래 출처에 링크를 통해 알게 된 사실을 추가한다.

 `word-break: keep-all;` 로만 하면, 텍스트가 박스를 벗어날 수 있다고 한다. 따라서 이를 방지하기 위해 `word-wrap: break-word;` 를 추가하면, 어떤 언어도 원하는대로 단어가 중간에 끊기지않고 줄을 띄울 수 있다.

출처 : [김유리님 WIT블로그 - word-break 속성과 word-wrap 속성 알아보기](https://wit.nts-corp.com/2017/07/25/4675)

<br>

##<a name="apply-style-to-multiple-ids"></a>복수의 id에 CSS 적용

HTML 문서의 스타일 코드를 적용할 때 class, id로 구분해서 스타일을 따로 적용하는 편인데, 이 때 서로다른 id에 같은 스타일의 적용이 필요할 때가 있다. 이 땐 그냥 `,` 로 구분해서 복수의 id에 스타일을 적용할 수 있다.

<p class="codepen" data-height="265" data-theme-id="default" data-default-tab="html,result" data-user="youngjinmo" data-slug-hash="LYEdypN" style="height: 265px; box-sizing: border-box; display: flex; align-items: center; justify-content: center; border: 2px solid; margin: 1em 0; padding: 1em;" data-pen-title="Apply style to multiple ids.">
  <span>See the Pen <a href="https://codepen.io/youngjinmo/pen/LYEdypN">
  Apply style to multiple ids.</a> by DevAndy (<a href="https://codepen.io/youngjinmo">@youngjinmo</a>)
  on <a href="https://codepen.io">CodePen</a>.</span>
</p>
<script async src="https://static.codepen.io/assets/embed/ei.js"></script>

<br>