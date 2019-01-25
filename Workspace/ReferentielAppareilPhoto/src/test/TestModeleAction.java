package test;

import java.io.File;

import life.light.common.form.ModeleForm;
import servletunit.struts.MockStrutsTestCase;

public class TestModeleAction extends MockStrutsTestCase {

	public void setUp() throws Exception {

		super.setUp();
		ConnectionBaseDeDonnees.initBDD();
		setContextDirectory(new File(Configuration.CONTEXTDIRECTORY));
		setInitParameter("validating", "false");
		setConfigFile(Configuration.CONFIGFILE);
		
	}

	private void ajouterMarque() {

		setRequestPathInfo("/marqueAction.do");
		addRequestParameter("actionMethod", "Enregistrer");
		addRequestParameter("nom", "NikonTest");
		actionPerform();

	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public TestModeleAction(String testName) {
		super(testName);
	}

	public void testAjouter() {

		setRequestPathInfo("/modeleAction.do");
		addRequestParameter("actionMethod", "Ajouter");
		actionPerform();
		verifyForward("Ajouter");
		verifyNoActionErrors();
	}

	public void testEditer() {

		testEnregistrer();

		setRequestPathInfo("/modeleAction.do");
		addRequestParameter("actionMethod", "Editer");
		addRequestParameter("idModele", "1");
		ModeleForm form = new ModeleForm();
		form.setIdMarque(1);
		setActionForm(form);
		actionPerform();
		verifyForwardPath("/listeModele.do");
		assertEquals("B35Test", ((ModeleForm) getActionForm()).getNom());
		verifyNoActionErrors();

	}

	public void testEnregistrer() {		
		
		ajouterMarque();

		setRequestPathInfo("/modeleAction.do");
		addRequestParameter("actionMethod", "Enregistrer");
		addRequestParameter("nom", "B35Test");
		ModeleForm form = new ModeleForm();
		form.setIdMarque(1);
		setActionForm(form);
		actionPerform();
		assertEquals("B35Test", ((ModeleForm) getActionForm()).getNom());
		verifyForwardPath("/listeModele.do");
		verifyNoActionErrors();

	}

	public void testSauvegarder() {

		testEnregistrer();

		setRequestPathInfo("/modeleAction.do");
		addRequestParameter("actionMethod", "Sauvegarder");
		addRequestParameter("idModele", "1");
		addRequestParameter("nom", "B35Test");
		ModeleForm form = new ModeleForm();
		form.setIdMarque(1);
		setActionForm(form);
		actionPerform();
		assertEquals("B35Test", ((ModeleForm) getActionForm()).getNom());
		verifyForwardPath("/listeModele.do");
		verifyNoActionErrors();

	}

	public void testSupprimer() {

		testEnregistrer();

		setRequestPathInfo("/modeleAction.do");
		addRequestParameter("actionMethod", "Supprimer");
		addRequestParameter("idModele", "1");
		ModeleForm form = new ModeleForm();
		form.setIdMarque(1);
		setActionForm(form);
		actionPerform();
		verifyForwardPath("/listeModele.do");
		verifyNoActionErrors();

	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestModeleAction.class);
	}
}