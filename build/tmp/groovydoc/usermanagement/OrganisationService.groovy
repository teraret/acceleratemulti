package usermanagement

import grails.gorm.services.Service

@Service(Organisation)
interface OrganisationService {

    Organisation get(Serializable id)

    List<Organisation> list(Map args)

    Long count()

    void delete(Serializable id)

    Organisation save(Organisation organisation)

}