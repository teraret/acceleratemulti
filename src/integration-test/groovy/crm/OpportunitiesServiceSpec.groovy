package crm

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OpportunitiesServiceSpec extends Specification {

    OpportunitiesService opportunitiesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Opportunities(...).save(flush: true, failOnError: true)
        //new Opportunities(...).save(flush: true, failOnError: true)
        //Opportunities opportunities = new Opportunities(...).save(flush: true, failOnError: true)
        //new Opportunities(...).save(flush: true, failOnError: true)
        //new Opportunities(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //opportunities.id
    }

    void "test get"() {
        setupData()

        expect:
        opportunitiesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Opportunities> opportunitiesList = opportunitiesService.list(max: 2, offset: 2)

        then:
        opportunitiesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        opportunitiesService.count() == 5
    }

    void "test delete"() {
        Long opportunitiesId = setupData()

        expect:
        opportunitiesService.count() == 5

        when:
        opportunitiesService.delete(opportunitiesId)
        sessionFactory.currentSession.flush()

        then:
        opportunitiesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Opportunities opportunities = new Opportunities()
        opportunitiesService.save(opportunities)

        then:
        opportunities.id != null
    }
}
