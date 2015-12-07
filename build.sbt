name := """Ordering"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  jdbc,
  cache,
<<<<<<< HEAD
  ws,"com.typesafe.play" %% "anorm" % "2.4.0",
=======
  ws,
  "com.typesafe.play" %% "anorm" % "2.4.0",
>>>>>>> bcb4597929a5cf41ee01fb4e02b94c96358291b1
  specs2 % Test
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
