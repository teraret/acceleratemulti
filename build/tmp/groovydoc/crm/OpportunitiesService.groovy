package crm

import grails.gorm.services.Service

@Service(Opportunities)
interface OpportunitiesService {

    Opportunities get(Serializable id)

    List<Opportunities> list(Map args)

    Long count()

    void delete(Serializable id)

    Opportunities save(Opportunities opportunities)

}