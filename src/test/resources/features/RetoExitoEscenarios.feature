Feature: login test

  Scenario Outline: testing the successful login
    Given the user is on the serenity demo page
    When attempts to log in
      | user   | pass   |
      | <user> | <pass> |
    Then validate the text on screen <message>
    Examples:
      | user  | pass     | message   |
      | admin | serenity | Dashboard |



  @caso2 @ElegirLugar
  Scenario Outline: Elegir lugar pedido
    Given quiero comprar productos
    And no tengo registrado una opcion de recojo pedido
    When ingrese al <menupedido>
    And elija <opcionpedido>
    And ingreso una <ciudad>
    And ingreso un <almacen>
    And haga clic en <botonConfirmar>
    Then se debe mostrar el lugar de recojo actualizado

    Examples:
      | menupedido  | opcionpedido   | ciudad |almacen | botonConfirmar   |
      | menupedido |comprayrecoje  | Barranquilla | exito barranquilla |Confirmar |


  @caso3 @SeleccionarProductos
  Scenario Outline: Seleccionar Productos
    Given que quiero seleccionar productos
    When haga clic en <botonAgregar>
    Then se mostrará el producto como agregado

    Examples:
      | botonAgregar |
      | Agregar |

  @caso4 @CantidadesProducto
  Scenario Outline: Agregar cantidades Productos
    Given que quiero agregar cantidades a un producto seleccionado
    When ingrese al <menucarrito>
    And quiero aumentar la cantidad de <nombreproducto>
    And haga clic en <botonCantidad>
    Then se debe mostrar la cantidad actualizada del producto
    And se mostrará el precio total de los productos seleccionados

    Examples:
      | menucarrito | nombreproducto | botonCantidad |
      | menucarrito | Limon           |         boton2 |