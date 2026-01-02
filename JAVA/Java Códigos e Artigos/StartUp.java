/**
 * <p>Title: Delegacia Virtual</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: SSPDS</p>
 * @author not attributable
 * @version 1.0
 */

package org.seguranca.sip.plugin;

import javax.servlet.*;
import javax.sql.*;
import javax.servlet.ServletContext;

import org.apache.struts.action.*;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.*;
import org.seguranca.sip.dao.BairroDAO;
import org.seguranca.sip.dao.NaturezaDAO;
import org.seguranca.sip.dao.TipoLocalDAO;
import org.seguranca.sip.dao.UfDAO;
import org.seguranca.sip.dao.MaterialDAO;
import org.seguranca.sip.dao.EnvolObjDAO;
import org.seguranca.sip.dao.UnidadeMaterialDAO;

public class StartUp implements PlugIn {

  private ServletContext context = null;

  public void init(ActionServlet servlet, ApplicationConfig config) {
    context = servlet.getServletContext();
    DataSource ds = (DataSource) context.getAttribute(Action.DATA_SOURCE_KEY);
    try {

      BairroDAO bairroDAO = new BairroDAO(ds);
      context.setAttribute("BairroList", bairroDAO.list());

      NaturezaDAO natDAO = new NaturezaDAO(ds);
      context.setAttribute("NatList", natDAO.list());

      TipoLocalDAO tpLocalDAO = new TipoLocalDAO(ds);
      context.setAttribute("TpLocalList", tpLocalDAO.list());

      UfDAO ufDAO = new UfDAO(ds);
      context.setAttribute("UfList", ufDAO.list());

      MaterialDAO matDAO = new MaterialDAO(ds);
      context.setAttribute("MaterialList", matDAO.list());

      EnvolObjDAO envolObjDAO = new EnvolObjDAO(ds);
      context.setAttribute("EnvolObjList", envolObjDAO.list());

      UnidadeMaterialDAO unidMatDAO = new UnidadeMaterialDAO(ds);
      context.setAttribute("UnidMatList", unidMatDAO.list());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void destroy() {
    context.setAttribute("BairroList", null);
    context.setAttribute("NatList", null);
    context.setAttribute("TpLocalList", null);
    context.setAttribute("UfList", null);
    context.setAttribute("MaterialList", null);
    context.setAttribute("EnvolObjList", null);
    context.setAttribute("UnidMatList", null);
  }
}
