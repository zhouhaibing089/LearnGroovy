class Person {
    
    def name

    Person(name) {
        this.name = name
    }

    String getName() {
        'getName: ' + name
    }

    String toUpperName() {
        name.toUpperCase()
    }
}

Person p = new Person('zhb')
println p.name      // 调用getName方法
println p.@name     // 直接访问属性

def toUpper = p.&toUpperName

println toUpper()
