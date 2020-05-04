package crm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class LeadAddressServiceSpec extends Specification {

    LeadAddressService leadAddressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new LeadAddress(...).save(flush: true, failOnError: true)
        //new LeadAddress(...).save(flush: true, failOnError: true)
        //LeadAddress leadAddress = new LeadAddress(...).save(flush: true, failOnError: true)
        //new LeadAddress(...).save(flush: true, failOnError: true)
        //new LeadAddress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //leadAddress.id
    }

    void "test get"() {
        setupData()

        expect:
        leadAddressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<LeadAddress> leadAddressList = leadAddressService.list(max: 2, offset: 2)

        then:
        leadAddressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        leadAddressService.count() == 5
    }

    void "test delete"() {
        Long leadAddressId = setupData()

        expect:
        leadAddressService.count() == 5

        when:
        leadAddressService.delete(leadAddressId)
        sessionFactory.currentSession.flush()

        then:
        leadAddressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        LeadAddress leadAddress = new LeadAddress()
        leadAddressService.save(leadAddress)

        then:
        leadAddress.id != null
    }
}
