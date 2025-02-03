lazy val root = project
  .in(file("."))
  .settings(
    name := "k7-calculator",
    version := "0.1.0",

    scalaVersion := "3.3.1",

    libraryDependencies += "com.github.sbt" % "junit-interface" % "0.13.3" % "test"
  )
