package com.pinpal.page;


import java.io.IOException;

import org.rendersnake.HtmlCanvas;

import static org.rendersnake.HtmlAttributesFactory.class_;
import static org.rendersnake.HtmlAttributesFactory.href;


public class HeaderFooter
{

    protected void addScriptsAndStyleSheets(HtmlCanvas html) throws IOException
    {

        html.head()
                .macros().javascript("/../../resources/scripts/jquery-1.10.2.min.js")
                .macros().javascript("/../../resources/scripts/continue.js")

                .macros().stylesheet("/../../resources/css/headerfooter.css")
                .macros().stylesheet("/../../resources/css/homepage.css")

                .head().title().content("PinPal")._head()
                ._head();
    }

    protected void renderHeader(HtmlCanvas html) throws IOException
    {

        html.html()
                .body(class_("background-color"))
                .div(class_("header"))
                .div(class_("project-title"))
                .span(class_("title")).content("PinPal")
                .span(class_("titlePart")).content("")
                ._div()
                ._div()
                ._body()
                ._html();
    }

    public void renderFooter(HtmlCanvas html) throws IOException
    {
        html.footer().div(class_("footer"))
                .div(class_("feedback-div")).a(href("/feedback/").class_("feedback").id("no-decoration")).content("Feedback")._div()
                ._div()
                ._footer();

    }
}
