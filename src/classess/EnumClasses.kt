package classess

/**
 * 枚举类
 */
fun main(args: Array<String>) {
/*
* 使用枚举常量
    就像在 Java 中一样，Kotlin 中的枚举类也有合成方法允许列出定义的枚举常量以及通过名称获取枚举常量。
    这些方法的签名如下（假设枚举类的名称是 EnumClass）：
    EnumClass.valueOf(value: String): EnumClass
    EnumClass.values(): Array<EnumClass>
    如果指定的名称与类中定义的任何枚举常量均不匹配，
    valueOf() 方法将抛出 IllegalArgumentException 异常。

    每个枚举常量都具有在枚举类声明中获取其名称和位置的属性：
    val name: String
    val ordinal: Int
* */
    println(Color.valueOf("BLUE").rgb)
    println(Color.values().get(1))
    println(Direction.WEST.name)
    println(Direction.WEST.ordinal)
}

//枚举类的最基本的用法是实现类型安全的枚举：
//每个枚举常量都是一个对象。枚举常量用逗号分隔。
enum class Direction {
    NORTH,
    SOUTH,
    WEST,
    EAST
}

//因为每一个枚举都是枚举类的实例，所以他们可以是这样初始化过的
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

//枚举常量也可以声明自己的匿名类及相应的方法、以及覆盖基类的方法。
// 注意，如果枚举类定义任何成员，要使用分号将成员定义中的枚举常量定义分隔开，就像在 Java 中一样。
enum class ProtocolState {
    WAITING {
        override fun signal() = TAKING
    },
    TAKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}


