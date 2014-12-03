package com.pinpal.page;


import java.io.IOException;

import com.pinpal.service.project.ProjectService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import static org.rendersnake.HtmlAttributesFactory.class_;


public class HomePage extends HeaderFooter implements Renderable
{

    public ProjectService _projectService;

    public HomePage(ProjectService projectService)
    {

        Validate.notNull(projectService, "projectService cannot be null");

        _projectService = projectService;

    }

    @Override
    public void renderOn(HtmlCanvas html) throws IOException
    {

        addScriptsAndStyleSheets(html);

        renderHeader(html, "homePage");

        html.html()
                .body(class_("background-color-cukes"));

        html.br();
        html.br();
        html._body()
                ._html();


    }
}
