package crm

import grails.gorm.services.Service

@Service(Lead)
interface LeadService {

    Lead get(Serializable id)

    List<Lead> list(Map args)

    Long count()

    void delete(Serializable id)

    Lead save(Lead lead)

}