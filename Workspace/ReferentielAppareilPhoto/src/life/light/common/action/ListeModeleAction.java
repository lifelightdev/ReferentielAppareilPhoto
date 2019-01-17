package life.light.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import life.light.common.service.ModeleService;

public class ListeModeleAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
		
		ModeleService modelelService = new ModeleService();
		request.setAttribute("listeModele", modelelService.findAll());
		
		return mapping.findForward("success");
	}
	
}
