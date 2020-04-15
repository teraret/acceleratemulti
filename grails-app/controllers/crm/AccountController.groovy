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
class AccountController {

    AccountService accountService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond accountService.list(params), model:[accountCount: accountService.count()]
    }

    def show(Long id) {
        respond accountService.get(id)
    }

    @Transactional
    def save(Account account) {
        if (account == null) {
            render status: NOT_FOUND
            return
        }
        if (account.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond account.errors
            return
        }

        try {
            accountService.save(account)
        } catch (ValidationException e) {
            respond account.errors
            return
        }

        respond account, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Account account) {
        if (account == null) {
            render status: NOT_FOUND
            return
        }
        if (account.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond account.errors
            return
        }

        try {
            accountService.save(account)
        } catch (ValidationException e) {
            respond account.errors
            return
        }

        respond account, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        accountService.delete(id)

        render status: NO_CONTENT
    }
}
