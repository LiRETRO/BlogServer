# BlogProject
[Blog Project Service Support](https://github.com/LiRETRO/BlogServer)


[toc]
# MySQL编码探究

> **摘要**: 本文主要分为2个部分  
> 1. 编码分类以及由来
> 2. MySQL协议对编码的影响  

## 编码
### 1. 什么是字符编码?
  在计算(Computing)、数据存储(Data Storage)和数据传输(Data Transmission)中，<font color=red>字符编码</font>用于通过编码系统来表示一组字符，该系统为每个字符分配一个数字以进行数字化展示  

### 2. 字符编码分类
  #### 2.1 ASIIC
    上世纪60年代，美国制定了一套字符编码，用于英文字符与二进制位之间的关系，这套字符编码被称为<font color=red>ASIIC</font>。ASIIC一共规定了128个字符的编码，这128个编码只占用了一个字节的后7位. 最高位统一位0


## MySQL协议对选择编码的影响
