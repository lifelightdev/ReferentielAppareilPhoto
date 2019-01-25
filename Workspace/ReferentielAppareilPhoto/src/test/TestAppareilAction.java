package test;

import java.io.File;

import life.light.common.bean.Marque;
import life.light.common.bean.Modele;
import life.light.common.bean.Type;
import life.light.common.form.AppareilForm;
import life.light.common.service.MarqueService;
import life.light.common.service.ModeleService;
import life.light.common.service.TypeService;
import servletunit.struts.MockStrutsTestCase;

public class TestAppareilAction extends MockStrutsTestCase {

	public void setUp() throws Exception {

		super.setUp();
		ConnectionBaseDeDonnees.initBDD();
		setContextDirectory(new File(Configuration.CONTEXTDIRECTORY));
		setInitParameter("validating", "false");
		setConfigFile(Configuration.CONFIGFILE);
		
		ajouterMarque();
		ajouterModele();
		ajouterType();
		
	}

	private void ajouterMarque() {

		MarqueService marqueService = new MarqueService();
		Marque marque = new Marque();
		marque.setNom("RolleiTest");		
		marqueService.persist(marque);

	}
	
	private void ajouterModele() {

		ModeleService modeleService = new ModeleService();
		Modele modele = new Modele();
		MarqueService marqueService = new MarqueService();
		Marque marque = marqueService.findById(1);		
		modele.setMarque(marque);
		modele.setNom("RolleiTest");		
		modeleService.persist(modele);

	}
	
	private void ajouterType() {

		TypeService typeService = new TypeService();
		Type type = new Type();	
		type.setNom("Argentique");		
		typeService.persist(type);

	}

	public void tearDown() throws Exception {
		super.tearDown();
	}

	public TestAppareilAction(String testName) {
		super(testName);
	}

	public void testAjouter() {

		setRequestPathInfo("/appareilAction.do");
		addRequestParameter("actionMethod", "Ajouter");
		actionPerform();
		verifyForward("Ajouter");
		assertEquals(false, ((AppareilForm) getActionForm()).getModeles().isEmpty());
		assertEquals(false, ((AppareilForm) getActionForm()).getTypes().isEmpty());
		verifyNoActionErrors();
		
	}

	public void testEditer() {

		testEnregistrer();

		setRequestPathInfo("/appareilAction.do");
		addRequestParameter("actionMethod", "Editer");
		addRequestParameter("idAppareil", "1");
		actionPerform();
		verifyForwardPath("/listeAppareil.do");
		verifyNoActionErrors();

	}

	public void testEnregistrer() {	

		setRequestPathInfo("/appareilAction.do");
		addRequestParameter("actionMethod", "Enregistrer");
		addRequestParameter("idModele", "1");
		addRequestParameter("idType", "1");
		actionPerform();
		verifyForwardPath("/listeAppareil.do");
		verifyNoActionErrors();

	}

	public void testSauvegarder() {

		testEnregistrer();

		setRequestPathInfo("/appareilAction.do");
		addRequestParameter("actionMethod", "Sauvegarder");
		addRequestParameter("idAppareil", "1");
		addRequestParameter("idModele", "1");
		addRequestParameter("idType", "1");
		actionPerform();
		verifyForwardPath("/listeAppareil.do");
		verifyNoActionErrors();

	}

	public void testSupprimer() {

		testEnregistrer();

		setRequestPathInfo("/appareilAction.do");
		addRequestParameter("idAppareil", "1");
		actionPerform();
		verifyForwardPath("/listeAppareil.do");
		verifyNoActionErrors();

	}

	public static void main(String[] args) {
		junit.textui.TestRunner.run(TestAppareilAction.class);
	}
}