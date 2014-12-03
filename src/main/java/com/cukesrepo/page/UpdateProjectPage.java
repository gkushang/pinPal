package com.cukesrepo.page;


import com.cukesrepo.domain.Project;
import com.cukesrepo.exceptions.ProjectNotFoundException;
import com.cukesrepo.service.project.ProjectService;
import org.apache.commons.lang.Validate;
import org.rendersnake.HtmlCanvas;
import org.rendersnake.Renderable;

import java.io.IOException;

import static org.rendersnake.HtmlAttributesFactory.*;

public class UpdateProjectPage extends HeaderFooter implements Renderable {

    private final String _projectId;
    private final ProjectService _projectService;

    public UpdateProjectPage(ProjectService projectService, String projectId) {

        Validate.notNull(projectService, "projectService cannot be null");
        Validate.notEmpty(projectId, "projectId cannot be empty/null");

        _projectService = projectService;
        _projectId = projectId;

    }

    @Override
    public void renderOn(HtmlCanvas html) throws IOException {


        try {

            Project project = _projectService.getProjectById(_projectId);


            addScriptsAndStyleSheets(html);

            renderHeader(html);

            html.html()
                    .body();

            html.br();
            html.br();
            html.div(class_("addproject-div-title"));
            html.h2().span(id("project-title")).content("update project").br().br();


            html.input(type("text").class_("add-project project-name").value(project.getName()).add("placeholder", "Project Name")).br().br();
            html.input(type("text").class_("add-project repository-path").value(project.getRepositoryPath()).add("placeholder", "Repository Path")).br().br();
            html.input(type("text").class_("add-project git-branch").value("").add("placeholder", "Git Branch")).br().br();
            html.input(type("text").class_("add-project collaborators").value("").add("placeholder", "Add Collaborators")).br().br();
            html.input(type("text").class_("add-project project-owners").value("").add("placeholder", "Add Project Owners")).br().br();

            html.a(href("#").id("add-project-navigate"));
            html.input(type("button").class_("cukes-button-add-p").id("update-project").style("float: left;")
                    .value("Save changes"))
                    .input(type("hidden").id("project-id").value(_projectId))
                    .input(type("button").class_("cukes-button-add-p").id("delete-project").style("float: right;")
                            .value("Delete"))
                    ._a();

            html._h2();
            html._div();


            html._body()
                    ._html();
        } catch (ProjectNotFoundException e) {
            throw new RuntimeException("Project not found. Replace this with rendering error page: ", e);
        }

    }
}
