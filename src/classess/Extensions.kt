package classess

/**
 * 扩展
 * Kotlin 同 C# 和 Gosu 类似，能够扩展一个类的新功能而无需继承该类或使用像装饰者这样的任何类型的设计模式。
 * 这通过叫做 扩展 的特殊声明完成。Kotlin 支持 扩展函数 和 扩展属性。
 */
fun main(args: Array<String>) {
    val mutableListOf = mutableListOf(1, 2, 3)
    mutableListOf.swap(1, 2)
    println(mutableListOf[1])
    printFoo(TA())
    TestA().funTest()
    var nullTest: String? = null
    println(nullTest.toString())

}


/**
 * 扩展函数
 */
//为 MutableList<T> 添加一个swap 函数：(可以在任意位置调用)
fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
    // this 关键字在扩展函数内部对应到接收者对象（传过来的在点符号前的对象）
    val tmp = this[index1]
    this[index1] = this[index2]
    this[index2] = tmp
}

//扩展函数是由函数调用所在的表达式的类型来决定的， 而不是由表达式运行时求值结果决定的
open class STA

class TA : STA()

fun STA.foo() = "STA"
fun TA.foo() = "TA"
fun printFoo(ta: STA) {
    println(ta.foo())//打印为STA
}


class TestA {
    fun funTest() {
        println("funTest")
    }
}

//如果一个类定义有一个成员函数和一个扩展函数，而这两个函数又有相同的接收者类型、相同的名字并且都适用给定的参数，
// 这种情况总是取成员函数。
fun TestA.funTest() {
    println("Extension funTest")
}

//可空接收者
//可以为可空的接收者类型定义扩展。这样的扩展可以在对象变量上调用， 即使其值为 null，
// 并且可以在函数体内检测 this == null
fun Any?.toString(): String {
    if (this == null) return "null"
    //// 空检测之后，“this”会自动转换为非空类型，所以下面的 toString()
    // 解析为 Any 类的成员函数
    return toString()
}

/**
 * 扩展属性
 * 和函数类似，Kotlin 支持扩展属性：
 */
val <T> List<T>.lastIndex: Int get() = size - 1
//注意：由于扩展没有实际的将成员插入类中，因此对扩展属性来说幕后字段是无效的。
// 这就是为什么扩展属性不能有初始化器。他们的行为只能由显式提供的 getters/setters 定义。
//val <T> List<T>.bar: Int = 1  // 错误：扩展属性不能有初始化器

