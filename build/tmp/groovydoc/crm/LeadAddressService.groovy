package crm

import grails.gorm.services.Service

@Service(LeadAddress)
interface LeadAddressService {

    LeadAddress get(Serializable id)

    List<LeadAddress> list(Map args)

    Long count()

    void delete(Serializable id)

    LeadAddress save(LeadAddress leadAddress)

}