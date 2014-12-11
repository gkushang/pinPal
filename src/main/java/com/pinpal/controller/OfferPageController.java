package com.pinpal.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

import com.pinpal.page.OfferPage;
import com.pinpal.service.project.PinPalService;
import org.rendersnake.HtmlCanvas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OfferPageController
{

    private final PinPalService _pinPalService;

    @Autowired
    public OfferPageController
            (
                    PinPalService pinPalService
            )
    {

        _pinPalService = pinPalService;
    }

    @RequestMapping(value = {"/offer/"})
    @ResponseBody
    public void renderProjectsPage
            (
                    HtmlCanvas html
            ) throws IOException
    {
        html.render(new OfferPage(_pinPalService));
    }

    @RequestMapping(value = {"/save-offer/"}, method = RequestMethod.POST)
    @ResponseBody
    public void saveOffer
            (
                    HttpServletRequest request
            ) throws IOException
    {
        _pinPalService.setRetailPrice(request.getParameter("r-price-id"));
        _pinPalService.setDiscountPercentage(request.getParameter("d-perc-id"));
        _pinPalService.setDiscountPrice(request.getParameter("d-price-id"));
        _pinPalService.setStartDate(request.getParameter("s-date-id"));
        _pinPalService.setEndDate(request.getParameter("e-date-id"));

    }

}