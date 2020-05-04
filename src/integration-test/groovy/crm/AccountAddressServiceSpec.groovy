package crm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AccountAddressServiceSpec extends Specification {

    AccountAddressService accountAddressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new AccountAddress(...).save(flush: true, failOnError: true)
        //new AccountAddress(...).save(flush: true, failOnError: true)
        //AccountAddress accountAddress = new AccountAddress(...).save(flush: true, failOnError: true)
        //new AccountAddress(...).save(flush: true, failOnError: true)
        //new AccountAddress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //accountAddress.id
    }

    void "test get"() {
        setupData()

        expect:
        accountAddressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<AccountAddress> accountAddressList = accountAddressService.list(max: 2, offset: 2)

        then:
        accountAddressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        accountAddressService.count() == 5
    }

    void "test delete"() {
        Long accountAddressId = setupData()

        expect:
        accountAddressService.count() == 5

        when:
        accountAddressService.delete(accountAddressId)
        sessionFactory.currentSession.flush()

        then:
        accountAddressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        AccountAddress accountAddress = new AccountAddress()
        accountAddressService.save(accountAddress)

        then:
        accountAddress.id != null
    }
}
