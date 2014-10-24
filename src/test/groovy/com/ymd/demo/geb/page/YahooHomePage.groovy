package com.ymd.demo.geb.page

import geb.Page

/**
 * Created by yolandad on 6/19/14.
 */
class YahooHomePage extends Page {

    static url = "http://www.yahoo.com"
    static at = { $("#yucs-logo-ani").text() == "Yahoo" }

    static content = {
        //finds search form in page using jQuery id search
        searchForm { $("form[name='sf1']") }
        //search button is defined by the content in the closure
        //button appears after search begins
        searchButton (to: YahooSearchResults){ $("#search-submit") }


    }

}
