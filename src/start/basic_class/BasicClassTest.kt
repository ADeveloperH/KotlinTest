package start.basic_class

fun main(args: Array<String>) {
    //创建对象不需要new
    val rectangle = Rectangle(5.0, 2.0)
    val triangle = Triangle(3.0, 4.0, 5.0)
    println("Area of rectangle is ${rectangle.calculateArea()},its perimeter is ${rectangle.perimeter}")
    println("Area of trangle is ${triangle.calculateArea()},its perimeter is ${triangle.perimeter}")

}