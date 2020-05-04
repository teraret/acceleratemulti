package crm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class ContactAddressServiceSpec extends Specification {

    ContactAddressService contactAddressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new ContactAddress(...).save(flush: true, failOnError: true)
        //new ContactAddress(...).save(flush: true, failOnError: true)
        //ContactAddress contactAddress = new ContactAddress(...).save(flush: true, failOnError: true)
        //new ContactAddress(...).save(flush: true, failOnError: true)
        //new ContactAddress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //contactAddress.id
    }

    void "test get"() {
        setupData()

        expect:
        contactAddressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<ContactAddress> contactAddressList = contactAddressService.list(max: 2, offset: 2)

        then:
        contactAddressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        contactAddressService.count() == 5
    }

    void "test delete"() {
        Long contactAddressId = setupData()

        expect:
        contactAddressService.count() == 5

        when:
        contactAddressService.delete(contactAddressId)
        sessionFactory.currentSession.flush()

        then:
        contactAddressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        ContactAddress contactAddress = new ContactAddress()
        contactAddressService.save(contactAddress)

        then:
        contactAddress.id != null
    }
}
