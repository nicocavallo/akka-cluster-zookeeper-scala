
val akkaVersion = "2.4.0"

val project = Project(
  id = "akka-cluster-zookeeper-scala",
  base = file("."),
  settings = Defaults.coreDefaultSettings ++ Seq(
    name := """akka-sample-cluster-scala""",
    version := "2.4.0",
    scalaVersion := "2.11.7",
    scalacOptions in Compile ++= Seq("-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation", "-feature", "-unchecked", "-Xlog-reflective-calls", "-Xlint"),
    javacOptions in Compile ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint:unchecked", "-Xlint:deprecation"),
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-remote" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
      "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
      "com.sclasen" %% "akka-zk-cluster-seed" % "0.1.2"),
    javaOptions in run ++= Seq(
      "-Xms128m", "-Xmx1024m", "-Djava.library.path=./target/native"),
    Keys.fork in run := true,  
    mainClass in (Compile, run) := Some("sample.cluster.factorial.FactorialApp"),
    // disable parallel tests
    parallelExecution in Test := false
  )
)

fork in run := true
