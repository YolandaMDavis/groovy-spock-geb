package com.ymd.demo.geb.page

import geb.Page

/**
 * Created by yolandad on 6/19/14.
 */
class YahooSearchResults extends Page {
    static url  = "http://search.yahoo.com/"
    static at = { title.contains("Yahoo Search Results")}

    static content = {
       searchResults {$("results")}
    }
}
