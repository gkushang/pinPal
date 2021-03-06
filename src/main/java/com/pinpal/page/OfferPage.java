package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.PinPalService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.*;


public class OfferPage extends HeaderFooter implements Renderable
{

    public PinPalService _pinPalService;

    public OfferPage(PinPalService pinPalService)
    {

        Validate.notNull(pinPalService, "projectService cannot be null");

        _pinPalService = pinPalService;

    }


    @Override
    public void renderOn(HtmlCanvas html) throws IOException
    {
        addScriptsAndStyleSheets(html);

        renderHeader(html);

        html.html()
                .body(class_("background-color-cukes"))

                .div(class_("step"))
                .span(class_("step-name")).content("Photo")
                .span(class_("step-name")).content("Product")
                .span(class_("step-name active")).content("Offer")
                .span(class_("step-name")).content("Pin-it")
                ._div()

                .div(class_("main-step"))

                .div(class_("main active"))

                .div(class_("image-container"))
                .img(class_("photo-image").id("blah").src(_pinPalService.getImage()).alt(""))
                ._div()


                .div(id("element-r-price"))
                .span(class_("element-title").id("element-r-price")).content("Retail Price $").br()
                .input(type("text").class_("element-box").id("r-price-id").value(_pinPalService.getRetailPrice())).br()
                ._div()

                .div(id("element-d-perc"))
                .span(class_("element-title").id("element-d-perc")).content("Discount %").br()
                .input(type("text").class_("element-box").id("d-perc-id").value(_pinPalService.getDiscountPercentage())).br()
                ._div()

                .div(id("element-d-price"))
                .span(class_("element-title").id("element-d-price")).content("Discount Price $").br()
                .input(type("text").class_("element-box").id("d-price-id").value(_pinPalService.getDiscountPrice())).br()
                ._div()

                .div(id("element-s-date"))
                .span(class_("element-title").id("element-s-date")).content("Start Date").br()
                .input(type("text").class_("element-box").id("s-date-id").value(_pinPalService.getStartDate())).br()
                ._div()

                .div(id("element-e-date"))
                .span(class_("element-title").id("element-e-date")).content("End Date").br()
                .input(type("text").class_("element-box").id("e-date-id").value(_pinPalService.getEndDate())).br()
                ._div()


                .a(href("/pin-it/").id("continue").style("float:right").class_("continue-offer")).content("Next")
                .a(href("/product/").id("back")).content("Back")


                ._div()
                ._div()

                ._body()
                ._html();
    }

}
