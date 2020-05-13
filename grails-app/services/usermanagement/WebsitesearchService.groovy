package usermanagement

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder

@CompileStatic
class WebsitesearchService  {



    BlockingHttpClient client

    Staff currentWeather() {
        try {
            HttpRequest request = HttpRequest.GET(currentWeatherUri())
            return client.retrieve(request, Staff)

        } catch (HttpClientResponseException e) {
            return null
        }
    }

    URI currentWeatherUri() {
        UriBuilder uriBuilder = UriBuilder.of('http://www.mocky.io/v2/5ebbacd43600000097f7e899')
        uriBuilder.build()
    }


}
