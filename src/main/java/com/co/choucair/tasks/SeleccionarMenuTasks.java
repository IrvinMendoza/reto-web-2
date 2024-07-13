package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.ExitoPage;
import com.co.choucair.userinterfaces.SerenityLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SeleccionarMenuTasks implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ExitoPage.BTN_PROPAGANDA),
                Click.on(ExitoPage.BTN_MENU),
                Click.on(ExitoPage.BTN_TECNOLOGIA),
                Click.on(ExitoPage.BTN_SAMSUMG)
        );
    }
    public static SeleccionarMenuTasks seleccionarMenu(){
        return Instrumented.instanceOf(SeleccionarMenuTasks.class).newInstance();
    }
}
