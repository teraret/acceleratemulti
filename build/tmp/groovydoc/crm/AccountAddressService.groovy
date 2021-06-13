package crm

import grails.gorm.services.Service

@Service(AccountAddress)
interface AccountAddressService {

    AccountAddress get(Serializable id)

    List<AccountAddress> list(Map args)

    Long count()

    void delete(Serializable id)

    AccountAddress save(AccountAddress accountAddress)

}