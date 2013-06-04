package com.zk.spring.action;

import java.util.List;
import java.util.Map;

import org.zkoss.zk.ui.Desktop;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.WebApp;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Window;

import com.zk.spring.model.User;

//@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MyComposer extends SelectorComposer<Window> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3318714486087127531L;

	private String title = "my Title";
	@WireVariable
    private Page _page;
     
    @WireVariable
    private Desktop _desktop;
     
    @WireVariable
    private Session _sess;
     
    @WireVariable
    private WebApp _wapp;
     
    @WireVariable("desktopScope")
    private Map<String, Object> _desktopScope;
	
	
	// @WireVariable
	private List<User> users;

	// <grid model="${$composer.users}>
	public ListModel<User> getUsers() {
		return new ListModelList<User>(users);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	//we could handle the exception by overriding ComposerExt.doCatch(Throwable) and/or ComposerExt.doFinally()
	public boolean doCatch(Throwable ex) {
		return true; // return true if ex could be ignored
	}
	//For involving the life cycle, you could override ComposerExt.doBeforeCompose(Page, Component, ComponentInfo)
	//and/or ComposerExt.doBeforeComposeChildren(T).
	
	
	@Override
	public void doAfterCompose(Window comp) {
		try {
			super.doAfterCompose(comp);// wire variables and event listners
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// do whatever you want (you could access wired variables here)
	}
}