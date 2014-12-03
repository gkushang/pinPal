package com.cukesrepo.page;


import com.cukesrepo.service.project.ProjectService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import java.io.IOException;

import static org.rendersnake.HtmlAttributesFactory.*;

public class AddProjectPage extends HeaderFooter implements Renderable {

    public ProjectService _projectService;

    public AddProjectPage(ProjectService projectService) {

        Validate.notNull(projectService, "projectService cannot be null");

        _projectService = projectService;

    }

    @Override
    public void renderOn(HtmlCanvas html) throws IOException {

        addScriptsAndStyleSheets(html);

        renderHeader(html);

        html.html()
                .body();

        html.br();
        html.br();
        html.div(class_("addproject-div-title"));
        html.h2().span(id("project-title")).content("add project").br().br();


        html.input(type("text").class_("add-project project-name").add("placeholder", "Project Name")).br().br();
        html.input(type("text").class_("add-project repository-path").add("placeholder", "Repository Path")).br().br();
        html.input(type("text").class_("add-project git-branch").add("placeholder", "Git Branch")).br().br();
        html.input(type("text").class_("add-project collaborators").add("placeholder", "Add Collaborators")).br().br();
        html.input(type("text").class_("add-project project-owners").add("placeholder", "Add Project Owners")).br().br();

        html.a(href("#").id("add-project-navigate"));
        html.input(type("button").class_("cukes-button-add-p").id("add-project").style("float: left;")
                .value("Add"))._a();

        html._h2();
        html._div();


        html._body()
                ._html();

    }
}
