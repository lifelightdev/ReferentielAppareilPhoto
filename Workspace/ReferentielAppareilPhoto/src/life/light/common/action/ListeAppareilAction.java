package life.light.common.action;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import life.light.common.bean.Appareil;
import life.light.common.service.AppareilService;

public class ListeAppareilAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		AppareilService appareilService = new AppareilService();
		List<Appareil> list = appareilService.findAll();
		for (Appareil appareil : list) {

			try {
				String filePath = request.getSession().getServletContext().getRealPath("\\") + "//";
				String path = request.getContextPath() + "/";
				if (appareil.getPhoto().length > 0) {
					appareil.setNomFichierPhoto(appareil.getModele().getMarque().getNom() + "-"
							+ appareil.getModele().getNom() + ".jpg");
					File image = new File(filePath + appareil.getNomFichierPhoto());
					FileUtils.writeByteArrayToFile(image, appareil.getPhoto());
					appareil.setImage(image);
					appareil.setUrlPhoto(path + appareil.getNomFichierPhoto());
				}
				if (appareil.getModeEmploie().length > 0) {
					appareil.setNomFichierModeEmploie(appareil.getModele().getMarque().getNom() + "-" + appareil.getModele().getNom()+ ".pdf");
					File pdf = new File(filePath + appareil.getNomFichierModeEmploie());
					FileUtils.writeByteArrayToFile(pdf, appareil.getModeEmploie());
					appareil.setPdf(pdf);
					appareil.setUrlModeEmploie(path + appareil.getNomFichierModeEmploie());
				} else {
					appareil.setNomFichierModeEmploie("");	
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		request.setAttribute("listeAppareil", list);

		return mapping.findForward("success");
	}

}
