package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.PinPalService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.*;


public class PhotoPage extends HeaderFooter implements Renderable
{

    public PinPalService _projectService;

    public PhotoPage(PinPalService projectService)
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

                .span(class_("step-name active")).content("Photo")

                .span(class_("step-name")).content("Product")

                .span(class_("step-name")).content("Offer")
                .span(class_("step-name")).content("Pin-it")

                ._div()

                .div(class_("main-step"))

                .div(class_("main active"))

                .div(class_("image-container"))
                .img(class_("photo-image").id("blah").src(_projectService.getImage()).alt(""))
                ._div()

                .form(id("uploadform").method("POST").enctype("multipart/form-data"))
                .input(type("file").id("file").name("myImage").onChange("readURL(this)").style("display:none"))

                .input(type("submit").id("btn-upload").class_("upload-button").value("Upload Photo"))
                ._form()

//                .div(id("continue-div"))
                .a(href("/product/").id("continue").class_("next-photo")).content("Next")
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
