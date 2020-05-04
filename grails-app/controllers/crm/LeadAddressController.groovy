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
class LeadAddressController {

    LeadAddressService leadAddressService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond leadAddressService.list(params), model:[leadAddressCount: leadAddressService.count()]
    }

    def show(Long id) {
        respond leadAddressService.get(id)
    }

    @Transactional
    def save(LeadAddress leadAddress) {
        if (leadAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (leadAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leadAddress.errors
            return
        }

        try {
            leadAddressService.save(leadAddress)
        } catch (ValidationException e) {
            respond leadAddress.errors
            return
        }

        respond leadAddress, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(LeadAddress leadAddress) {
        if (leadAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (leadAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond leadAddress.errors
            return
        }

        try {
            leadAddressService.save(leadAddress)
        } catch (ValidationException e) {
            respond leadAddress.errors
            return
        }

        respond leadAddress, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        leadAddressService.delete(id)

        render status: NO_CONTENT
    }
}
