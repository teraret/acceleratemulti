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
class ContactAddressController {

    ContactAddressService contactAddressService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond contactAddressService.list(params), model:[contactAddressCount: contactAddressService.count()]
    }

    def show(Long id) {
        respond contactAddressService.get(id)
    }

    @Transactional
    def save(ContactAddress contactAddress) {
        if (contactAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (contactAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contactAddress.errors
            return
        }

        try {
            contactAddressService.save(contactAddress)
        } catch (ValidationException e) {
            respond contactAddress.errors
            return
        }

        respond contactAddress, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(ContactAddress contactAddress) {
        if (contactAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (contactAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond contactAddress.errors
            return
        }

        try {
            contactAddressService.save(contactAddress)
        } catch (ValidationException e) {
            respond contactAddress.errors
            return
        }

        respond contactAddress, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        contactAddressService.delete(id)

        render status: NO_CONTENT
    }
}
