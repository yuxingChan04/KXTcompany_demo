package top.dreamyy.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import top.dreamyy.hrm.domain.Message;
import top.dreamyy.hrm.domain.Notice;
import top.dreamyy.hrm.domain.User;
import top.dreamyy.hrm.service.HrmService;
import top.dreamyy.hrm.util.tag.PageModel;

@Controller
public class MessageController {
	
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	
	@RequestMapping(value="/addmessage")
	public ModelAndView addmessage(String flag,@ModelAttribute Message message,ModelAndView mv){
		
		 hrmService.addmessage(message);
		 
		 mv.setViewName("forward:/Write");
		
		return mv;
		
	}
	
	
	@RequestMapping(value="/message/previewMessage")
	 public String previewNotice(
			 Integer id,Model model){
		
		Message message = hrmService.findMessageById(id);
		
		model.addAttribute("message", message);
		// 返回
		return "message/previewMessage";
	}
	
	
	@RequestMapping(value="/message/deleteMessage")
	public ModelAndView removeMessage(ModelAndView mv,String ids){
		
		String[] arr = ids.split(",");
		for(String id : arr){
			// 根据id删除公告
			hrmService.removeMessageById(Integer.parseInt(id));
		}
		
		mv.setViewName("redirect:/message/selectMessage");
		
		return mv;
	}
	
	

	/**
	 * 处理查询请求
	 * 
	 * @param pageIndex
	 *            请求的是第几页
	 * @param employee
	 *            模糊查询参数
	 * @param Model
	 *            model
	 */
	@RequestMapping(value = "/message/selectMessage")
	public String selectMessage(Integer pageIndex, @ModelAttribute Message message, Model model) {
		
		PageModel pageModel = new PageModel();
		if (pageIndex != null) {
			pageModel.setPageIndex(pageIndex);
		}		
		/** 查询留言信息 */
		List<Message> messages = hrmService.findMessage(message, pageModel);
		model.addAttribute("messages", messages);
		model.addAttribute("pageModel", pageModel);	
		
		return "message/message";

	}

}
