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
双引号字符串为GString类型
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


