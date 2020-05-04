package usermanagement

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrganisationServiceSpec extends Specification {

    OrganisationService organisationService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Organisation(...).save(flush: true, failOnError: true)
        //new Organisation(...).save(flush: true, failOnError: true)
        //Organisation organisation = new Organisation(...).save(flush: true, failOnError: true)
        //new Organisation(...).save(flush: true, failOnError: true)
        //new Organisation(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //organisation.id
    }

    void "test get"() {
        setupData()

        expect:
        organisationService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Organisation> organisationList = organisationService.list(max: 2, offset: 2)

        then:
        organisationList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        organisationService.count() == 5
    }

    void "test delete"() {
        Long organisationId = setupData()

        expect:
        organisationService.count() == 5

        when:
        organisationService.delete(organisationId)
        sessionFactory.currentSession.flush()

        then:
        organisationService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Organisation organisation = new Organisation()
        organisationService.save(organisation)

        then:
        organisation.id != null
    }
}
