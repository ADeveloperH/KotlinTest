package start

import java.io.File

fun main(args: Array<String>) {
    testDTOs()
    defaultParmaTest("name")
    filterTest()
    mapTest()
    println("test".stringToUpper())
    ifNullTest()
    testTrutle()
    testNullBoolean()
}

fun testDTOs() {
    val customer = Customer("huangjian", "huangjianalex@163.com")
    println("customer hashCode is ${customer.hashCode()}")
    println("cusomer toString is ${customer.toString()}")
}

data class Customer(val name: String, val email: String) {
    override fun toString(): String {
        return "name is ${name} ,email is ${email}"
    }
}

//函数的默认参数
fun defaultParmaTest(a: String = "jian", b: String = "huangjian") {
    println("a is ${a},b is ${b}")
}

//过滤list
fun filterTest() {
    val valueList = listOf(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5)
    println(valueList.filter { x -> x > 0 })
    println(valueList.filter { it > 0 }
            .forEach { print(it) })
}

//map的使用
fun mapTest() {
    var map = mapOf("a" to 1, "b" to 2, "c" to 3)
    println(map["b"])
    //遍历map
    for ((kk, vv) in map) {
        println("$kk -> $vv")
    }

    //使用区间
    for (i in 1..10) {// 闭区间：包含 10
        print(i)
    }
    println()
    for (i in 1 until 3) {// 半开区间：不包含 3
        print(i)
    }
    println()
    for (i in 2..20 step 2) {
        print(i)
    }
    println()
    for (i in 20 downTo 1 step 3) {
        print(i)
    }
    println()
}

//扩展函数的使用。
fun String.stringToUpper(): String {
    return "${this} to Upper is " + this.toUpperCase()
}

//if null..等判断语句简写模式
fun ifNullTest() {
    try {
        val files = File("Test").listFiles()
        //if not null的缩写
        println(files?.size)
        //If not null and else 缩写
        println(files?.size ?: "empty")
        //if null 执行一个语句
        println(files ?: "empty")
    } catch(e: Exception) {
    }
}

//对一个对象实例调用多个方法 （with）
class Trutle {
    fun fun1() = 1
    fun fun2() = 2
    fun fun3() = 3
    fun fun4() = 4
}

fun testTrutle() {
    val trutle = Trutle()
    with(trutle) {
        println(fun1())
        println(fun2())
        println(fun3())
    }

    println(trutle.fun4())
}

//使用可控布尔
fun testNullBoolean() {
    val b: Boolean? = null
    if (b == true) {
        println("b == true")
    } else {
        println("`b` 是 false 或者 null")
    }
}


