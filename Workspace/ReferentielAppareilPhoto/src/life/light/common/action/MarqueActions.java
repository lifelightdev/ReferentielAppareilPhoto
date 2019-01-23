package life.light.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import life.light.common.bean.Marque;
import life.light.common.form.MarqueForm;
import life.light.common.service.MarqueService;

public class MarqueActions extends DispatchAction {
	
	public ActionForward Ajouter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		return mapping.findForward("Ajouter");
		
	}

	public ActionForward Editer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int idMarque = Integer.parseInt(request.getParameter("idMarque"));
		MarqueForm marqueform = (MarqueForm) form;
		MarqueService marqueService = new MarqueService();
		Marque marque = marqueService.findById(idMarque);
		marqueform.setIdMarque(idMarque);
		marqueform.setNom(marque.getNom());		

		return mapping.findForward("Editer");
	}

	public ActionForward Enregistrer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		MarqueForm marqueform = (MarqueForm) form;

		MarqueService marqueService = new MarqueService();
		Marque marque = new Marque();
		marque.setNom(marqueform.getNom());		
		
		marqueService.persist(marque);
		
		return new ActionForward("/listeMarque.do", true);

	}

	public ActionForward Sauvegarder(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		MarqueForm marqueform = (MarqueForm) form;		

		MarqueService marqueService = new MarqueService();
		Marque marque =  marqueService.findById(marqueform.getIdMarque());
		marque.setNom(marqueform.getNom());		

		marqueService.update(marque);
		
		return new ActionForward("/listeMarque.do", true);
	}

	public ActionForward Supprimer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		MarqueForm marqueform = (MarqueForm) form;		

		MarqueService marqueService = new MarqueService();
		marqueService.delete(marqueform.getIdMarque());
		
		return new ActionForward("/listeMarque.do", true);

	}
	
	public ActionForward Retour(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {		
		
		return new ActionForward("/listeMarque.do", true);

	}

}