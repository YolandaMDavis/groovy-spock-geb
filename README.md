groovy-spock-geb
==============

This project serves as a demo for creating groovy based tests using the Spock and Geb frameworks

The project supports Geb testing with Chrome for visible browser tests and and PhantomJS for headless browser testing.
In order to run desktop with Chrome, the chromedriver should be installed in local directory and referred to
in the build.gradle file as seen below(mac/unix based file struction):

systemProperty "webdriver.chrome.driver","/Users/<youruser>/<installdir>/chromedriver"

Be sure NOT to included the .exe extension of the file...it doesn't like that

To run tests you can either execute the tests gradle task or run individually the testChrome or testPhantom tasks.
The test tasks simply depends on the testPhantom task in order to support automated CI environments that may not
have chrome browser installed.  Other browser drivers are available as well (IE,Safari,etc) with some configuration changes
to build.gradle and GebConfig.groovy.  See https://github.com/geb/geb-example-gradle for additional examples.