package life.light.common.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import life.light.common.bean.Appareil;
import life.light.common.bean.Modele;
import life.light.common.bean.Type;
import life.light.common.form.AppareilForm;
import life.light.common.service.AppareilService;
import life.light.common.service.ModeleService;
import life.light.common.service.TypeService;

public class AppareilActions extends DispatchAction {
	
	public ActionForward Ajouter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		
		AppareilForm appareilForm = (AppareilForm) form;
				
		TypeService typeService = new TypeService();
		List<Type> liste = typeService.findAll();
		appareilForm.setTypes(liste);
		
		ModeleService modeleService = new ModeleService();
		appareilForm.setModeles(modeleService.findAll());
		
		return mapping.findForward("Ajouter");
		
	}

	public ActionForward Editer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		int idAppareil = Integer.parseInt(request.getParameter("idAppareil"));
		AppareilForm appareilForm = (AppareilForm) form;
		AppareilService appareilService = new AppareilService();
		Appareil appareil = appareilService.findById(idAppareil);
		appareilForm.setIdAppareil(idAppareil);
		
		ModeleService modeleService = new ModeleService();
		appareilForm.setModeles(modeleService.findAll());
		appareilForm.setModele(appareil.getModele());
		appareilForm.setIdModele(appareil.getModele().getId());
		
		TypeService typeService = new TypeService();
		appareilForm.setTypes(typeService.findAll());
		appareilForm.setType(appareil.getType());
		appareilForm.setIdType(appareil.getType().getId());					

		return mapping.findForward("Editer");
	}

	public ActionForward Enregistre(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		AppareilForm appareilForm = (AppareilForm) form;
		
		ModeleService modeleService = new ModeleService();
		Modele modele = modeleService.findById(appareilForm.getIdModele());
		
		TypeService typeService = new TypeService();
		Type type = typeService.findById(appareilForm.getIdType());

		AppareilService appareilService = new AppareilService();
		Appareil appareil = new Appareil();
		appareil.setModele(modele);	
		appareil.setType(type);
		
		try {
			appareil.setPhoto(appareilForm.getPhoto().getFileData());
			appareil.setModeEmploie(appareilForm.getModeEmploie().getFileData());
		} catch (IOException e) {
			e.printStackTrace();
		}

		appareilService.persist(appareil);
		
		return new ActionForward("/listeAppareil.do", true);

	}

	public ActionForward MiseAJour(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		AppareilForm appareilForm = (AppareilForm) form;	
		
		ModeleService modeleService = new ModeleService();
		Modele modele = modeleService.findById(appareilForm.getIdModele());
		
		TypeService typeService = new TypeService();
		Type type = typeService.findById(appareilForm.getIdType());

		AppareilService appareilService = new AppareilService();
		Appareil appareil =  appareilService.findById(appareilForm.getIdAppareil());
		appareil.setModele(modele);
		appareil.setType(type);
		
		try {
			appareil.setPhoto(appareilForm.getPhoto().getFileData());
			appareil.setModeEmploie(appareilForm.getModeEmploie().getFileData());
		} catch (IOException e) {
			e.printStackTrace();
		}

		appareilService.update(appareil);
		
		return new ActionForward("/listeAppareil.do", true);
	}

	public ActionForward Supprimer(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		AppareilForm appareilForm = (AppareilForm) form;		

		AppareilService appareilService = new AppareilService();
		appareilService.delete(appareilForm.getIdAppareil());
		
		return new ActionForward("/listeAppareil.do", true);

	}

}