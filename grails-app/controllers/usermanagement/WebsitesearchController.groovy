package usermanagement


import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.web.client.RestTemplate

class WebsitesearchController {
	static responseFormats = ['json', 'xml']

   WebsitesearchService websitesearchService

    BlockingHttpClient client

    RestTemplate restTemplate


	
    def index() {

        URI uri = ("http://www.mocky.io/v2/5ebbacd43600000097f7e899").toURI()

        render restTemplate.getForObject("http://www.mocky.io/v2/5ebbacd43600000097f7e899",String.class)

//        try {
//            HttpRequest request = HttpRequest.GET("http://www.mocky.io/v2/5ebbacd43600000097f7e899")
//            render client.retrieve(request)
//
//        } catch (HttpClientResponseException e) {
//            render  "issue is there"
//        }

       }
}
