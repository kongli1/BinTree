## 一个react的例子
### 使用
- react-start-kit模板

### 创建步骤
- 创建项目

>使用WebStrom创建一个Entry Project

- 配置项目框架

>1、将[react-start-kit](https://github.com/kriasoft/react-starter-kit.git)根目录下的package.json文件和tools文件拷贝到新建项目的根目录<br/>
2、在控制台中输入'npm install'运行安装node控件<br/>
3、运行'npm install jquery --save'安装jQuery控件

- 修改配置文件
>1、修改tools中webpack.config.js文件的clientConfig变量的entry值为'./src/client.js'<br/>
2、修改tools中webpack.config.js文件的serverConfig变量的entry值为'./src/server.js'

- 创建项目目录及文件

>1、在根目录下创建src目录<br/>
2、在src目录下创建client.js文件<br/>
3、在src目录下创建server.js文件<br/>
4、在src目录下创建public文件夹<br/>
5、在src目录下的public文件夹下创建index.html文件

- 创建Comment控件
>1、在src目录下创建Comment.js文件<br/>
2、在Comment.js中引入所需控件<br/>
```base
import React from 'react';
```
>3、创建Comment控件<br/>
```base
var Comment = React.createClass({
    render: function () {
        return (
            <div className="comment">
                <h2 className="commentAuthor">
                    {this.props.author}
                </h2>
            </div>
        );
    }
});
```
>4、输出Comment控件
```base
export default Comment;
```

- 创建CommentFrom控件
>1、在src目录下创建CommentFrom.js文件<br/>
2、在CommentFrom.js中引入所需的控件<br/>
```base
import React from 'react';
```
>3、创建CommentFrom控件
```base
var CommentFrom = React.createClass({
    handleSubmit: function (event) {
        event.preventDefault();
        var author = this.state.author.trim();
        var text = this.state.text.trim();
        if (!text || !author) {
            return;
        }
        this.props.onCommentSubmit({author: author, text: text});
        this.setState({author: '', text: ''});
    },
    handleAuthorChange: function (event) {
        this.setState({author: event.target.value});
    },
    handleTextChange: function () {
        this.setState({author: event.target.value});
    },
    render: function () {
        <form className="commentForm" onSubmit={this.handleSubmit}>
            <input type="text" onChange={this.handleAuthorChange}
                   placeholder="Your name"
                   value={this.state.author}/>
            <input type="text" onChange={this.handleTextChange}
                   placeholder="Say something..."
                   value={this.state.text}/>
            <input type="submit" value="Post"/>
        </form>
    }
});
```
>4、到出CommentFrom控件
```base
export default CommentFrom;
```
- 创建CommentList控件
>1、在src目录下创建CommentList.js文件<br/>
2、在CommentList.js中引入所需的控件<br/>
```base
import React from 'react';
```
>3、创建CommentList控件
```base

```
> 4、到出CommentList控件
```base
export default CommentList;
```
