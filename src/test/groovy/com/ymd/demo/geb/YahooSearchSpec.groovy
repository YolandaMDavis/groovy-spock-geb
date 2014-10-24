package com.ymd.demo.geb

import com.ymd.demo.geb.page.YahooHomePage
import com.ymd.demo.geb.page.YahooSearchResults
import geb.spock.GebSpec
import spock.lang.Stepwise
/**
* Report lives here : /Users/yolandad/Development/reports/geb
**/

//annotation will execute one test at a time and stop
//completely if a test fails
@Stepwise
class YahooSearchSpec extends GebSpec {


    def "go to google search page"(){

        when: "I provide the url"
        browser.go("http://www.yahoo.com")

        then: "Will get to the search screen"
        $("#yucs-logo-ani")
    }

    def "enter a search and submit"() {

        given:" I'm on the login page"
        to YahooHomePage

        when: "I enter valid search criteria and click the search button"

        searchForm.with {
            p = "cat in the hat"
        }
        searchButton.click()


        then: "Then page will display a list of search terms"
        at YahooSearchResults
        $("div.res")
    }

/*
    //unroll allow reporting by each individual execution of parameters
    @Unroll
    def "failed to login to app with #user and #pass"(String user, String pass){

        given: "I'm on the login page"
        to GoogleSearch

        when: "I provide invalid user credentials"
        loginForm.with {
            username = user
            password = pass
        }
        loginButton.click(GoogleSearch)

        then: "I will see the login screen with a failed message"
        at GoogleSearch
        errorHeading.contains("Failed to login")

        //a datatable can be defined to attempt
        //several parameters to execute against test
        where:
        user | pass
        "yolandad@ymd.com"|"whatever"
        "admin@ymd.com"|"whatever"

    }
    */

}
