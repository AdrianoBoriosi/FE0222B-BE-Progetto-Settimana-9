package it.epicode.be.demo.eclipse;

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	/* Classi di configurazione delle servlet e view di Spring*/
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { SpringWebConfig.class };
	}
	
	/* Dichiariamo url del sito */
	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
}