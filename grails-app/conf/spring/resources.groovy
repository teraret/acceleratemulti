import usermanagement.CustomAppRestAuthTokenJsonRenderer
import usermanagement.CustomTenentResolver
import usermanagement.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    accessTokenJsonRenderer(CustomAppRestAuthTokenJsonRenderer)
    customTenentResolver(CustomTenentResolver)
    //rest(grails.plugins.rest.client.RestBuilder)
}
