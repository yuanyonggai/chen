package com.wisely.viewresolver;

import java.util.Locale;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

import com.wisely.domain.DemoObj;

public class XmlViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {
        MarshallingView view = new MarshallingView();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(DemoObj.class);
        marshaller.setPackagesToScan("com.wisely.domain");
        view.setMarshaller(marshaller);
        return view;
    }

}