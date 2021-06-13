package crm

import grails.gorm.services.Service

@Service(ContactAddress)
interface ContactAddressService {

    ContactAddress get(Serializable id)

    List<ContactAddress> list(Map args)

    Long count()

    void delete(Serializable id)

    ContactAddress save(ContactAddress contactAddress)

}