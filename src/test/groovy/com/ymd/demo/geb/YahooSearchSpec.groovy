package com.ymd.demo.geb

import com.ymd.demo.geb.page.YahooHomePage
import com.ymd.demo.geb.page.YahooSearchResults
import geb.spock.GebSpec
import spock.lang.Stepwise
import spock.lang.Unroll

/**
* Report lives here : /Users/yolandad/Development/reports/geb
**/

//annotation will execute one test at a time and stop
//completely if a test fails
@Stepwise
class YahooSearchSpec extends GebSpec {


    def "go to yahoo home page"(){

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

    @Unroll
    def "search Yahoo with #searchText"(String searchText){

        given:" I'm on the login page"
        to YahooHomePage

        when: "I enter valid search criteria and click the search button"

        searchForm.with {
            p = searchText
        }
        searchButton.click()


        then: "Then page will display a list of search terms"
        at YahooSearchResults
        $("div.res")
        //a array or datatable can be defined to attempt
        //several parameters to execute against test
        where:
        searchText << ["cat in the hat","avengers","Game of Thrones"]

    }

}
