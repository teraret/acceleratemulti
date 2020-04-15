package crm

import grails.gorm.MultiTenant
import usermanagement.User

class Lead  implements MultiTenant<Lead> {

    String firstName
    String lastName
    Date dob
    String note
    String mobile
    String email
    String country
    String state
    String zip
    Date dateCreated
    Date lastUpdated
    User user
    String website

    static constraints = {
    }

    static  mapping ={
        tenantId name: 'website'
    }
}
