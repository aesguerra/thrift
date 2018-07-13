lazy val scalaTest = "org.scalatest" %% "scalatest" % "3.0.3"

lazy val versions = new {
  val sparkVersion = "2.2.0"
  val rabbitmq = "5.2.0"
  val typesafe = "1.3.1"
  val spray = "1.3.3"
  val mongodb = "2.2.1"
  val jodaTime = "2.9.3"
  val jodaConvert = "2.1"
  val log4j = "1.2.17"
}

lazy val root = (project in file("."))
  .configs(Test)
  .settings(
    inThisBuild(List(
      organization := "org.minyodev",
      scalaVersion := "2.11.8",
      version := "1.0.0"
    )),
    name := "thrift-pg",
    libraryDependencies += scalaTest % Test
  )

parallelExecution in Test := false

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % versions.sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % versions.sparkVersion % "provided",
  "org.apache.spark" %% "spark-hive" % versions.sparkVersion % "provided",
  "org.mongodb.scala" %% "mongo-scala-driver" % versions.mongodb,
  "com.typesafe" % "config" % versions.typesafe,
  "com.rabbitmq" % "amqp-client" % versions.rabbitmq,
  "org.influxdb" % "influxdb-java" % "2.9",
  "joda-time" % "joda-time" % versions.jodaTime,
  "org.joda" % "joda-convert" % versions.jodaConvert,
  "log4j" % "log4j" % versions.log4j,
  "log4j" % "apache-log4j-extras" % versions.log4j,
  "org.apache.thrift" % "libthrift" % "0.11.0"
)

parallelExecution := false

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
