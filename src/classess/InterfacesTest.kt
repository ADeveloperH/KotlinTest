package classess

/**
 * 接口
 * 定义的接口类不能
 * Kotlin 的接口与 Java 8 类似，既包含抽象方法的声明，也包含实现。
 * 与抽象类不同的是，接口无法保存状态。它可以有属性但必须声明为抽象或提供访问器实现。
 * 一个类或者对象可以实现一个或多个接口。一个类只能继承自一个父类
 */
fun main(args: Array<String>) {
    val cc = CC()
    cc.bar()
    cc.foo()
}

interface MyInterface {
    //在接口中声明的属性要么是抽象的，要么提供访问器的实现。
    // 在接口中声明的属性不能有幕后字段（backing field），因此接口中声明的访问器不能引用它们。
    var prop: Int// 抽象的

    val propertyWithImplementation: String
        get() = "foo"

    fun bar()
    fun foo() {
        // 可选的方法体.如果有方法体。子类中可不实现
    }
}

class Child : MyInterface {
    override var prop: Int = 10

    override fun bar() {
    }

    //    override fun foo() {
    //    }
}

/**
 * 覆盖冲突
 *
 */
//定义的接口名不能和其他的接口或类重名。默认都是open的(classess.A)
interface AA {
    fun foo()
    fun bar() {
        println("AA.bar()")
    }
}

interface BB {
    fun foo()
    fun bar() {
        println("BB.bar()")
    }
}

class CC : AA, BB {
    override fun bar() {
        //在AA和BB中已经有实现的了
        super<AA>.bar()
        super<BB>.bar()
        println("CC.bar()")
    }

    override fun foo() {
        println("CC.foo()")
    }

}
