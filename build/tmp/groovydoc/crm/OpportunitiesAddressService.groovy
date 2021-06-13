package crm

import grails.gorm.services.Service

@Service(OpportunitiesAddress)
interface OpportunitiesAddressService {

    OpportunitiesAddress get(Serializable id)

    List<OpportunitiesAddress> list(Map args)

    Long count()

    void delete(Serializable id)

    OpportunitiesAddress save(OpportunitiesAddress opportunitiesAddress)

}