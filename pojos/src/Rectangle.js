class Rectangle {
  constructor(length, width) {
    this.length = length
    this.width = width
  }

  area() {
    let total = this.length * this.width
    return total
  }

  perimeter() {
    let total = this.length * 2 + this.width * 2
    return total
  }
}

module.exports = Rectangle