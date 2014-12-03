package com.pinpal.page;


import java.io.IOException;
import java.util.List;

import com.cukesrepo.domain.Feature;
import com.cukesrepo.domain.Project;
import org.apache.commons.lang3.StringUtils;
import org.rendersnake.HtmlCanvas;

import static org.rendersnake.HtmlAttributesFactory.*;


public class HeaderFooter
{

    private Project _project;

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
                .content("")
                .span(class_("titlePart"))
                .content("")
                ._div()
                .div(class_("pageTitle"))
                .a(class_("logo_image").src("/resources/images/logo.png").alt("logo"))._a();

        html.ul();

        if (headerType.equalsIgnoreCase("featuresPage"))
        {
            html.li(class_("sub-menu-l")).
                    a(class_("s-menu report-link").href("#")).content("Test Reports").
                    ul();

            _addTestReport(html, _project.getP1TestJob(), "P1");
            _addTestReport(html, _project.getAcceptance(), "Acceptance");
            _addTestReport(html, _project.getE2e(), "E2E");

            if (StringUtils.isBlank(_project.getP1TestJob()) &&
                    StringUtils.isBlank(_project.getAcceptance()) &&
                    StringUtils.isBlank(_project.getE2e()))
            {
                html.li(class_("sub-menu")).a(class_("s-menu test-link").href("/projects/" + _project.getId() + "/settings"))
                        .content("Add Reports (+)")._li();
            }
            html._ul();
            html._li();
        }

        html.
                li().a(href("/projects/").class_("full")).content("Home").
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

    protected void renderScenarioHeader(HtmlCanvas html, Project project) throws IOException
    {

        html.html()
                .body(class_("background-color-cukes"))
                .div(class_("cukes-logo bgColorA"))
                .div(class_("pageTitle"))
                .span(class_("title"))
                .content(" ")
                .span(class_("titlePart"))
                .content(" ")
                .ul()

                .li()
                .a(href("/projects/" + project.getId() + "/").class_("full"))
                .content(project.getName())
                ._li()


                .li()
                .a(href("/projects/").class_("full"))
                .content("Home")
                ._li()

                ._ul()
                ._div()
                ._div()
                .div()._div();


        html._body()
                .html();


    }


    protected void renderDiscussionHeader(HtmlCanvas html, Project project, Feature feature) throws IOException
    {

        html.html()
                .body(class_("background-color-cukes"))
                .div(class_("cukes-logo bgColorA"))
                .div(class_("pageTitle"))
                .span(class_("title"))
                .content(" ")
                .span(class_("titlePart"))
                .content(" ")
                .ul()

                .li()
                .a(href("/projects/" + project.getId() + "/" + feature.getId() + "/").class_("full"))
                .content("Scenarios")
                ._li()


                .li()
                .a(href("/projects/" + project.getId() + "/").class_("full"))
                .content(project.getName())
                ._li()


                .li()
                .a(href("/projects/").class_("full"))
                .content("Home")
                ._li()

                ._ul()
                ._div()
                ._div()
                .div()._div();
        ;

        html._body()
                .html();


    }


    protected void renderTitle(HtmlCanvas html) throws IOException
    {

        html.html()
                .body()
                .div(class_("cukes-logo bgColorA"))
                .div(class_("pageTitle"))
                .span(class_("title"))
                .content("cukes ")
                .span(class_("titlePart"))
                .content("Repo")
                ._div()
                ._div();

        html._body()
                .html();


    }

    public void addLeftNavigationPane(HtmlCanvas html, String projectId, List<Feature> features) throws Throwable
    {

        html.div(class_("full-height"));

//        html.li().a(href("/projects/").class_("full-abch")).span().content("<")._a()._li();
//        html.li().a(href("/projects/").class_("full-abch")).span().content(">")._a()._li();
//
        for (Feature feature : features)
        {
            html.li().a(href("/projects/" + projectId + "/" + feature.getId() + "/").class_("full-h")).span().content(feature.getName())._a()._li();
            html.br();
        }
        html._div();
        html.div(id("main-low"));
        html.br();

    }

    public void setProject(Project project)
    {
        _project = project;
    }


}
