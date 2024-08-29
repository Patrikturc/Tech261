Feature: Inventory

  Inventory page should contain 6 items
  Adding an item to the basket should increase the number of items in the basket by 1

  Background:
    Given I am on the inventory page
    And I am logged in

  @HappyPath
    Scenario: Inventory page should contain 6 items
        Then I should see 6 items

  @HappyPath
    Scenario: Adding an item to the basket should increase the number of items in the basket by 1
        When I add an item to the basket
        Then the number of items in the basket should be 1