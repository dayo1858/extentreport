$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("Google test_2.feature");
formatter.feature({
  "line": 1,
  "name": "Google test2",
  "description": "",
  "id": "google-test2",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search google",
  "description": "",
  "id": "google-test2;search-google",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "am on the google home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter word to be searched",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I click the search button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the search result should be return",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleStepDeftn.am_on_the_google_home_page()"
});
formatter.result({
  "duration": 19492453600,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.i_enter_word_to_be_searched()"
});
formatter.result({
  "duration": 474266400,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.i_click_the_search_button()"
});
formatter.result({
  "duration": 4588426800,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.the_search_result_should_be_return()"
});
formatter.result({
  "duration": 2730427900,
  "status": "passed"
});
formatter.uri("search.feature");
formatter.feature({
  "line": 1,
  "name": "Google test",
  "description": "",
  "id": "google-test",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search google",
  "description": "",
  "id": "google-test;search-google",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "am on the google home page",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I enter word to be searched",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I click the search button",
  "keyword": "And "
});
formatter.step({
  "line": 7,
  "name": "the search result should be return",
  "keyword": "Then "
});
formatter.match({
  "location": "GoogleStepDeftn.am_on_the_google_home_page()"
});
formatter.result({
  "duration": 13800273700,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.i_enter_word_to_be_searched()"
});
formatter.result({
  "duration": 494609900,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.i_click_the_search_button()"
});
formatter.result({
  "duration": 2625857500,
  "status": "passed"
});
formatter.match({
  "location": "GoogleStepDeftn.the_search_result_should_be_return()"
});
formatter.result({
  "duration": 1120915700,
  "status": "passed"
});
});