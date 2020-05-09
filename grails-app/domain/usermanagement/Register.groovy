package usermanagement

class Register {

    String source
    String emailotp
    String emailotpstatus
    String toemail
    String phonenumberotp
    String phonenumberotpstatus
    Long phonenumber



    static constraints = {
        emailotp  nullable: true, blank: true
        emailotpstatus  nullable: true, blank: true
        phonenumberotp  nullable: true, blank: true
        phonenumberotpstatus  nullable: true, blank: true
    }
}
