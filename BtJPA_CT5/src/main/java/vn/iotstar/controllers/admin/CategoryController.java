package vn.iotstar.controllers.admin;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.entity.Category;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.Impl.CategoryServiceImpl;

@WebServlet(urlPatterns = {"/admin/categories", "/admin/edit", "/admin/delete", "/admin/insert"})
public class CategoryController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CategoryServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String url = req.getRequestURI();

	    if (url.endsWith("/categories")) {
	        // Hiển thị danh sách
	        List<Category> list = cateService.findAll();
	        req.setAttribute("listcate", list);
	        req.getRequestDispatcher("/views/admin/categories.jsp").forward(req, resp);
	    } 
	    else if (url.endsWith("/insert")) {
	        // Chuyển đến form thêm
	        req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
	    }
	    else if (url.endsWith("/edit")) {
	        // Load dữ liệu để sửa
	        int id = Integer.parseInt(req.getParameter("id"));
	        Category cate = cateService.findById(id);
	        req.setAttribute("cate", cate);
	        req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
	    }
	    else if (url.endsWith("/delete")) {
	        int id = Integer.parseInt(req.getParameter("id"));
	        cateService.delete(id);
	        resp.sendRedirect(req.getContextPath() + "/admin/categories");
	    }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String url = req.getRequestURI();

	    if (url.endsWith("/insert")) {
	        String name = req.getParameter("categoryname");
	        Category c = new Category();
	        c.setCategoryname(name);
	        cateService.create(c);
	        resp.sendRedirect(req.getContextPath() + "/admin/categories");
	    }
	    else if (url.endsWith("/edit")) {
	        int id = Integer.parseInt(req.getParameter("id"));
	        String name = req.getParameter("categoryname");

	        Category c = cateService.findById(id);
	        if (c != null) {
	            c.setCategoryname(name);
	            cateService.update(c);
	        }
	        resp.sendRedirect(req.getContextPath() + "/admin/categories");
	    }
	}
}
