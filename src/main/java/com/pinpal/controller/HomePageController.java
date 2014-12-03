package com.pinpal.controller;

import java.io.IOException;

import com.pinpal.page.HomePage;
import com.pinpal.service.project.ProjectService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HomePageController
{

    private final ProjectService _projectService;

    @Autowired
    public HomePageController
            (
                    ProjectService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/home/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {

        html.render(new HomePage(_projectService));

    }

}

