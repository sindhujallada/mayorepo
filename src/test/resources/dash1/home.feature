Feature: dashboard
Scenario: Testdashboard
Given open browser
When launch site "https://www.mayoclinic.org"
Then click symptom checker
Then select one symptom
Then select checkboxes
Then click findcause