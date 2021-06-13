package usermanagement

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class OrganisationController {

    OrganisationService organisationService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond organisationService.list(params), model:[organisationCount: organisationService.count()]
    }

    def show(Long id) {
        respond organisationService.get(id)
    }

    @Transactional
    def save(Organisation organisation) {
        if (organisation == null) {
            render status: NOT_FOUND
            return
        }
        if (organisation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond organisation.errors
            return
        }

        try {
            organisationService.save(organisation)
        } catch (ValidationException e) {
            respond organisation.errors
            return
        }

        respond organisation, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Organisation organisation) {
        if (organisation == null) {
            render status: NOT_FOUND
            return
        }
        if (organisation.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond organisation.errors
            return
        }

        try {
            organisationService.save(organisation)
        } catch (ValidationException e) {
            respond organisation.errors
            return
        }

        respond organisation, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        organisationService.delete(id)

        render status: NO_CONTENT
    }
}
