import org.fusesource.scalate.{TemplateEngine, TemplateSource}

import scala.io.Source

object Main extends App {
  val engine = new TemplateEngine()

  val source = Source.fromResource("test.mustache")

  val tsource = TemplateSource.fromSource("test.mustache", source)

  val ctx = Map(
    "name" -> "Chris",
    "value" -> 10000,
    "taxed_value" -> (10000 - (10000 * 0.4)),
    "in_ca" -> true
  )

  val output = engine.layout(tsource, ctx)
  println(output)
}