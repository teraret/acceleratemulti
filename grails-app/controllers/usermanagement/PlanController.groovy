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
class PlanController {

    PlanService planService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond planService.list(params), model:[planCount: planService.count()]
    }

    def show(Long id) {
        respond planService.get(id)
    }

    @Transactional
    def save(Plan plan) {
        if (plan == null) {
            render status: NOT_FOUND
            return
        }
        if (plan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond plan.errors
            return
        }

        try {
            planService.save(plan)
        } catch (ValidationException e) {
            respond plan.errors
            return
        }

        respond plan, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Plan plan) {
        if (plan == null) {
            render status: NOT_FOUND
            return
        }
        if (plan.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond plan.errors
            return
        }

        try {
            planService.save(plan)
        } catch (ValidationException e) {
            respond plan.errors
            return
        }

        respond plan, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        planService.delete(id)

        render status: NO_CONTENT
    }
}
