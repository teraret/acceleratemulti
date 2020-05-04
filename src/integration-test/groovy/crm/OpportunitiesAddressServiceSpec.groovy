package crm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OpportunitiesAddressServiceSpec extends Specification {

    OpportunitiesAddressService opportunitiesAddressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new OpportunitiesAddress(...).save(flush: true, failOnError: true)
        //new OpportunitiesAddress(...).save(flush: true, failOnError: true)
        //OpportunitiesAddress opportunitiesAddress = new OpportunitiesAddress(...).save(flush: true, failOnError: true)
        //new OpportunitiesAddress(...).save(flush: true, failOnError: true)
        //new OpportunitiesAddress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //opportunitiesAddress.id
    }

    void "test get"() {
        setupData()

        expect:
        opportunitiesAddressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<OpportunitiesAddress> opportunitiesAddressList = opportunitiesAddressService.list(max: 2, offset: 2)

        then:
        opportunitiesAddressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        opportunitiesAddressService.count() == 5
    }

    void "test delete"() {
        Long opportunitiesAddressId = setupData()

        expect:
        opportunitiesAddressService.count() == 5

        when:
        opportunitiesAddressService.delete(opportunitiesAddressId)
        sessionFactory.currentSession.flush()

        then:
        opportunitiesAddressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        OpportunitiesAddress opportunitiesAddress = new OpportunitiesAddress()
        opportunitiesAddressService.save(opportunitiesAddress)

        then:
        opportunitiesAddress.id != null
    }
}
