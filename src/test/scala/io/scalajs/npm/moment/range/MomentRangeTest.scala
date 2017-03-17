package io.scalajs.npm.moment
package range

import io.scalajs.JSON
import io.scalajs.nodejs.Assert
import org.scalatest.FunSpec

import scala.scalajs.js

/**
  * Moment Range Functional Specification
  * @author lawrence.daniels@gmail.com
  */
class MomentRangeTest extends FunSpec {

  describe("MomentRange") {

    it("can construct ranges via dates") {
      val moment = MomentRange.extendMoment(Moment)
      val start = new js.Date(2012, 0, 15)
      val end = new js.Date(2012, 4, 23)
      val range = moment.range(start, end)
      info(s"range = ${JSON.stringify(range)}")
    }

    it("can construct ranges via moment") {
      val moment = MomentRange.extendMoment(Moment)
      val start = Moment("2011-04-15", "YYYY-MM-DD")
      val end = Moment("2011-11-27", "YYYY-MM-DD")
      val range = moment.range(start, end)
      info(s"range = ${JSON.stringify(range)}")
    }

    it("can construct ranges via moment array") {
      val moment = MomentRange.extendMoment(Moment)
      val dates = js.Array(Moment("2011-04-15", "YYYY-MM-DD"), Moment("2011-11-27", "YYYY-MM-DD"))
      val range = moment.range(dates)
      info(s"range = ${JSON.stringify(range)}")
    }

    it("can construct ranges via time intervals") {
      val moment = MomentRange.extendMoment(Moment)
      val timeInterval = "2015-01-17T09:50:04+00:00/2015-04-17T08:29:55+00:00"
      val range = moment.range(timeInterval)
      info(s"range = ${JSON.stringify(range)}")
    }

    it("can determine adjacent dates") {
      val moment = MomentRange.extendMoment(Moment)
      val a = moment("2016-03-15")
      val b = moment("2016-03-29")
      val c = moment("2016-03-10")
      val d = moment("2016-03-15")

      val range1 = moment.range(a, b)
      val range2 = moment.range(c, d)

      Assert.ok(range1.adjacent(range2))
    }

    it("Calculates the center of a range:") {
      val moment = MomentRange.extendMoment(Moment)
      val start = new js.Date(2011, 2, 5)
      val end = new js.Date(2011, 3, 5)
      val dr = moment.range(start, end)

      info(s"center = ${JSON.stringify(dr.center())}")
      Assert.ok(dr.center().isSame(moment("2011-03-20T12:30:00.000")))
    }

    it("Check to see if your range contains a date/moment:") {
      val moment = MomentRange.extendMoment(Moment)
      val start = new js.Date(2012, 4, 1)
      val end = new js.Date(2012, 4, 23)
      val lol = new js.Date(2012, 4, 15)
      val wat = new js.Date(2012, 4, 27)
      val range = moment.range(start, end)
      val range2 = moment.range(lol, wat)

      Assert.ok(range.contains(lol)) // true
      Assert.ok(!range.contains(wat)) // false
    }

    it("Find out if your moment falls within a date range:") {
      val moment = MomentRange.extendMoment(Moment)
      val start = new js.Date(2012, 4, 1)
      val end = new js.Date(2012, 4, 23)
      val when = moment("2012-05-10", "YYYY-MM-DD")
      val range = moment.range(start, end)

      Assert.ok(when.within(range)) // true 
    }

  }

}
