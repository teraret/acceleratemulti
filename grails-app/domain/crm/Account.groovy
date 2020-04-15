package crm

import grails.gorm.MultiTenant
import usermanagement.User

class Account  implements MultiTenant<Account> {
    String name
    String city
    String state
    String country
    String mobile
    Date dateCreated
    Date lastUpdated
    User user
    String website


    static constraints = {
        name unique: 'website'

    }

    static  mapping ={
        tenantId name: 'website'
    }
}
