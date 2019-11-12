# Node.js

- [Node.js](#nodejs)
- [주요 특징](#features)
- [fileRead](#fileread)

<br>

## <a name="nodejs"></a>Node.js

Node.js는 JavaScript를 이용하여 웹 서버를 만들 수 있는 서버 사이드 플랫폼이다. 

Node.js를 백엔드 프레임워크로 오해하고 있었는데, Node.js는 구글 Chrome의 V8 JavaScript엔진 기반으로 빌드된 JavaScript Runtime Environment라고 한다.

마찬가지로 Node.js는 Apache같은 웹 서버가 아니다.

<br>

## <a name="features"></a>주요 특징

- **비동기 I/O 처리**
  - Node.js 라이브러리의 모든 API는 비동기식. 즉 데이터를 반환할 때까지 기다리지 않고 다음 API를 실행하는, 멈추지 않고 작동한다는 특징이 있다.
- **빠른 속도**
  - 구글 크롬의 V8 JavaScript Engine을 사용하여 빠른 실행을 제공한다고 한다.
- **싱글쓰레드 / 확장성**
  - 이벤트 메커니즘은 서버가 멈추지 않고 반응하도록 하여 서버의 확장성을 키워준다고 한다. 일반적인 웹 서버는 요청을 처리하기 위해 제한된 쓰레드를 생성하지만, Node.js는 쓰레드를 한개만 사용하면서 Apache같은 웹 서버보다 많은 요청을 처리할 수 있다고 한다. 
    (아직 정확히 이해하지 못했다..) 
- **버퍼링이 없다.**
  - Node.js 애플리케이션엔 데이터 버퍼링이 없다고 한다.

<br>

## <a name="filerea"></a>fileRead

Node.js에서 파일을 읽어들이는 방법이다.

먼저 File을 다루기 위해서는 FileSystem 모듈을 가져와야 한다.

```js
var fs = require('fs');
```



FileSystem의 내장모듈로 [readFile](https://nodejs.org/dist/latest-v12.x/docs/api/fs.html#fs_fs_readfile_path_options_callback)이 존재하는데, `readFile`을 이용하여 파일을 불러올 수 있다.

예제 코드를 작성했다. `fileread.js` 파일에서 `sample.txt` 속 파일을 읽어보겠다.

`sample.txt`

```txt
Hello World 
It will be showed by Node JS
```

`fileread.js`

```javascript
var fs = require('fs');
fs.readFile('sample.txt', 'utf-8', function(err, data){
   console.log(data);
});
```

**결과**

![](http://www.mediafire.com/convkey/480a/8hlzitle4uhdz4rzg.jpg)

<br>