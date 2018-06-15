#Features
Feature: Brush Teeth
  In order to do stay pain free
  As a human
  I want brush my teeth

  Scenario: Successful Brushing
   Given there is toothpaste on the brush
     And the mouth is open
   When the back teeth are brushed
     And the front teeth are brushed
   Then the teeth look clean
     And the mouth feels fresh
     But the braces aren’t damaged
    