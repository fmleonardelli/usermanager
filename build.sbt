name := "usermanager"
organization := "com.company"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.12.8"

libraryDependencies += guice
libraryDependencies ++= Dependencies.userManagerDependencies

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.company.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.company.binders._"
