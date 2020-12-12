Feature: Show menu

  As a potential customer
  I want to be able to see all available meals
  So that I can order the meals I want to eat

# Personas
# Jan - Potential customer

  Rule: All available meals are shown

    Scenario: Potential customer requests to view all meals
      Given there are meals available
      When “Jan” requests all available meals
      Then “Jan” should be able to see the list of all available meals

    Scenario: Potential customer requests to view all meals but no meals were found
      Given there are no available meals anymore
      When “Jan” requests all available meals
      Then “Jan” should be able to get a message that there are no more meals available


  Rule: Price is always shown

    Scenario: Potential customer sees the meals with correct prices
      Given there are meals available
      When “Jan” requests all available meals
      Then the correct prices for each product is shown

  Rule: Allergies and vegan must always be shown
    Scenario: Potential customer requests to see all meals with correct allergies and vegan products
      Given there are meals available
      When “Jan” requests all available meals
      Then the correct allergies and vegan products are shown

  Rule: Meals are grouped by category
    Scenario: Potential customer requests to see all meals that are grouped
      Given there are a lot of meals available
      When “Jan” requests all available meals
      Then the meals are grouped by category