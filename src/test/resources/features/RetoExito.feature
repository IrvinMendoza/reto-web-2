Feature: Reto exito
  @caso1 @ingresar
  Scenario Outline: Ingresar y mostrar productos
    Given ingreso a la pagina exito.com
    When selecciono una categoria y subcategoria
    And seleccione productos


    Examples:
      | pagina  | categoria     | subcategoria   |
      | https://www.exito.com/ | Tecnología | Televisores |


