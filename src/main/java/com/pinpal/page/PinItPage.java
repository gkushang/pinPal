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
                .img(class_("pinit-image").id("blah").src("http://i57.tinypic.com/j7x3kk.png").alt(""))
                ._div()


                .div(class_("pin-it-btn-div"))
                .a(href("//www.pinterest.com/pin/create/button/?url=https%3A%2F%2Fstage2md053.qa.paypal.com%2Fdeals%2F%23%2Foffers%2Fdetails%2F947eccb0-63ac-0132-d39f-7a163e6a7efb&media=http%3A%2F%2Fi57.tinypic.com%2Fj7x3kk.png&description=" +
                                "20% Off Scuderia Ferrari R200 Headphones"))
                .img(src("//assets.pinterest.com/images/pidgets/pinit_fg_en_rect_red_28.png"))._a().br().br()

                .img(src("http://s7.postimg.org/re9es4dxj/1688856378692136946.png").alt("Smiley face").width("40").height("40")).br().br()

                .img(src("http://s21.postimg.org/scbr9fi3n/twitter_icon_128_1262922753.png").alt("Smiley face").width("40").height("40")).br().br()

                .img(src("  http://s4.postimg.org/d7jkle13d/instagram_icon_128_1826619604.png").alt("Smiley face").width("42").height("42"))


                ._div()

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
