package test;

import java.io.File;

import life.light.common.form.MarqueForm;
import servletunit.struts.MockStrutsTestCase;

public class TestMarqueAction extends MockStrutsTestCase {

	public void setUp() throws Exception {

		super.setUp();
		ConnectionBaseDeDonnees.initBDD();
		setContextDirectory(new File(Configuration.CONTEXTDIRECTORY));
		setInitParameter("validating", "false");
		setConfigFile(Configuration.CONFIGFILE);

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
		
		testEnregistrer();

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Editer");
		addRequestParameter("idMarque","1");
		actionPerform();
		verifyForwardPath("/listeMarque.do");
		assertEquals("NikonTest",((MarqueForm) getActionForm()).getNom());
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
		
		testEnregistrer();

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Sauvegarder");
		addRequestParameter("idMarque","1");
		addRequestParameter("nom","RolleiTest");
		actionPerform();
		assertEquals("RolleiTest",((MarqueForm) getActionForm()).getNom());
		verifyForwardPath("/listeMarque.do");
		verifyNoActionErrors();
		
	}
	
	public void testSupprimer() {
		
		testEnregistrer();

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Supprimer");
		addRequestParameter("idMarque","1");
		actionPerform();
		verifyForwardPath("/listeMarque.do");
		verifyNoActionErrors();
		
	}	
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestMarqueAction.class);
	}
}