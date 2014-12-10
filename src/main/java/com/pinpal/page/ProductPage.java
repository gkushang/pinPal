package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.PinPalService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.*;


public class ProductPage extends HeaderFooter implements Renderable
{

    public PinPalService _pinPalService;

    public ProductPage(PinPalService pinPalService)
    {

        Validate.notNull(pinPalService, "pinPalService cannot be null");

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
                .span(class_("step-name active")).content("Product")
                .span(class_("step-name")).content("Offer")
                .span(class_("step-name")).content("Pin-it")
                ._div()

                .div(class_("main-step"))

                .div(class_("main active"))

                .div(class_("image-container"))
                .img(class_("photo-image").id("blah").src(_pinPalService.getImage()).alt(""))
                ._div()

                .div(class_("product-description"))
                .span(class_("element-title")).content("Description").br()
                .textarea(class_("prd-description").id("description").cols("20").rows("3")).content("").br()

                .div(id("element-man"))
                .span(class_("element-title").id("element-man")).content("Manufacture").br()
                .input(type("text").class_("element-box").id("manufacture-id").value("")).br()
                ._div()

                .div(id("element-item"))
                .span(class_("element-title").id("element-item")).content("Item Name").br()
                .input(type("text").class_("element-box").id("item-id").value("")).br()
                ._div()

                .div(id("element-sku"))
                .span(class_("element-title").id("element-sku")).content("SKU").br()
                .input(type("text").class_("element-box").id("sku-id").value("")).br()
                ._div()

                ._div()

//                .div(class_("product-next"))
//                .a(href("/offer/").id("continue-next-on-prod").class_("product-next-a").style("float:right")).content("Next")
                .a(href("/offer/").id("continue")).content("Next")
                .a(href("/photo/").id("back")).content("Back")
//                .a(href("/photo/").id("continue-back-on-prod").class_("product-next-a").style("float:left")).content("Back")
//                ._div()


                ._div()
                ._div()

                ._body()
                ._html();
    }

    private void tabs(HtmlCanvas html) throws IOException
    {
        html.div(class_("tabs"))
                .ul(class_("tab-links"))
                .li(class_("active")).a(href("#photo")).content("Photo")._li()
                .li().a(href("#offer")).content("Offer")._li()
                .li().a(href("#publish")).content("Publish")._li()
                ._ul()

                .div(class_("tab-content"))
                .div(id("tab1").class_("tab active"))
                .p().content("photo content")
                ._div()

                .div(id("tab2").class_("tab"))
                .p().content("offer content")
                ._div()

                .div(id("tab3").class_("tab"))
                .p().content("publish content")
                ._div()

                ._div()
                ._div();
    }
}
