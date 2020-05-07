package usermanagement

import com.nexmo.client.NexmoClient
import com.nexmo.client.sms.SmsSubmissionResponse
import com.nexmo.client.sms.SmsSubmissionResponseMessage
import com.nexmo.client.sms.messages.TextMessage
import com.sendgrid.Content
import com.sendgrid.Email
import com.sendgrid.Mail
import com.sendgrid.Method
import com.sendgrid.Request
import com.sendgrid.Response
import com.sendgrid.SendGrid
import grails.validation.ValidationException
import org.apache.commons.lang3.RandomStringUtils

import static org.springframework.http.HttpStatus.CREATED
import static org.springframework.http.HttpStatus.NOT_FOUND
import static org.springframework.http.HttpStatus.NO_CONTENT
import static org.springframework.http.HttpStatus.OK
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@ReadOnly
class RegisterController {

    RegisterService registerService

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond registerService.list(params), model:[registerCount: registerService.count()]
    }

    def show(Long id) {
        respond registerService.get(id)
    }

    @Transactional
    def save(Register register) {
        if (register == null) {
            render status: NOT_FOUND
            return
        }
        if (register.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond register.errors
            return
        }

        try {

            String charset = (('A'..'Z') + ('0'..'9')).join()
            Integer length = 6
            String emailrandomString = RandomStringUtils.random(length, charset.toCharArray())
            String phonerandomString = RandomStringUtils.random(length, charset.toCharArray())

            if(register.source=="website") {

                register.emailotp=emailrandomString
                Email from = new Email("sales@teraret.com")
                String subject = "Sending with SendGrid is Fun"
                Email to = new Email(register.toemail)
                println(register.toemail)
                Content content = new Content("text/plain", "and easy to do anywhere, even with Java"+emailrandomString)
                Mail mail = new Mail(from, subject, to, content)
                SendGrid sg = new SendGrid("")
                Request request = new Request()
                register.phonenumberotp=phonerandomString
                NexmoClient client = NexmoClient.builder().apiKey("").apiSecret("").build()
                TextMessage message = new TextMessage("Acme Inc", register.phonenumber.toString(), "hello Friend your otp is "+phonerandomString+" please enter it", true)
                SmsSubmissionResponse responses = client.getSmsClient().submitMessage(message)
                for (SmsSubmissionResponseMessage responseMessage : responses.getMessages()) {
                    println(message.toString())
                }
                request.setMethod(Method.POST)
                request.setEndpoint("mail/send")
                request.setBody(mail.build())
                Response response = sg.api(request)
                println(response.getStatusCode())
                register.emailotpstatus = response.getStatusCode().toString()
            } else {
                register.emailotp=emailrandomString
                register.phonenumberotp=phonerandomString
            }
            registerService.save(register)
        } catch (ValidationException e) {
            respond register.errors
            return
        }

        respond register, [status: CREATED, view:"show"]
    }

    @Transactional
    def update(Register register) {
        if (register == null) {
            render status: NOT_FOUND
            return
        }
        if (register.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond register.errors
            return
        }

        try {
            registerService.save(register)
        } catch (ValidationException e) {
            respond register.errors
            return
        }

        respond register, [status: OK, view:"show"]
    }

    @Transactional
    def delete(Long id) {
        if (id == null) {
            render status: NOT_FOUND
            return
        }

        registerService.delete(id)

        render status: NO_CONTENT
    }
}
