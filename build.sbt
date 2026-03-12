// project metadata
ThisBuild / version      := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "3.6.3"
ThisBuild / organization := "blueDoraemon"

lazy val root = (project in file("."))
  .settings(
    name := "Scala-TCP-Echo-Server",

    libraryDependencies ++= Seq(
      "org.scalatest" %% "scalatest" % "3.2.19" % Test
    ),

    // prevents sbt from eating Ctrl+C, socket releases cleanly
    fork := true,

    Compile / mainClass := Some("server.Main")
  )
