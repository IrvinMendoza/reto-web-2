package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class ExitoPage {
    public static final Target BTN_MENU = Target.the("btn_menu")
            .located(By.cssSelector("button[aria-label=\"Menu hamburguesa\"],button[aria-label=\"Collapse menu\"]"));

    public static final Target BTN_TECNOLOGIA = Target.the("btn_tecnologia")
            .located(By.xpath("//aside//p[contains(text(),\"Tecnología\")]"));

    public static final Target BTN_SAMSUMG = Target.the("btn_samsumg")
            .located(By.cssSelector("a[href='/tecnologia/televisores/televisores-samsung']"));

    public static final Target BTN_PROPAGANDA = Target.the("btn_propaganda")
            .located(By.id("wps-overlay-close-button"));


}
