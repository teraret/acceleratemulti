package usermanagement


import grails.rest.*
import grails.converters.*
import org.springframework.web.client.RestTemplate


class WebsitesearchController {
	static responseFormats = ['json', 'xml']

    def index() {
        RestTemplate restTemplate = new RestTemplate()
        Staff staff = restTemplate.getForObject("http://www.mocky.io/v2/5ebd118731000092005b0fe3",Staff.class)
        render staff

       }
}
