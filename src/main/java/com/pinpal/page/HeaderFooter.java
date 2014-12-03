package com.pinpal.page;


import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.rendersnake.HtmlCanvas;

import static org.rendersnake.HtmlAttributesFactory.class_;
import static org.rendersnake.HtmlAttributesFactory.href;


public class HeaderFooter
{

    protected void addScriptsAndStyleSheets(HtmlCanvas html) throws IOException
    {

        html.head()
                .macros().javascript("/../../resources/scripts/jquery-1.10.2.min.js")
                .macros().javascript("/../../resources/scripts/email.js")
                .macros().javascript("/../../resources/scripts/canvasjs.min.js")
                .macros().javascript("/../../resources/scripts/firstword.js")
                .macros().javascript("/../../resources/scripts/dashboard.js")
                .macros().javascript("/../../resources/scripts/approve.js")
                .macros().javascript("/../../resources/scripts/comment.js")
                .macros().javascript("/../../resources/scripts/scrollTo.js")
                .macros().javascript("/../../resources/scripts/addproject.js")
                .macros().javascript("/../../resources/scripts/login.js")
                .macros().javascript("/../../resources/scripts/updateproject.js")
                .macros().javascript("/../../resources/scripts/signup.js")
                .macros().stylesheet("/../../resources/css/dashboard.css")
                .macros().stylesheet("/../../resources/css/headerfooter.css")
                .macros().stylesheet("/../../resources/css/cukes.css")
                .macros().stylesheet("/../../resources/css/discussion.css")
                .macros().stylesheet("/../../resources/css/feedback.css")
                .macros().javascript("/../../resources/scripts/save_discussion.js")
                .macros().javascript("/../../resources/scripts/cancel_discussion.js")
                .macros().javascript("/../../resources/scripts/sendfeedback.js")

                .macros().stylesheet("/../../resources/css/project.css")
                .macros().stylesheet("/../../resources/css/common.css")
                .macros().stylesheet("/../../resources/css/feature.css")
                .macros().stylesheet("/../../resources/css/scenario.css")

                .head().title().content("Cukes Repo")._head()
//                .link(rel("icon").type("image/png").href("/resources/images/favicon.png"))
                ._head();
    }

    protected void renderHeader(HtmlCanvas html, String headerType) throws IOException
    {

        html.html()
                .body(class_("background-color-cukes"))
                .div(class_("cukes-logo bgColorA"))
                .div(class_("cukesTitle"))
                .span(class_("title"))
                .content("PinPal")
                .span(class_("titlePart"))
                .content("")
                ._div()
                .div(class_("pageTitle"))
                .a(class_("logo_image").src("/resources/images/logo.png").alt("logo"))._a();

        html.ul();

        html.
                li().a(href("/home/").class_("full")).content("").
                _li().
                _ul()
                ._div()
                ._div()
                .div()._div();

        html._body()
                .html();


    }

    public void renderFooter(HtmlCanvas html) throws IOException
    {
        html.footer().div(class_("footer"))
                .div(class_("feedback-div")).a(href("/feedback/").class_("feedback").id("no-decoration")).content("Feedback")._div()
                ._div()
                ._footer();

    }

    private void _addTestReport(HtmlCanvas html, String testReportUrl, String testReportTitle) throws IOException
    {
        if (StringUtils.isNotBlank(testReportUrl))
        {
            html.li(class_("sub-menu")).a(class_("s-menu test-link").href(testReportUrl).target("_blank")).content(testReportTitle)._li();
        }
    }


}
