package classess

import java.awt.Window

/**
 * 嵌套类与内部类
 */
fun main(args: Array<String>) {
    println(Outer.Nested().foo())
    println(Outer2().Inner().foo())

    val nested = Outer.Nested()
    nested.test = 3
    println(Outer.Nested().test)

    val inner = Outer2().Inner()
    inner.test = 3
    println(inner.test)

    //匿名内部类
    Outer3().addListener(object : Outer3.TestListener {
        override fun testListener() {

        }

    })

}

//嵌套类
class Outer {
    private val bar: Int = 1

    class Nested {
        public var test: Int = 2
        fun foo() = 2//无法访问bar
    }
}

//内部类
//类可以标记为 inner 以便能够访问外部类的成员。内部类会带有一个对外部类的对象的引用：
class Outer2 {
    private val bar: Int = 3

    inner class Inner {
        public var test: Int = 2
        fun foo() = bar//可以访问bar
    }
}

//匿名内部类
class Outer3 {
    interface TestListener {
        fun testListener()
    }

    var listner: TestListener? = null

    fun addListener(listener2: TestListener) {
        this.listner = listener2
        println("设置了监听")
    }
}