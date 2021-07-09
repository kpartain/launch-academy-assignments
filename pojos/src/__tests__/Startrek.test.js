const StarTrek = require("../StarTrek")

describe("StarTrek", () => {
  let series
  let ship
  let captain
  let starTrek

  beforeEach(() => {
    series = "Voyager"
    ship = "Voyager"
    captain = "Kathryn Janeway"
    starTrek = new StarTrek(series, ship, captain)
  })

  it("has a series name", () => {
    expect(starTrek.series).toEqual(series)
  })

  it("has a ship name", () => {
    expect(starTrek.ship).toEqual(ship)
  })

  it("has an captain", () => {
    expect(starTrek.captain).toEqual(captain)
  })

  it("knows what it is talking about", () => {
    expect(starTrek.theBest()).toBe("Deep Space Nine is the best series, Voyager is the best Ship, Jean Luc Picard is the best Captain!")
  })
})