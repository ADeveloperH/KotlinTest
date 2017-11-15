package start.basic_class

class Rectangle(
        val height: Double,
        val length: Double) : Shape(listOf(height, length, height, length)), RectangleProperties {
    override val isSquare: Boolean get() = length == height
    override fun calculateArea(): Double = height * length
}