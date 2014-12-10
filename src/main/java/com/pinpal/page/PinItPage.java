package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.PinPalService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.*;


public class PinItPage extends HeaderFooter implements Renderable
{

    public PinPalService _projectService;

    public PinItPage(PinPalService projectService)
    {

        Validate.notNull(projectService, "projectService cannot be null");

        _projectService = projectService;

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
                .span(class_("step-name")).content("Offer")
                .span(class_("step-name active")).content("Pin-it")
                ._div()

                .div(class_("main-step"))

                .div(class_("main active"))

                .div(class_("image-container"))
                .img(class_("photo-image").id("blah").src(_projectService.getImage()).alt(""))
                ._div()


                .div(class_("pin-it-btn-div"))
                .a(href("https://www.pinterest.com/pin/create/button/\n" +
                                "        ?url=http%3A%2F%2Fwww.flickr.com%2Fphotos%2Fkentbrew%2F6851755809%2F\n" +
                                "        &media=http%3A%2F%2Ffarm8.staticflickr.com%2F7027%2F6851755809_df5b2051c9_z.jpg\n" +
                                "        &description=Next%20stop%3A%20Pinterest").id("continue-next-on-prod"))
                .img(src("//assets.pinterest.com/images/pidgets/pin_it_button.png").id("pin-it-button"))._a()

                ._div()

                .a(href("/offer/").id("continue-pin").class_("continue-back-pin").style("float:left")).content("Back")


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
