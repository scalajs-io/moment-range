moment-range API for Scala.js
================================
[moment-range](https://www.npmjs.com/package/moment-range) - Fancy date ranges for Moment.js.

### Description

Fancy date ranges for Moment.js.

### Build Dependencies

* [SBT v0.13.13](http://www.scala-sbt.org/download.html)

### Build/publish the SDK locally

```bash
 $ sbt clean publish-local
```

### Running the tests

Before running the tests the first time, you must ensure the npm packages are installed:

```bash
$ npm install
```

Then you can run the tests:

```bash
$ sbt test
```

### Examples

```scala
import io.scalajs.npm.moment._
import io.scalajs.npm.moment.range._
import scala.scalajs.js

val moment = MomentRange.extendMoment(Moment)
val start = new js.Date(2012, 4, 1)
val end = new js.Date(2012, 4, 23)
val lol = new js.Date(2012, 4, 15)
val wat = new js.Date(2012, 4, 27)
val range = moment.range(start, end)
val range2 = moment.range(lol, wat)

range.contains(lol) // true
range.contains(wat) // false
```

### Artifacts and Resolvers

To add the `moment-range` binding to your project, add the following to your build.sbt:  

```sbt
libraryDependencies += "io.scalajs.npm" %%% "moment-range" % "0.4.0-pre3"
```

Optionally, you may add the Sonatype Repository resolver:

```sbt   
resolvers += Resolver.sonatypeRepo("releases") 