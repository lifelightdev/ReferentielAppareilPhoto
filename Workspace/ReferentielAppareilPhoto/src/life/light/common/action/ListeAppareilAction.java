package life.light.common.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import life.light.common.service.AppareilService;

public class ListeAppareilAction extends Action{
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,
		HttpServletRequest request,HttpServletResponse response)
        throws Exception {
		
		AppareilService appareilService = new AppareilService();
		request.setAttribute("listeAppareil", appareilService.findAll());
		
		return mapping.findForward("success");
	}
	
}
