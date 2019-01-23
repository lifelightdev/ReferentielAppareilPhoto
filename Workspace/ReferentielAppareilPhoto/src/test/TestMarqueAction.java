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
	
	public void testEnregistrer() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Enregistrer");
		addRequestParameter("nom","NikonTest");
		actionPerform();
		assertEquals("NikonTest",((MarqueForm) getActionForm()).getNom());
		verifyForwardPath("/listeMarque.do");
		verifyNoActionErrors();
		
	}

	public void testSauvegarder() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Sauvegarder");
		addRequestParameter("idMarque","2");
		addRequestParameter("nom","Rollei1");
		actionPerform();
		assertEquals("Rollei1",((MarqueForm) getActionForm()).getNom());
		verifyForwardPath("/listeMarque.do");
		verifyNoActionErrors();
		
	}
	
	public void testSupprimer() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Supprimer");
		addRequestParameter("idMarque","5");
		actionPerform();
		verifyForwardPath("/listeMarque.do");
		verifyNoActionErrors();
		
	}	
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMarqueAction.class);
	}
}