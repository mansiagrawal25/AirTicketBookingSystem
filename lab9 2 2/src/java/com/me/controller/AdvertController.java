package com.me.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import com.me.dao.AdvertDAO;
import com.me.dao.CategoryDAO;
import com.me.dao.UserDAO;
import com.me.exception.AdvertException;
import com.me.pojo.Advert;
import com.me.pojo.Category;
import com.me.pojo.User;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/advert/*")
public class AdvertController {
		
		@Autowired
		@Qualifier("advertDao")
		AdvertDAO advertDao;
		
		@Autowired
		@Qualifier("categoryDao")
		CategoryDAO categoryDAO;
		
		@Autowired
		@Qualifier("userDao")
		UserDAO userDao;
		
                @RequestMapping(value="/advert/add", method = RequestMethod.GET)
		public ModelAndView initializeForm(HttpServletRequest request) throws Exception {
                    HttpSession session = (HttpSession) request.getSession();
                    User user = (User)session.getAttribute("user");
                    if (user == null) {
                        return new ModelAndView("login-user");
                    }
                    
	            ModelAndView mv = new ModelAndView();
		    mv.addObject("categories", categoryDAO.list());			
	            mv.addObject("advert", new Advert());
		    mv.setViewName("advert-form");
		    return mv;
		}

		@RequestMapping(value = "/advert/add", method = RequestMethod.POST)
		public ModelAndView addAdvert(HttpServletRequest request, @ModelAttribute("advert") Advert advert, BindingResult result) throws Exception {

			try {			
				
				User u = userDao.get(advert.getUser().getId());
				advert.setUser(u);
				advert = advertDao.create(advert);
	
	            for(Category c: advert.getCategories()){
	            	c = categoryDAO.get(c.getTitle());
	            	c.getAdverts().add(advert);
	            	categoryDAO.update(c);
	            }
				
			return new ModelAndView("advert-success", "advert", advert);
				
			} catch (AdvertException e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "error while login");
			}
			
			
		}
		
		@RequestMapping(value = "/advert/list", method = RequestMethod.GET)
		public ModelAndView addCategory(HttpServletRequest request) throws Exception {
                        
			try {			
				List<Advert> adverts = advertDao.list();
				return new ModelAndView("advert-list", "adverts", adverts);
				
			} catch (AdvertException e) {
				System.out.println(e.getMessage());
				return new ModelAndView("error", "errorMessage", "error while login");
			}
			
			
		}

		


}