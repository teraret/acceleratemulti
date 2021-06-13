package usermanagement

import grails.validation.ValidationException
import org.grails.datastore.mapping.query.api.Criteria
import org.springframework.web.bind.annotation.RequestBody

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class UserController {

    static namespace = 'v1'

    UserService userService
    UserServiceImplService userServiceImplService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST",filter:"POST", patch:"PATCH",update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond userServiceImplService.list(params), model:[userCount: userServiceImplService.count()]
    }

    def show(Long id) {
        respond userService.get(id)
    }


//    def filter(UserFilter userFilter){
//
//       // def user = userService.createCriteria()
//
//        Criteria c = User.createCriteria()
//
//        def result = c.list{
//
//           // eq("mobile","8667710055")
//
//            userFilter.filterValues.each {  value ->
//
//                if(value.operation=="equal"){
//                    eq(value.key,value.value)
//                } else if (value.operation=="contains"){
//                    like(value.key,"%"+value.value+"%")
//                } else {
//                    ne(value.key,value.value)
//
//                }
//
//
//            }
//
//        }
//
//        respond result
//    }





    @Transactional
    def save(User user) {
        if (user == null) {
            render status: NOT_FOUND
            return
        }
        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors
            return
        }

        respond user, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(User user) {
        if (user == null) {
            render status: NOT_FOUND
            return
        }
        if (user.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond user.errors
            return
        }

        try {
            userService.save(user)
        } catch (ValidationException e) {
            respond user.errors
            return
        }

        respond user, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        userService.delete(id)

        render status: NO_CONTENT
    }
}
