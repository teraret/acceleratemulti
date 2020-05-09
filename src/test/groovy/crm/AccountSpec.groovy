package crm

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification


class AccountSpec extends Specification implements DomainUnitTest<Account> {

    @Override
    Closure doWithConfig() {
        { config ->
            config.grails.gorm.multiTenancy.mode = null
        }
    }

    def setup() {

    }

    def cleanup() {

    }

    void 'mobile number cannot be null'() {
        when:
        domain.mobile = null
        then:
        !domain.validate(['mobile'])
        domain.errors['mobile'].code == 'nullable'
    }
}
