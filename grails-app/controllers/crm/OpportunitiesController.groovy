package crm

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class OpportunitiesController {

    OpportunitiesService opportunitiesService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond opportunitiesService.list(params), model:[opportunitiesCount: opportunitiesService.count()]
    }

    def show(Long id) {
        respond opportunitiesService.get(id)
    }

    @Transactional
    def save(Opportunities opportunities) {
        if (opportunities == null) {
            render status: NOT_FOUND
            return
        }
        if (opportunities.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond opportunities.errors
            return
        }

        try {
            opportunitiesService.save(opportunities)
        } catch (ValidationException e) {
            respond opportunities.errors
            return
        }

        respond opportunities, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Opportunities opportunities) {
        if (opportunities == null) {
            render status: NOT_FOUND
            return
        }
        if (opportunities.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond opportunities.errors
            return
        }

        try {
            opportunitiesService.save(opportunities)
        } catch (ValidationException e) {
            respond opportunities.errors
            return
        }

        respond opportunities, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        opportunitiesService.delete(id)

        render status: NO_CONTENT
    }
}
