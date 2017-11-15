package start

//基础语法
fun main(args: Array<String>) {
    println(sum(5, 1))
    println(sum2(5, 2))
    printSum(5, 3)
    printSum2(5, 4)
    variable()
    stringModule()
    maxOf(5, 6)
    maxOf2(5, 7)
    printProdect("23", "ab")
    printProdect("2", "3.5")
    printProdect("2", "3")

    println("${getStringLength(234)}")
    println("${getStringLength("huangjian")}")

    forTest()
    whileTest()
    println(whenTest(0))
    println(whenTest("Hello"))
    println(whenTest(0L))
    println(whenTest("huangjian"))
    rangeTest()
    iterationTest()
    lambdaTest()
}

/**
 * 定义函数
 */

//带有两个 Int 参数、返回 Int 的函数
fun sum(a: Int, b: Int): Int {
    return a + b
}

//将表达式作为函数体、返回值类型自动推断的函数
fun sum2(a: Int, b: Int) = a + b

//函数返回无意义的值
fun printSum(a: Int, b: Int): Unit {
    println("sum of $a and $b is ${a + b}")
}

//Unit 返回类型可以省略
fun printSum2(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

/**
 *定义变量
 */
fun variable() {
    //一次赋值（只读）的局部变量
    val a: Int = 5// 立即赋值
    val b = 2//自动推断出 `Int` 类型
    val c: Int // 如果没有初始值类型不能省略
    c = 3// 明确赋值
    println("a=$a,b=$b,c=$c")

    //可变变量：
    var x = 5// 自动推断出 `Int` 类型
    x++
    println("x=$x")
    println("y=$y,y+PI=${y + PI}")
}

//顶层变量：
val PI = 3.1415926
var y = 0


//使用字符串模板
fun stringModule() {
    var a = 1
    val s = "a is $a"
    a = 2
    val s2 = "${s.replace("is", "was")},but now is $a"
    println(s2)
}


//条件表达式
fun maxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}

//使用 if 作为表达式
fun maxOf2(a: Int, b: Int) = if (a > b) a else b

//使用可空值及 null 检测
fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProdect(arg1: String, arg2: String) {
    val x = parseInt(arg1)
    val y = parseInt(arg2)
    if (x != null && y != null) {
        println(x * y)
    } else {
        println("either '$arg1' or '$arg2' is not a number")
    }
}

//使用类型检测及自动类型转换is
fun getStringLength(str: Any): Int? {
    if (str is String && str.length > 0) {
        return str.length
    } else {
        return null
    }
}

//for循环
fun forTest() {
    val list = listOf("apple", "banana", "oreo")
    for (item in list) {
        print(item + "--")
    }
    println()
    for (index in list.indices) {
        println("index at $index is ${list[index]}")
    }
}

//while循环
fun whileTest() {
    val list = listOf("one", "two", "three")
    var index = 0
    while (index < list.size) {
        println("index at $index is ${list[index]}")
        index++
    }
}

//when表达式
fun whenTest(obj: Any): String = when (obj) {
    1 -> "ONE"
    "Hello" -> "Greeting"
    is Long -> "Long"
    !is String -> "Not a String"
    else -> "Unknow"
}

//使用区间range
fun rangeTest() {
    val x = 10
    val y = 10
    if (x in 1..y+1) {
        println("$x is in 1...${y+1}")
    }
    val list = listOf("a","b","c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of rang")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too")
    }
}

//迭代iteration
fun iterationTest() {
    //区间迭代
    for (x in 1..5) {
        print(x)
    }
    println()
    //数列迭代
    for (x in 1..10 step 2) {
        print(x)
    }

    println()
    for (x in 9 downTo 0 step 3) {
        print(x)
    }

    println()
    //集合迭代
    val items = listOf("apple", "banana", "orea")
    for (item in items) {
        print(item)
    }
    println()

    val fruits = setOf("apple", "banana", "kiwi")
    when {
        "orange" in fruits -> println("juicy")
        "apple" in fruits -> println("apple is fine too")
    }
}

//lambda 表达式来过滤（filter）和映射（map）集合
fun lambdaTest() {
    val fruits = listOf("apple","banana","avocado","kiwi","aaa")
    fruits.filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
}



