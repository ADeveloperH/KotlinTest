package classess

fun main(args: Array<String>) {
    val person = Person("huangjian", 20)
    println(person.toString())

    OuterClass().test()
}

//类名、类头（指定其类型参数、主构造函数等）和由大括号包围的类体构成
//主构造函数没有任何注解或者可见性修饰符，可以省略这个 constructor 关键字。
class Person constructor(name: String?) {
    //主构造函数不能包含任何的代码。初始化的代码可以放到以 init 关键字作为前缀的初始化块（initializer blocks）中
    init {
        println("类初始化代码块已加载")
        println("name is $name")
    }

    //如果类有一个主构造函数，每个次构造函数需要委托给主构造函数，
    // 可以直接委托或者通过别的次构造函数间接委托。委托到同一个类的另一个构造函数用 this 关键字即可：
    constructor(name: String, age: Int) : this(name) {
        println("次构造函数已经加载了")
    }
}


//如果一个非抽象类没有声明任何（主或次）构造函数，它会有一个生成的不带参数的主构造函数。
// 构造函数的可见性是 public。如果你不希望你的类有一个公有构造函数，你需要声明一个带有非默认可见性的空的主构造函数：
class DontCreateMe private constructor()


//继承：默认情况下，在 Kotlin 中所有的类都是 final。
// 类上的 open 标注与 Java 中 final 相反，它允许其他类从这个类继承
open class Base(p: Int)

//类有一个主构造函数，其基类型可以（并且必须） 用（基类型的）主构造函数参数就地初始化。
class Derived(p: Int) : Base(p)

open class View {
    constructor(c1: Int)
    constructor(c1: Int, c2: Int)

    //与 Java 不同，Kotlin 需要显式标注可覆盖的成员（我们称之为开放）和覆盖后的成员：
    open fun v() {}

    fun nv() {}

    open val x: Int get() {
        return 1
    }

    open val y: Int get() = 2
}

//如果类没有主构造函数，那么每个次构造函数必须使用 super 关键字初始化其基类型，或委托给另一个构造函数做到这一点。
// 注意，在这种情况下，不同的次构造函数可以调用基类型的不同的构造函数：
class MyView : View {
    constructor(my: Int) : super(my)
    constructor(my: Int, my2: Int) : super(my, my2)

    //函数上必须加上 override标注。如果没写，编译器将会报错
    //标记为 override 的成员本身是开放的，也就是说，它可以在子类中覆盖。如果你想禁止再次覆盖，使用 final 关键字：
    override fun v() {
        super.v()
    }

    //可以用一个 var 属性覆盖一个 val 属性，但反之则不行
    override var x: Int = 0

    //派生类中的代码可以使用 super 关键字调用其超类的函数与属性访问器的实现
    override val y: Int
        get() = super.y + 1
}

open class SuperOuterClass {
    open fun f(): Int {
        return 1
    }
}

class OuterClass : SuperOuterClass() {
    override fun f(): Int {
        return 3
    }

    inner class InnerClass {
        //在一个内部类中访问外部类的超类，可以通过由外部类名限定的 super 关键字来实现：super@Outer：
        fun g(): Int {
            return super@OuterClass.f() + 2
        }
        //区别g()
        fun g2(): Int {
            return f() + 2
        }
    }

    fun test() {
        val innerClass = InnerClass()
        println(innerClass.g())
        println(innerClass.g2())
    }
}

open class A{
    open fun f() {
        println("A.f")
    }

    fun a() {
        println("A.a")
    }
}
interface B{
    //// 接口成员默认就是“open”的
    fun f(){
        println("B.f")
    }

    fun b(){
        println("B.b")
    }
}

class C: A(),B{

    //如果一个类从它的直接超类继承相同成员的多个实现，
    // 它必须覆盖这个成员并提供其自己的实现（也许用继承来的其中之一）。
    // 为了表示采用从哪个超类型继承的实现，我们使用由尖括号中超类型名限定的 super，如 super<Base>
    override fun f() {
        super<A>.f()
        super<B>.f()
    }
}

open class SuperAbstractClass{
    open fun f() {}
}

//类和其中的某些成员可以声明为 abstract。 抽象成员在本类中可以不用实现。
// 需要注意的是，我们并不需要用 open 标注一个抽象类或者函数——因为这不言而喻。
abstract class AbstractClass: SuperAbstractClass() {
    //我们可以用一个抽象成员覆盖一个非抽象的开放成员
    override fun f() {
        super.f()
    }
}


/**
 * 伴生对象:

    与 Java 或 C# 不同，在 Kotlin 中类没有静态方法。在大多数情况下，它建议简单地使用包级函数。

    如果你需要写一个可以无需用一个类的实例来调用、但需要访问类内部的函数（例如，工厂方法），

    你可以把它写成该类内对象声明中的一员。

    更具体地讲，如果在你的类内声明了一个伴生对象， 你就可以使用像在 Java/C# 中调用静态方法相同的语法来调用其成员，

    只使用类名作为限定符。
 *
 */
