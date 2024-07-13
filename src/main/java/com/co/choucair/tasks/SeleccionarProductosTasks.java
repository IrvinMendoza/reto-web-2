package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.ExitoPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SeleccionarProductosTasks implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        for (int i = 0; i < cantidad; i++) {
            actor.attemptsTo(
                    Click.on(ExitoPage.BTN_MENU),
                    Click.on(ExitoPage.BTN_TECNOLOGIA),
                    Click.on(ExitoPage.BTN_SAMSUMG)
            );
        }

    }
    private int cantidad;
    public static SeleccionarProductosTasks seleccionarProducto(){
        return Instrumented.instanceOf(SeleccionarProductosTasks.class).newInstance();
    }
}
