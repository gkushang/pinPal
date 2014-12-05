package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.ProjectService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.*;


public class PhotoPage extends HeaderFooter implements Renderable
{

    public ProjectService _projectService;

    public PhotoPage(ProjectService projectService)
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

//                .div(class_("step-name-number"))
//                .span(class_("step-number active")).content("1")
                .span(class_("step-name active")).content("Photo")
//                ._div()

//                .div(class_("step-name-number"))
//                .span(class_("step-name")).content("2")
                .span(class_("step-name")).content("Product")
//                ._div()

//                .div(class_("step-name-number"))
//                .span(class_("step-number")).content("3")
                .span(class_("step-name")).content("Offer")
//                ._div()

//                .div(class_("step-name-number"))
//                .span(class_("step-number")).content("4")
                .span(class_("step-name")).content("Pin-it")
//                ._div()

                ._div()

                .div(class_("main-step"))

                .div(class_("main active"))

                .div(class_("image-container"))
                .img(class_("photo-image").id("blah").src("").alt(""))
                ._div()

                .input(type("file").id("file").onChange("readURL(this)").style("display:none"))
                .input(type("button").id("btn-upload").class_("upload-button").value("Upload Photo"))

//                .input(type("button").class_("continue-product").id("continue").value("Continue"))
                .a(href("/product/").id("continue")).content("Next")

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
