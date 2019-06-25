import sbt._

object Dependencies {

  val scalaTestPlusPlay = "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.2" % Test

  val mongojack = "org.mongojack" % "mongojack" % "2.10.0"

  val jackson = "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.9.8"

  val jacksonDataTypes = "com.fasterxml.jackson.datatype" % "jackson-datatype-jsr310" % "2.9.8"

  val scalaz = "org.scalaz" % "scalaz-core_2.12" % "7.2.17"

  val userManagerDependencies: Seq[ModuleID] = Seq(scalaTestPlusPlay, mongojack, jackson, jacksonDataTypes, scalaz)
}
