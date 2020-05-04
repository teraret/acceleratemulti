package resellerclub

import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileStatic
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient

import java.time.temporal.IsoFields

@CompileStatic
class WebsiteService  implements GrailsConfigurationAware {

    @Override
    void setConfiguration(Config co) {

    }
}
