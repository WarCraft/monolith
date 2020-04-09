lazy val commonSettings = Seq(
  organization := "gg.warcraft",
  version := "15.0.0-SNAPSHOT",
  scalaVersion := "2.13.1",
  scalacOptions ++= Seq(
    "-language:implicitConversions"
  ),
  resolvers ++= Seq(
    Resolver.mavenLocal
  )
)

lazy val assemblySettings = Seq(
  assemblyJarName in assembly := s"${name.value}-${version.value}-all.jar",
  assemblyMergeStrategy in assembly := {
    case PathList("META-INF", _ @_*) => MergeStrategy.discard
    case "module-info.class"         => MergeStrategy.discard
    case it                          => (assemblyMergeStrategy in assembly).value(it)
  }
)

lazy val commonDependencies = Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % Test
)

lazy val api = (project in file("monolith-api"))
  .settings(
    name := "monolith-api",
    commonSettings,
    libraryDependencies ++= commonDependencies ++ Seq(
      "org.flywaydb" % "flyway-core" % "6.0.8",
      "org.joml" % "joml" % "1.9.19",
      "org.xerial" % "sqlite-jdbc" % "3.28.0",
      "io.circe" %% "circe-core" % "0.12.3",
      "io.circe" %% "circe-generic" % "0.12.3",
      "io.circe" %% "circe-parser" % "0.12.3",
      "io.circe" %% "circe-yaml" % "0.12.0",
      "io.getquill" %% "quill-jdbc" % "3.4.10",

      "com.fasterxml.jackson.core" % "jackson-databind" % "2.10.0"
    )
  )

lazy val java = (project in file("monolith-java"))
  .settings(
    name := "monolith-java",
    commonSettings,
    assemblySettings
  )
  .dependsOn(api)

lazy val spigot = (project in file("monolith-spigot"))
  .settings(
    name := "monolith-spigot",
    commonSettings,
    assemblySettings,
    resolvers ++= Seq(
      "PaperMC" at "https://papermc.io/repo/repository/maven-public/"
    ),
    libraryDependencies ++= commonDependencies ++ Seq(
      "com.destroystokyo.paper" % "paper-api" % "1.15.2-R0.1-SNAPSHOT" % Provided
    )
  )
  .dependsOn(api)

lazy val bootstrap = (project in file("monolith-bootstrap"))
  .settings(
    name := "monolith-bootstrap",
    commonSettings,
    resolvers ++= Seq(
      "PaperMC" at "https://papermc.io/repo/repository/maven-public/"
    ),
    libraryDependencies ++= commonDependencies ++ Seq(
      "com.destroystokyo.paper" % "paper-api" % "1.15.2-R0.1-SNAPSHOT" % Provided,
      "io.circe" %% "circe-core" % "0.12.3",
      "io.circe" %% "circe-generic" % "0.12.3",
      "io.circe" %% "circe-parser" % "0.12.3",
      "io.circe" %% "circe-yaml" % "0.12.0"
    )
  )
