package crm

import grails.gorm.MultiTenant

class OpportunitiesAddress  implements MultiTenant<OpportunitiesAddress> {

    Opportunities opportunities
    String tenantId
    String addresslineone
    String addresslinetwo
    String country
    String state
    String zip
    OfficeType officeType
    Date dateCreated
    Date lastUpdated



    static constraints = {
    }


}
