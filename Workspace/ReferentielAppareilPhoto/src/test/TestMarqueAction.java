package test;

import java.io.File;

import life.light.common.form.MarqueForm;
import servletunit.struts.MockStrutsTestCase;

public class TestMarqueAction extends MockStrutsTestCase {

	public void setUp() throws Exception {

		super.setUp();
		setContextDirectory(new File(
				"E:\\MesDocuments\\ReferentielAppareilPhoto\\Workspace\\ReferentielAppareilPhoto\\WebContent"));
		setInitParameter("validating", "false");
		setConfigFile("/WEB-INF/struts-config.xml");

	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public TestMarqueAction(String testName) {
		super(testName);
	}

	public void testAjouter() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Ajouter");
		actionPerform();
		verifyForward("Ajouter");		
		verifyNoActionErrors();
	}

	public void testEditer() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Editer");
		addRequestParameter("idMarque","1");
		actionPerform();
		verifyForward("Editer");
		assertEquals("Nikon",((MarqueForm) getActionForm()).getNom());
		verifyNoActionErrors();
		
	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMarqueAction.class);
	}
}