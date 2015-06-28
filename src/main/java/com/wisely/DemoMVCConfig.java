package com.wisely;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.wisely.viewresolver.JsonViewResolver;
import com.wisely.viewresolver.PdfViewResolver;
import com.wisely.viewresolver.XlsViewResolver;
import com.wisely.viewresolver.XmlViewResolver;

@Configuration
@ComponentScan("com.wisely")
@EnableWebMvc
public class DemoMVCConfig extends WebMvcConfigurerAdapter {

	// 名称与实际的页面的映射
	// return "index" ; 实际返回的页面是/WEB-INF/views/index.jsp
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	// 静态资源映射
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/js/**").addResourceLocations("/js/");
	}

	// 注册拦截器
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// registry.addInterceptor(demoInteceptor());
	// }

	// 自定义拦截器
	// @Bean
	// public DemoInteceptor demoInteceptor() {
	// return new DemoInteceptor();
	// }

	// 文件上传设置--在此处
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}

	// 在此---配置ContentNegotiationManager,在无后缀名情况下默认为jsp view resolver
	@Override
	public void configureContentNegotiation(
			ContentNegotiationConfigurer configurer) {
		configurer.ignoreAcceptHeader(true).defaultContentType(
				MediaType.TEXT_HTML);
	}

	// 在此---配置ContentNegotiatingViewResolver,通过此代理到不同的viewResolover
	@Bean
	public ViewResolver contentNegotiatingViewResolver(
			ContentNegotiationManager manager) {

		ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
		resolver.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

		resolvers.add(xmlViewResolver());
		resolvers.add(jsonViewResolver());
		resolvers.add(viewResolver());// jsp view resolver
		resolvers.add(pdfViewResolver());
		resolvers.add(xlsViewResolver());

		resolver.setViewResolvers(resolvers);
		return resolver;
	}

	// 在此---xml viewResolver
	@Bean
	public ViewResolver xmlViewResolver() {
		return new XmlViewResolver();
	}

	// 在此---json viewResolver
	@Bean
	public ViewResolver jsonViewResolver() {
		return new JsonViewResolver();
	}

	// 在此---pdf viewResolver
	@Bean
	public ViewResolver pdfViewResolver() {
		return new PdfViewResolver();
	}

	// 在此---excel viewResolver
	@Bean
	ViewResolver xlsViewResolver() {
		return new XlsViewResolver();
	}
}