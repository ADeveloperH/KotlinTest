package classess


/**
 * 数据类
 * 我们经常创建一些只保存数据的类。 在这些类中，一些标准函数往往是从数据机械推导而来的。
 * 在 Kotlin 中，这叫做 数据类 并标记为 data：
 */
fun main(args: Array<String>) {
    val jack = User("jack", 3)
    val oldJack = jack.copy(age = 4)
    println(oldJack.age)
}
//编译器自动从主构造函数中声明的所有属性导出以下成员：
//1、equals()/hashCode() 对；
//2、toString() 格式是 "User(name=John, age=42)"；
//3、componentN() 函数 按声明顺序对应于所有属性；
//4、copy() 函数
//确保生成的代码的一致性和有意义的行为，数据类必须满足以下要求：
// 1、主构造函数需要至少有一个参数；
//2、主构造函数的所有参数需要标记为 val 或 var；
//3、数据类不能是抽象、开放、密封或者内部的；
//4、（在1.1之前）数据类只能实现接口。
//如果生成的类需要含有一个无参的构造函数，则所有的属性必须指定默认值
data class User(val name: String = "", val age: Int = 2)