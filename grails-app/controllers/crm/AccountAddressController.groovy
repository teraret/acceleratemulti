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
class AccountAddressController {

    AccountAddressService accountAddressService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond accountAddressService.list(params), model:[accountAddressCount: accountAddressService.count()]
    }

    def show(Long id) {
        respond accountAddressService.get(id)
    }

    @Transactional
    def save(AccountAddress accountAddress) {
        if (accountAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (accountAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accountAddress.errors
            return
        }

        try {
            accountAddressService.save(accountAddress)
        } catch (ValidationException e) {
            respond accountAddress.errors
            return
        }

        respond accountAddress, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(AccountAddress accountAddress) {
        if (accountAddress == null) {
            render status: NOT_FOUND
            return
        }
        if (accountAddress.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond accountAddress.errors
            return
        }

        try {
            accountAddressService.save(accountAddress)
        } catch (ValidationException e) {
            respond accountAddress.errors
            return
        }

        respond accountAddress, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        accountAddressService.delete(id)

        render status: NO_CONTENT
    }
}
