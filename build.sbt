name := "borer-vs-jackson"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies += "com.typesafe.akka" %% "akka-serialization-jackson" % "2.6.1"
val Version = "1.4.0"
val Org = "io.bullet"
libraryDependencies += Org %% "borer-core" % Version
libraryDependencies += Org %% "borer-derivation" % Version
libraryDependencies += Org %% "borer-compat-akka" % Version
