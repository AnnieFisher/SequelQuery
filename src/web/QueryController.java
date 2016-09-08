package web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import data.QueryDAO;

@Controller
public class QueryController {
@Autowired
private QueryDAO queryDAO;

@RequestMapping(path="getQuery.do")
public ModelAndView getQuery(@RequestParam("keyword")String keyword) {
	ModelAndView mv = new ModelAndView();
	
	List<List<String>> query = queryDAO.getQueryInfo(keyword);
	mv.addObject("result", keyword);
	mv.addObject("queries", query);
	mv.setViewName("index.jsp");
	
	
	
	return mv;
}
	
	
	
}
