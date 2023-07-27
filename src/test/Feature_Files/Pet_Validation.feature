Feature:To Validate petstore API testing

  Background:
    * def java_file = Java.type('support.Reusable')
    * def result = java_file.read_Properties_File('createpet_API')

  Scenario Outline: User to validate POST call for pet creation
    * def txt_pet_id = java_file.read_Excel('<TestCase_Name>','pet_id')
    * def txt_pet_name = java_file.read_Excel('<TestCase_Name>','pet_name')
    * def pet_body = java_file.creatPait_Req_Body(txt_pet_id, txt_pet_name)
    Given url result
    And header Content-type = 'application/json; charset=utf-8'
    When request pet_body
    When method POST
    Then status 200
    Then match responseType == 'json'
    And print response
    And assert response.id == txt_pet_id
    And assert response.name == txt_pet_name
    And assert response.status == 'available'

    * def petID_ = java_file.floattoint(txt_pet_id)
    Given url 'https://petstore.swagger.io/v2/pet/'+petID_
    When method GET
    Then status 200
    Then match responseType == 'json'
    And print response
    And print txt_pet_id
    And assert response.id == txt_pet_id
    And assert response.name == txt_pet_name
    And assert response.status == 'available'


    Given url 'https://petstore.swagger.io/v2/pet/'+petID_
    When method DELETE
    Then status 200
    Then match responseType == 'json'
    And print response
    And assert response.code == 200
    And assert response.message == petID_


    Examples:
      |TestCase_Name|
      |TC_001       |
      |TC_002       |
      |TC_003       |
      |TC_004       |
      |TC_005       |
      |TC_006       |
      |TC_007       |
      |TC_008       |
      |TC_009       |
      |TC_010       |
      |TC_011       |
      |TC_012       |
      |TC_013       |
      |TC_014       |
      |TC_015       |
      |TC_016       |
      |TC_017       |
      |TC_018       |
      |TC_019       |
      |TC_020       |
      |TC_021       |
      |TC_022       |
      |TC_023       |
      |TC_024       |
      |TC_025       |
      |TC_026       |
      |TC_027       |
      |TC_028       |
      |TC_029       |
      |TC_030       |



