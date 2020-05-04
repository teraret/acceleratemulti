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
class OpportunitiesAddressController {

    OpportunitiesAddressService opportunitiesAddressService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond opportunitiesAddressService.list(params), model:[opportunitiesAddressCount: opportunitiesAddressService.count()]
    }

    def show(Long id) {
        respond opportunitiesAddressService.get(id)
    }

    @Transactional
    def save(OpportunitiesAddress opportunitiesAddress) {
        if (opportunitiesAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (opportunitiesAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond opportunitiesAddress.errors
            return
        }

        try {
            opportunitiesAddressService.save(opportunitiesAddress)
        } catch (ValidationException e) {
            respond opportunitiesAddress.errors
            return
        }

        respond opportunitiesAddress, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(OpportunitiesAddress opportunitiesAddress) {
        if (opportunitiesAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (opportunitiesAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond opportunitiesAddress.errors
            return
        }

        try {
            opportunitiesAddressService.save(opportunitiesAddress)
        } catch (ValidationException e) {
            respond opportunitiesAddress.errors
            return
        }

        respond opportunitiesAddress, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        opportunitiesAddressService.delete(id)

        render status: NO_CONTENT
    }
}
