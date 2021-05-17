

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'usermanagement.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'usermanagement.UserRole'
grails.plugin.springsecurity.authority.className = 'usermanagement.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
	[pattern: '/**',             access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]


grails.plugin.springsecurity.rest.token.storage.jwt.secret='teraretloveteraretloveteraretloveteraretloveteraretloveteraretloveteraretloveteraretloveteraretloveteraretloveteraretlove'


grails {
	mongo {
		host = "localhost"
		port = 27107
		username = ""
		password = ""
		databaseName = "accelerate"
	}
}


//grails {
//  plugin {
//    springsecurity {
//
//      rest {
//
//        oauth {
//
//          frontendCallbackUrl = { String tokenValue -> "http://teraret.com/facebook#token=${tokenValue}" }
//          facebook {
//            client = org.pac4j.oauth.client.FacebookClient
//            key = '571933560122232'
//            secret = '4e1f31de3f7bc22028e78433eb025e5e'
//            scope = 'email,user_location'
//            fields = 'id,name,first_name,middle_name,last_name,username'
//            defaultRoles = ['ROLE_USER', 'ROLE_FACEBOOK']
//          }
//        }
//      }
//    }
//  }
//}
