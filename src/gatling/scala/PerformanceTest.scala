package parcelp;

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class PerformanceTest extends Simulation {

	val httpProtocol = http
		.baseURL("http://192.168.56.10:1200/parcel-service/")
		.inferHtmlResources()
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.5")
		.userAgentHeader("Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0")

	val headers_0 = Map("Upgrade-Insecure-Requests" -> "1")

	val headers_1 = Map(
		"Access-Control-Request-Headers" -> "content-type",
		"Access-Control-Request-Method" -> "POST",
		"Origin" -> "http://www.allgaeu-parcel-service.de:1200")

	val headers_2 = Map(
		"Accept" -> "application/json, text/plain, */*",
		"Content-Type" -> "application/json;charset=utf-8",
		"Origin" -> "http://www.allgaeu-parcel-service.de:1200/parcel-service")

    	val baseUri = "www.allgaeu-parcel-service.de:1200"

	val scn = scenario("PerformanceTest")
		.exec(http("request_0")
			.get("/parcel-service/")
			.headers(headers_0))
		.pause(8)
		.exec(http("size-request")
			.options("http://" + baseUri + "/rest/size")
			.headers(headers_1)
			.resources(http("request_2")
			.post("http://" + baseUri + "/rest/size")
			.headers(headers_2)
			.body(RawFileBody("parcelsize_request.txt"))))

	setUp(scn.inject(atOnceUsers(100)))
		.assertions(
            details("size-request").successfulRequests.percent.gt(95),
            details("size-request").responseTime.max.lt(10000)
        )
		.protocols(httpProtocol)
}
