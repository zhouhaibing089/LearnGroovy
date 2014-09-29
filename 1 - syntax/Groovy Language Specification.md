Groovy Language Specification
=============================

###语法

**注释**: 与Java相同,单行注释,多行注释,DOC注释(type definitions;fields and properties definitions;methods definitions)

**Shebang line**: 在脚本文件中第一行指定执行此脚本的可执行文件(`#!/usr/bin/env groovy`)

**定义变量**: `def {identifier}`

**字符串的形式**

*   '单引号'
*   "双引号"
*   '''三单引号'''
*   """三双引号"""
*   /正则表达式般/
*   $/这个有点奇怪/$

所有的关键字跟在.后面都是合法的标志符.

标志符还可以被扩在引号里，在引号里的标志符可以含有空格等常规Java标志符不允许出现的字符.

interpolation(插入,注入)

    def map = [:]
    def firstname = "Homer"
    map."Simson-${firstname}" = "Homer Simson"

单引号字符串为String类型
双引号字符串为GString类型(若有Interpolation)
三单(双)引号字符串支持多行

String的两个方法: `stripIndent`和`stripMargin`

尝试`stripIndent`,当在代码中含有缩进时,该方法可以将字符串中的缩进去除，像下面这样:

```groovy
    def str1 = '''
        HelloWorld
    '''

println str1
println str1.stripIndent()
```

上面代码的输出是:

```

        HelloWorld


HelloWorld

```

尝试`stripMargin`,代码比较能说明问题

```groovy
def str1 = '''
  &HelloWorld
'''

println str1
println str1.stripIndent('&')
```

上面这一小段代码的输出是:

```

  &HelloWorld


HelloWorld

```

在字符串插入过程中,任何expression都可以(除了triple string),也可以是statement. 总结来说像下面这样:

```groovy
${expression or statements}
$a.b.c.d
```

像`$name.method()`会被解释成`${name.method}()`

若需要转义`$`,则使用反斜杠

```groovy
assert '${name}' == "\${name}"
```

需要注意的是`${->}`是一种闭包形式

```groovy
def parentheness = "1 + 2 == ${-> 3}"
assert parentheness == '1 + 2 ==3'
def param = "1 + 2 == ${w -> w << 3}"
assert param == '1 + 2 == 3'
```

闭包有一个强大的地方在于lazy特性

下面这段代码比较清晰地解释了这个特性

```groovy
def number = 1
def eagerGString = "value == ${number}"
def lazyGString = "value == ${ -> number }"

assert eagerGString == "value == 1"
assert lazyGString == "value == 1"

number = 2

assert eagerGString == "value == 1"
assert lazyGString == "value == 2"
```

也就是说每次取lazyGString的值时都会重新计算一次

一个embedded closure expression只能接受0个或1个参数

GString和String的hashcode值不一样，因此像map这样的结构无法混合使用GString和String

**slash string**是多行的,可以使用interpolated特性

声明字符类型的三种方式:

*   `char c1 = 'A'`
*   `def c2 = 'B' as char`
*   `def c3 = (char)'C'`

声明数字时使用def的话会使用最合适大小的类型

长的数字可以用下划线连接

下面是一些类型对应的后缀

*   BigInteger G or g
*   Long L or l
*   Integer I or i
*   BigDecimal  G or g
*   Double D or d
*   Float F or f

关于相关类型的运算结果类型,要查看相关文档

声明List的方式为: `def numbers = [1, 2, 3]`

默认的List实现为ArrayList,若要修改默认行为可以使用as关键字或者直接声明类型

```groovy
def linkedList = [2, 3, 4] as LinkedList
LinkedList otherLinked = [3, 4, 5]
```

对于List可以使用`[]`来取元素,正负数皆可,也可以使用`<<`来追加元素

Array和List的写法一样,如果你要声明Array的话就需要把类型补上.

```groovy
String[] arrStr = ['Ananas', 'Banana', 'Kiwi']
```









