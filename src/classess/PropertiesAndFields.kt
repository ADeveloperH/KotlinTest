package classess

/**
 * 属性和字段
 *
 */

fun main(args: Array<String>) {
    val copyAddress = copyAddress("UA")
    println(copyAddress.email)
    println(copyAddress.nickName)
    println(copyAddress.nickName2)
}

class Address {
    // 属性可以用关键字var 声明为可变的，否则使用只读关键字val。
    val name: String = "huangjian"
    var city: String = "ZH"

    //我们可以编写自定义的访问器，非常像普通函数，刚好在属性声明内部。
    //只读属性不允许 setter
    val email: String get() = this.name + "@163.com"

    // 此初始器值直接写入到幕后字段
    var nickName: String = ""
            //Kotlin 中类不能有字段。然而，当使用自定义访问器时，有时有一个幕后字段（backing field）有时是必要的。
            // 为此 Kotlin 提供一个自动幕后字段，它可通过使用 field 标识符访问。
        get() {
            return field + " \$_$"
        }
            //setter 参数的名称是 value，但是如果你喜欢你可以选择一个不同的名称。
        set(value) {
            field = value + "^_^"
        }

    /**
     * 不想使用幕后字段。
     * 幕后属性
     * 从各方面看，这正是与 Java 相同的方式。因为通过默认 getter 和 setter 访问私有属性会被优化，
     * 所以不会引入函数调用开销。
     */
    private var tempNickName2: String? = null
    public var nickName2: String
        get() {
            return tempNickName2 + " \$_$"
        }
        set(value) {
            tempNickName2 = value + "^_^"
        }
}

fun copyAddress(city: String = "CH"): Address {
    // Kotlin 中没有“new”关键字
    val address = Address()
    address.city = city
    address.nickName = address.name
    address.nickName2 = address.name
    return address
}