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
//                .a(href("//www.pinterest.com/pin/create/button/?url=http%3A%2F%2Fwww.flickr.com%2Fphotos%2Fkentbrew%2F6851755809%2F&media=file%3A%2F%2F%2FUsers%2Fmaduraisamy%2FPaypal%2FpinPal%2Fsrc%2Fmain%2Fwebapp%2Fimages%2Fflip_speakers_with_travel_case_.png&description=Next%20stop%3A%20Pinterest\" data-pin-do=\"buttonPin\" data-pin-config=\"above\" data-pin-color=\"red\" data-pin-height=\"28\"").id("continue-next-on-prod"))
//                .img(src("//assets.pinterest.com/images/pidgets/pinit_fg_en_rect_red_28.png").id("pin-it-button"))._a()

                .a(href("//www.pinterest.com/pin/create/button/?url=href%3D%26quot%3Bhttp%3A%2F%2Ftinypic.com%3Fref%3D2vs1bmq%26quot%3B%20target%3D%26quot%3B_blank%26quot%3B%26gt%3B%26lt%3Bimg%20src%3D%26quot%3Bhttp%3A%2F%2Fi60.tinypic.com%2F2vs1bmq.png%26quot%3B%20border%3D%26quot%3B0%26quot%3B%20alt%3D%26quot%3BImage%20and%20video%20hosting%20by%20TinyPic%26quot%3B&media=http%3A%2F%2Fi60.tinypic.com%2F2vs1bmq.png&description=" + _projectService
                        .getDescription()))
                .img(src("//assets.pinterest.com/images/pidgets/pinit_fg_en_rect_red_28.png"))._a()


                ._div()

//                .a(href("/offer/").id("continue-pin").class_("continue-back-pin").style("float:left")).content("Back")
                .a(href("/offer/").id("back")).content("Back")


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
