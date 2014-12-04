package com.pinpal.controller;

import java.io.IOException;

import com.pinpal.page.PhotoPage;
import com.pinpal.service.project.ProjectService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class PhotoPageController
{

    private final ProjectService _projectService;

    @Autowired
    public PhotoPageController
            (
                    ProjectService projectService
            )
    {

        _projectService = projectService;
    }

    @RequestMapping(value = {"/photo/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {

        html.render(new PhotoPage(_projectService));

    }

    @RequestMapping(value = {"/upload-photo/"}, method = RequestMethod.POST)
    @ResponseBody
    protected void uploadPhoto
            (

            )
    {


    }
}

