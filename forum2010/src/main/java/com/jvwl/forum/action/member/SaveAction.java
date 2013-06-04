package com.jvwl.forum.action.member;

import javax.annotation.Resource;

import org.apache.struts2.json.annotations.JSON;

import com.jvwl.forum.action.base.BaseAction;
import com.jvwl.forum.common.Message;
import com.jvwl.forum.exception.BusinessException;
import com.jvwl.forum.model.Member;
import com.jvwl.forum.service.MemberService;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.interceptor.annotations.InputConfig;
import com.opensymphony.xwork2.validator.annotations.RegexFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

@SuppressWarnings("serial")
public class SaveAction extends BaseAction implements ModelDriven<Member> {

	private MemberService memberService;
	private Member member = new Member();
	private Message message;

	public Message getMessage() {
		return message;
	}

	@Resource
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public String fail() {
		System.out.println(this.getFieldErrors().values());
		message = new Message(getText("operate_fail"), "添加部门信息失败，请重试！<br/>原因："
				+ this.getFieldErrors().values(), false, null);
		return SUCCESS;
	}

	@JSON(serialize = false)
	@Override
	@InputConfig(methodName = "fail")
	@Validations(regexFields = {
			@RegexFieldValidator(fieldName = "depart_id", message = "编号格式不正确", expression = "^(\\w){4,20}$"),
			@RegexFieldValidator(fieldName = "depart_name", message = "名称格式不正确", expression = "^[\\u4E00-\\u9FA5\\uF900-\\uFA2D]+$") })
	public String execute() throws Exception {
		if (member.getId() == null) {
			try {
				memberService.save(member);
				message = new Message(getText("operate_ok"), "添加部门信息成功！", true,
						"member_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_fail"),
						"添加部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		} else {
			try {
				memberService.update(member);
				message = new Message(getText("operate_ok"), "修改部门信息成功！", true,
						"member_list");
			} catch (BusinessException e) {
				e.printStackTrace();
				message = new Message(getText("operate_ok"),
						"修改部门信息失败，请重试！<br/>原因：" + e.getMessage(), false, null);
			}
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Member getModel() {
		return member;
	}
}
