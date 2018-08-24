package con.aruistar.studyjavalin

import io.javalin.Javalin

data class User(val name: String, val id: Int)

fun main(args: Array<String>) {
    val app = Javalin.create().start(7000)

    val map = hashMapOf<String, Int>()
    map.put("one", 1)
    map.put("two", 2)

    app.get("/") { ctx -> ctx.result("Hello World") }
    app.get("/json") { ctx -> ctx.json(User("Alex", 1)) }
    app.get("/json/map") { ctx -> ctx.json(map) }
    app.after { ctx ->
        println("log")
        println(ctx.resultString())
    }
}