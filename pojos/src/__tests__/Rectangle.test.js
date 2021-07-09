const Rectangle = require("../Rectangle")

describe("A Rectangle", () => {
  let rectangle
  let length
  let width

  beforeEach(() => {
    length = 3
    width = 4
    rectangle = new Rectangle(length, width)
  })

  it("has a length", () => {
    expect(rectangle.length).toEqual(length)
  })

  it("has a width", () => {
    expect(rectangle.width).toEqual(width)
  })

  it("has an area", () => {
    expect(rectangle.area()).toEqual(12)
  })

  it("has an perimeter", () => {
    expect(rectangle.perimeter()).toEqual(14)
  })
})