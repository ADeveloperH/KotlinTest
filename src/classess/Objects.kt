package classess

/**
 * 对象表达式和对象声明
 * 有时候，我们需要创建一个对某个类做了轻微改动的类的对象，而不用为之显式声明新的子类。
 * Java 用匿名内部类 处理这种情况。 Kotlin 用对象表达式和对象声明对这个概念稍微概括了下。
 *
 */
fun main(args: Array<String>) {
    foo()
    testCompanion()
}


//任何时候，如果我们只需要“一个对象而已”，并不需要特殊超类型，那么我们可以简单地写：
fun foo() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 1
    }
    println(adHoc.x + adHoc.y)
}


//伴生对象
fun testCompanion() {
    //该伴生对象的成员可通过只使用类名作为限定符来调用
    val myClass = MyClass.create()//或者MyClass.Factory.create()
    println(myClass.x)
    val myClass2 = MyClass2.create()//或者MyClass2.Companion.create()
    println(myClass2.y)
    val myClass3 = MyClass3.create()
    println(myClass3.z)
}

//类内部的对象声明可以用 companion 关键字标记
class MyClass {
    val x: Int = 2

    companion object Factory {
        fun create(): MyClass = MyClass()
    }
}

//可以省略伴生对象的名称，在这种情况下将使用名称 Companion：
class MyClass2 {
    val y: Int = 3

    companion object {
        fun create(): MyClass2 = MyClass2()
    }
}

//即使伴生对象的成员看起来像其他语言的静态成员，在运行时他们仍然是真实对象的实例成员，而且，例如还可以实现接口：
interface Factory<T> {
    fun create(): T
}

class MyClass3 {
    val z = 4
    companion object : Factory<MyClass3> {
        override fun create(): MyClass3 = MyClass3()
    }
}





