package life.light.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import life.light.common.bean.Marque;
import life.light.common.bean.Modele;
import life.light.common.form.ModeleForm;
import life.light.common.service.MarqueService;
import life.light.common.service.ModeleService;

public class ModeleActions extends DispatchAction {
	
	public ActionForward Ajouter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		ModeleForm modeleForm = (ModeleForm) form;
		
		MarqueService marqueService = new MarqueService();
		modeleForm.setMarques(marqueService.findAll());
		
		return mapping.findForward("Ajouter");
		
	}

	public ActionForward Editer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int idModele = Integer.parseInt(request.getParameter("idModele"));
		ModeleForm modeleForm = (ModeleForm) form;
		ModeleService modeleService = new ModeleService();
		Modele modele = modeleService.findById(idModele);
		modeleForm.setIdModele(idModele);
		
		MarqueService marqueService = new MarqueService();
		modeleForm.setMarques(marqueService.findAll());
		modeleForm.setMarque(modele.getMarque());
		modeleForm.setIdMarque(modele.getMarque().getId());
		
		modeleForm.setNom(modele.getNom());		

		return mapping.findForward("Editer");
	}

	public ActionForward Enregistre(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ModeleForm modeleForm = (ModeleForm) form;
		
		MarqueService marqueService = new MarqueService();
		Marque marque = marqueService.findById(modeleForm.getIdMarque());

		ModeleService modeleService = new ModeleService();
		Modele modele = new Modele();
		modele.setNom(modeleForm.getNom());	
		modele.setMarque(marque);		
		
		modeleService.persist(modele);
		
		return new ActionForward("/listeModele.do", true);

	}

	public ActionForward MiseAJour(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ModeleForm modeleForm = (ModeleForm) form;	
		
		MarqueService marqueService = new MarqueService();
		Marque marque = marqueService.findById(modeleForm.getIdMarque());

		ModeleService modeleService = new ModeleService();
		Modele modele =  modeleService.findById(modeleForm.getIdModele());
		modele.setNom(modeleForm.getNom());	
		modele.setMarque(marque);

		modeleService.update(modele);
		
		return new ActionForward("/listeModele.do", true);
	}

	public ActionForward Supprimer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ModeleForm modeleForm = (ModeleForm) form;		

		ModeleService modeleService = new ModeleService();
		modeleService.delete(modeleForm.getIdModele());
		
		return new ActionForward("/listeModele.do", true);

	}

}