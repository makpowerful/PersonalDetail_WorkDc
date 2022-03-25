Feature: Matching products  on two screens

Scenario Outline:  Verify the product on one screen is equal to another

Given User is on Greenkart Homepage and should search the product <Product Main>
And User is on Greenkart top search page and should search the product <Product Table>
When GreenKart Homepage Value is compared with Top deal  search Page
Then They values should match

Examples:
|Product Main|Product Table|
|Tomato      |Tomato       |
|Strawberry  |Strawberry   |