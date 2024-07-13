package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.Login;
import com.co.choucair.tasks.SeleccionarMenuTasks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.SerenityLoginPage.TXT_VALIDATION;
import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class RetoExitoStepDefinitions {

    //case3
    @Given("ingreso a la pagina exito.com")
    public void queQuieroSeleccionarProductos() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }


//    @When("haga clic en <botonAgregar>")
//    public void hagaClicEnBotonAgregar() {
//  //      OnStage.theActorInTheSpotlight().attemptsTo(
//  //              Login.onTheSite(UserLoombokData.setData(dataTable).get(0));
//
//    }
//control+sift+/
//
//    @Then("se mostrará el producto como agregado")
//    public void seMostraráElProductoComoAgregado() {
//     //   OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION), containsString(text)));
//
//
//    }

    @When("selecciono una categoria y subcategoria")
    public void seleccionoUnaCategoriaYSubcategoria() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarMenuTasks.seleccionarMenu());
   //     System.out.println();
    }

    @And("seleccione productos")
    public void seleccioneProductos() {


    }
}
