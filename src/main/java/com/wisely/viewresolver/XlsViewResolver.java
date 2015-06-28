package com.wisely.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import com.wisely.view.XlsView;

public class XlsViewResolver implements ViewResolver{

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        return new XlsView();
    }

}