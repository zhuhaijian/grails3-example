package org.sample

class HomeController {

    transient springSecurityService

    def index() {
        println ("HomeController index User:"+ springSecurityService.getPrincipal()?.getUsername()+ " "
                +(springSecurityService.isLoggedIn() ? " accessing /home is logged in!" : " accessing /home is not logged in!"))

        // 1. if the user is logged in. Otherwise a "banner" text will be rendered. We don't have a separate template.

        if(springSecurityService.isLoggedIn()) {
            // 2. modify session and model - ignore for now...

//            def current_text = "current text!"
//            session["current_text"] = current_text // session parameter, not needed for now...
//            render view: '/index_login', model:[current_text:current_text]
            render view: '/index'
            return
        }

        render view: '/index'
    }
}
