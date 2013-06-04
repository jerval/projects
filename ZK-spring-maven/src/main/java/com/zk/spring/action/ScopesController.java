package com.zk.spring.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.zkoss.spring.context.annotation.EventHandler;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.zk.spring.model.SimpleMessageBean;

@org.springframework.stereotype.Component("scopesCtrl")
@Scope("desktop")
public class ScopesController extends SelectorComposer<Window> {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = -7502463501847043256L;
	@Autowired
    private SimpleMessageBean msgBean;
	@Wire
    private Textbox name;
	@Wire
    private Button setMsgBtn;
	@Wire
    private Button showMsgBtn;
	/**
 In additions to wiring via identifiers, you could wire by a CSS3-like selector (Selector), such as
@Wire("#foo")
@Wire("textbox, intbox, decimalbox, datebox")
@Listen("onClick = button[label='Clear']")
@Wire("window > div > button")
	 */
    
    public String uuu="12342134";

	public String getUuu() {
		return uuu;
	}

	public void setUuu(String uuu) {
		this.uuu = uuu;
	}
 
	@Listen("onClick = #setMsgBtn")
    public void setMessage(Event evt) {
        msgBean.setMsg(name.getValue());
    }
	
	@Listen("onClick = #showMsgBtn")
    public void showMessage(Event evt) throws InterruptedException {
        Messagebox.show(msgBean.getMsg());
    }
    
    
}