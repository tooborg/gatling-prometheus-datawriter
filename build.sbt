

ThisBuild / scalaVersion := "2.12.12"
ThisBuild / organization := "com.github.vitalii-barabash"

ThisBuild / organizationName := "gatling-prometheus-datawriter"
ThisBuild / organizationHomepage := Some(url("https://github.com/vitalii-barabash/gatling-prometheus-datawriter"))

ThisBuild / scmInfo := Some(
    ScmInfo(
        url("https://github.com/vitalii-barabash/gatling-prometheus-datawriter"),
        "scm:git@github.com/vitalii-barabash/gatling-prometheus-datawriter.git"
    )
)
ThisBuild / developers := List(
    Developer(
        id    = "vitalii-barabash",
        name  = "Vitalii Barabash",
        email = "vit.barabash@gmail.com",
        url   = url("https://github.com/vitalii-barabash")
    )
)

ThisBuild / description := "Prometheus Plugin for Gatling 3.4.x"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/vitalii-barabash/gatling-prometheus-datawriter"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishMavenStyle := true

val gatling                        = "io.gatling"                           % "gatling-core"                    % "3.4.1"
val simpleClient                   = "io.prometheus"                        % "simpleclient"                    % "0.9.0"
val simpleClientHttpServe          = "io.prometheus"                        % "simpleclient_httpserver"         % "0.9.0"
val java8Compat                    = "org.scala-lang.modules"              %% "scala-java8-compat"              % "0.9.1"
val akka                           = "com.typesafe.akka"                   %% "akka-actor"                      % "2.6.8"

val scalaTest                      = "org.scalatest"                       %% "scalatest"                       % "3.2.2"             % "test"
val scalaTestScalacheck            = "org.scalatestplus"                   %% "scalacheck-1-14"                 % "3.2.2.0"           % "test"
val scalaTestMockito               = scalaTestScalacheck.organization      %% "mockito-3-4"                     % "3.2.2.0"           % "test"
val scalaCheck                     = "org.scalacheck"                      %% "scalacheck"                      % "1.14.3"            % "test"
val akkaTestKit                    = akka.organization                     %% "akka-testkit"                    % akka.revision       % "test"
val mockitoCore                    = "org.mockito"                          % "mockito-core"                    % "3.5.11"            % "test"

val testDeps = Seq(scalaTest, scalaTestScalacheck, scalaTestMockito, scalaCheck, akkaTestKit, mockitoCore)

lazy val prometheusPlugin = (project in file("."))
  .settings(
    name := "gatling34x-prometheus-plugin",
    libraryDependencies += gatling,
    libraryDependencies += simpleClient,
    libraryDependencies += simpleClientHttpServe,
    libraryDependencies += java8Compat,
    libraryDependencies += akka,
    libraryDependencies ++= testDeps
  )

publishTo := sonatypePublishTo.value
