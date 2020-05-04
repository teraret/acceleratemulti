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
class LeadController {

    LeadService leadService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond leadService.list(params), model:[leadCount: leadService.count()]
    }

    def show(Long id) {
        respond leadService.get(id)
    }

    @Transactional
    def save(Lead lead) {
        if (lead == null) {
            render status: NOT_FOUND
            return
        }
        if (lead.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lead.errors
            return
        }

        try {
            leadService.save(lead)
        } catch (ValidationException e) {
            respond lead.errors
            return
        }

        respond lead, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Lead lead) {
        if (lead == null) {
            render status: NOT_FOUND
            return
        }
        if (lead.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond lead.errors
            return
        }

        try {
            leadService.save(lead)
        } catch (ValidationException e) {
            respond lead.errors
            return
        }

        respond lead, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        leadService.delete(id)

        render status: NO_CONTENT
    }
}
